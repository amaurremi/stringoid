/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;
/*    */ import android.util.AttributeSet;

/*    */
/*    */ public abstract class CompoundButton extends Button implements Checkable
/*    */ {
    /*    */
    public CompoundButton(Context context)
/*    */ {
/* 10 */
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public CompoundButton(Context context, AttributeSet attrs) {
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public CompoundButton(Context context, AttributeSet attrs, int defStyle) {
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void toggle() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public boolean performClick() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @android.view.ViewDebug.ExportedProperty
/* 16 */ public boolean isChecked() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setChecked(boolean checked) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setButtonDrawable(int resid) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setButtonDrawable(android.graphics.drawable.Drawable d) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    protected void onDraw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    protected int[] onCreateDrawableState(int extraSpace) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    protected void drawableStateChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    protected boolean verifyDrawable(android.graphics.drawable.Drawable who) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void jumpDrawablesToCurrentState() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public android.os.Parcelable onSaveInstanceState() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void onRestoreInstanceState(android.os.Parcelable state) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnCheckedChangeListener
/*    */ {
        /*    */
        public abstract void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/CompoundButton.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */