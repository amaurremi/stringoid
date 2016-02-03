/*    */
package android.graphics;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*    */ public class Region implements android.os.Parcelable {
    /*    */   public static enum Op {
        /*  7 */     DIFFERENCE,
        /*  8 */     INTERSECT,
        /*  9 */     REPLACE,
        /* 10 */     REVERSE_DIFFERENCE,
        /* 11 */     UNION,
        /* 12 */     XOR;

        /*    */
        private Op() {
        }
    }

    /* 14 */
    public Region() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public Region(Region region) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public Region(Rect r) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public Region(int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setEmpty() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public boolean set(Region region) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public boolean set(Rect r) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public boolean set(int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public boolean setPath(Path path, Region clip) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native boolean isEmpty();

    /*    */
    public native boolean isRect();

    /*    */
    public native boolean isComplex();

    /* 26 */
    public Rect getBounds() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public boolean getBounds(Rect r) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public Path getBoundaryPath() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public boolean getBoundaryPath(Path path) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native boolean contains(int paramInt1, int paramInt2);

    /* 31 */
    public boolean quickContains(Rect r) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native boolean quickContains(int paramInt1, int paramInt2, int paramInt3, int paramInt4);

    /* 33 */
    public boolean quickReject(Rect r) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native boolean quickReject(int paramInt1, int paramInt2, int paramInt3, int paramInt4);

    /*    */
    public native boolean quickReject(Region paramRegion);

    /* 36 */
    public void translate(int dx, int dy) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native void translate(int paramInt1, int paramInt2, Region paramRegion);

    /* 38 */
    public final boolean union(Rect r) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public boolean op(Rect r, Op op) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public boolean op(int left, int top, int right, int bottom, Op op) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public boolean op(Region region, Op op) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public boolean op(Rect rect, Region region, Op op) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public boolean op(Region region1, Region region2, Op op) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public void writeToParcel(Parcel p, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public boolean equals(Object obj) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 50 */   public static final android.os.Parcelable.Creator<Region> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/Region.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */