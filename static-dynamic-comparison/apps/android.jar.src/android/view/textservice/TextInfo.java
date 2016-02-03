/*    */
package android.view.textservice;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public final class TextInfo implements android.os.Parcelable {
    public TextInfo(String text) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public TextInfo(String text, int cookie, int sequence) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public TextInfo(Parcel source) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public String getText() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getCookie() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int getSequence() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 14 */   public static final android.os.Parcelable.Creator<TextInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/textservice/TextInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */