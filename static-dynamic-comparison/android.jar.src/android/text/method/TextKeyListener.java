/*    */
package android.text.method;
/*    */ 
/*    */

import android.text.Editable;

/*    */
/*    */ public class TextKeyListener extends BaseKeyListener implements android.text.SpanWatcher
/*    */ {
    /*    */   public static enum Capitalize {
        /*  8 */     CHARACTERS,
        /*  9 */     NONE,
        /* 10 */     SENTENCES,
        /* 11 */     WORDS;

        /*    */
        private Capitalize() {
        }
    }

    /* 13 */
    public TextKeyListener(Capitalize cap, boolean autotext) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public static TextKeyListener getInstance(boolean autotext, Capitalize cap) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public static TextKeyListener getInstance() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public static boolean shouldCap(Capitalize cap, CharSequence cs, int off) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public int getInputType() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public boolean onKeyDown(android.view.View view, Editable content, int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public boolean onKeyUp(android.view.View view, Editable content, int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public boolean onKeyOther(android.view.View view, Editable content, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public static void clear(Editable e) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void onSpanAdded(android.text.Spannable s, Object what, int start, int end) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void onSpanRemoved(android.text.Spannable s, Object what, int start, int end) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void onSpanChanged(android.text.Spannable s, Object what, int start, int end, int st, int en) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void release() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/method/TextKeyListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */