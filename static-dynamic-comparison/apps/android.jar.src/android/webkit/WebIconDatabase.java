/*    */
package android.webkit;
/*    */ 
/*    */

import android.graphics.Bitmap;

/*    */
/*    */ 
/*    */ public class WebIconDatabase
/*    */ {
    /*  8 */   WebIconDatabase() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void open(String path) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void close() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void removeAllIcons() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void requestIconForPageUrl(String url, IconListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void retainIconForPageUrl(String url) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void releaseIconForPageUrl(String url) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public static WebIconDatabase getInstance() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface IconListener
/*    */ {
        /*    */
        public abstract void onReceivedIcon(String paramString, Bitmap paramBitmap);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/webkit/WebIconDatabase.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */