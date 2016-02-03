/*    */
package android.view.inputmethod;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*  5 */ public final class InputMethodSubtype implements android.os.Parcelable {
    public InputMethodSubtype(int nameId, int iconId, String locale, String mode, String extraValue, boolean isAuxiliary, boolean overridesImplicitlyEnabledSubtype) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public int getNameResId() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public int getIconResId() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public String getLocale() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public String getMode() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public String getExtraValue() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public boolean isAuxiliary() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public boolean overridesImplicitlyEnabledSubtype() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public CharSequence getDisplayName(Context context, String packageName, android.content.pm.ApplicationInfo appInfo) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public boolean containsExtraValueKey(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public String getExtraValueOf(String key) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public boolean equals(Object o) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void writeToParcel(android.os.Parcel dest, int parcelableFlags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 21 */   public static final android.os.Parcelable.Creator<InputMethodSubtype> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/inputmethod/InputMethodSubtype.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */