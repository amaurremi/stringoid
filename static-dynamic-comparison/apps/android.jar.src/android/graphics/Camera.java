/*    */
package android.graphics;

/*    */
/*    */ public class Camera {
    /*  4 */
    public Camera() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native void save();

    /*    */
    public native void restore();

    /*    */
    public native void translate(float paramFloat1, float paramFloat2, float paramFloat3);

    /*    */
    public native void rotateX(float paramFloat);

    /*    */
    public native void rotateY(float paramFloat);

    /*    */
    public native void rotateZ(float paramFloat);

    /*    */
    public native void rotate(float paramFloat1, float paramFloat2, float paramFloat3);

    /*    */
    public native float getLocationX();

    /*    */
    public native float getLocationY();

    /*    */
    public native float getLocationZ();

    /*    */
    public native void setLocation(float paramFloat1, float paramFloat2, float paramFloat3);

    /* 16 */
    public void getMatrix(Matrix matrix) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void applyToCanvas(Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native float dotWithNormal(float paramFloat1, float paramFloat2, float paramFloat3);

    /* 19 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/Camera.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */