/*    */
package android.view.inputmethod;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class ExtractedText implements android.os.Parcelable {
    public ExtractedText() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public CharSequence text;
    /*    */   public int startOffset;
    /*    */   public int partialStartOffset;
    /*    */   public int partialEndOffset;
    /*    */   public int selectionStart;
    /*    */   public int selectionEnd;
    /*    */   public static final int FLAG_SINGLE_LINE = 1;
    /*    */   public static final int FLAG_SELECTING = 2;
    /*    */   public int flags;
    /* 18 */   public static final android.os.Parcelable.Creator<ExtractedText> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/inputmethod/ExtractedText.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */