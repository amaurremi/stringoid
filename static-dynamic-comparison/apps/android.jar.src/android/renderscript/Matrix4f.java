/*    */
package android.renderscript;

/*    */
/*    */ public class Matrix4f {
    /*  4 */
    public Matrix4f() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public Matrix4f(float[] dataArray) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public float[] getArray() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public float get(int i, int j) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void set(int i, int j, float v) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void loadIdentity() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void load(Matrix4f src) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void loadRotate(float rot, float x, float y, float z) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void loadScale(float x, float y, float z) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void loadTranslate(float x, float y, float z) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void loadMultiply(Matrix4f lhs, Matrix4f rhs) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void loadOrtho(float l, float r, float b, float t, float n, float f) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void loadOrthoWindow(int w, int h) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void loadFrustum(float l, float r, float b, float t, float n, float f) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void loadPerspective(float fovy, float aspect, float near, float far) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void loadProjectionNormalized(int w, int h) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void multiply(Matrix4f rhs) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void rotate(float rot, float x, float y, float z) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void scale(float x, float y, float z) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void translate(float x, float y, float z) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public boolean inverse() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean inverseTranspose() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void transpose() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/renderscript/Matrix4f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */