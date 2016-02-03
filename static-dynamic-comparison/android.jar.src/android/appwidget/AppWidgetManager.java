/*    */
package android.appwidget;
/*    */

import android.widget.RemoteViews;

/*    */
/*  4 */ public class AppWidgetManager {
    AppWidgetManager() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public static AppWidgetManager getInstance(android.content.Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void updateAppWidget(int[] appWidgetIds, RemoteViews views) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void updateAppWidgetOptions(int appWidgetId, android.os.Bundle options) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public android.os.Bundle getAppWidgetOptions(int appWidgetId) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void updateAppWidget(int appWidgetId, RemoteViews views) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void partiallyUpdateAppWidget(int[] appWidgetIds, RemoteViews views) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void partiallyUpdateAppWidget(int appWidgetId, RemoteViews views) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void updateAppWidget(android.content.ComponentName provider, RemoteViews views) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void notifyAppWidgetViewDataChanged(int[] appWidgetIds, int viewId) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void notifyAppWidgetViewDataChanged(int appWidgetId, int viewId) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public java.util.List<AppWidgetProviderInfo> getInstalledProviders() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public AppWidgetProviderInfo getAppWidgetInfo(int appWidgetId) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public boolean bindAppWidgetIdIfAllowed(int appWidgetId, android.content.ComponentName provider) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public int[] getAppWidgetIds(android.content.ComponentName provider) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final String ACTION_APPWIDGET_PICK = "android.appwidget.action.APPWIDGET_PICK";
    /*    */   public static final String ACTION_APPWIDGET_BIND = "android.appwidget.action.APPWIDGET_BIND";
    /*    */   public static final String ACTION_APPWIDGET_CONFIGURE = "android.appwidget.action.APPWIDGET_CONFIGURE";
    /*    */   public static final String EXTRA_APPWIDGET_ID = "appWidgetId";
    /*    */   public static final String OPTION_APPWIDGET_MIN_WIDTH = "appWidgetMinWidth";
    /*    */   public static final String OPTION_APPWIDGET_MIN_HEIGHT = "appWidgetMinHeight";
    /*    */   public static final String OPTION_APPWIDGET_MAX_WIDTH = "appWidgetMaxWidth";
    /*    */   public static final String OPTION_APPWIDGET_MAX_HEIGHT = "appWidgetMaxHeight";
    /*    */   public static final String EXTRA_APPWIDGET_OPTIONS = "appWidgetOptions";
    /*    */   public static final String EXTRA_APPWIDGET_IDS = "appWidgetIds";
    /*    */   public static final String EXTRA_APPWIDGET_PROVIDER = "appWidgetProvider";
    /*    */   public static final String EXTRA_CUSTOM_INFO = "customInfo";
    /*    */   public static final String EXTRA_CUSTOM_EXTRAS = "customExtras";
    /*    */   public static final int INVALID_APPWIDGET_ID = 0;
    /*    */   public static final String ACTION_APPWIDGET_UPDATE = "android.appwidget.action.APPWIDGET_UPDATE";
    /*    */   public static final String ACTION_APPWIDGET_OPTIONS_CHANGED = "android.appwidget.action.APPWIDGET_UPDATE_OPTIONS";
    /*    */   public static final String ACTION_APPWIDGET_DELETED = "android.appwidget.action.APPWIDGET_DELETED";
    /*    */   public static final String ACTION_APPWIDGET_DISABLED = "android.appwidget.action.APPWIDGET_DISABLED";
    /*    */   public static final String ACTION_APPWIDGET_ENABLED = "android.appwidget.action.APPWIDGET_ENABLED";
    /*    */   public static final String META_DATA_APPWIDGET_PROVIDER = "android.appwidget.provider";
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/appwidget/AppWidgetManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */