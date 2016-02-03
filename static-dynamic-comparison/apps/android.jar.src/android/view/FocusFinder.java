/*   */
package android.view;
/*   */

import android.graphics.Rect;

/*   */
/* 4 */ public class FocusFinder {
    FocusFinder() {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public static FocusFinder getInstance() {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public final View findNextFocus(ViewGroup root, View focused, int direction) {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public View findNextFocusFromRect(ViewGroup root, Rect focusedRect, int direction) {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public View findNearestTouchable(ViewGroup root, int x, int y, int direction, int[] deltas) {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/FocusFinder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */