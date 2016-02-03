/*    */
package android.media;
/*    */ 
/*    */

import android.graphics.PointF;

/*    */
/*    */ public class FaceDetector {
    public class Face {
        public static final float CONFIDENCE_THRESHOLD = 0.4F;
        public static final int EULER_X = 0;

        /*  6 */     Face() {
            throw new RuntimeException("Stub!");
        }

        /*  7 */
        public float confidence() {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public void getMidPoint(PointF point) {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public float eyesDistance() {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public float pose(int euler) {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public static final int EULER_Y = 1;
        /*    */     public static final int EULER_Z = 2;
/*    */
    }

    /*    */
/* 16 */
    public FaceDetector(int width, int height, int maxFaces) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public int findFaces(android.graphics.Bitmap bitmap, Face[] faces) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/media/FaceDetector.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */