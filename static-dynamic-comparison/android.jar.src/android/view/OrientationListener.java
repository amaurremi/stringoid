/*    */
package android.view;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */
@Deprecated
/*  6 */ public abstract class OrientationListener implements android.hardware.SensorListener {
    public OrientationListener(Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public OrientationListener(Context context, int rate) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void enable() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void disable() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void onAccuracyChanged(int sensor, int accuracy) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void onSensorChanged(int sensor, float[] values) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int ORIENTATION_UNKNOWN = -1;

    /*    */
    public abstract void onOrientationChanged(int paramInt);
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/OrientationListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */