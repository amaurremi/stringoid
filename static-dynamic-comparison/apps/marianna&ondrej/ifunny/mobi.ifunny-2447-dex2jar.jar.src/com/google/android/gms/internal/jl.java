package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View.MeasureSpec;
import android.webkit.WebView;

public final class jl
        extends AsyncTask<Void, Void, Boolean> {
    private final WebView b;
    private Bitmap c;

    public jl(jk paramjk, WebView paramWebView) {
        this.b = paramWebView;
    }

    protected Boolean a(Void... paramVarArgs) {
        for (; ; ) {
            int i;
            int m;
            try {
                int n = this.c.getWidth();
                int i1 = this.c.getHeight();
                if ((n == 0) || (i1 == 0)) {
                    paramVarArgs = Boolean.valueOf(false);
                    return paramVarArgs;
                }
                i = 0;
                j = 0;
                int k;
                if (i < n) {
                    k = 0;
                    if (k >= i1) {
                        break label139;
                    }
                    m = j;
                    if (this.c.getPixel(i, k) != 0) {
                        m = j + 1;
                    }
                } else {
                    if (j / (n * i1 / 100.0D) > 0.1D) {
                        bool = true;
                        paramVarArgs = Boolean.valueOf(bool);
                        continue;
                    }
                    boolean bool = false;
                    continue;
                }
                k += 10;
            } finally {
            }
            int j = m;
            continue;
            label139:
            i += 10;
        }
    }

    protected void a(Boolean paramBoolean) {
        jk.c(this.a);
        if ((paramBoolean.booleanValue()) || (this.a.c()) || (jk.d(this.a) <= 0L)) {
            this.a.c = paramBoolean.booleanValue();
            jk.e(this.a).a(this.a.a);
        }
        while (jk.d(this.a) <= 0L) {
            return;
        }
        if (mx.a(2)) {
            mx.a("Ad not detected, scheduling another run.");
        }
        jk.g(this.a).postDelayed(this.a, jk.f(this.a));
    }

    protected void onPreExecute() {
        try {
            this.c = Bitmap.createBitmap(jk.a(this.a), jk.b(this.a), Bitmap.Config.ARGB_8888);
            this.b.setVisibility(0);
            this.b.measure(View.MeasureSpec.makeMeasureSpec(jk.a(this.a), 0), View.MeasureSpec.makeMeasureSpec(jk.b(this.a), 0));
            this.b.layout(0, 0, jk.a(this.a), jk.b(this.a));
            Canvas localCanvas = new Canvas(this.c);
            this.b.draw(localCanvas);
            this.b.invalidate();
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/jl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */