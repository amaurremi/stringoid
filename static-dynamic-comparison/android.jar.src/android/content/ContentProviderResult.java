/*    */
package android.content;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class ContentProviderResult implements android.os.Parcelable {
    public ContentProviderResult(android.net.Uri uri) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public ContentProviderResult(int count) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public ContentProviderResult(Parcel source) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public final android.net.Uri uri;
    /*    */   public final Integer count;
    /* 14 */   public static final android.os.Parcelable.Creator<ContentProviderResult> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/ContentProviderResult.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */