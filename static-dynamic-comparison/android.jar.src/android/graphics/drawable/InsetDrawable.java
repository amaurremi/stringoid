/*    */
package android.graphics.drawable;
/*    */ 
/*    */

import android.graphics.Rect;

/*    */
/*    */ public class InsetDrawable extends Drawable implements Drawable.Callback {
    /*  6 */
    public InsetDrawable(Drawable drawable, int inset) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public InsetDrawable(Drawable drawable, int insetLeft, int insetTop, int insetRight, int insetBottom) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void inflate(android.content.res.Resources r, org.xmlpull.v1.XmlPullParser parser, android.util.AttributeSet attrs) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void invalidateDrawable(Drawable who) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void unscheduleDrawable(Drawable who, Runnable what) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void draw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int getChangingConfigurations() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public boolean getPadding(Rect padding) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public boolean setVisible(boolean visible, boolean restart) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void setAlpha(int alpha) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setColorFilter(android.graphics.ColorFilter cf) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public int getOpacity() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public boolean isStateful() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    protected boolean onStateChange(int[] state) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    protected void onBoundsChange(Rect bounds) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public int getIntrinsicWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public int getIntrinsicHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public Drawable.ConstantState getConstantState() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public Drawable mutate() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/drawable/InsetDrawable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */