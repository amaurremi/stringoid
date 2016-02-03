/*    */
package android.graphics;

/*    */
/*    */ public class Shader
/*    */ {
    /*    */   public static enum TileMode {
        /*  6 */     CLAMP,
        /*  7 */     MIRROR,
        /*  8 */     REPEAT;

        /*    */
        private TileMode() {
        }
    }

    /* 10 */
    public Shader() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public boolean getLocalMatrix(Matrix localM) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void setLocalMatrix(Matrix localM) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/Shader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */