/*    */
package android.view.inputmethod;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class ExtractedTextRequest implements android.os.Parcelable {
    public ExtractedTextRequest() {
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
/*    */   public int token;
    /*    */   public int flags;
    /*    */   public int hintMaxLines;
    /*    */   public int hintMaxChars;
    /* 13 */   public static final android.os.Parcelable.Creator<ExtractedTextRequest> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/inputmethod/ExtractedTextRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */