package android.support.v4.view;

import android.view.animation.Interpolator;

final class bz
        implements Interpolator {
    public float getInterpolation(float paramFloat) {
        paramFloat -= 1.0F;
        return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */