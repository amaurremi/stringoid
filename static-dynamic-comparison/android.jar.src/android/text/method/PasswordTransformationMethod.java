/*    */
package android.text.method;
/*    */ 
/*    */

import android.view.View;

/*    */
/*  5 */ public class PasswordTransformationMethod implements TransformationMethod, android.text.TextWatcher {
    public PasswordTransformationMethod() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public CharSequence getTransformation(CharSequence source, View view) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static PasswordTransformationMethod getInstance() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void afterTextChanged(android.text.Editable s) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void onFocusChanged(View view, CharSequence sourceText, boolean focused, int direction, android.graphics.Rect previouslyFocusedRect) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/method/PasswordTransformationMethod.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */