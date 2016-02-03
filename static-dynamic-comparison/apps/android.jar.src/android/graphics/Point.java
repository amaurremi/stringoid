/*    */
package android.graphics;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class Point implements android.os.Parcelable {
    public Point() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public Point(int x, int y) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public Point(Point src) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void set(int x, int y) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public final void negate() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public final void offset(int dx, int dy) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public final boolean equals(int x, int y) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public boolean equals(Object o) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public String toString() {
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
/*    */   public int x;
    /*    */   public int y;
    /* 21 */   public static final android.os.Parcelable.Creator<Point> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/Point.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */