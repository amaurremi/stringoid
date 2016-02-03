/*    */
package android.view.textservice;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public final class SentenceSuggestionsInfo implements android.os.Parcelable {
    public SentenceSuggestionsInfo(SuggestionsInfo[] suggestionsInfos, int[] offsets, int[] lengths) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public SentenceSuggestionsInfo(Parcel source) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int getSuggestionsCount() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public SuggestionsInfo getSuggestionsInfoAt(int i) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int getOffsetAt(int i) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int getLengthAt(int i) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 14 */   public static final android.os.Parcelable.Creator<SentenceSuggestionsInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/textservice/SentenceSuggestionsInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */