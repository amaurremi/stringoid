package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

@ii
public class mz
        extends WebView
        implements DownloadListener {
    private final nb a;
    private final na b;
    private final Object c = new Object();
    private final pv d;
    private final gt e;
    private fj f;
    private ay g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private final WindowManager l;

    private mz(na paramna, ay paramay, boolean paramBoolean1, boolean paramBoolean2, pv parampv, gt paramgt) {
        super(paramna);
        this.b = paramna;
        this.g = paramay;
        this.h = paramBoolean1;
        this.d = parampv;
        this.e = paramgt;
        this.l = ((WindowManager) getContext().getSystemService("window"));
        setBackgroundColor(0);
        paramay = getSettings();
        paramay.setJavaScriptEnabled(true);
        paramay.setSavePassword(false);
        paramay.setSupportMultipleWindows(true);
        paramay.setJavaScriptCanOpenWindowsAutomatically(true);
        lw.a(paramna, paramgt.b, paramay);
        if (Build.VERSION.SDK_INT >= 17) {
            mt.a(getContext(), paramay);
            setDownloadListener(this);
            if (Build.VERSION.SDK_INT < 11) {
                break label194;
            }
            this.a = new no(this, paramBoolean2);
            label142:
            setWebViewClient(this.a);
            if (Build.VERSION.SDK_INT < 14) {
                break label211;
            }
            setWebChromeClient(new np(this));
        }
        for (; ; ) {
            m();
            return;
            if (Build.VERSION.SDK_INT < 11) {
                break;
            }
            mj.a(getContext(), paramay);
            break;
            label194:
            this.a = new nb(this, paramBoolean2);
            break label142;
            label211:
            if (Build.VERSION.SDK_INT >= 11) {
                setWebChromeClient(new ne(this));
            }
        }
    }

    public static mz a(Context paramContext, ay paramay, boolean paramBoolean1, boolean paramBoolean2, pv parampv, gt paramgt) {
        return new mz(new na(paramContext), paramay, paramBoolean1, paramBoolean2, parampv, paramgt);
    }

    private void m() {
        for (; ; ) {
            synchronized (this.c) {
                if ((this.h) || (this.g.e)) {
                    if (Build.VERSION.SDK_INT < 14) {
                        mx.a("Disabling hardware acceleration on an overlay.");
                        n();
                        return;
                    }
                    mx.a("Enabling hardware acceleration on an overlay.");
                    o();
                }
            }
            if (Build.VERSION.SDK_INT < 18) {
                mx.a("Disabling hardware acceleration on an AdView.");
                n();
            } else {
                mx.a("Enabling hardware acceleration on an AdView.");
                o();
            }
        }
    }

    private void n() {
        synchronized (this.c) {
            if ((!this.i) && (Build.VERSION.SDK_INT >= 11)) {
                mj.a(this);
            }
            this.i = true;
            return;
        }
    }

    private void o() {
        synchronized (this.c) {
            if ((this.i) && (Build.VERSION.SDK_INT >= 11)) {
                mj.b(this);
            }
            this.i = false;
            return;
        }
    }

    public void a() {
        if (!f().b()) {
            return;
        }
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        Display localDisplay = this.l.getDefaultDisplay();
        localDisplay.getMetrics(localDisplayMetrics);
        int n = lw.c(getContext());
        float f1 = 160.0F / localDisplayMetrics.densityDpi;
        int m = Math.round(localDisplayMetrics.widthPixels * f1);
        n = Math.round((localDisplayMetrics.heightPixels - n) * f1);
        try {
            b("onScreenInfoChanged", new JSONObject().put("width", m).put("height", n).put("density", localDisplayMetrics.density).put("rotation", localDisplay.getRotation()));
            return;
        } catch (JSONException localJSONException) {
            mx.b("Error occured while obtaining screen information.", localJSONException);
        }
    }

    public void a(Context paramContext, ay paramay) {
        synchronized (this.c) {
            this.b.setBaseContext(paramContext);
            this.f = null;
            this.g = paramay;
            this.h = false;
            this.k = false;
            lw.b(this);
            loadUrl("about:blank");
            this.a.d();
            setOnTouchListener(null);
            setOnClickListener(null);
            return;
        }
    }

    public void a(ay paramay) {
        synchronized (this.c) {
            this.g = paramay;
            requestLayout();
            return;
        }
    }

    public void a(fj paramfj) {
        synchronized (this.c) {
            this.f = paramfj;
            return;
        }
    }

    protected void a(String paramString) {
        synchronized (this.c) {
            if (!l()) {
                loadUrl(paramString);
                return;
            }
            mx.e("The webview is destroyed. Ignoring action.");
        }
    }

    public void a(String paramString, Map<String, ?> paramMap) {
        try {
            paramMap = lw.a(paramMap);
            b(paramString, paramMap);
            return;
        } catch (JSONException paramString) {
            mx.e("Could not convert parameters to JSON.");
        }
    }

    public void a(String paramString, JSONObject paramJSONObject) {
        Object localObject = paramJSONObject;
        if (paramJSONObject == null) {
            localObject = new JSONObject();
        }
        paramJSONObject = ((JSONObject) localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder) localObject).append("javascript:" + paramString + "(");
        ((StringBuilder) localObject).append(paramJSONObject);
        ((StringBuilder) localObject).append(");");
        a(((StringBuilder) localObject).toString());
    }

    public void a(boolean paramBoolean) {
        synchronized (this.c) {
            this.h = paramBoolean;
            m();
            return;
        }
    }

    public void b() {
        HashMap localHashMap = new HashMap(1);
        localHashMap.put("version", this.e.b);
        a("onhide", localHashMap);
    }

    public void b(String paramString, JSONObject paramJSONObject) {
        Object localObject = paramJSONObject;
        if (paramJSONObject == null) {
            localObject = new JSONObject();
        }
        paramJSONObject = ((JSONObject) localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder) localObject).append("javascript:AFMA_ReceiveMessage('");
        ((StringBuilder) localObject).append(paramString);
        ((StringBuilder) localObject).append("'");
        ((StringBuilder) localObject).append(",");
        ((StringBuilder) localObject).append(paramJSONObject);
        ((StringBuilder) localObject).append(");");
        mx.d("Dispatching AFMA event: " + localObject);
        a(((StringBuilder) localObject).toString());
    }

    public void b(boolean paramBoolean) {
        synchronized (this.c) {
            if (this.f != null) {
                this.f.b(paramBoolean);
                return;
            }
            this.k = paramBoolean;
        }
    }

    public void c() {
        HashMap localHashMap = new HashMap(1);
        localHashMap.put("version", this.e.b);
        a("onshow", localHashMap);
    }

    public fj d() {
        synchronized (this.c) {
            fj localfj = this.f;
            return localfj;
        }
    }

    public void destroy() {
        synchronized (this.c) {
            super.destroy();
            this.j = true;
            return;
        }
    }

    public ay e() {
        synchronized (this.c) {
            ay localay = this.g;
            return localay;
        }
    }

    public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback) {
        synchronized (this.c) {
            if (l()) {
                mx.e("The webview is destroyed. Ignoring action.");
                if (paramValueCallback != null) {
                    paramValueCallback.onReceiveValue(null);
                }
                return;
            }
            super.evaluateJavascript(paramString, paramValueCallback);
            return;
        }
    }

    public nb f() {
        return this.a;
    }

    public boolean g() {
        return this.k;
    }

    public pv h() {
        return this.d;
    }

    public gt i() {
        return this.e;
    }

    public boolean j() {
        synchronized (this.c) {
            boolean bool = this.h;
            return bool;
        }
    }

    public Context k() {
        return this.b.a();
    }

    public boolean l() {
        synchronized (this.c) {
            boolean bool = this.j;
            return bool;
        }
    }

    public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {
        try {
            paramString2 = new Intent("android.intent.action.VIEW");
            paramString2.setDataAndType(Uri.parse(paramString1), paramString4);
            getContext().startActivity(paramString2);
            return;
        } catch (ActivityNotFoundException paramString2) {
            mx.a("Couldn't find an Activity to view url/mimetype: " + paramString1 + " / " + paramString4);
        }
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        int n = Integer.MAX_VALUE;
        for (; ; ) {
            int m;
            int i2;
            int i1;
            synchronized (this.c) {
                if ((isInEditMode()) || (this.h)) {
                    super.onMeasure(paramInt1, paramInt2);
                    return;
                }
                int i3 = View.MeasureSpec.getMode(paramInt1);
                m = View.MeasureSpec.getSize(paramInt1);
                i2 = View.MeasureSpec.getMode(paramInt2);
                i1 = View.MeasureSpec.getSize(paramInt2);
                if (i3 == Integer.MIN_VALUE) {
                    break label280;
                }
                if (i3 != 1073741824) {
                    break label273;
                }
                break label280;
                if ((this.g.g > paramInt1) || (this.g.d > paramInt2)) {
                    float f1 = this.b.getResources().getDisplayMetrics().density;
                    mx.e("Not enough space to show ad. Needs " + (int) (this.g.g / f1) + "x" + (int) (this.g.d / f1) + " dp, but only has " + (int) (m / f1) + "x" + (int) (i1 / f1) + " dp.");
                    if (getVisibility() != 8) {
                        setVisibility(4);
                    }
                    setMeasuredDimension(0, 0);
                    return;
                }
            }
            if (getVisibility() != 8) {
                setVisibility(0);
            }
            setMeasuredDimension(this.g.g, this.g.d);
            continue;
            label273:
            paramInt1 = Integer.MAX_VALUE;
            break label283;
            label280:
            paramInt1 = m;
            label283:
            if (i2 != Integer.MIN_VALUE) {
                paramInt2 = n;
                if (i2 != 1073741824) {
                }
            } else {
                paramInt2 = i1;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (this.d != null) {
            this.d.a(paramMotionEvent);
        }
        return super.onTouchEvent(paramMotionEvent);
    }

    public void setContext(Context paramContext) {
        this.b.setBaseContext(paramContext);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/mz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */