/*    */
package android.inputmethodservice;
/*    */ 
/*    */

import android.content.Context;
/*    */ import android.graphics.Canvas;
/*    */ import android.util.AttributeSet;
/*    */ import android.view.MotionEvent;
/*    */ import android.view.View;
/*    */ import android.view.View.OnClickListener;

/*    */
/*    */ 
/*    */ public class KeyboardView
/*    */ extends View
/*    */ implements View.OnClickListener
/*    */ {
    /*    */
    public KeyboardView(Context context, AttributeSet attrs)
/*    */ {
/* 17 */
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public KeyboardView(Context context, AttributeSet attrs, int defStyle) {
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setOnKeyboardActionListener(OnKeyboardActionListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    protected OnKeyboardActionListener getOnKeyboardActionListener() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void setKeyboard(Keyboard keyboard) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public Keyboard getKeyboard() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public boolean setShifted(boolean shifted) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public boolean isShifted() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void setPreviewEnabled(boolean previewEnabled) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public boolean isPreviewEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setVerticalCorrection(int verticalOffset) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setPopupParent(View v) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setPopupOffset(int x, int y) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void setProximityCorrectionEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public boolean isProximityCorrectionEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void onDraw(Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void invalidateAllKeys() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void invalidateKey(int keyIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    protected boolean onLongPress(Keyboard.Key popupKey) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public boolean onHoverEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public boolean onTouchEvent(MotionEvent me) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    protected void swipeRight() {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    protected void swipeLeft() {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    protected void swipeUp() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    protected void swipeDown() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void closing() {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public void onDetachedFromWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public boolean handleBack() {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public void onClick(View v) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnKeyboardActionListener
/*    */ {
        /*    */
        public abstract void onPress(int paramInt);

        /*    */
/*    */
        public abstract void onRelease(int paramInt);

        /*    */
/*    */
        public abstract void onKey(int paramInt, int[] paramArrayOfInt);

        /*    */
/*    */
        public abstract void onText(CharSequence paramCharSequence);

        /*    */
/*    */
        public abstract void swipeLeft();

        /*    */
/*    */
        public abstract void swipeRight();

        /*    */
/*    */
        public abstract void swipeDown();

        /*    */
/*    */
        public abstract void swipeUp();
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/inputmethodservice/KeyboardView.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */