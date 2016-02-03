/*    */
package android.text.method;
/*    */ 
/*    */

import android.text.Spanned;

/*    */
/*  5 */ public class DigitsKeyListener extends NumberKeyListener {
    public DigitsKeyListener() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public DigitsKeyListener(boolean sign, boolean decimal) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    protected char[] getAcceptedChars() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public static DigitsKeyListener getInstance() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public static DigitsKeyListener getInstance(boolean sign, boolean decimal) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public static DigitsKeyListener getInstance(String accepted) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int getInputType() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/method/DigitsKeyListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */