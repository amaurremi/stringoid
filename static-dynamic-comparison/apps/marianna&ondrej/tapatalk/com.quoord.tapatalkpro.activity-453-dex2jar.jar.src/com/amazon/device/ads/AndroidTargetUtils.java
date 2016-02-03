package com.amazon.device.ads;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ImageButton;

class AndroidTargetUtils {
    public static final void disableHardwareAcceleration(View paramView) {
        HoneycombTargetUtils.disableHardwareAcceleration(paramView);
    }

    public static void editorApply(SharedPreferences.Editor paramEditor) {
        GingerbreadTargetUtils.editorApply(paramEditor);
    }

    public static <T> void executeAsyncTask(AsyncTask<T, ?, ?> paramAsyncTask, T... paramVarArgs) {
        if (Build.VERSION.SDK_INT >= 11) {
            HoneycombTargetUtils.executeAsyncTaskWithThreadPooling(paramAsyncTask, paramVarArgs);
            return;
        }
        paramAsyncTask.execute(paramVarArgs);
    }

    public static BitmapDrawable getNewBitmapDrawable(Resources paramResources, String paramString) {
        if (isAtLeastAndroidAPI(5)) {
            return EclairTargetUtils.getNewBitmapDrawable(paramResources, paramString);
        }
        return new BitmapDrawable(paramString);
    }

    public static int getOrientation(Display paramDisplay) {
        if (isAtLeastAndroidAPI(8)) {
            return FroyoTargetUtils.getRotation(paramDisplay);
        }
        return paramDisplay.getOrientation();
    }

    public static String getPackageCodePath(Context paramContext) {
        return FroyoTargetUtils.getPackageCodePath(paramContext);
    }

    public static void hideActionAndStatusBars(Activity paramActivity) {
        HoneycombTargetUtils.hideActionAndStatusBars(paramActivity);
    }

    public static boolean isAtLeastAndroidAPI(int paramInt) {
        return Build.VERSION.SDK_INT >= paramInt;
    }

    public static boolean isInstanceOfSQLiteDatabaseLockedException(SQLiteException paramSQLiteException) {
        return HoneycombTargetUtils.isInstanceOfSQLiteDatabaseLockedException(paramSQLiteException);
    }

    public static void setBackgroundDrawable(View paramView, Drawable paramDrawable) {
        if (isAtLeastAndroidAPI(16)) {
            JellyBeanTargetUtils.setBackgroundForLinerLayout(paramView, paramDrawable);
            return;
        }
        paramView.setBackgroundDrawable(paramDrawable);
    }

    public static void setImageButtonAlpha(ImageButton paramImageButton, int paramInt) {
        if (isAtLeastAndroidAPI(16)) {
            JellyBeanTargetUtils.setImageButtonAlpha(paramImageButton, paramInt);
            return;
        }
        paramImageButton.setAlpha(paramInt);
    }

    public static void webViewOnPause(WebView paramWebView) {
        HoneycombTargetUtils.webViewOnPause(paramWebView);
    }

    public static void webViewOnResume(WebView paramWebView) {
        HoneycombTargetUtils.webViewOnResume(paramWebView);
    }

    @TargetApi(5)
    private static class EclairTargetUtils {
        protected static BitmapDrawable getNewBitmapDrawable(Resources paramResources, String paramString) {
            return new BitmapDrawable(paramResources, paramString);
        }
    }

    @TargetApi(8)
    private static class FroyoTargetUtils {
        protected static String getPackageCodePath(Context paramContext) {
            return paramContext.getPackageCodePath();
        }

        protected static int getRotation(Display paramDisplay) {
            return paramDisplay.getRotation();
        }
    }

    @TargetApi(9)
    private static class GingerbreadTargetUtils {
        protected static void editorApply(SharedPreferences.Editor paramEditor) {
            paramEditor.apply();
        }
    }

    @TargetApi(11)
    private static class HoneycombTargetUtils {
        public static final void disableHardwareAcceleration(View paramView) {
            paramView.setLayerType(1, null);
        }

        protected static final <T> void executeAsyncTaskWithThreadPooling(AsyncTask<T, ?, ?> paramAsyncTask, T... paramVarArgs) {
            paramAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramVarArgs);
        }

        protected static void hideActionAndStatusBars(Activity paramActivity) {
            ActionBar localActionBar = paramActivity.getActionBar();
            if (localActionBar != null) {
                localActionBar.hide();
            }
            paramActivity.getWindow().getDecorView().setSystemUiVisibility(4);
        }

        public static boolean isInstanceOfSQLiteDatabaseLockedException(SQLiteException paramSQLiteException) {
            return paramSQLiteException instanceof SQLiteDatabaseLockedException;
        }

        protected static void webViewOnPause(WebView paramWebView) {
            paramWebView.onPause();
        }

        protected static void webViewOnResume(WebView paramWebView) {
            paramWebView.onResume();
        }
    }

    @TargetApi(16)
    private static class JellyBeanTargetUtils {
        public static void setBackgroundForLinerLayout(View paramView, Drawable paramDrawable) {
            paramView.setBackground(paramDrawable);
        }

        protected static void setImageButtonAlpha(ImageButton paramImageButton, int paramInt) {
            paramImageButton.setImageAlpha(paramInt);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AndroidTargetUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */