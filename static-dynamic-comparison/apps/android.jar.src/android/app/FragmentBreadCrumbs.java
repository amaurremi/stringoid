/*    */
package android.app;
/*    */ 
/*    */

import android.content.Context;
/*    */ import android.util.AttributeSet;

/*    */
/*    */ public class FragmentBreadCrumbs extends android.view.ViewGroup implements FragmentManager.OnBackStackChangedListener
/*    */ {
    /*    */
    public FragmentBreadCrumbs(Context context)
/*    */ {
/* 10 */
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public FragmentBreadCrumbs(Context context, AttributeSet attrs) {
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public FragmentBreadCrumbs(Context context, AttributeSet attrs, int defStyle) {
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void setActivity(Activity a) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void setMaxVisible(int visibleCrumbs) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void setParentTitle(CharSequence title, CharSequence shortTitle, android.view.View.OnClickListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void setOnBreadCrumbClickListener(OnBreadCrumbClickListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setTitle(CharSequence title, CharSequence shortTitle) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void onBackStackChanged() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnBreadCrumbClickListener
/*    */ {
        /*    */
        public abstract boolean onBreadCrumbClick(FragmentManager.BackStackEntry paramBackStackEntry, int paramInt);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/FragmentBreadCrumbs.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */