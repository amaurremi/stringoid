/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */
@RemoteViews.RemoteView
/*    */ public class ImageView extends android.view.View {
    /*    */   public static enum ScaleType {
        /*  8 */     CENTER,
        /*  9 */     CENTER_CROP,
        /* 10 */     CENTER_INSIDE,
        /* 11 */     FIT_CENTER,
        /* 12 */     FIT_END,
        /* 13 */     FIT_START,
        /* 14 */     FIT_XY,
        /* 15 */     MATRIX;

        /*    */
        private ScaleType() {
        }
    }

    /* 17 */
    public ImageView(Context context) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public ImageView(Context context, android.util.AttributeSet attrs) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public ImageView(Context context, android.util.AttributeSet attrs, int defStyle) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    protected boolean verifyDrawable(android.graphics.drawable.Drawable dr) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void jumpDrawablesToCurrentState() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void invalidateDrawable(android.graphics.drawable.Drawable dr) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public boolean hasOverlappingRendering() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void onPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean getAdjustViewBounds() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void setAdjustViewBounds(boolean adjustViewBounds) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public int getMaxWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setMaxWidth(int maxWidth) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public int getMaxHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void setMaxHeight(int maxHeight) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public android.graphics.drawable.Drawable getDrawable() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void setImageResource(int resId) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void setImageURI(android.net.Uri uri) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void setImageDrawable(android.graphics.drawable.Drawable drawable) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void setImageBitmap(android.graphics.Bitmap bm) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void setImageState(int[] state, boolean merge) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void setSelected(boolean selected) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void setImageLevel(int level) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void setScaleType(ScaleType scaleType) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public ScaleType getScaleType() {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public android.graphics.Matrix getImageMatrix() {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public void setImageMatrix(android.graphics.Matrix matrix) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public boolean getCropToPadding() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void setCropToPadding(boolean cropToPadding) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public int[] onCreateDrawableState(int extraSpace) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    protected boolean setFrame(int l, int t, int r, int b) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    protected void drawableStateChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    protected void onDraw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @android.view.ViewDebug.ExportedProperty(category = "layout")
/* 51 */ public int getBaseline() {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public void setBaseline(int baseline) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public void setBaselineAlignBottom(boolean aligned) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public boolean getBaselineAlignBottom() {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public final void setColorFilter(int color, android.graphics.PorterDuff.Mode mode) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public final void setColorFilter(int color) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public final void clearColorFilter() {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public android.graphics.ColorFilter getColorFilter() {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public void setColorFilter(android.graphics.ColorFilter cf) {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public int getImageAlpha() {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public void setImageAlpha(int alpha) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 63 */ public void setAlpha(int alpha) {
        throw new RuntimeException("Stub!");
    }

    /* 64 */
    public void setVisibility(int visibility) {
        throw new RuntimeException("Stub!");
    }

    /* 65 */
    protected void onAttachedToWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 66 */
    protected void onDetachedFromWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 67 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 68 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/ImageView.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */