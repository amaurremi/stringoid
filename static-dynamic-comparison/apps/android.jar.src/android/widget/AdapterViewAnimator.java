/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */ public abstract class AdapterViewAnimator extends AdapterView<Adapter> implements Advanceable {
    /*  6 */
    public AdapterViewAnimator(Context context) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public AdapterViewAnimator(Context context, android.util.AttributeSet attrs) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public AdapterViewAnimator(Context context, android.util.AttributeSet attrs, int defStyleAttr) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void setDisplayedChild(int whichChild) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getDisplayedChild() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void showNext() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void showPrevious() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean onTouchEvent(android.view.MotionEvent ev) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public android.os.Parcelable onSaveInstanceState() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void onRestoreInstanceState(android.os.Parcelable state) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public android.view.View getCurrentView() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public android.animation.ObjectAnimator getInAnimation() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setInAnimation(android.animation.ObjectAnimator inAnimation) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public android.animation.ObjectAnimator getOutAnimation() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void setOutAnimation(android.animation.ObjectAnimator outAnimation) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void setInAnimation(Context context, int resourceID) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void setOutAnimation(Context context, int resourceID) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void setAnimateFirstView(boolean animate) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public int getBaseline() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public Adapter getAdapter() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setAdapter(Adapter adapter) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setRemoteViewsAdapter(android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void setSelection(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public android.view.View getSelectedView() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void deferNotifyDataSetChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public boolean onRemoteAdapterConnected() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void onRemoteAdapterDisconnected() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void advance() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void fyiWillBeAdvancedByHostKThx() {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/AdapterViewAnimator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */