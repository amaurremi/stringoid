/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;
/*    */ import android.content.Intent;
/*    */ import android.graphics.Bitmap;

/*    */
/*    */ public class RemoteViews
/*    */ implements android.os.Parcelable, android.view.LayoutInflater.Filter
/*    */ {
    /*    */   public static class ActionException
/*    */ extends RuntimeException
/*    */ {
        /* 13 */
        public ActionException(Exception ex) {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public ActionException(String message) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 16 */
    public RemoteViews(String packageName, int layoutId) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public RemoteViews(RemoteViews landscape, RemoteViews portrait) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public RemoteViews(android.os.Parcel parcel) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public RemoteViews clone() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public String getPackage() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public int getLayoutId() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void addView(int viewId, RemoteViews nestedView) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void removeAllViews(int viewId) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void showNext(int viewId) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void showPrevious(int viewId) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void setDisplayedChild(int viewId, int childIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setViewVisibility(int viewId, int visibility) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setTextViewText(int viewId, CharSequence text) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setTextViewTextSize(int viewId, int units, float size) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void setTextViewCompoundDrawables(int viewId, int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void setTextViewCompoundDrawablesRelative(int viewId, int start, int top, int end, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void setImageViewResource(int viewId, int srcId) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void setImageViewUri(int viewId, android.net.Uri uri) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void setImageViewBitmap(int viewId, Bitmap bitmap) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void setEmptyView(int viewId, int emptyViewId) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void setChronometer(int viewId, long base, String format, boolean started) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void setProgressBar(int viewId, int max, int progress, boolean indeterminate) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void setOnClickPendingIntent(int viewId, android.app.PendingIntent pendingIntent) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void setPendingIntentTemplate(int viewId, android.app.PendingIntent pendingIntentTemplate) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void setOnClickFillInIntent(int viewId, Intent fillInIntent) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public void setTextColor(int viewId, int color) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 43 */ public void setRemoteAdapter(int appWidgetId, int viewId, Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void setRemoteAdapter(int viewId, Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public void setScrollPosition(int viewId, int position) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public void setRelativeScrollPosition(int viewId, int offset) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public void setViewPadding(int viewId, int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public void setBoolean(int viewId, String methodName, boolean value) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public void setByte(int viewId, String methodName, byte value) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public void setShort(int viewId, String methodName, short value) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public void setInt(int viewId, String methodName, int value) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public void setLong(int viewId, String methodName, long value) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public void setFloat(int viewId, String methodName, float value) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public void setDouble(int viewId, String methodName, double value) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public void setChar(int viewId, String methodName, char value) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public void setString(int viewId, String methodName, String value) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public void setCharSequence(int viewId, String methodName, CharSequence value) {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public void setUri(int viewId, String methodName, android.net.Uri value) {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public void setBitmap(int viewId, String methodName, Bitmap value) {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public void setBundle(int viewId, String methodName, android.os.Bundle value) {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public void setIntent(int viewId, String methodName, Intent value) {
        throw new RuntimeException("Stub!");
    }

    /* 62 */
    public void setContentDescription(int viewId, CharSequence contentDescription) {
        throw new RuntimeException("Stub!");
    }

    /* 63 */
    public android.view.View apply(Context context, android.view.ViewGroup parent) {
        throw new RuntimeException("Stub!");
    }

    /* 64 */
    public void reapply(Context context, android.view.View v) {
        throw new RuntimeException("Stub!");
    }

    /* 65 */
    public boolean onLoadClass(Class clazz) {
        throw new RuntimeException("Stub!");
    }

    /* 66 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 67 */
    public void writeToParcel(android.os.Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 69 */   public static final android.os.Parcelable.Creator<RemoteViews> CREATOR = null;

    /*    */
/*    */
    @java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
/*    */
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/*    */ public static @interface RemoteView {
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/RemoteViews.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */