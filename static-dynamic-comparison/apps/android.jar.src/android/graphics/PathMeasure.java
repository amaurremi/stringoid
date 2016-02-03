/*    */
package android.graphics;

/*    */
/*    */ public class PathMeasure {
    /*  4 */
    public PathMeasure() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public PathMeasure(Path path, boolean forceClosed) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void setPath(Path path, boolean forceClosed) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public float getLength() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public boolean getPosTan(float distance, float[] pos, float[] tan) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public boolean getMatrix(float distance, Matrix matrix, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public boolean getSegment(float startD, float stopD, Path dst, boolean startWithMoveTo) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public boolean isClosed() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public boolean nextContour() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int POSITION_MATRIX_FLAG = 1;
    /*    */   public static final int TANGENT_MATRIX_FLAG = 2;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/PathMeasure.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */