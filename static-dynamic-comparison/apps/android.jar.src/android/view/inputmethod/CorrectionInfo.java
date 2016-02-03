/*    */
package android.view.inputmethod;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public final class CorrectionInfo implements android.os.Parcelable {
    public CorrectionInfo(int offset, CharSequence oldText, CharSequence newText) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public int getOffset() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public CharSequence getOldText() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public CharSequence getNewText() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 13 */   public static final android.os.Parcelable.Creator<CorrectionInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/inputmethod/CorrectionInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */