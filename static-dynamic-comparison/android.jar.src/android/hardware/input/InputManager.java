/*    */
package android.hardware.input;
/*    */ 
/*    */

import android.os.Handler;

/*    */
/*    */ 
/*    */ public final class InputManager {
    /*    */   public static final String ACTION_QUERY_KEYBOARD_LAYOUTS = "android.hardware.input.action.QUERY_KEYBOARD_LAYOUTS";
    /*    */   public static final String META_DATA_KEYBOARD_LAYOUTS = "android.hardware.input.metadata.KEYBOARD_LAYOUTS";

    /*    */
/* 10 */   InputManager() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public android.view.InputDevice getInputDevice(int id) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int[] getInputDeviceIds() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void registerInputDeviceListener(InputDeviceListener listener, Handler handler) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void unregisterInputDeviceListener(InputDeviceListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface InputDeviceListener
/*    */ {
        /*    */
        public abstract void onInputDeviceAdded(int paramInt);

        /*    */
/*    */
        public abstract void onInputDeviceRemoved(int paramInt);

        /*    */
/*    */
        public abstract void onInputDeviceChanged(int paramInt);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/hardware/input/InputManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */