/*    */
package android.graphics;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class PointF implements android.os.Parcelable {
    public PointF() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public PointF(float x, float y) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public PointF(Point p) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public final void set(float x, float y) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public final void set(PointF p) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public final void negate() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public final void offset(float dx, float dy) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public final boolean equals(float x, float y) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public final float length() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public static float length(float x, float y) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void writeToParcel(Parcel out, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void readFromParcel(Parcel in) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public float x;
    /*    */   public float y;
    /* 21 */   public static final android.os.Parcelable.Creator<PointF> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/PointF.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */