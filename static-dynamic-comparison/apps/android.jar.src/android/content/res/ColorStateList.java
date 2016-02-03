/*    */
package android.content.res;
/*    */ 
/*    */

import org.xmlpull.v1.XmlPullParser;

/*    */
/*  5 */ public class ColorStateList implements android.os.Parcelable {
    public ColorStateList(int[][] states, int[] colors) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static ColorStateList valueOf(int color) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static ColorStateList createFromXml(Resources r, XmlPullParser parser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public ColorStateList withAlpha(int alpha) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public boolean isStateful() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getColorForState(int[] stateSet, int defaultColor) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int getDefaultColor() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void writeToParcel(android.os.Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 16 */   public static final android.os.Parcelable.Creator<ColorStateList> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/res/ColorStateList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */