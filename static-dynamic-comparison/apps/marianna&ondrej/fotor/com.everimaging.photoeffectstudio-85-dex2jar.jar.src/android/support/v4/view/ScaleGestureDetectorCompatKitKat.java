package android.support.v4.view;

import android.view.ScaleGestureDetector;

class ScaleGestureDetectorCompatKitKat {
    public static boolean isQuickScaleEnabled(Object paramObject) {
        return ((ScaleGestureDetector) paramObject).isQuickScaleEnabled();
    }

    public static void setQuickScaleEnabled(Object paramObject, boolean paramBoolean) {
        ((ScaleGestureDetector) paramObject).setQuickScaleEnabled(paramBoolean);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v4/view/ScaleGestureDetectorCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */