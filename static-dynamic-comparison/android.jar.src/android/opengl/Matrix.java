/*    */
package android.opengl;

/*    */
/*    */ public class Matrix {
    /*  4 */
    public Matrix() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public static native void multiplyMM(float[] paramArrayOfFloat1, int paramInt1, float[] paramArrayOfFloat2, int paramInt2, float[] paramArrayOfFloat3, int paramInt3);

    /*    */
    public static native void multiplyMV(float[] paramArrayOfFloat1, int paramInt1, float[] paramArrayOfFloat2, int paramInt2, float[] paramArrayOfFloat3, int paramInt3);

    /*  7 */
    public static void transposeM(float[] mTrans, int mTransOffset, float[] m, int mOffset) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public static boolean invertM(float[] mInv, int mInvOffset, float[] m, int mOffset) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public static void orthoM(float[] m, int mOffset, float left, float right, float bottom, float top, float near, float far) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public static void frustumM(float[] m, int offset, float left, float right, float bottom, float top, float near, float far) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public static void perspectiveM(float[] m, int offset, float fovy, float aspect, float zNear, float zFar) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public static float length(float x, float y, float z) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public static void setIdentityM(float[] sm, int smOffset) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public static void scaleM(float[] sm, int smOffset, float[] m, int mOffset, float x, float y, float z) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public static void scaleM(float[] m, int mOffset, float x, float y, float z) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public static void translateM(float[] tm, int tmOffset, float[] m, int mOffset, float x, float y, float z) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public static void translateM(float[] m, int mOffset, float x, float y, float z) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public static void rotateM(float[] rm, int rmOffset, float[] m, int mOffset, float a, float x, float y, float z) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public static void rotateM(float[] m, int mOffset, float a, float x, float y, float z) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public static void setRotateM(float[] rm, int rmOffset, float a, float x, float y, float z) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public static void setRotateEulerM(float[] rm, int rmOffset, float x, float y, float z) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public static void setLookAtM(float[] rm, int rmOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/opengl/Matrix.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */