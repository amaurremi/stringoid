/*    */
package android.view.accessibility;
/*    */ 
/*    */

import java.util.List;

/*    */
/*    */ 
/*    */ public final class AccessibilityManager
/*    */ {
    /*  8 */   AccessibilityManager() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public boolean isEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public boolean isTouchExplorationEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void sendAccessibilityEvent(AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void interrupt() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 14 */ public List<android.content.pm.ServiceInfo> getAccessibilityServiceList() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public List<android.accessibilityservice.AccessibilityServiceInfo> getInstalledAccessibilityServiceList() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public List<android.accessibilityservice.AccessibilityServiceInfo> getEnabledAccessibilityServiceList(int feedbackTypeFlags) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public boolean addAccessibilityStateChangeListener(AccessibilityStateChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public boolean removeAccessibilityStateChangeListener(AccessibilityStateChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface AccessibilityStateChangeListener
/*    */ {
        /*    */
        public abstract void onAccessibilityStateChanged(boolean paramBoolean);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/accessibility/AccessibilityManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */