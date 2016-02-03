/*   */
package android.text.method;
/*   */ 
/*   */

import android.view.View;

/*   */
/* 5 */ public abstract class ReplacementTransformationMethod implements TransformationMethod {
    public ReplacementTransformationMethod() {
        throw new RuntimeException("Stub!");
    }

    /*   */
    protected abstract char[] getOriginal();

    /*   */
    protected abstract char[] getReplacement();

    /* 8 */
    public CharSequence getTransformation(CharSequence source, View v) {
        throw new RuntimeException("Stub!");
    }

    /* 9 */
    public void onFocusChanged(View view, CharSequence sourceText, boolean focused, int direction, android.graphics.Rect previouslyFocusedRect) {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/method/ReplacementTransformationMethod.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */