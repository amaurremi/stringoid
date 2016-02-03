/*    */
package android.content.pm;
/*    */ 
/*    */

import android.util.Printer;

/*    */
/*  5 */ public class ComponentInfo extends PackageItemInfo {
    public ComponentInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public ComponentInfo(ComponentInfo orig) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    protected ComponentInfo(android.os.Parcel source) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public CharSequence loadLabel(PackageManager pm) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public boolean isEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public final int getIconResource() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    protected void dumpFront(Printer pw, String prefix) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    protected void dumpBack(Printer pw, String prefix) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void writeToParcel(android.os.Parcel dest, int parcelableFlags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public ApplicationInfo applicationInfo;
    /*    */   public String processName;
    /*    */   public int descriptionRes;
    /*    */   public boolean enabled;
    /*    */   public boolean exported;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/pm/ComponentInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */