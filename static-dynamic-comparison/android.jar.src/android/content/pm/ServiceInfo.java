/*    */
package android.content.pm;
/*    */ 
/*    */

import android.util.Printer;

/*    */
/*    */ public class ServiceInfo extends ComponentInfo implements android.os.Parcelable {
    /*  6 */
    public ServiceInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public ServiceInfo(ServiceInfo orig) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void dump(Printer pw, String prefix) {
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
    public void writeToParcel(android.os.Parcel dest, int parcelableFlags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public String permission;
    /*    */   public static final int FLAG_STOP_WITH_TASK = 1;
    /*    */   public static final int FLAG_ISOLATED_PROCESS = 2;
    /*    */   public int flags;
    /* 17 */   public static final android.os.Parcelable.Creator<ServiceInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/pm/ServiceInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */