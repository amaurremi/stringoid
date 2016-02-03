/*    */
package android.content.pm;
/*    */ 
/*    */

import android.content.Intent;

/*    */
/*  5 */ public class LabeledIntent extends Intent {
    public LabeledIntent(Intent origIntent, String sourcePackage, int labelRes, int icon) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public LabeledIntent(Intent origIntent, String sourcePackage, CharSequence nonLocalizedLabel, int icon) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public LabeledIntent(String sourcePackage, int labelRes, int icon) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public LabeledIntent(String sourcePackage, CharSequence nonLocalizedLabel, int icon) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public String getSourcePackage() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getLabelResource() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public CharSequence getNonLocalizedLabel() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int getIconResource() {
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
    public void writeToParcel(android.os.Parcel dest, int parcelableFlags) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void readFromParcel(android.os.Parcel in) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 18 */   public static final android.os.Parcelable.Creator<LabeledIntent> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/pm/LabeledIntent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */