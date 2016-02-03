/*   */
package android.view.accessibility;
/*   */

import android.os.Bundle;

/*   */
/* 4 */ public abstract class AccessibilityNodeProvider {
    public AccessibilityNodeProvider() {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public boolean performAction(int virtualViewId, int action, Bundle arguments) {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public java.util.List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String text, int virtualViewId) {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/accessibility/AccessibilityNodeProvider.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */