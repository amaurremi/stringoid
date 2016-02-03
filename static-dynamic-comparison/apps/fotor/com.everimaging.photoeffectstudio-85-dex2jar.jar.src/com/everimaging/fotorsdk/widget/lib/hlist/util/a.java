package com.everimaging.fotorsdk.widget.lib.hlist.util;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;

public class a {
    public static final a a(View paramView) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 16) {
            return new com.everimaging.fotorsdk.widget.lib.hlist.util.v16.a(paramView);
        }
        if (i >= 14) {
            return new com.everimaging.fotorsdk.widget.lib.hlist.util.v14.a(paramView);
        }
        return new b(paramView);
    }

    public static abstract class a {
        protected View a;

        protected a(View paramView) {
            this.a = paramView;
            Log.i("ViewHelper", getClass().getSimpleName());
        }

        public abstract void a(int paramInt);

        public abstract void a(Runnable paramRunnable);

        public abstract boolean a();
    }

    public static class b
            extends a.a {
        public b(View paramView) {
            super();
        }

        public void a(int paramInt) {
            Log.d("ViewHelper", "setScrollX: " + paramInt);
            this.a.scrollTo(paramInt, this.a.getScrollY());
        }

        public void a(Runnable paramRunnable) {
            this.a.post(paramRunnable);
        }

        public boolean a() {
            return false;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/lib/hlist/util/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */