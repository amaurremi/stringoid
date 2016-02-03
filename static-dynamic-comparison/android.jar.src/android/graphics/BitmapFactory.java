/*    */
package android.graphics;
/*    */ 
/*    */

import java.io.InputStream;

/*    */
/*    */ public class BitmapFactory {
    /*  6 */   public static class Options {
        public Options() {
            throw new RuntimeException("Stub!");
        }

        /*  7 */
        public void requestCancelDecode() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public Bitmap inBitmap;
        /*    */     public boolean inMutable;
        /*    */     public boolean inJustDecodeBounds;
        /*    */     public int inSampleSize;
        /*    */     public Bitmap.Config inPreferredConfig;
        /*    */     public boolean inDither;
        /*    */     public int inDensity;
        /*    */     public int inTargetDensity;
        /*    */     public int inScreenDensity;
        /*    */     public boolean inScaled;
        /*    */     public boolean inPurgeable;
        /*    */     public boolean inInputShareable;
        /*    */     public boolean inPreferQualityOverSpeed;
        /*    */     public int outWidth;
        /*    */     public int outHeight;
        /*    */     public String outMimeType;
        /* 25 */     public byte[] inTempStorage = null;
        /*    */     public boolean mCancel;
    }

    /*    */
/* 28 */
    public BitmapFactory() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public static Bitmap decodeFile(String pathName, Options opts) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public static Bitmap decodeFile(String pathName) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public static Bitmap decodeResourceStream(android.content.res.Resources res, android.util.TypedValue value, InputStream is, Rect pad, Options opts) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public static Bitmap decodeResource(android.content.res.Resources res, int id, Options opts) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public static Bitmap decodeResource(android.content.res.Resources res, int id) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public static Bitmap decodeByteArray(byte[] data, int offset, int length, Options opts) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public static Bitmap decodeByteArray(byte[] data, int offset, int length) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public static Bitmap decodeStream(InputStream is, Rect outPadding, Options opts) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public static Bitmap decodeStream(InputStream is) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public static Bitmap decodeFileDescriptor(java.io.FileDescriptor fd, Rect outPadding, Options opts) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public static Bitmap decodeFileDescriptor(java.io.FileDescriptor fd) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/BitmapFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */