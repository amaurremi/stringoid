/*    */
package android.graphics.drawable.shapes;
/*    */ 
/*    */

import android.graphics.Canvas;

/*    */
/*  5 */ public abstract class Shape implements Cloneable {
    public Shape() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public final float getWidth() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public final float getHeight() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract void draw(Canvas paramCanvas, android.graphics.Paint paramPaint);

    /*  9 */
    public final void resize(float width, float height) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public boolean hasAlpha() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    protected void onResize(float width, float height) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public Shape clone() throws CloneNotSupportedException {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/drawable/shapes/Shape.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */