/*    */
package android.content.pm;
/*    */ 
/*    */

import android.util.Printer;

/*    */
/*    */ public class ResolveInfo implements android.os.Parcelable {
    /*    */   public ActivityInfo activityInfo;

    /*    */
/*  8 */   public static class DisplayNameComparator implements java.util.Comparator<ResolveInfo> {
        public DisplayNameComparator(PackageManager pm) {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public final int compare(ResolveInfo a, ResolveInfo b) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 11 */
    public ResolveInfo() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public CharSequence loadLabel(PackageManager pm) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public android.graphics.drawable.Drawable loadIcon(PackageManager pm) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public final int getIconResource() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void dump(Printer pw, String prefix) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void writeToParcel(android.os.Parcel dest, int parcelableFlags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/*    */   public ServiceInfo serviceInfo;
    /*    */   public android.content.IntentFilter filter;
    /*    */   public int priority;
    /*    */   public int preferredOrder;
    /*    */   public int match;
    /*    */   public int specificIndex;
    /*    */   public boolean isDefault;
    /*    */   public int labelRes;
    /*    */   public CharSequence nonLocalizedLabel;
    /*    */   public int icon;
    /*    */   public String resolvePackageName;
    /* 32 */   public static final android.os.Parcelable.Creator<ResolveInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/pm/ResolveInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */