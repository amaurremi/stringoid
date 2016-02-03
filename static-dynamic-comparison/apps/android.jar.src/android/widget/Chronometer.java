/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */
@RemoteViews.RemoteView
/*    */ public class Chronometer extends TextView
/*    */ {
    /*    */
    public Chronometer(Context context)
/*    */ {
/* 10 */
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public Chronometer(Context context, android.util.AttributeSet attrs) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public Chronometer(Context context, android.util.AttributeSet attrs, int defStyle) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void setBase(long base) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public long getBase() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void setFormat(String format) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public String getFormat() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setOnChronometerTickListener(OnChronometerTickListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public OnChronometerTickListener getOnChronometerTickListener() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void start() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void stop() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    protected void onDetachedFromWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    protected void onWindowVisibilityChanged(int visibility) {
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

    /*    */
/*    */   public static abstract interface OnChronometerTickListener
/*    */ {
        /*    */
        public abstract void onChronometerTick(Chronometer paramChronometer);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/Chronometer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */