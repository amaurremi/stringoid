/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */ public class TimePicker extends FrameLayout
/*    */ {
    /*    */
    public TimePicker(Context context)
/*    */ {
/*  9 */
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public TimePicker(Context context, android.util.AttributeSet attrs) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public TimePicker(Context context, android.util.AttributeSet attrs, int defStyle) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void setEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean isEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    protected void onConfigurationChanged(android.content.res.Configuration newConfig) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    protected android.os.Parcelable onSaveInstanceState() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    protected void onRestoreInstanceState(android.os.Parcelable state) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setOnTimeChangedListener(OnTimeChangedListener onTimeChangedListener) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public Integer getCurrentHour() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setCurrentHour(Integer currentHour) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setIs24HourView(Boolean is24HourView) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public boolean is24HourView() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public Integer getCurrentMinute() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void setCurrentMinute(Integer currentMinute) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public int getBaseline() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void onPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnTimeChangedListener
/*    */ {
        /*    */
        public abstract void onTimeChanged(TimePicker paramTimePicker, int paramInt1, int paramInt2);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/TimePicker.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */