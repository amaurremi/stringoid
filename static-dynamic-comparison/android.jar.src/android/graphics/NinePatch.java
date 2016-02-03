/*    */
package android.graphics;

/*    */
/*    */ public class NinePatch {
    /*  4 */
    public NinePatch(Bitmap bitmap, byte[] chunk, String srcName) {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public void setPaint(Paint p) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void draw(Canvas canvas, RectF location) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void draw(Canvas canvas, Rect location) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void draw(Canvas canvas, Rect location, Paint paint) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int getDensity() {
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
    public final boolean hasAlpha() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public final Region getTransparentRegion(Rect location) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */
    public static native boolean isNinePatchChunk(byte[] paramArrayOfByte);
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/NinePatch.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */