/*    */
package android.content.pm;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class ConfigurationInfo implements android.os.Parcelable {
    public ConfigurationInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public ConfigurationInfo(ConfigurationInfo orig) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public String getGlEsVersion() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public int reqTouchScreen;
    /*    */   public int reqKeyboardType;
    /*    */   public int reqNavigation;
    /*    */   public static final int INPUT_FEATURE_HARD_KEYBOARD = 1;
    /*    */   public static final int INPUT_FEATURE_FIVE_WAY_NAV = 2;
    /*    */   public int reqInputFeatures;
    /*    */   public static final int GL_ES_VERSION_UNDEFINED = 0;
    /*    */   public int reqGlEsVersion;
    /* 20 */   public static final android.os.Parcelable.Creator<ConfigurationInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/pm/ConfigurationInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */