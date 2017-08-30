package kmitl.lab03.bdloner.simplemydot.model;

/**
 * Created by BDLoneRZ on 8/25/2017.
 */

public class Dot {
    private int centerX;
    private int centerY;
    private int radius;
    private int color;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;

        this.listener.onDotChanged(this);
    }

    public Dot(OnDotChangeListener listener, int centerX, int centerY, int radius, int color) {
        this.listener = listener;
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.color = color;

//        this.listener.onDotChanged(this);
    }

    public Dot(int centerX, int centerY, int radius, int color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.color = color;
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;

        this.listener.onDotChanged(this);
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;

        this.listener.onDotChanged(this);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public interface OnDotChangeListener{
        void onDotChanged(Dot dot);
    }

    private OnDotChangeListener listener;

    public void setListener(OnDotChangeListener listener) {
        this.listener = listener;
    }


}
