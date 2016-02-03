/*    */
package android.content.pm;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*    */ public class PermissionGroupInfo extends PackageItemInfo implements android.os.Parcelable {
    /*  6 */
    public PermissionGroupInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public PermissionGroupInfo(PermissionGroupInfo orig) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public CharSequence loadDescription(PackageManager pm) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public int descriptionRes;
    /*    */   public CharSequence nonLocalizedDescription;
    /* 15 */   public static final android.os.Parcelable.Creator<PermissionGroupInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/pm/PermissionGroupInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */