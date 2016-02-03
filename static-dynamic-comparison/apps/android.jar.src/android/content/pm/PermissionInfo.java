/*    */
package android.content.pm;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*    */ public class PermissionInfo extends PackageItemInfo implements android.os.Parcelable {
    /*  6 */
    public PermissionInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public PermissionInfo(PermissionInfo orig) {
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
/*    */   public static final int PROTECTION_NORMAL = 0;
    /*    */   public static final int PROTECTION_DANGEROUS = 1;
    /*    */   public static final int PROTECTION_SIGNATURE = 2;
    /*    */   public static final int PROTECTION_SIGNATURE_OR_SYSTEM = 3;
    /*    */   public static final int PROTECTION_FLAG_SYSTEM = 16;
    /*    */   public static final int PROTECTION_FLAG_DEVELOPMENT = 32;
    /*    */   public static final int PROTECTION_MASK_BASE = 15;
    /*    */   public static final int PROTECTION_MASK_FLAGS = 240;
    /*    */   public String group;
    /*    */   public int descriptionRes;
    /*    */   public CharSequence nonLocalizedDescription;
    /*    */   public int protectionLevel;
    /* 25 */   public static final android.os.Parcelable.Creator<PermissionInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/pm/PermissionInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */