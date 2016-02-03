/*    */
package android.content.pm;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class PathPermission extends android.os.PatternMatcher {
    public PathPermission(String pattern, int type, String readPermission, String writePermission) {
        super((Parcel) null);
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public PathPermission(Parcel src) {
        super((Parcel) null);
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public String getReadPermission() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public String getWritePermission() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 11 */   public static final android.os.Parcelable.Creator<PathPermission> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/pm/PathPermission.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */