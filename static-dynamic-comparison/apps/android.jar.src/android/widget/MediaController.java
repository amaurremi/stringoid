/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;
/*    */ import android.util.AttributeSet;
/*    */ import android.view.KeyEvent;
/*    */ import android.view.MotionEvent;
/*    */ import android.view.View;
/*    */ import android.view.View.OnClickListener;
/*    */ import android.view.accessibility.AccessibilityEvent;
/*    */ import android.view.accessibility.AccessibilityNodeInfo;

/*    */
/*    */ 
/*    */ public class MediaController
/*    */ extends FrameLayout
/*    */ {
    /*    */
    public MediaController(Context context, AttributeSet attrs)
/*    */ {
/* 18 */
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public MediaController(Context context, boolean useFastForward) {
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public MediaController(Context context) {
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void onFinishInflate() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void setMediaPlayer(MediaPlayerControl player) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void setAnchorView(View view) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void show() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void show(int timeout) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public boolean isShowing() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void hide() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public boolean onTouchEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public boolean onTrackballEvent(MotionEvent ev) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public boolean dispatchKeyEvent(KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void setEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void setPrevNextListeners(View.OnClickListener next, View.OnClickListener prev) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface MediaPlayerControl
/*    */ {
        /*    */
        public abstract void start();

        /*    */
/*    */
        public abstract void pause();

        /*    */
/*    */
        public abstract int getDuration();

        /*    */
/*    */
        public abstract int getCurrentPosition();

        /*    */
/*    */
        public abstract void seekTo(int paramInt);

        /*    */
/*    */
        public abstract boolean isPlaying();

        /*    */
/*    */
        public abstract int getBufferPercentage();

        /*    */
/*    */
        public abstract boolean canPause();

        /*    */
/*    */
        public abstract boolean canSeekBackward();

        /*    */
/*    */
        public abstract boolean canSeekForward();
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/MediaController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */