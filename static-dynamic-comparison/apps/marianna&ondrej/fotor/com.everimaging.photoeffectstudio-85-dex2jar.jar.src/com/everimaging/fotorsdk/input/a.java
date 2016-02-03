package com.everimaging.fotorsdk.input;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;

public class a {
    private View a;
    private a b;
    private int c;

    public a(Activity paramActivity) {
        this.a = ((FrameLayout) paramActivity.findViewById(16908290)).getChildAt(0);
        this.a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                a.a(a.this);
            }
        });
    }

    private void a() {
        int i = b();
        if (i != this.c) {
            int j = this.a.getRootView().getHeight();
            int k = j - i;
            if (k <= j / 8) {
                break label59;
            }
            if (this.b != null) {
                this.b.a(k);
            }
        }
        for (; ; ) {
            this.c = i;
            return;
            label59:
            if (this.b != null) {
                this.b.b();
            }
        }
    }

    private int b() {
        Rect localRect = new Rect();
        this.a.getWindowVisibleDisplayFrame(localRect);
        return localRect.bottom - localRect.top;
    }

    public void a(a parama) {
        this.b = parama;
    }

    public static abstract interface a {
        public abstract void a(int paramInt);

        public abstract void b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/input/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */