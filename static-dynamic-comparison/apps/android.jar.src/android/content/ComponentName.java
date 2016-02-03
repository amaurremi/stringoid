/*    */
package android.content;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public final class ComponentName implements android.os.Parcelable, Cloneable, Comparable<ComponentName> {
    public ComponentName(String pkg, String cls) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public ComponentName(Context pkg, String cls) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public ComponentName(Context pkg, Class<?> cls) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public ComponentName(Parcel in) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public ComponentName clone() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public String getPackageName() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public String getClassName() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public String getShortClassName() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public String flattenToString() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public String flattenToShortString() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public static ComponentName unflattenFromString(String str) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public String toShortString() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public boolean equals(Object obj) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public int compareTo(ComponentName that) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void writeToParcel(Parcel out, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public static void writeToParcel(ComponentName c, Parcel out) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public static ComponentName readFromParcel(Parcel in) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 26 */   public static final android.os.Parcelable.Creator<ComponentName> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/ComponentName.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */