/*    */
package android.webkit;
/*    */ 
/*    */

import android.graphics.Bitmap;

/*    */
/*  5 */ public class WebHistoryItem implements Cloneable {
    WebHistoryItem() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/*  8 */ public int getId() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public String getUrl() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public String getOriginalUrl() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public String getTitle() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public Bitmap getFavicon() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    protected synchronized WebHistoryItem clone() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/webkit/WebHistoryItem.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */