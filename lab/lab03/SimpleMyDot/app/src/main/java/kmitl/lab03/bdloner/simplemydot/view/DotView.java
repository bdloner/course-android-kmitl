package kmitl.lab03.bdloner.simplemydot.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

import kmitl.lab03.bdloner.simplemydot.model.Dot;

/**
 * Created by BDLoneRZ on 8/25/2017.
 */

public class DotView extends View {

    private Paint paint;
    private List<Dot> dotList;

    public DotView(Context context) {
        super(context);
        paint = new Paint();
    }
    public DotView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public DotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (this.dotList != null) {
            for(int i=0;i<dotList.size();i++){
                switch (this.dotList.get(i).getColor()){
                    case 0 : paint.setColor(Color.RED);break;
                    case 1 : paint.setColor(Color.rgb(255,0,255));break;
                    case 2 : paint.setColor(Color.YELLOW);break;
                    case 3 : paint.setColor(Color.GREEN);break;
                    case 4 : paint.setColor(Color.CYAN);break;
                    case 5 : paint.setColor(Color.BLUE);break;
                    case 6 : paint.setColor(Color.rgb(199,21,133));break;
                }
                    canvas.drawCircle(this.dotList.get(i).getCenterX(), this.dotList.get(i).getCenterY(), this.dotList.get(i).getRadius(), paint);

            }
        }

    }

    public void setDot(List dotList) {
        this.dotList = dotList;
    }
}
