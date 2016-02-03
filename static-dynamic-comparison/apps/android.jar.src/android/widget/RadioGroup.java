/*    */
package android.widget;
/*    */ 
/*    */

import android.util.AttributeSet;

/*    */
/*    */ public class RadioGroup extends LinearLayout {
    public static abstract interface OnCheckedChangeListener {
        public abstract void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt);
/*    */
    }

    /*    */
/*  8 */   public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(android.content.Context c, AttributeSet attrs) {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public LayoutParams(int w, int h) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public LayoutParams(int w, int h, float initWeight) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public LayoutParams(android.view.ViewGroup.LayoutParams p) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public LayoutParams(android.view.ViewGroup.MarginLayoutParams source) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        protected void setBaseAttributes(android.content.res.TypedArray a, int widthAttr, int heightAttr) {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */ 
/*    */
    public RadioGroup(android.content.Context context)
/*    */ {
/* 19 */
        super((android.content.Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public RadioGroup(android.content.Context context, AttributeSet attrs) {
        super((android.content.Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void setOnHierarchyChangeListener(android.view.ViewGroup.OnHierarchyChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    protected void onFinishInflate() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void addView(android.view.View child, int index, android.view.ViewGroup.LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void check(int id) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public int getCheckedRadioButtonId() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void clearCheck() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/RadioGroup.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */