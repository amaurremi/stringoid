/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;
/*    */ import android.util.AttributeSet;
/*    */ import android.view.accessibility.AccessibilityEvent;

/*    */
/*    */ public class SeekBar extends AbsSeekBar
/*    */ {
    /*    */
    public SeekBar(Context context)
/*    */ {
/* 11 */
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public SeekBar(Context context, AttributeSet attrs) {
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public SeekBar(Context context, AttributeSet attrs, int defStyle) {
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void setOnSeekBarChangeListener(OnSeekBarChangeListener l) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnSeekBarChangeListener
/*    */ {
        /*    */
        public abstract void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean);

        /*    */
/*    */
        public abstract void onStartTrackingTouch(SeekBar paramSeekBar);

        /*    */
/*    */
        public abstract void onStopTrackingTouch(SeekBar paramSeekBar);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/SeekBar.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */