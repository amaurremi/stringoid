/*    */
package android.widget;
/*    */ 
/*    */

import android.view.View;

/*    */
/*    */ public class PopupWindow {
    /*    */   public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;

    /*    */
/*  8 */
    public PopupWindow(android.content.Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public PopupWindow(android.content.Context context, android.util.AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public PopupWindow(android.content.Context context, android.util.AttributeSet attrs, int defStyle) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public PopupWindow(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public PopupWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public PopupWindow(View contentView) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public PopupWindow(int width, int height) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public PopupWindow(View contentView, int width, int height) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public PopupWindow(View contentView, int width, int height, boolean focusable) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public android.graphics.drawable.Drawable getBackground() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setBackgroundDrawable(android.graphics.drawable.Drawable background) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public int getAnimationStyle() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setIgnoreCheekPress() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void setAnimationStyle(int animationStyle) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public View getContentView() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void setContentView(View contentView) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void setTouchInterceptor(android.view.View.OnTouchListener l) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean isFocusable() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void setFocusable(boolean focusable) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public int getInputMethodMode() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setInputMethodMode(int mode) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setSoftInputMode(int mode) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public int getSoftInputMode() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public boolean isTouchable() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void setTouchable(boolean touchable) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public boolean isOutsideTouchable() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void setOutsideTouchable(boolean touchable) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public boolean isClippingEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void setClippingEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public boolean isSplitTouchEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void setSplitTouchEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void setWindowLayoutMode(int widthSpec, int heightSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public int getHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public void setHeight(int height) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public int getWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public void setWidth(int width) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public boolean isShowing() {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public void showAtLocation(View parent, int gravity, int x, int y) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public void showAsDropDown(View anchor) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public boolean isAboveAnchor() {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public int getMaxAvailableHeight(View anchor) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public int getMaxAvailableHeight(View anchor, int yOffset) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public void dismiss() {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public void setOnDismissListener(OnDismissListener onDismissListener) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public void update() {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public void update(int width, int height) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public void update(int x, int y, int width, int height) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public void update(int x, int y, int width, int height, boolean force) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public void update(View anchor, int width, int height) {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public void update(View anchor, int xoff, int yoff, int width, int height) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int INPUT_METHOD_NEEDED = 1;
    /*    */   public static final int INPUT_METHOD_NOT_NEEDED = 2;

    /*    */   public static abstract interface OnDismissListener
/*    */ {
        /*    */
        public abstract void onDismiss();
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/PopupWindow.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */