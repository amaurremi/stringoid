/*    */
package android.graphics.drawable;
/*    */ 
/*    */

import android.content.res.Resources;
/*    */ import android.graphics.Rect;

/*    */
/*    */ 
/*    */ 
/*    */ public abstract class Drawable
/*    */ {
    /*    */   public static abstract class ConstantState
/*    */ {
        /* 12 */
        public ConstantState() {
            throw new RuntimeException("Stub!");
        }

        /*    */
        public abstract Drawable newDrawable();

        /* 14 */
        public Drawable newDrawable(Resources res) {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */
        public abstract int getChangingConfigurations();
    }

    /* 17 */
    public Drawable() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract void draw(android.graphics.Canvas paramCanvas);

    /* 19 */
    public void setBounds(int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setBounds(Rect bounds) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public final void copyBounds(Rect bounds) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public final Rect copyBounds() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public final Rect getBounds() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void setChangingConfigurations(int configs) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public int getChangingConfigurations() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void setDither(boolean dither) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setFilterBitmap(boolean filter) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public final void setCallback(Callback cb) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public Callback getCallback() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void invalidateSelf() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void scheduleSelf(Runnable what, long when) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void unscheduleSelf(Runnable what) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract void setAlpha(int paramInt);

    /*    */
    public abstract void setColorFilter(android.graphics.ColorFilter paramColorFilter);

    /* 35 */
    public void setColorFilter(int color, android.graphics.PorterDuff.Mode mode) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void clearColorFilter() {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public boolean isStateful() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public boolean setState(int[] stateSet) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public int[] getState() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void jumpToCurrentState() {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public Drawable getCurrent() {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public final boolean setLevel(int level) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public final int getLevel() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public boolean setVisible(boolean visible, boolean restart) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public final boolean isVisible() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract int getOpacity();

    /* 47 */
    public static int resolveOpacity(int op1, int op2) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public android.graphics.Region getTransparentRegion() {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    protected boolean onStateChange(int[] state) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    protected boolean onLevelChange(int level) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    protected void onBoundsChange(Rect bounds) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public int getIntrinsicWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public int getIntrinsicHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public int getMinimumWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public int getMinimumHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public boolean getPadding(Rect padding) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public Drawable mutate() {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public static Drawable createFromStream(java.io.InputStream is, String srcName) {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public static Drawable createFromResourceStream(Resources res, android.util.TypedValue value, java.io.InputStream is, String srcName) {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public static Drawable createFromResourceStream(Resources res, android.util.TypedValue value, java.io.InputStream is, String srcName, android.graphics.BitmapFactory.Options opts) {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public static Drawable createFromXml(Resources r, org.xmlpull.v1.XmlPullParser parser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 62 */
    public static Drawable createFromXmlInner(Resources r, org.xmlpull.v1.XmlPullParser parser, android.util.AttributeSet attrs) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 63 */
    public static Drawable createFromPath(String pathName) {
        throw new RuntimeException("Stub!");
    }

    /* 64 */
    public void inflate(Resources r, org.xmlpull.v1.XmlPullParser parser, android.util.AttributeSet attrs) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 65 */
    public ConstantState getConstantState() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface Callback
/*    */ {
        /*    */
        public abstract void invalidateDrawable(Drawable paramDrawable);

        /*    */
/*    */
        public abstract void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong);

        /*    */
/*    */
        public abstract void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/drawable/Drawable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */