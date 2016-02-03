/*    */
package android.graphics;
/*    */

import java.io.OutputStream;

/*    */
/*  4 */ public class YuvImage {
    public YuvImage(byte[] yuv, int format, int width, int height, int[] strides) {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public boolean compressToJpeg(Rect rectangle, int quality, OutputStream stream) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public byte[] getYuvData() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public int getYuvFormat() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int[] getStrides() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int getWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getHeight() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/YuvImage.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */