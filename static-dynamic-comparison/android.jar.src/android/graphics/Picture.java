/*    */
package android.graphics;
/*    */

import java.io.InputStream;

/*    */
/*  4 */ public class Picture {
    public Picture() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public Picture(Picture src) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public Canvas beginRecording(int width, int height) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void endRecording() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native int getWidth();

    /*    */
    public native int getHeight();

    /* 10 */
    public void draw(Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public static Picture createFromStream(InputStream stream) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void writeToStream(java.io.OutputStream stream) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/Picture.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */