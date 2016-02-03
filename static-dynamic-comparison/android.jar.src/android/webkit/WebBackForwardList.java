/*    */
package android.webkit;
/*    */ 
/*    */

import java.io.Serializable;

/*    */
/*  5 */ public class WebBackForwardList implements Cloneable, Serializable {
    WebBackForwardList() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public synchronized WebHistoryItem getCurrentItem() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public synchronized int getCurrentIndex() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public synchronized WebHistoryItem getItemAtIndex(int index) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public synchronized int getSize() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    protected synchronized WebBackForwardList clone() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/webkit/WebBackForwardList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */