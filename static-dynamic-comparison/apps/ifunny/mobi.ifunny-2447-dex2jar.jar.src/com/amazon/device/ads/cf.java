package com.amazon.device.ads;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.sqlite.SQLiteException;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

class cf {
    public static int a(Display paramDisplay) {
        if (a(8)) {
            return ch.a(paramDisplay);
        }
        return paramDisplay.getOrientation();
    }

    public static BitmapDrawable a(Resources paramResources, String paramString) {
        if (a(5)) {
            return cg.a(paramResources, paramString);
        }
        return new BitmapDrawable(paramString);
    }

    public static String a(Context paramContext) {
        return ch.a(paramContext);
    }

    public static void a(SharedPreferences.Editor paramEditor) {
        ci.a(paramEditor);
    }

    public static <T> void a(AsyncTask<T, ?, ?> paramAsyncTask, T... paramVarArgs) {
        if (Build.VERSION.SDK_INT >= 11) {
            cj.a(paramAsyncTask, paramVarArgs);
            return;
        }
        paramAsyncTask.execute(paramVarArgs);
    }

    public static final void a(View paramView) {
        cj.a(paramView);
    }

    public static void a(View paramView, Drawable paramDrawable) {
        if (a(16)) {
            ck.a(paramView, paramDrawable);
            return;
        }
        paramView.setBackgroundDrawable(paramDrawable);
    }

    public static void a(WebView paramWebView) {
        cj.a(paramWebView);
    }

    public static void a(ImageButton paramImageButton, int paramInt) {
        if (a(16)) {
            ck.a(paramImageButton, paramInt);
            return;
        }
        paramImageButton.setAlpha(paramInt);
    }

    public static boolean a(int paramInt) {
        return Build.VERSION.SDK_INT >= paramInt;
    }

    public static boolean a(SQLiteException paramSQLiteException) {
        return cj.a(paramSQLiteException);
    }

    public static void b(WebView paramWebView) {
        cj.b(paramWebView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */