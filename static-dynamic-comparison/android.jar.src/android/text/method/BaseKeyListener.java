/*    */
package android.text.method;
/*    */ 
/*    */

import android.view.View;

/*    */
/*    */ public abstract class BaseKeyListener extends MetaKeyKeyListener implements KeyListener {
    /*  6 */
    public BaseKeyListener() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public boolean backspace(View view, android.text.Editable content, int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public boolean forwardDelete(View view, android.text.Editable content, int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public boolean onKeyDown(View view, android.text.Editable content, int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public boolean onKeyOther(View view, android.text.Editable content, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/method/BaseKeyListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */