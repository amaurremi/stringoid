package com.everimaging.fotorsdk.widget.pulltorefresh.library.internal;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;

public class g {
    public static void a(View paramView, int paramInt) {
        if (Build.VERSION.SDK_INT >= 11) {
            a.a(paramView, paramInt);
        }
    }

    public static void a(View paramView, Drawable paramDrawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            b.a(paramView, paramDrawable);
            return;
        }
        paramView.setBackgroundDrawable(paramDrawable);
    }

    public static void a(View paramView, Runnable paramRunnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            b.a(paramView, paramRunnable);
            return;
        }
        paramView.postDelayed(paramRunnable, 16L);
    }

    @TargetApi(11)
    static class a {
        public static void a(View paramView, int paramInt) {
            paramView.setLayerType(paramInt, null);
        }
    }

    @TargetApi(16)
    static class b {
        public static void a(View paramView, Drawable paramDrawable) {
            paramView.setBackground(paramDrawable);
        }

        public static void a(View paramView, Runnable paramRunnable) {
            paramView.postOnAnimation(paramRunnable);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/pulltorefresh/library/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */