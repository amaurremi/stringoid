/*    */
package android.view.textservice;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public final class SuggestionsInfo implements android.os.Parcelable {
    public SuggestionsInfo(int suggestionsAttributes, String[] suggestions) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public SuggestionsInfo(int suggestionsAttributes, String[] suggestions, int cookie, int sequence) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public SuggestionsInfo(Parcel source) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void setCookieAndSequence(int cookie, int sequence) {
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
    public int getSuggestionsAttributes() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int getSuggestionsCount() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public String getSuggestionAt(int i) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int RESULT_ATTR_IN_THE_DICTIONARY = 1;
    /*    */   public static final int RESULT_ATTR_LOOKS_LIKE_TYPO = 2;
    /*    */   public static final int RESULT_ATTR_HAS_RECOMMENDED_SUGGESTIONS = 4;
    /* 20 */   public static final android.os.Parcelable.Creator<SuggestionsInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/textservice/SuggestionsInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */