package kmitl.lab03.bdloner.simplemydot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kmitl.lab03.bdloner.simplemydot.model.Dot;
import kmitl.lab03.bdloner.simplemydot.view.DotView;

public class MainActivity extends AppCompatActivity implements Dot.OnDotChangeListener{

    private DotView dotView;
    private Dot dot;
    private List<Dot> dotList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dotView = (DotView) findViewById(R.id.dotView);
        dotList = new ArrayList<>();
    }

    public void onRandomDot(View view) {
        Random random = new Random();
        int centerX = random.nextInt(1080);
        int centerY = random.nextInt(1920);
        int radius = random.nextInt(80)+20;
        int color = random.nextInt(7);
        dot = new Dot(this, centerX, centerY, radius, color);
        dot.setCenterX(centerX);
        dot.setCenterY(centerY);
        dotView.setDot(dotList);
        dotView.invalidate();
    }

    @Override
    public void onDotChanged(Dot dot) {
        dotList.add(dot);
        dotView.setDot(dotList);
        dotView.invalidate();
    }

    public void onClearAll(View view) {
        dotList.clear();
        dotView.setDot(dotList);
        dotView.invalidate();
    }
}
