/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*  5 */ public abstract class AbsSeekBar extends ProgressBar {
    public AbsSeekBar(Context context) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public AbsSeekBar(Context context, android.util.AttributeSet attrs) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public AbsSeekBar(Context context, android.util.AttributeSet attrs, int defStyle) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void setThumb(android.graphics.drawable.Drawable thumb) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public android.graphics.drawable.Drawable getThumb() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getThumbOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void setThumbOffset(int thumbOffset) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void setKeyProgressIncrement(int increment) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int getKeyProgressIncrement() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public synchronized void setMax(int max) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    protected boolean verifyDrawable(android.graphics.drawable.Drawable who) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void jumpDrawablesToCurrentState() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    protected void drawableStateChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    protected synchronized void onDraw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public boolean onTouchEvent(android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean performAccessibilityAction(int action, android.os.Bundle arguments) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/AbsSeekBar.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */