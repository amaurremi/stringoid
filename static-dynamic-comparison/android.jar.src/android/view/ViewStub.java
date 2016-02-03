/*    */
package android.view;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */
@android.widget.RemoteViews.RemoteView
/*    */ public final class ViewStub extends View
/*    */ {
    /*    */
    public ViewStub(Context context)
/*    */ {
/* 10 */
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public ViewStub(Context context, int layoutResource) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public ViewStub(Context context, android.util.AttributeSet attrs) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 14 */
    public ViewStub(Context context, android.util.AttributeSet attrs, int defStyle) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public int getInflatedId() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void setInflatedId(int inflatedId) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public int getLayoutResource() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setLayoutResource(int layoutResource) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setLayoutInflater(LayoutInflater inflater) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public LayoutInflater getLayoutInflater() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void draw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void setVisibility(int visibility) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public View inflate() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void setOnInflateListener(OnInflateListener inflateListener) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnInflateListener
/*    */ {
        /*    */
        public abstract void onInflate(ViewStub paramViewStub, View paramView);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/ViewStub.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */