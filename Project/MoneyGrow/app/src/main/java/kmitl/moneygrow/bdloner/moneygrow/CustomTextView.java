package kmitl.moneygrow.bdloner.moneygrow;

/**
 * Created by BDLoneR on 31/10/2560.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class CustomTextView extends android.support.v7.widget.AppCompatTextView {
    public CustomTextView(Context context) {
        super(context);
        initTypFace();
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTypFace();
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initTypFace();
    }

    private void initTypFace() {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "font/thaisanslite_r1.ttf");
        setTypeface(typeface);
        setLineSpacing(getPixelFromDp(getContext(), 10 ), 1);
        setIncludeFontPadding(false);
    }

    public static float getPixelFromDp(Context context, float dp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return dp * (metrics.densityDpi / 160f);
    }
}
