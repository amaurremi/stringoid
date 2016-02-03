/*    */
package android.graphics;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SurfaceTexture
/*    */ {
    /*    */   public static class OutOfResourcesException
/*    */ extends Exception
/*    */ {
        /* 11 */
        public OutOfResourcesException() {
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public OutOfResourcesException(String name) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 14 */
    public SurfaceTexture(int texName) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void setOnFrameAvailableListener(OnFrameAvailableListener l) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void setDefaultBufferSize(int width, int height) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void updateTexImage() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void detachFromGLContext() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void attachToGLContext(int texName) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void getTransformMatrix(float[] mtx) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public long getTimestamp() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void release() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnFrameAvailableListener
/*    */ {
        /*    */
        public abstract void onFrameAvailable(SurfaceTexture paramSurfaceTexture);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/SurfaceTexture.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */