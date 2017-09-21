package kmitl.lab05.bdloner.simplemydot.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import kmitl.lab05.bdloner.simplemydot.model.Dot;
import kmitl.lab05.bdloner.simplemydot.model.Dots;

/**
 * Created by BDLoneRZ on 8/25/2017.
 */

public class DotView extends View implements View.OnLongClickListener{

    private Paint paint;
    private Dots allDot;

    private final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            listener.onDotViewPressed(
                    (int)e.getX(),
                    (int)e.getY());
            return super.onSingleTapUp(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            listener.onDotViewLongPressed(
                    (int)e.getX(),
                    (int)e.getY());
            super.onLongPress(e);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

    });

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.allDot != null) {
            for (Dot dot : allDot.getAllDot()) {
                paint.setColor(dot.getColor());
                canvas.drawCircle(
                        dot.getCenterX(),
                        dot.getCenterY(), dot.getRadius(), paint);
            }
        }
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    public interface OnDotViewPressListener {
        void onDotViewPressed(int x, int y);
        void onDotViewLongPressed(int x, int y);
    }

    public OnDotViewPressListener getListener() {
        return listener;
    }

    public void setListener(OnDotViewPressListener listener) {
        this.listener = listener;
    }

    public OnDotViewPressListener getOnDotViewPressListener() {
        return onDotViewPressListener;
    }

    private OnDotViewPressListener listener;

    private OnDotViewPressListener onDotViewPressListener;

    public void setOnDotViewPressListener(
            OnDotViewPressListener onDotViewPressListener) {
        this.onDotViewPressListener = onDotViewPressListener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

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


    public void setDots(Dots dots) {
        this.allDot = dots;
    }
}