/*    */
package android.graphics.drawable;
/*    */ 
/*    */

import android.graphics.drawable.shapes.Shape;

/*    */
/*    */ public class ShapeDrawable extends Drawable {
    /*    */   public static abstract class ShaderFactory {
        /*  7 */
        public ShaderFactory() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */
        public abstract android.graphics.Shader resize(int paramInt1, int paramInt2);
    }

    /* 10 */
    public ShapeDrawable() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public ShapeDrawable(Shape s) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public Shape getShape() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void setShape(Shape s) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void setShaderFactory(ShaderFactory fact) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public ShaderFactory getShaderFactory() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public android.graphics.Paint getPaint() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setPadding(int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setPadding(android.graphics.Rect padding) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setIntrinsicWidth(int width) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setIntrinsicHeight(int height) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public int getIntrinsicWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public int getIntrinsicHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public boolean getPadding(android.graphics.Rect padding) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    protected void onDraw(Shape shape, android.graphics.Canvas canvas, android.graphics.Paint paint) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void draw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public int getChangingConfigurations() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setAlpha(int alpha) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setColorFilter(android.graphics.ColorFilter cf) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public int getOpacity() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void setDither(boolean dither) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    protected void onBoundsChange(android.graphics.Rect bounds) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    protected boolean inflateTag(String name, android.content.res.Resources r, org.xmlpull.v1.XmlPullParser parser, android.util.AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void inflate(android.content.res.Resources r, org.xmlpull.v1.XmlPullParser parser, android.util.AttributeSet attrs) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public Drawable.ConstantState getConstantState() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public Drawable mutate() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/drawable/ShapeDrawable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */