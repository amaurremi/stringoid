/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*  5 */ public abstract class AbsSpinner extends AdapterView<SpinnerAdapter> {
    public AbsSpinner(Context context) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public AbsSpinner(Context context, android.util.AttributeSet attrs) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public AbsSpinner(Context context, android.util.AttributeSet attrs, int defStyle) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void setAdapter(SpinnerAdapter adapter) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void setSelection(int position, boolean animate) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void setSelection(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public android.view.View getSelectedView() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void requestLayout() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public SpinnerAdapter getAdapter() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int getCount() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public int pointToPosition(int x, int y) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public android.os.Parcelable onSaveInstanceState() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void onRestoreInstanceState(android.os.Parcelable state) {
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
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/AbsSpinner.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */