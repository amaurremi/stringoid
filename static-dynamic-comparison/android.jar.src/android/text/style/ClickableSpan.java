/*   */
package android.text.style;
/*   */ 
/*   */

import android.text.TextPaint;

/*   */
/*   */ public abstract class ClickableSpan extends CharacterStyle implements UpdateAppearance {
    /* 6 */
    public ClickableSpan() {
        throw new RuntimeException("Stub!");
    }

    /*   */
    public abstract void onClick(android.view.View paramView);

    /* 8 */
    public void updateDrawState(TextPaint ds) {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/style/ClickableSpan.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */