/*    */
package android.text.method;
/*    */ 
/*    */

import android.view.KeyEvent;

/*    */
/*    */ public abstract class NumberKeyListener extends BaseKeyListener implements android.text.InputFilter {
    /*  6 */
    public NumberKeyListener() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    protected abstract char[] getAcceptedChars();

    /*  8 */
    protected int lookup(KeyEvent event, android.text.Spannable content) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public CharSequence filter(CharSequence source, int start, int end, android.text.Spanned dest, int dstart, int dend) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    protected static boolean ok(char[] accept, char c) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public boolean onKeyDown(android.view.View view, android.text.Editable content, int keyCode, KeyEvent event) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/method/NumberKeyListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */