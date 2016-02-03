/*    */
package android.view.animation;
/*    */

import android.graphics.Matrix;

/*    */
/*  4 */ public class Transformation {
    public Transformation() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public void clear() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public int getTransformationType() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void setTransformationType(int transformationType) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void set(Transformation t) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void compose(Transformation t) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public Matrix getMatrix() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void setAlpha(float alpha) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public float getAlpha() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public String toShortString() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static int TYPE_IDENTITY;
    /*    */   public static int TYPE_ALPHA;
    /*    */   public static int TYPE_MATRIX;
    /*    */   public static int TYPE_BOTH;
    /*    */   protected Matrix mMatrix;
    /*    */   protected float mAlpha;
    /*    */   protected int mTransformationType;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/animation/Transformation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */