/*    */
package android.content.pm;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*    */ public final class ProviderInfo extends ComponentInfo implements android.os.Parcelable {
    public String authority;
    public String readPermission;

    /*  6 */
    public ProviderInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public ProviderInfo(ProviderInfo orig) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void writeToParcel(Parcel out, int parcelableFlags) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/*    */   public String writePermission;
    /*    */   public boolean grantUriPermissions;
    /* 15 */   public android.os.PatternMatcher[] uriPermissionPatterns = null;
    /* 16 */   public PathPermission[] pathPermissions = null;
    /*    */
/*    */   public boolean multiprocess;
    /*    */   public int initOrder;
    /*    */
    @Deprecated
/*    */ public boolean isSyncable;
    /* 22 */   public static final android.os.Parcelable.Creator<ProviderInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/pm/ProviderInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */