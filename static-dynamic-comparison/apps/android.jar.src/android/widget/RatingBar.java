/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */ public class RatingBar extends AbsSeekBar
/*    */ {
    /*    */
    public RatingBar(Context context, android.util.AttributeSet attrs, int defStyle)
/*    */ {
/*  9 */
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public RatingBar(Context context, android.util.AttributeSet attrs) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public RatingBar(Context context) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void setOnRatingBarChangeListener(OnRatingBarChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public OnRatingBarChangeListener getOnRatingBarChangeListener() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void setIsIndicator(boolean isIndicator) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public boolean isIndicator() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void setNumStars(int numStars) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public int getNumStars() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setRating(float rating) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public float getRating() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setStepSize(float stepSize) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public float getStepSize() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public synchronized void setMax(int max) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnRatingBarChangeListener
/*    */ {
        /*    */
        public abstract void onRatingChanged(RatingBar paramRatingBar, float paramFloat, boolean paramBoolean);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/RatingBar.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */