/*    */
package android.app;
/*    */ 
/*    */

import android.view.SurfaceHolder;

/*    */
/*    */ public class NativeActivity extends Activity implements android.view.SurfaceHolder.Callback2, android.view.InputQueue.Callback, android.view.ViewTreeObserver.OnGlobalLayoutListener {
    /*  6 */
    public NativeActivity() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    protected void onCreate(android.os.Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    protected void onDestroy() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    protected void onPause() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    protected void onResume() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    protected void onSaveInstanceState(android.os.Bundle outState) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    protected void onStart() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    protected void onStop() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void onConfigurationChanged(android.content.res.Configuration newConfig) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void onLowMemory() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void onWindowFocusChanged(boolean hasFocus) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public boolean dispatchKeyEvent(android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void surfaceCreated(SurfaceHolder holder) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void surfaceRedrawNeeded(SurfaceHolder holder) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void surfaceDestroyed(SurfaceHolder holder) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void onInputQueueCreated(android.view.InputQueue queue) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void onInputQueueDestroyed(android.view.InputQueue queue) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void onGlobalLayout() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final String META_DATA_LIB_NAME = "android.app.lib_name";
    /*    */   public static final String META_DATA_FUNC_NAME = "android.app.func_name";
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/NativeActivity.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */