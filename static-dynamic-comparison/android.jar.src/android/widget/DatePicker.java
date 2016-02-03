/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */ public class DatePicker extends FrameLayout
/*    */ {
    /*    */
    public DatePicker(Context context)
/*    */ {
/*  9 */
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public DatePicker(Context context, android.util.AttributeSet attrs) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public DatePicker(Context context, android.util.AttributeSet attrs, int defStyle) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public long getMinDate() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void setMinDate(long minDate) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public long getMaxDate() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void setMaxDate(long maxDate) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void setEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public boolean isEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void onPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    protected void onConfigurationChanged(android.content.res.Configuration newConfig) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public boolean getCalendarViewShown() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public CalendarView getCalendarView() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void setCalendarViewShown(boolean shown) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public boolean getSpinnersShown() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setSpinnersShown(boolean shown) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void updateDate(int year, int month, int dayOfMonth) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    protected void dispatchRestoreInstanceState(android.util.SparseArray<android.os.Parcelable> container) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    protected android.os.Parcelable onSaveInstanceState() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    protected void onRestoreInstanceState(android.os.Parcelable state) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void init(int year, int monthOfYear, int dayOfMonth, OnDateChangedListener onDateChangedListener) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public int getYear() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public int getMonth() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public int getDayOfMonth() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnDateChangedListener
/*    */ {
        /*    */
        public abstract void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/DatePicker.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */