/*    */
package android.content.pm;
/*    */ 
/*    */

import android.util.Printer;

/*    */
/*    */ public class PackageItemInfo {
    public String name;

    /*    */
/*  7 */   public static class DisplayNameComparator implements java.util.Comparator<PackageItemInfo> {
        public DisplayNameComparator(PackageManager pm) {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public final int compare(PackageItemInfo aa, PackageItemInfo ab) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 10 */
    public PackageItemInfo() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public PackageItemInfo(PackageItemInfo orig) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    protected PackageItemInfo(android.os.Parcel source) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public CharSequence loadLabel(PackageManager pm) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public android.graphics.drawable.Drawable loadIcon(PackageManager pm) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public android.graphics.drawable.Drawable loadLogo(PackageManager pm) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public android.content.res.XmlResourceParser loadXmlMetaData(PackageManager pm, String name) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    protected void dumpFront(Printer pw, String prefix) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    protected void dumpBack(Printer pw, String prefix) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void writeToParcel(android.os.Parcel dest, int parcelableFlags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public String packageName;
    /*    */   public int labelRes;
    /*    */   public CharSequence nonLocalizedLabel;
    /*    */   public int icon;
    /*    */   public int logo;
    /*    */   public android.os.Bundle metaData;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/pm/PackageItemInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */