/*    */
package android.text.method;
/*    */

import android.text.Editable;

/*    */
/*  4 */ public abstract class MetaKeyKeyListener {
    public MetaKeyKeyListener() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public static void resetMetaState(android.text.Spannable text) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static final int getMetaState(CharSequence text) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static final int getMetaState(CharSequence text, int meta) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public static void adjustMetaAfterKeypress(android.text.Spannable content) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public static boolean isMetaTracker(CharSequence text, Object what) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public static boolean isSelectingMetaTracker(CharSequence text, Object what) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    protected static void resetLockedMeta(android.text.Spannable content) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public boolean onKeyDown(android.view.View view, Editable content, int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean onKeyUp(android.view.View view, Editable content, int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void clearMetaKeyState(android.view.View view, Editable content, int states) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public static void clearMetaKeyState(Editable content, int states) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public static long resetLockedMeta(long state) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public static final int getMetaState(long state) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public static final int getMetaState(long state, int meta) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public static long adjustMetaAfterKeypress(long state) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public static long handleKeyDown(long state, int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public static long handleKeyUp(long state, int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public long clearMetaKeyState(long state, int which) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int META_SHIFT_ON = 1;
    /*    */   public static final int META_ALT_ON = 2;
    /*    */   public static final int META_SYM_ON = 4;
    /*    */   public static final int META_CAP_LOCKED = 256;
    /*    */   public static final int META_ALT_LOCKED = 512;
    /*    */   public static final int META_SYM_LOCKED = 1024;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/method/MetaKeyKeyListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */