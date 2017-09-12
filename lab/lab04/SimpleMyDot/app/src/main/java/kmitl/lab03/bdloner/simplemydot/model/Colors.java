package kmitl.lab03.bdloner.simplemydot.model;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by BDLoneR on 12/9/2560.
 */

public class Colors {

    public int getColor() {
        int red = new Random().nextInt(255);
        int green = new Random().nextInt(255);
        int blue = new Random().nextInt(255);
        return Color.rgb(red, green, blue);
    }
}
