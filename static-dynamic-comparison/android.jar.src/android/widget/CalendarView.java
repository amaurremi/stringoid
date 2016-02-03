/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */ public class CalendarView extends FrameLayout
/*    */ {
    /*    */
    public CalendarView(Context context)
/*    */ {
/*  9 */
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public CalendarView(Context context, android.util.AttributeSet attrs) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public CalendarView(Context context, android.util.AttributeSet attrs, int defStyle) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void setShownWeekCount(int count) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int getShownWeekCount() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void setSelectedWeekBackgroundColor(int color) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public int getSelectedWeekBackgroundColor() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void setFocusedMonthDateColor(int color) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public int getFocusedMonthDateColor() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setUnfocusedMonthDateColor(int color) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public int getUnfocusedMonthDateColor() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setWeekNumberColor(int color) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public int getWeekNumberColor() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void setWeekSeparatorLineColor(int color) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public int getWeekSeparatorLineColor() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void setSelectedDateVerticalBar(int resourceId) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void setSelectedDateVerticalBar(android.graphics.drawable.Drawable drawable) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public android.graphics.drawable.Drawable getSelectedDateVerticalBar() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setWeekDayTextAppearance(int resourceId) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public int getWeekDayTextAppearance() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setDateTextAppearance(int resourceId) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public int getDateTextAppearance() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void setEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public boolean isEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    protected void onConfigurationChanged(android.content.res.Configuration newConfig) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public long getMinDate() {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void setMinDate(long minDate) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public long getMaxDate() {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void setMaxDate(long maxDate) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void setShowWeekNumber(boolean showWeekNumber) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public boolean getShowWeekNumber() {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public int getFirstDayOfWeek() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public void setFirstDayOfWeek(int firstDayOfWeek) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void setOnDateChangeListener(OnDateChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public long getDate() {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public void setDate(long date) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public void setDate(long date, boolean animate, boolean center) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnDateChangeListener
/*    */ {
        /*    */
        public abstract void onSelectedDayChange(CalendarView paramCalendarView, int paramInt1, int paramInt2, int paramInt3);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/CalendarView.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */