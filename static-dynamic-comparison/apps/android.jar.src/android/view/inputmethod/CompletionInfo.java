/*    */
package android.view.inputmethod;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public final class CompletionInfo implements android.os.Parcelable {
    public CompletionInfo(long id, int index, CharSequence text) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public CompletionInfo(long id, int index, CharSequence text, CharSequence label) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public long getId() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int getPosition() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public CharSequence getText() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public CharSequence getLabel() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 15 */   public static final android.os.Parcelable.Creator<CompletionInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/inputmethod/CompletionInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */