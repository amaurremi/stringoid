/*    */
package android.view;
/*    */

import android.graphics.Point;

/*    */
/*  4 */ public class Display {
    Display() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public int getDisplayId() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void getSize(Point outSize) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void getRectSize(android.graphics.Rect outSize) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void getCurrentSizeRange(Point outSmallestSize, Point outLargestSize) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 10 */ public int getWidth() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 12 */ public int getHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int getRotation() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/*    */ public native int getOrientation();

    /* 16 */
    public int getPixelFormat() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public float getRefreshRate() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void getMetrics(android.util.DisplayMetrics outMetrics) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int DEFAULT_DISPLAY = 0;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/Display.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */