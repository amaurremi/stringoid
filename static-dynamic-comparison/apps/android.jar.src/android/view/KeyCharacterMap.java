/*    */
package android.view;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*    */ public class KeyCharacterMap implements android.os.Parcelable {
    @Deprecated
/*    */ public static class KeyData {
        public static final int META_LENGTH = 4;
        /*    */     public char displayLabel;

        /*  8 */
        public KeyData() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */ 
/*    */     public char number;
        /* 12 */     public char[] meta = null;
/*    */
    }

    /*    */
/*    */   public static class UnavailableException
/*    */ extends android.util.AndroidRuntimeException {
        /* 17 */
        public UnavailableException(String msg) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 19 */   KeyCharacterMap() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public static KeyCharacterMap load(int deviceId) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public int get(int keyCode, int metaState) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public char getNumber(int keyCode) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public char getMatch(int keyCode, char[] chars) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public char getMatch(int keyCode, char[] chars, int metaState) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public char getDisplayLabel(int keyCode) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public static int getDeadChar(int accent, int c) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 29 */ public boolean getKeyData(int keyCode, KeyData results) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public KeyEvent[] getEvents(char[] chars) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public boolean isPrintingKey(int keyCode) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public int getKeyboardType() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public int getModifierBehavior() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public static boolean deviceHasKey(int keyCode) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public static boolean[] deviceHasKeys(int[] keyCodes) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void writeToParcel(Parcel out, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */
    @Deprecated
/*    */ public static final int BUILT_IN_KEYBOARD = 0;
    /*    */   public static final int VIRTUAL_KEYBOARD = -1;
    /*    */   public static final int NUMERIC = 1;
    /*    */   public static final int PREDICTIVE = 2;
    /*    */   public static final int ALPHA = 3;
    /*    */   public static final int FULL = 4;
    /*    */   public static final int SPECIAL_FUNCTION = 5;
    /*    */   public static final char HEX_INPUT = '';
    /*    */   public static final char PICKER_DIALOG_INPUT = '';
    /*    */   public static final int MODIFIER_BEHAVIOR_CHORDED = 0;
    /*    */   public static final int MODIFIER_BEHAVIOR_CHORDED_OR_TOGGLED = 1;
    /*    */   public static final int COMBINING_ACCENT = Integer.MIN_VALUE;
    /*    */   public static final int COMBINING_ACCENT_MASK = Integer.MAX_VALUE;
    /* 53 */   public static final android.os.Parcelable.Creator<KeyCharacterMap> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/KeyCharacterMap.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */