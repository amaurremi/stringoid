package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class bp {
    public static int a(View paramView) {
        return paramView.getLayerType();
    }

    static long a() {
        return ValueAnimator.getFrameDelay();
    }

    public static void a(View paramView, int paramInt, Paint paramPaint) {
        paramView.setLayerType(paramInt, paramPaint);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */