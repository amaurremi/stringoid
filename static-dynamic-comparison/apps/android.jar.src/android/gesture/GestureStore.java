/*    */
package android.gesture;
/*    */

import java.io.InputStream;

/*    */
/*  4 */ public class GestureStore {
    public GestureStore() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public void setOrientationStyle(int style) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public int getOrientationStyle() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void setSequenceType(int type) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int getSequenceType() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public java.util.Set<String> getGestureEntries() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public java.util.ArrayList<Prediction> recognize(Gesture gesture) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void addGesture(String entryName, Gesture gesture) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void removeGesture(String entryName, Gesture gesture) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void removeEntry(String entryName) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public java.util.ArrayList<Gesture> getGestures(String entryName) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public boolean hasChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void save(java.io.OutputStream stream) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void save(java.io.OutputStream stream, boolean closeStream) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void load(InputStream stream) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void load(InputStream stream, boolean closeStream) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int SEQUENCE_INVARIANT = 1;
    /*    */   public static final int SEQUENCE_SENSITIVE = 2;
    /*    */   public static final int ORIENTATION_INVARIANT = 1;
    /*    */   public static final int ORIENTATION_SENSITIVE = 2;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/gesture/GestureStore.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */