/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */
@RemoteViews.RemoteView
/*  6 */ public class ProgressBar extends android.view.View {
    public ProgressBar(Context context) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public ProgressBar(Context context, android.util.AttributeSet attrs) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public ProgressBar(Context context, android.util.AttributeSet attrs, int defStyle) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*    */
    @android.view.ViewDebug.ExportedProperty(category = "progress")
/* 10 */ public synchronized boolean isIndeterminate() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public synchronized void setIndeterminate(boolean indeterminate) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public android.graphics.drawable.Drawable getIndeterminateDrawable() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void setIndeterminateDrawable(android.graphics.drawable.Drawable d) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public android.graphics.drawable.Drawable getProgressDrawable() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void setProgressDrawable(android.graphics.drawable.Drawable d) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    protected boolean verifyDrawable(android.graphics.drawable.Drawable who) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void jumpDrawablesToCurrentState() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void postInvalidate() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public synchronized void setProgress(int progress) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public synchronized void setSecondaryProgress(int secondaryProgress) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @android.view.ViewDebug.ExportedProperty(category = "progress")
/* 22 */ public synchronized int getProgress() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @android.view.ViewDebug.ExportedProperty(category = "progress")
/* 24 */ public synchronized int getSecondaryProgress() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @android.view.ViewDebug.ExportedProperty(category = "progress")
/* 26 */ public synchronized int getMax() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public synchronized void setMax(int max) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public final synchronized void incrementProgressBy(int diff) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public final synchronized void incrementSecondaryProgressBy(int diff) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void setInterpolator(Context context, int resID) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void setInterpolator(android.view.animation.Interpolator interpolator) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public android.view.animation.Interpolator getInterpolator() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void setVisibility(int v) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    protected void onVisibilityChanged(android.view.View changedView, int visibility) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void invalidateDrawable(android.graphics.drawable.Drawable dr) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    protected synchronized void onDraw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    protected void drawableStateChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public android.os.Parcelable onSaveInstanceState() {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public void onRestoreInstanceState(android.os.Parcelable state) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    protected void onAttachedToWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    protected void onDetachedFromWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/ProgressBar.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */