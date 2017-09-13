package kmitl.lab04.bdloner.simplemydot.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by BDLoneR on 12/9/2560.
 */


public class DotParcelable implements Parcelable {
    public static final Creator<DotParcelable> CREATOR = new Creator<DotParcelable>() {
        @Override
        public DotParcelable createFromParcel(Parcel in) {
            return new DotParcelable(in);
        }

        @Override
        public DotParcelable[] newArray(int size) {
            return new DotParcelable[size];
        }
    };
    private int centerX;
    private int centerY;
    private int radius;
    private int dotPosition;
    private int color;

    public DotParcelable(int dotPosition) {
        this.dotPosition = dotPosition;

    }

    public DotParcelable(int dotPosition, int color) {
        this.dotPosition = dotPosition;
        this.color = color;
    }


    public DotParcelable(int dotPosition, int color, int radius) {
        this.dotPosition = dotPosition;
        this.color = color;
        this.radius = radius;
    }


    public DotParcelable(int centerX, int centerY, int radius, int dotPosition) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.dotPosition = dotPosition;
    }

    protected DotParcelable(Parcel in) {
        centerX = in.readInt();
        centerY = in.readInt();
        radius = in.readInt();
        dotPosition = in.readInt();
        color = in.readInt();
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getDotPosition() {
        return dotPosition;
    }

    public void setDotPosition(int dotPosition) {
        this.dotPosition = dotPosition;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel des, int flags) {
        des.writeInt(centerX);
        des.writeInt(centerY);
        des.writeInt(radius);
        des.writeInt(dotPosition);
        des.writeInt(color);
    }
}
