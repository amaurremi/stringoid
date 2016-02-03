/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */ public class ViewSwitcher extends ViewAnimator
/*    */ {
    /*    */
    public ViewSwitcher(Context context)
/*    */ {
/*  9 */
        super((Context) null, (android.util.AttributeSet) null);
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public ViewSwitcher(Context context, android.util.AttributeSet attrs) {
        super((Context) null, (android.util.AttributeSet) null);
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void addView(android.view.View child, int index, android.view.ViewGroup.LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public android.view.View getNextView() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void setFactory(ViewFactory factory) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void reset() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface ViewFactory
/*    */ {
        /*    */
        public abstract android.view.View makeView();
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/ViewSwitcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */