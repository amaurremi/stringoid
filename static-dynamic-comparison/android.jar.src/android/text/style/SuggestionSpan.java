/*    */
package android.text.style;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */ public class SuggestionSpan extends CharacterStyle implements android.text.ParcelableSpan {
    /*  6 */
    public SuggestionSpan(Context context, String[] suggestions, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public SuggestionSpan(java.util.Locale locale, String[] suggestions, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public SuggestionSpan(Context context, java.util.Locale locale, String[] suggestions, int flags, Class<?> notificationTargetClass) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public SuggestionSpan(android.os.Parcel src) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public String[] getSuggestions() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public String getLocale() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int getFlags() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void setFlags(int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void writeToParcel(android.os.Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int getSpanTypeId() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public boolean equals(Object o) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void updateDrawState(android.text.TextPaint tp) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int FLAG_EASY_CORRECT = 1;
    /*    */   public static final int FLAG_MISSPELLED = 2;
    /*    */   public static final int FLAG_AUTO_CORRECTION = 4;
    /*    */   public static final String ACTION_SUGGESTION_PICKED = "android.text.style.SUGGESTION_PICKED";
    /*    */   public static final String SUGGESTION_SPAN_PICKED_AFTER = "after";
    /*    */   public static final String SUGGESTION_SPAN_PICKED_BEFORE = "before";
    /*    */   public static final String SUGGESTION_SPAN_PICKED_HASHCODE = "hashcode";
    /*    */   public static final int SUGGESTIONS_MAX_SIZE = 5;
    /* 29 */   public static final android.os.Parcelable.Creator<SuggestionSpan> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/style/SuggestionSpan.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */