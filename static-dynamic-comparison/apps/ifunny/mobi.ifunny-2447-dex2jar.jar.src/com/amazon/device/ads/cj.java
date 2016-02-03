package com.amazon.device.ads;

import android.annotation.TargetApi;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.view.View;
import android.webkit.WebView;

@TargetApi(11)
class cj {
    protected static final <T> void a(AsyncTask<T, ?, ?> paramAsyncTask, T... paramVarArgs) {
        paramAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramVarArgs);
    }

    public static final void a(View paramView) {
        paramView.setLayerType(1, null);
    }

    protected static void a(WebView paramWebView) {
        paramWebView.onPause();
    }

    public static boolean a(SQLiteException paramSQLiteException) {
        return paramSQLiteException instanceof SQLiteDatabaseLockedException;
    }

    protected static void b(WebView paramWebView) {
        paramWebView.onResume();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */