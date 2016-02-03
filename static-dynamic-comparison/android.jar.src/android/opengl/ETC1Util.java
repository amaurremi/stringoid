/*    */
package android.opengl;
/*    */ 
/*    */

import java.io.InputStream;

/*    */
/*    */ public class ETC1Util {
    /*  6 */   public static class ETC1Texture {
        public ETC1Texture(int width, int height, java.nio.ByteBuffer data) {
            throw new RuntimeException("Stub!");
        }

        /*  7 */
        public int getWidth() {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public int getHeight() {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public java.nio.ByteBuffer getData() {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 11 */
    public ETC1Util() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public static void loadTexture(int target, int level, int border, int fallbackFormat, int fallbackType, InputStream input) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public static void loadTexture(int target, int level, int border, int fallbackFormat, int fallbackType, ETC1Texture texture) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public static boolean isETC1Supported() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public static ETC1Texture createTexture(InputStream input) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public static ETC1Texture compressTexture(java.nio.Buffer input, int width, int height, int pixelSize, int stride) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public static void writeTexture(ETC1Texture texture, java.io.OutputStream output) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/opengl/ETC1Util.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */