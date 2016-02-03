/*    */
package android.view;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class DragEvent implements android.os.Parcelable {
    DragEvent() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public int getAction() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public float getX() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public float getY() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public android.content.ClipData getClipData() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public android.content.ClipDescription getClipDescription() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public Object getLocalState() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public boolean getResult() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int ACTION_DRAG_STARTED = 1;
    /*    */   public static final int ACTION_DRAG_LOCATION = 2;
    /*    */   public static final int ACTION_DROP = 3;
    /*    */   public static final int ACTION_DRAG_ENDED = 4;
    /*    */   public static final int ACTION_DRAG_ENTERED = 5;
    /*    */   public static final int ACTION_DRAG_EXITED = 6;
    /* 23 */   public static final android.os.Parcelable.Creator<DragEvent> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/DragEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */