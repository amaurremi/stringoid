/*    */
package android.widget;
/*    */ 
/*    */

import android.view.ViewGroup.LayoutParams;

/*    */
/*    */
@Deprecated
/*    */
@RemoteViews.RemoteView
/*    */ public class AbsoluteLayout extends android.view.ViewGroup {
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public int x;
        /*    */     public int y;

        /*    */
/* 10 */
        public LayoutParams(int width, int height, int x, int y) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public LayoutParams(android.content.Context c, android.util.AttributeSet attrs) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public LayoutParams(ViewGroup.LayoutParams source) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public String debug(String output) {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */
    public AbsoluteLayout(android.content.Context context) {
/* 17 */
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public AbsoluteLayout(android.content.Context context, android.util.AttributeSet attrs) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public AbsoluteLayout(android.content.Context context, android.util.AttributeSet attrs, int defStyle) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public ViewGroup.LayoutParams generateLayoutParams(android.util.AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public boolean shouldDelayChildPressedState() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/AbsoluteLayout.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */