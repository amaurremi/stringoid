/*   */
package android.text.style;
/*   */

import android.text.TextPaint;

/*   */
/* 4 */ public abstract class CharacterStyle {
    public CharacterStyle() {
        throw new RuntimeException("Stub!");
    }

    /*   */
    public abstract void updateDrawState(TextPaint paramTextPaint);

    /* 6 */
    public static CharacterStyle wrap(CharacterStyle cs) {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public CharacterStyle getUnderlying() {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/style/CharacterStyle.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */