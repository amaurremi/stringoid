/*    */
package android.appwidget;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*  5 */ public class AppWidgetHostView extends android.widget.FrameLayout {
    public AppWidgetHostView(Context context) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*    */
/*  7 */
    public AppWidgetHostView(Context context, int animationIn, int animationOut) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void setAppWidget(int appWidgetId, AppWidgetProviderInfo info) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public static android.graphics.Rect getDefaultPaddingForWidget(Context context, android.content.ComponentName component, android.graphics.Rect padding) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getAppWidgetId() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public AppWidgetProviderInfo getAppWidgetInfo() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    protected void dispatchSaveInstanceState(android.util.SparseArray<android.os.Parcelable> container) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    protected void dispatchRestoreInstanceState(android.util.SparseArray<android.os.Parcelable> container) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void updateAppWidgetSize(android.os.Bundle options, int minWidth, int minHeight, int maxWidth, int maxHeight) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void updateAppWidgetOptions(android.os.Bundle options) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public android.widget.FrameLayout.LayoutParams generateLayoutParams(android.util.AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void updateAppWidget(android.widget.RemoteViews remoteViews) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    protected boolean drawChild(android.graphics.Canvas canvas, android.view.View child, long drawingTime) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    protected void prepareView(android.view.View view) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    protected android.view.View getDefaultView() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    protected android.view.View getErrorView() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/appwidget/AppWidgetHostView.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */