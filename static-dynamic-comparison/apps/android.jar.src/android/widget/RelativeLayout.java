/*    */
package android.widget;
/*    */ 
/*    */

import android.view.ViewGroup.LayoutParams;

/*    */
/*    */
@RemoteViews.RemoteView
/*    */ public class RelativeLayout extends android.view.ViewGroup {
    public static final int TRUE = -1;
    public static final int LEFT_OF = 0;

    /*    */   public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {
        @android.view.ViewDebug.ExportedProperty(category = "layout")
/*    */ public boolean alignWithParent;

        /*  9 */
        public LayoutParams(android.content.Context c, android.util.AttributeSet attrs) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public LayoutParams(int w, int h) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public LayoutParams(ViewGroup.LayoutParams source) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public LayoutParams(android.view.ViewGroup.MarginLayoutParams source) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public String debug(String output) {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public void addRule(int verb) {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public void addRule(int verb, int anchor) {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        public int[] getRules() {
            throw new RuntimeException("Stub!");
        }
/*    */     
/*    */
    }

    /*    */
/* 20 */
    public RelativeLayout(android.content.Context context) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public RelativeLayout(android.content.Context context, android.util.AttributeSet attrs) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public RelativeLayout(android.content.Context context, android.util.AttributeSet attrs, int defStyle) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public boolean shouldDelayChildPressedState() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void setIgnoreGravity(int viewId) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public int getGravity() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void setGravity(int gravity) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setHorizontalGravity(int horizontalGravity) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setVerticalGravity(int verticalGravity) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public int getBaseline() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void requestLayout() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public LayoutParams generateLayoutParams(android.util.AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int RIGHT_OF = 1;
    /*    */   public static final int ABOVE = 2;
    /*    */   public static final int BELOW = 3;
    /*    */   public static final int ALIGN_BASELINE = 4;
    /*    */   public static final int ALIGN_LEFT = 5;
    /*    */   public static final int ALIGN_TOP = 6;
    /*    */   public static final int ALIGN_RIGHT = 7;
    /*    */   public static final int ALIGN_BOTTOM = 8;
    /*    */   public static final int ALIGN_PARENT_LEFT = 9;
    /*    */   public static final int ALIGN_PARENT_TOP = 10;
    /*    */   public static final int ALIGN_PARENT_RIGHT = 11;
    /*    */   public static final int ALIGN_PARENT_BOTTOM = 12;
    /*    */   public static final int CENTER_IN_PARENT = 13;
    /*    */   public static final int CENTER_HORIZONTAL = 14;
    /*    */   public static final int CENTER_VERTICAL = 15;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/RelativeLayout.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */