/*    */
package android.graphics.drawable;
/*    */ 
/*    */

import android.graphics.Shader.TileMode;

/*    */
/*    */ public class BitmapDrawable extends Drawable {
    @Deprecated
/*  6 */ public BitmapDrawable() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*  8 */
    public BitmapDrawable(android.content.res.Resources res) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 10 */ public BitmapDrawable(android.graphics.Bitmap bitmap) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public BitmapDrawable(android.content.res.Resources res, android.graphics.Bitmap bitmap) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 13 */ public BitmapDrawable(String filepath) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 15 */
    public BitmapDrawable(android.content.res.Resources res, String filepath) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 17 */ public BitmapDrawable(java.io.InputStream is) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 19 */
    public BitmapDrawable(android.content.res.Resources res, java.io.InputStream is) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public final android.graphics.Paint getPaint() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public final android.graphics.Bitmap getBitmap() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void setTargetDensity(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void setTargetDensity(android.util.DisplayMetrics metrics) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void setTargetDensity(int density) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public int getGravity() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void setGravity(int gravity) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setAntiAlias(boolean aa) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setFilterBitmap(boolean filter) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setDither(boolean dither) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public Shader.TileMode getTileModeX() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public Shader.TileMode getTileModeY() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void setTileModeX(Shader.TileMode mode) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public final void setTileModeY(Shader.TileMode mode) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void setTileModeXY(Shader.TileMode xmode, Shader.TileMode ymode) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public int getChangingConfigurations() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    protected void onBoundsChange(android.graphics.Rect bounds) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void draw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void setAlpha(int alpha) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void setColorFilter(android.graphics.ColorFilter cf) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public Drawable mutate() {
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
    public int getOpacity() {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public final Drawable.ConstantState getConstantState() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/drawable/BitmapDrawable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */