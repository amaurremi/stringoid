/*    */
package android.content;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClipboardManager
/*    */ extends android.text.ClipboardManager
/*    */ {
    /*  9 */   ClipboardManager() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void setPrimaryClip(ClipData clip) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public ClipData getPrimaryClip() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public ClipDescription getPrimaryClipDescription() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean hasPrimaryClip() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void addPrimaryClipChangedListener(OnPrimaryClipChangedListener what) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void removePrimaryClipChangedListener(OnPrimaryClipChangedListener what) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 17 */ public CharSequence getText() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 19 */ public void setText(CharSequence text) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 21 */ public boolean hasText() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnPrimaryClipChangedListener
/*    */ {
        /*    */
        public abstract void onPrimaryClipChanged();
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/ClipboardManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */