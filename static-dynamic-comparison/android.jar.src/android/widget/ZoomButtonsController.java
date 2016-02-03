/*    */
package android.widget;
/*    */ 
/*    */

import android.view.MotionEvent;
/*    */ import android.view.View;

/*    */
/*    */ 
/*    */ public class ZoomButtonsController
/*    */ implements android.view.View.OnTouchListener
/*    */ {
    /* 10 */
    public ZoomButtonsController(View ownerView) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void setZoomInEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void setZoomOutEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void setZoomSpeed(long speed) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void setOnZoomListener(OnZoomListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void setFocusable(boolean focusable) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public boolean isAutoDismissed() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setAutoDismissed(boolean autoDismiss) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public boolean isVisible() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setVisible(boolean visible) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public android.view.ViewGroup getContainer() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public View getZoomControls() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public boolean onTouch(View v, MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnZoomListener
/*    */ {
        /*    */
        public abstract void onVisibilityChanged(boolean paramBoolean);

        /*    */
/*    */
        public abstract void onZoom(boolean paramBoolean);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/ZoomButtonsController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */