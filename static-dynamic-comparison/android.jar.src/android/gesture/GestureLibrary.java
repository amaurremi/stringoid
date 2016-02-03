/*    */
package android.gesture;
/*    */

import java.util.ArrayList;

/*    */
/*  4 */ public abstract class GestureLibrary {
    protected GestureLibrary() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract boolean save();

    /*    */
    public abstract boolean load();

    /*  7 */
    public boolean isReadOnly() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void setOrientationStyle(int style) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int getOrientationStyle() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void setSequenceType(int type) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int getSequenceType() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public java.util.Set<String> getGestureEntries() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public ArrayList<Prediction> recognize(Gesture gesture) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void addGesture(String entryName, Gesture gesture) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void removeGesture(String entryName, Gesture gesture) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void removeEntry(String entryName) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public ArrayList<Gesture> getGestures(String entryName) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   protected final GestureStore mStore;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/gesture/GestureLibrary.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */