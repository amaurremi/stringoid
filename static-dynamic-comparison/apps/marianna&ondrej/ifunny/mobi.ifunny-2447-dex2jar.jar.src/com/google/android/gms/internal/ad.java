package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

@ii
public class ad
        extends Thread {
    private boolean a = false;
    private boolean b = false;
    private boolean c = false;
    private final Object d;
    private final ac e;
    private final ab f;
    private final ih g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;

    public ad(ac paramac, ab paramab, Bundle paramBundle, ih paramih) {
        this.e = paramac;
        this.f = paramab;
        this.g = paramih;
        this.d = new Object();
        this.i = paramBundle.getInt(bt.h.a());
        this.j = paramBundle.getInt(bt.i.a());
        this.k = paramBundle.getInt(bt.j.a());
        this.l = paramBundle.getInt(bt.k.a());
        this.h = paramBundle.getInt(bt.l.a(), 10);
        setName("ContentFetchTask");
    }

    private void a(Activity paramActivity) {
        if (paramActivity == null) {
        }
        Object localObject1;
        do {
            return;
            Object localObject2 = null;
            localObject1 = localObject2;
            if (paramActivity.getWindow() != null) {
                localObject1 = localObject2;
                if (paramActivity.getWindow().getDecorView() != null) {
                    localObject1 = paramActivity.getWindow().getDecorView().findViewById(16908290);
                }
            }
        } while (localObject1 == null);
        a((View) localObject1);
    }

    private boolean a(WebView paramWebView, aa paramaa) {
        if (!py.e()) {
            return false;
        }
        paramaa.e();
        paramWebView.post(new af(this, paramaa, paramWebView));
        return true;
    }

    private boolean f() {
        try {
            Object localObject1 = this.e.b();
            if (localObject1 == null) {
                return false;
            }
            Object localObject2 = (ActivityManager) ((Context) localObject1).getSystemService("activity");
            KeyguardManager localKeyguardManager = (KeyguardManager) ((Context) localObject1).getSystemService("keyguard");
            localObject1 = (PowerManager) ((Context) localObject1).getSystemService("power");
            if ((localObject2 != null) && (localKeyguardManager != null) && (localObject1 != null)) {
                localObject2 = ((ActivityManager) localObject2).getRunningAppProcesses();
                if (localObject2 == null) {
                    return false;
                }
                localObject2 = ((List) localObject2).iterator();
                while (((Iterator) localObject2).hasNext()) {
                    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) ((Iterator) localObject2).next();
                    if (Process.myPid() == localRunningAppProcessInfo.pid) {
                        if ((localRunningAppProcessInfo.importance == 100) && (!localKeyguardManager.inKeyguardRestrictedInputMode())) {
                            boolean bool = ((PowerManager) localObject1).isScreenOn();
                            if (bool) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
        } catch (Throwable localThrowable) {
            return false;
        }
        return false;
    }

    ah a(View paramView, aa paramaa) {
        int m = 0;
        if (paramView == null) {
            return new ah(this, 0, 0);
        }
        if (((paramView instanceof TextView)) && (!(paramView instanceof EditText))) {
            paramaa.b(((TextView) paramView).getText().toString());
            return new ah(this, 1, 0);
        }
        if (((paramView instanceof WebView)) && (!(paramView instanceof mz))) {
            paramaa.e();
            if (a((WebView) paramView, paramaa)) {
                return new ah(this, 0, 1);
            }
            return new ah(this, 0, 0);
        }
        if ((paramView instanceof ViewGroup)) {
            paramView = (ViewGroup) paramView;
            int n = 0;
            int i1 = 0;
            while (m < paramView.getChildCount()) {
                ah localah = a(paramView.getChildAt(m), paramaa);
                i1 += localah.a;
                n += localah.b;
                m += 1;
            }
            return new ah(this, i1, n);
        }
        return new ah(this, 0, 0);
    }

    public void a() {
        synchronized (this.d) {
            if (this.a) {
                mx.a("Content hash thread already started, quiting...");
                return;
            }
            this.a = true;
            start();
            return;
        }
    }

    void a(aa paramaa, WebView paramWebView, String paramString) {
        paramaa.d();
        try {
            if (!TextUtils.isEmpty(paramString)) {
                paramString = new JSONObject(paramString).optString("text");
                if (TextUtils.isEmpty(paramWebView.getTitle())) {
                    break label84;
                }
                paramaa.a(paramWebView.getTitle() + "\n" + paramString);
            }
            while (paramaa.a()) {
                this.f.b(paramaa);
                return;
                label84:
                paramaa.a(paramString);
            }
            return;
        } catch (JSONException paramaa) {
            mx.a("Json string may be malformed.");
            return;
        } catch (Throwable paramaa) {
            mx.a("Failed to get webview content.", paramaa);
            this.g.b(paramaa);
        }
    }

    boolean a(View paramView) {
        if (paramView == null) {
            return false;
        }
        paramView.post(new ae(this, paramView));
        return true;
    }

    public aa b() {
        return this.f.a();
    }

    void b(View paramView) {
        try {
            aa localaa = new aa(this.i, this.j, this.k, this.l);
            paramView = a(paramView, localaa);
            localaa.f();
            if ((paramView.a == 0) && (paramView.b == 0)) {
                return;
            }
            if (((paramView.b != 0) || (localaa.h() != 0)) && ((paramView.b != 0) || (!this.f.a(localaa)))) {
                this.f.c(localaa);
                return;
            }
        } catch (Exception paramView) {
            mx.b("Exception in fetchContentOnUIThread", paramView);
            this.g.b(paramView);
        }
    }

    public void c() {
        synchronized (this.d) {
            this.b = false;
            this.d.notifyAll();
            mx.a("ContentFetchThread: wakeup");
            return;
        }
    }

    public void d() {
        synchronized (this.d) {
            this.b = true;
            mx.a("ContentFetchThread: paused, mPause = " + this.b);
            return;
        }
    }

    public boolean e() {
        return this.b;
    }

    public void run() {
        while (!this.c) {
            try {
                if (f()) {
                    Activity localActivity = this.e.a();
                    if (localActivity == null) {
                        mx.a("ContentFetchThread: no activity");
                    }
                }
            } catch (Throwable localThrowable) {
                mx.b("Error in ContentFetchTask", localThrowable);
                this.g.b(localThrowable);
                synchronized (this.d) {
                    for (; ; ) {
                        boolean bool = this.b;
                        if (!bool) {
                            break;
                        }
                        try {
                            mx.a("ContentFetchTask: waiting");
                            this.d.wait();
                        } catch (InterruptedException localInterruptedException) {
                        }
                    }
                    a((Activity) ? ??);
                    for (; ; ) {
                        Thread.sleep(this.h * 1000);
                        break;
                        mx.a("ContentFetchTask: sleeping");
                        d();
                    }
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */