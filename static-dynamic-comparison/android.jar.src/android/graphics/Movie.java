/*    */
package android.graphics;
/*    */

import java.io.InputStream;

/*    */
/*  4 */ public class Movie {
    Movie() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native int width();

    /*    */
    public native int height();

    /*    */
    public native boolean isOpaque();

    /*    */
    public native int duration();

    /*    */
    public native boolean setTime(int paramInt);

    /*    */
    public native void draw(Canvas paramCanvas, float paramFloat1, float paramFloat2, Paint paramPaint);

    /* 11 */
    public void draw(Canvas canvas, float x, float y) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public static native Movie decodeStream(InputStream paramInputStream);

    /*    */
    public static native Movie decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2);

    /* 14 */
    public static Movie decodeFile(String pathName) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/Movie.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */