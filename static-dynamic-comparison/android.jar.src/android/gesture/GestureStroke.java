/*    */
package android.gesture;
/*    */

import java.util.ArrayList;

/*    */
/*  4 */ public class GestureStroke {
    public GestureStroke(ArrayList<GesturePoint> points) {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public android.graphics.Path getPath() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public android.graphics.Path toPath(float width, float height, int numSample) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void clearPath() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public OrientedBoundingBox computeOrientedBoundingBox() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public final android.graphics.RectF boundingBox;
    /* 12 */   public final float length;
    public final float[] points = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/gesture/GestureStroke.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */