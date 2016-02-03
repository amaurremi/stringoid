/*    */
package android.graphics.drawable;
/*    */ 
/*    */

import android.graphics.Rect;

/*    */
/*    */ public class GradientDrawable extends Drawable {
    public static final int RECTANGLE = 0;

    /*    */
/*  7 */   public static enum Orientation {
        BL_TR,
        /*  8 */     BOTTOM_TOP,
        /*  9 */     BR_TL,
        /* 10 */     LEFT_RIGHT,
        /* 11 */     RIGHT_LEFT,
        /* 12 */     TL_BR,
        /* 13 */     TOP_BOTTOM,
        /* 14 */     TR_BL;

        /*    */
        private Orientation() {
        }
    }

    /* 16 */
    public GradientDrawable() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public GradientDrawable(Orientation orientation, int[] colors) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public boolean getPadding(Rect padding) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setCornerRadii(float[] radii) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setCornerRadius(float radius) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void setStroke(int width, int color) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void setStroke(int width, int color, float dashWidth, float dashGap) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void setSize(int width, int height) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void setShape(int shape) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void setGradientType(int gradient) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void setGradientCenter(float x, float y) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setGradientRadius(float gradientRadius) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setUseLevel(boolean useLevel) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public Orientation getOrientation() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void setOrientation(Orientation orientation) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void setColors(int[] colors) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void draw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void setColor(int argb) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public int getChangingConfigurations() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void setAlpha(int alpha) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void setDither(boolean dither) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void setColorFilter(android.graphics.ColorFilter cf) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public int getOpacity() {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    protected void onBoundsChange(Rect r) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    protected boolean onLevelChange(int level) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public void inflate(android.content.res.Resources r, org.xmlpull.v1.XmlPullParser parser, android.util.AttributeSet attrs) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public int getIntrinsicWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public int getIntrinsicHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public Drawable.ConstantState getConstantState() {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public Drawable mutate() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int OVAL = 1;
    /*    */   public static final int LINE = 2;
    /*    */   public static final int RING = 3;
    /*    */   public static final int LINEAR_GRADIENT = 0;
    /*    */   public static final int RADIAL_GRADIENT = 1;
    /*    */   public static final int SWEEP_GRADIENT = 2;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/drawable/GradientDrawable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */