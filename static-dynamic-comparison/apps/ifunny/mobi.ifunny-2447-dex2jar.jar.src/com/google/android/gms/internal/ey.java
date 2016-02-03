package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.e;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

@ii
public class ey {
    static final Set<String> a = new HashSet(Arrays.asList(new String[]{"top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center"}));
    private int b = -1;
    private int c = -1;
    private int d = 0;
    private int e = 0;
    private boolean f = true;
    private String g = "top-right";
    private final mz h;
    private final Map<String, String> i;
    private final Context j;

    public ey(mz parammz, Map<String, String> paramMap) {
        this.h = parammz;
        this.i = paramMap;
        this.j = parammz.k();
    }

    private void e() {
        Object localObject = lw.d(this.j);
        int k;
        if (!TextUtils.isEmpty((CharSequence) this.i.get("width"))) {
            k = lw.b((String) this.i.get("width"));
            if (a(k, localObject[0])) {
                this.b = k;
            }
        }
        if (!TextUtils.isEmpty((CharSequence) this.i.get("height"))) {
            k = lw.b((String) this.i.get("height"));
            if (b(k, localObject[1])) {
                this.c = k;
            }
        }
        if (!TextUtils.isEmpty((CharSequence) this.i.get("offsetX"))) {
            this.d = lw.b((String) this.i.get("offsetX"));
        }
        if (!TextUtils.isEmpty((CharSequence) this.i.get("offsetY"))) {
            this.e = lw.b((String) this.i.get("offsetY"));
        }
        if (!TextUtils.isEmpty((CharSequence) this.i.get("allowOffscreen"))) {
            this.f = Boolean.parseBoolean((String) this.i.get("allowOffscreen"));
        }
        localObject = (String) this.i.get("customClosePosition");
        if ((!TextUtils.isEmpty((CharSequence) localObject)) && (a.contains(localObject))) {
            this.g = ((String) localObject);
        }
    }

    boolean a() {
        return (this.b > -1) && (this.c > -1);
    }

    boolean a(int paramInt1, int paramInt2) {
        return (paramInt1 >= 50) && (paramInt1 < paramInt2);
    }

    public void b() {
        mx.c("PLEASE IMPLEMENT mraid.resize()");
        if (this.j == null) {
            mx.e("Not an activity context. Cannot resize.");
            return;
        }
        if (this.h.e().e) {
            mx.e("Is interstitial. Cannot resize an interstitial.");
            return;
        }
        if (this.h.j()) {
            mx.e("Is expanded. Cannot resize an expanded banner.");
            return;
        }
        e();
        if (!a()) {
            mx.e("Invalid width and height options. Cannot resize.");
            return;
        }
        Object localObject1 = (WindowManager) this.j.getSystemService("window");
        Object localObject2 = new DisplayMetrics();
        ((WindowManager) localObject1).getDefaultDisplay().getMetrics((DisplayMetrics) localObject2);
        int k = mv.a((DisplayMetrics) localObject2, this.b);
        int m = mv.a((DisplayMetrics) localObject2, this.c);
        localObject1 = this.h.getParent();
        if ((localObject1 != null) && ((localObject1 instanceof ViewGroup))) {
            ((ViewGroup) localObject1).removeView(this.h);
        }
        localObject1 = new LinearLayout(this.j);
        ((LinearLayout) localObject1).setBackgroundColor(0);
        localObject2 = new PopupWindow(this.j);
        ((PopupWindow) localObject2).setHeight(m + 16);
        ((PopupWindow) localObject2).setWidth(k + 16);
        if (!this.f) {
        }
        for (boolean bool = true; ; bool = false) {
            ((PopupWindow) localObject2).setClippingEnabled(bool);
            ((PopupWindow) localObject2).setContentView((View) localObject1);
            ((LinearLayout) localObject1).addView(this.h, -1, -1);
            ((PopupWindow) localObject2).showAtLocation(((Activity) this.j).getWindow().getDecorView(), 0, this.d, this.e);
            this.h.a(new ay(this.j, new e(this.b, this.c)));
            c();
            d();
            return;
        }
    }

    boolean b(int paramInt1, int paramInt2) {
        return (paramInt1 >= 50) && (paramInt1 < paramInt2);
    }

    void c() {
        try {
            JSONObject localJSONObject = new JSONObject().put("x", this.d).put("y", this.e).put("width", this.b).put("height", this.c);
            this.h.b("onSizeChanged", localJSONObject);
            return;
        } catch (JSONException localJSONException) {
            mx.b("Error occured while dispatching size change.", localJSONException);
        }
    }

    void d() {
        try {
            JSONObject localJSONObject = new JSONObject().put("state", "resized");
            this.h.b("onStateChanged", localJSONObject);
            return;
        } catch (JSONException localJSONException) {
            mx.b("Error occured while dispatching state change.", localJSONException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */