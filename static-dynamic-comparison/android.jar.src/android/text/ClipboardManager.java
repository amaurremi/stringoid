/*   */
package android.text;

/*   */
/*   */
@Deprecated
/*   */ public abstract class ClipboardManager {
    /* 5 */
    public ClipboardManager() {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */
    public abstract CharSequence getText();

    /*   */
/*   */
    public abstract void setText(CharSequence paramCharSequence);

    /*   */
/*   */
    public abstract boolean hasText();
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/ClipboardManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */