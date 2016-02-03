/*    */
package android.graphics;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public final class Rect implements android.os.Parcelable {
    public Rect() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public Rect(int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public Rect(Rect r) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public boolean equals(Object o) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public String toShortString() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public String flattenToString() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public static Rect unflattenFromString(String str) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public final boolean isEmpty() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public final int width() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public final int height() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public final int centerX() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public final int centerY() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public final float exactCenterX() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public final float exactCenterY() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void setEmpty() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void set(int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void set(Rect src) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void offset(int dx, int dy) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void offsetTo(int newLeft, int newTop) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void inset(int dx, int dy) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public boolean contains(int x, int y) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public boolean contains(int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public boolean contains(Rect r) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public boolean intersect(int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public boolean intersect(Rect r) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public boolean setIntersect(Rect a, Rect b) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public boolean intersects(int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public static boolean intersects(Rect a, Rect b) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void union(int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void union(Rect r) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void union(int x, int y) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void sort() {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void writeToParcel(Parcel out, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public void readFromParcel(Parcel in) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public int left;
    /*    */   public int top;
    /*    */   public int right;
    /*    */   public int bottom;
    /* 47 */   public static final android.os.Parcelable.Creator<Rect> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/Rect.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */