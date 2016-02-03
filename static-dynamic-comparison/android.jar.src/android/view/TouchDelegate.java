/*   */
package android.view;
/*   */

import android.graphics.Rect;

/*   */
/* 4 */ public class TouchDelegate {
    public TouchDelegate(Rect bounds, View delegateView) {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public boolean onTouchEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   public static final int ABOVE = 1;
    /*   */   public static final int BELOW = 2;
    /*   */   public static final int TO_LEFT = 4;
    /*   */   public static final int TO_RIGHT = 8;
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/TouchDelegate.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */