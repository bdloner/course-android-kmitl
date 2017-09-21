package kmitl.lab05.bdloner.simplemydot;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import kmitl.lab05.bdloner.simplemydot.model.Colors;
import kmitl.lab05.bdloner.simplemydot.model.Dot;
import kmitl.lab05.bdloner.simplemydot.model.DotParcelable;
import kmitl.lab05.bdloner.simplemydot.model.Dots;
import kmitl.lab05.bdloner.simplemydot.model.Screenshot;
import kmitl.lab05.bdloner.simplemydot.view.DotView;

public class MainActivity extends AppCompatActivity
        implements Dots.OnDotsChangeListener, DotView.OnDotViewPressListener, View.OnClickListener {

    private DotView dotView;
    private Dots dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button clearAllDot = (Button) findViewById(R.id.clearAllBtn);
        Button randomDot = (Button) findViewById(R.id.randomDotBtn);
        Button shareDot = (Button) findViewById(R.id.shareBtn);

        dotView = (DotView) findViewById(R.id.dotView);
        dotView.setListener(this);
        dots = new Dots();
        dots.setListener(this);

        clearAllDot.setOnClickListener(this);
        randomDot.setOnClickListener(this);
        shareDot.setOnClickListener(this);
    }

    public void randomDot() {
        Random random = new Random();
        int centerX = random.nextInt(dotView.getWidth());
        int centerY = random.nextInt(dotView.getHeight());
        Dot newDot = new Dot(centerX, centerY, 70, new Colors().getColor());
        dots.addDot(newDot);
    }

    @Override
    public void onDotsChanged(Dots dots) {
        dotView.setDots(dots);
        dotView.invalidate();
    }

    public void clearAllDot() {
        dots.clearAll();
    }

    @Override
    public void onDotViewPressed(int x, int y) {
        final int dotPosition = dots.findDot(x, y);
        if (dotPosition == -1) {
            Dot newDot = new Dot(x, y, 70, new Colors().getColor());
            dots.addDot(newDot);
        } else {
            dots.removeBy(dotPosition);
        }
    }

    @Override
    public void onDotViewLongPressed(int x, int y) {
        int dotPosition = dots.findDot(x, y);
        if (dotPosition == -1) {
            return;
        } else {
            alertDialog(dotPosition);
        }
    }

    public void alertDialog(final int dotPosition) {
        final DotParcelable dotParcelable = new DotParcelable(dotPosition, dots.getAllDot().get(dotPosition).getColor(), dots.getAllDot().get(dotPosition).getRadius());
        Intent editActIntent = new Intent(MainActivity.this, EditActivity.class);
        editActIntent.putExtra("dotParcelable", dotParcelable);
        startActivityForResult(editActIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            DotParcelable dotParcelable = data.getParcelableExtra("reDotParcelable");
            if (resultCode == Activity.RESULT_OK) {
                dots.getAllDot().get(dotParcelable.getDotPosition()).setColor(dotParcelable.getColor());
            } else {
                dots.getAllDot().get(dotParcelable.getDotPosition()).setRadius(dotParcelable.getRadius());
            }
        }
    }

    public void shareDot() {
        View main;
        main = findViewById(R.id.main);
        Bitmap b = Screenshot.takescreenshotOfRottView(main);
        saveBitmap(b);
        File imagePath = new File(this.getCacheDir(), "images");
        File newFile = new File(imagePath, "image.png");
        Uri contentUri = FileProvider.getUriForFile(this, "kmitl.lab05.bdloner.simplemydot.fileprovider", newFile);
        if (contentUri != null) {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            shareIntent.setDataAndType(contentUri, getContentResolver().getType(contentUri));
            shareIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
            startActivity(Intent.createChooser(shareIntent, "Choose an app"));
        }
    }

    private void saveBitmap(Bitmap bitmap) {
        try {
            File cachePath = new File(this.getCacheDir(), "images");
            cachePath.mkdirs();
            FileOutputStream stream = new FileOutputStream(cachePath + "/image.png");
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            stream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        if (R.id.clearAllBtn == view.getId()){
            clearAllDot();
        }
        if (R.id.randomDotBtn == view.getId()){
            randomDot();
        }
        if (R.id.shareBtn == view.getId()){
            shareDot();
        }

    }

}
