/*   */
package android.view;
/*   */

import android.content.Context;

/*   */
/* 4 */ public abstract class OrientationEventListener {
    public OrientationEventListener(Context context) {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public OrientationEventListener(Context context, int rate) {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public void enable() {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public void disable() {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public boolean canDetectOrientation() {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   public static final int ORIENTATION_UNKNOWN = -1;

    /*   */
    public abstract void onOrientationChanged(int paramInt);
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/OrientationEventListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */