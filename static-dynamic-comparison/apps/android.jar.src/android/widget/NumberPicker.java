/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;
/*    */ import android.graphics.Canvas;
/*    */ import android.util.AttributeSet;
/*    */ import android.view.KeyEvent;
/*    */ import android.view.MotionEvent;
/*    */ import android.view.View;
/*    */ import android.view.accessibility.AccessibilityEvent;
/*    */ import android.view.accessibility.AccessibilityNodeProvider;
/*    */ import java.util.ArrayList;

/*    */
/*    */ 
/*    */ 
/*    */ public class NumberPicker
/*    */ extends LinearLayout
/*    */ {
    /*    */
    public NumberPicker(Context context)
/*    */ {
/* 20 */
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public NumberPicker(Context context, AttributeSet attrs) {
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public NumberPicker(Context context, AttributeSet attrs, int defStyle) {
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean onInterceptTouchEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public boolean onTouchEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public boolean dispatchTouchEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public boolean dispatchKeyEvent(KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public boolean dispatchTrackballEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    protected boolean dispatchHoverEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void computeScroll() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void setEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void scrollBy(int x, int y) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public int getSolidColor() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void setOnValueChangedListener(OnValueChangeListener onValueChangedListener) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void setFormatter(Formatter formatter) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void setValue(int value) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public boolean getWrapSelectorWheel() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void setWrapSelectorWheel(boolean wrapSelectorWheel) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public void setOnLongPressUpdateInterval(long intervalMillis) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public int getValue() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public int getMinValue() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void setMinValue(int minValue) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public int getMaxValue() {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public void setMaxValue(int maxValue) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public String[] getDisplayedValues() {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public void setDisplayedValues(String[] displayedValues) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    protected float getTopFadingEdgeStrength() {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    protected float getBottomFadingEdgeStrength() {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    protected void onDetachedFromWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    protected void onDraw(Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface Formatter
/*    */ {
        /*    */
        public abstract String format(int paramInt);
/*    */
    }

    /*    */
/*    */   public static abstract interface OnScrollListener
/*    */ {
        /*    */     public static final int SCROLL_STATE_IDLE = 0;
        /*    */     public static final int SCROLL_STATE_TOUCH_SCROLL = 1;
        /*    */     public static final int SCROLL_STATE_FLING = 2;

        /*    */
/*    */
        public abstract void onScrollStateChange(NumberPicker paramNumberPicker, int paramInt);
/*    */
    }

    /*    */
/*    */   public static abstract interface OnValueChangeListener
/*    */ {
        /*    */
        public abstract void onValueChange(NumberPicker paramNumberPicker, int paramInt1, int paramInt2);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/NumberPicker.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */