/*    */
package android.graphics;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class RectF implements android.os.Parcelable {
    public RectF() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public RectF(float left, float top, float right, float bottom) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public RectF(RectF r) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public RectF(Rect r) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public boolean equals(Object o) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public String toShortString() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public final boolean isEmpty() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public final float width() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public final float height() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public final float centerX() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public final float centerY() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setEmpty() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void set(float left, float top, float right, float bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void set(RectF src) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void set(Rect src) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void offset(float dx, float dy) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void offsetTo(float newLeft, float newTop) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void inset(float dx, float dy) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean contains(float x, float y) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public boolean contains(float left, float top, float right, float bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public boolean contains(RectF r) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public boolean intersect(float left, float top, float right, float bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public boolean intersect(RectF r) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public boolean setIntersect(RectF a, RectF b) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public boolean intersects(float left, float top, float right, float bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public static boolean intersects(RectF a, RectF b) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void round(Rect dst) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void roundOut(Rect dst) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void union(float left, float top, float right, float bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void union(RectF r) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void union(float x, float y) {
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
/*    */   public float left;
    /*    */   public float top;
    /*    */   public float right;
    /*    */   public float bottom;
    /* 47 */   public static final android.os.Parcelable.Creator<RectF> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/RectF.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */