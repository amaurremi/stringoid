/*    */
package android.text.method;
/*    */ 
/*    */

import android.text.Spannable;

/*    */
/*    */ public class MultiTapKeyListener extends BaseKeyListener implements android.text.SpanWatcher {
    /*  6 */
    public MultiTapKeyListener(TextKeyListener.Capitalize cap, boolean autotext) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static MultiTapKeyListener getInstance(boolean autotext, TextKeyListener.Capitalize cap) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int getInputType() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public boolean onKeyDown(android.view.View view, android.text.Editable content, int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void onSpanChanged(Spannable buf, Object what, int s, int e, int start, int stop) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void onSpanAdded(Spannable s, Object what, int start, int end) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void onSpanRemoved(Spannable s, Object what, int start, int end) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/method/MultiTapKeyListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */