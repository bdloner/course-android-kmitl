package kmitl.lab03.bdloner.simplemydot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import kmitl.lab03.bdloner.simplemydot.model.DotParcelable;
import kmitl.lab03.bdloner.simplemydot.model.DotSerializable;

public class SecondActivity extends AppCompatActivity {

    // DotSerializable dotSerializable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnOpenActivity = (Button) findViewById(R.id.btnBack);
        btnOpenActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        //int x = getIntent().getIntExtra("xValue", 0);

       // dotSerializable = (DotSerializable) getIntent().getSerializableExtra("dotSerializable");
       // TextView tvValueX = (TextView) findViewById(R.id.tvValueX);
        TextView tvDot = (TextView) findViewById(R.id.tvDot);
       // tvValueX.setText(String.valueOf(x));

        /*tvDot.setText("centerX : " + dotSerializable.getCenterX() + "\n" +
                        "center Y : " + dotSerializable.getCenterY() + "\n" +
                        "Radius : " + dotSerializable.getRadius());

        tvDot.setTextColor(dotSerializable.getColor());*/

        DotParcelable dotParcelable = getIntent().getParcelableExtra("dotParcelable");

        tvDot.setText("centerX : " + dotParcelable.getCenterX() + "\n" +
                "center Y : " + dotParcelable.getCenterY() + "\n" +
                "Radius : " + dotParcelable.getRadius());

    }
}
