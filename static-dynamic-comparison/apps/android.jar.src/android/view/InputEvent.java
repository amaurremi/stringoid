/*    */
package android.view;
/*    */ 
/*    */

import android.os.Parcelable;

/*    */
/*  5 */ public abstract class InputEvent implements Parcelable {
    InputEvent() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract int getDeviceId();

    /*  7 */
    public final InputDevice getDevice() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract int getSource();

    /*    */
    public abstract long getEventTime();

    /* 10 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 12 */   public static final android.os.Parcelable.Creator<InputEvent> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/InputEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */