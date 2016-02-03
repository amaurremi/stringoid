/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;
/*    */ import android.view.View;

/*    */
/*    */ public abstract class AdapterView<T extends Adapter> extends android.view.ViewGroup
/*    */ {
    /*    */   public static final int ITEM_VIEW_TYPE_IGNORE = -1;
    /*    */   public static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
    /*    */   public static final int INVALID_POSITION = -1;
    /*    */   public static final long INVALID_ROW_ID = Long.MIN_VALUE;

    /*    */
/*    */   public static class AdapterContextMenuInfo implements android.view.ContextMenu.ContextMenuInfo
/*    */ {
        /*    */     public View targetView;
        /*    */     public int position;
        /*    */     public long id;

        /*    */
/*    */
        public AdapterContextMenuInfo(View targetView, int position, long id)
/*    */ {
/* 21 */
            throw new RuntimeException("Stub!");
/*    */
        }
/*    */
    }

    /*    */
/*    */
    public AdapterView(Context context) {
/* 26 */
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public AdapterView(Context context, android.util.AttributeSet attrs) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public AdapterView(Context context, android.util.AttributeSet attrs, int defStyle) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setOnItemClickListener(OnItemClickListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public final OnItemClickListener getOnItemClickListener() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public boolean performItemClick(View view, int position, long id) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public final OnItemLongClickListener getOnItemLongClickListener() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void setOnItemSelectedListener(OnItemSelectedListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public final OnItemSelectedListener getOnItemSelectedListener() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract T getAdapter();

    /*    */
    public abstract void setAdapter(T paramT);

    /* 38 */
    public void addView(View child) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void addView(View child, int index) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void addView(View child, android.view.ViewGroup.LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public void addView(View child, int index, android.view.ViewGroup.LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public void removeView(View child) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public void removeViewAt(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void removeAllViews() {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @android.view.ViewDebug.CapturedViewProperty
/* 47 */ public int getSelectedItemPosition() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @android.view.ViewDebug.CapturedViewProperty
/* 49 */ public long getSelectedItemId() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract View getSelectedView();

    /* 51 */
    public Object getSelectedItem() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @android.view.ViewDebug.CapturedViewProperty
/* 53 */ public int getCount() {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public int getPositionForView(View view) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public int getFirstVisiblePosition() {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public int getLastVisiblePosition() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract void setSelection(int paramInt);

    /* 58 */
    public void setEmptyView(View emptyView) {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public View getEmptyView() {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public void setFocusable(boolean focusable) {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public void setFocusableInTouchMode(boolean focusable) {
        throw new RuntimeException("Stub!");
    }

    /* 62 */
    public Object getItemAtPosition(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 63 */
    public long getItemIdAtPosition(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 64 */
    public void setOnClickListener(android.view.View.OnClickListener l) {
        throw new RuntimeException("Stub!");
    }

    /* 65 */
    protected void dispatchSaveInstanceState(android.util.SparseArray<android.os.Parcelable> container) {
        throw new RuntimeException("Stub!");
    }

    /* 66 */
    protected void dispatchRestoreInstanceState(android.util.SparseArray<android.os.Parcelable> container) {
        throw new RuntimeException("Stub!");
    }

    /* 67 */
    protected void onDetachedFromWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 68 */
    public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 69 */
    public boolean onRequestSendAccessibilityEvent(View child, android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 70 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /* 71 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 72 */
    protected boolean canAnimate() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnItemSelectedListener
/*    */ {
        /*    */
        public abstract void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong);

        /*    */
/*    */
        public abstract void onNothingSelected(AdapterView<?> paramAdapterView);
/*    */
    }

    /*    */
/*    */   public static abstract interface OnItemLongClickListener
/*    */ {
        /*    */
        public abstract boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong);
/*    */
    }

    /*    */
/*    */   public static abstract interface OnItemClickListener
/*    */ {
        /*    */
        public abstract void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/AdapterView.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */