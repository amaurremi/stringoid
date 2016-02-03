/*    */
package android.content;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class ClipDescription implements android.os.Parcelable {
    public ClipDescription(CharSequence label, String[] mimeTypes) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public ClipDescription(ClipDescription o) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static boolean compareMimeTypes(String concreteType, String desiredType) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public CharSequence getLabel() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public boolean hasMimeType(String mimeType) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public String[] filterMimeTypes(String mimeType) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int getMimeTypeCount() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public String getMimeType(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final String MIMETYPE_TEXT_PLAIN = "text/plain";
    /*    */   public static final String MIMETYPE_TEXT_HTML = "text/html";
    /*    */   public static final String MIMETYPE_TEXT_URILIST = "text/uri-list";
    /*    */   public static final String MIMETYPE_TEXT_INTENT = "text/vnd.android.intent";
    /* 21 */   public static final android.os.Parcelable.Creator<ClipDescription> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/ClipDescription.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */