/*    */
package android.gesture;
/*    */ 
/*    */

import android.graphics.Path;

/*    */
/*  5 */ public class Gesture implements android.os.Parcelable {
    public Gesture() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public java.util.ArrayList<GestureStroke> getStrokes() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int getStrokesCount() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void addStroke(GestureStroke stroke) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public float getLength() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public android.graphics.RectF getBoundingBox() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public Path toPath() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public Path toPath(Path path) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public Path toPath(int width, int height, int edge, int numSample) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public Path toPath(Path path, int width, int height, int edge, int numSample) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public long getID() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public android.graphics.Bitmap toBitmap(int width, int height, int edge, int numSample, int color) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public android.graphics.Bitmap toBitmap(int width, int height, int inset, int color) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void writeToParcel(android.os.Parcel out, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 22 */   public static final android.os.Parcelable.Creator<Gesture> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/gesture/Gesture.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */