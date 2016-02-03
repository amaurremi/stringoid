/*    */
package android.graphics.drawable;
/*    */ 
/*    */

import android.content.res.Resources;

/*    */
/*    */ public class NinePatchDrawable extends Drawable {
    @Deprecated
/*  6 */ public NinePatchDrawable(android.graphics.Bitmap bitmap, byte[] chunk, android.graphics.Rect padding, String srcName) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public NinePatchDrawable(Resources res, android.graphics.Bitmap bitmap, byte[] chunk, android.graphics.Rect padding, String srcName) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/*  9 */ public NinePatchDrawable(android.graphics.NinePatch patch) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public NinePatchDrawable(Resources res, android.graphics.NinePatch patch) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void setTargetDensity(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void setTargetDensity(android.util.DisplayMetrics metrics) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void setTargetDensity(int density) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void draw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public int getChangingConfigurations() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public boolean getPadding(android.graphics.Rect padding) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setAlpha(int alpha) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setColorFilter(android.graphics.ColorFilter cf) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setDither(boolean dither) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setFilterBitmap(boolean filter) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void inflate(Resources r, org.xmlpull.v1.XmlPullParser parser, android.util.AttributeSet attrs) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public android.graphics.Paint getPaint() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public int getIntrinsicWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public int getIntrinsicHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public int getMinimumWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public int getMinimumHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public int getOpacity() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public android.graphics.Region getTransparentRegion() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public Drawable.ConstantState getConstantState() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public Drawable mutate() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/drawable/NinePatchDrawable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */