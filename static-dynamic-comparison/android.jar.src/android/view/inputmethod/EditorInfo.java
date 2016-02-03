/*    */
package android.view.inputmethod;
/*    */ 
/*    */

import android.util.Printer;

/*    */
/*  5 */ public class EditorInfo implements android.text.InputType, android.os.Parcelable {
    public EditorInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public final void makeCompatible(int targetSdkVersion) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void dump(Printer pw, String prefix) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void writeToParcel(android.os.Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public int inputType;
    /*    */   public static final int IME_MASK_ACTION = 255;
    /*    */   public static final int IME_ACTION_UNSPECIFIED = 0;
    /*    */   public static final int IME_ACTION_NONE = 1;
    /*    */   public static final int IME_ACTION_GO = 2;
    /*    */   public static final int IME_ACTION_SEARCH = 3;
    /*    */   public static final int IME_ACTION_SEND = 4;
    /*    */   public static final int IME_ACTION_NEXT = 5;
    /*    */   public static final int IME_ACTION_DONE = 6;
    /*    */   public static final int IME_ACTION_PREVIOUS = 7;
    /*    */   public static final int IME_FLAG_NO_FULLSCREEN = 33554432;
    /*    */   public static final int IME_FLAG_NAVIGATE_PREVIOUS = 67108864;
    /*    */   public static final int IME_FLAG_NAVIGATE_NEXT = 134217728;
    /*    */   public static final int IME_FLAG_NO_EXTRACT_UI = 268435456;
    /*    */   public static final int IME_FLAG_NO_ACCESSORY_ACTION = 536870912;
    /*    */   public static final int IME_FLAG_NO_ENTER_ACTION = 1073741824;
    /*    */   public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    /*    */   public static final int IME_NULL = 0;
    /*    */   public int imeOptions;
    /*    */   public String privateImeOptions;
    /*    */   public CharSequence actionLabel;
    /*    */   public int actionId;
    /*    */   public int initialSelStart;
    /*    */   public int initialSelEnd;
    /*    */   public int initialCapsMode;
    /*    */   public CharSequence hintText;
    /*    */   public CharSequence label;
    /*    */   public String packageName;
    /*    */   public int fieldId;
    /*    */   public String fieldName;
    /*    */   public android.os.Bundle extras;
    /* 42 */   public static final android.os.Parcelable.Creator<EditorInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/inputmethod/EditorInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */