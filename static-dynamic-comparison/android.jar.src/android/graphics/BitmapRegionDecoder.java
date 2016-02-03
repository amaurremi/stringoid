/*    */
package android.graphics;
/*    */

import java.io.IOException;

/*    */
/*  4 */ public final class BitmapRegionDecoder {
    BitmapRegionDecoder() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public static BitmapRegionDecoder newInstance(byte[] data, int offset, int length, boolean isShareable) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static BitmapRegionDecoder newInstance(java.io.FileDescriptor fd, boolean isShareable) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static BitmapRegionDecoder newInstance(java.io.InputStream is, boolean isShareable) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public static BitmapRegionDecoder newInstance(String pathName, boolean isShareable) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public Bitmap decodeRegion(Rect rect, BitmapFactory.Options options) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int getHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void recycle() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public final boolean isRecycled() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/BitmapRegionDecoder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */