package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import org.json.JSONException;
import org.json.JSONObject;

@ii
public class ff {
    DisplayMetrics a;
    int b = -1;
    int c = -1;
    private final mz d;
    private final Context e;
    private final WindowManager f;
    private final br g;
    private float h;
    private int i;
    private int j = -1;
    private int k = -1;
    private int[] l = new int[2];

    public ff(mz parammz, Context paramContext, br parambr) {
        this.d = parammz;
        this.e = paramContext;
        this.g = parambr;
        this.f = ((WindowManager) paramContext.getSystemService("window"));
        g();
        a();
        h();
    }

    private void g() {
        this.a = new DisplayMetrics();
        Display localDisplay = this.f.getDefaultDisplay();
        localDisplay.getMetrics(this.a);
        this.h = this.a.density;
        this.i = localDisplay.getRotation();
    }

    private void h() {
        this.d.getLocationOnScreen(this.l);
        this.d.measure(0, 0);
        float f1 = 160.0F / this.a.densityDpi;
        this.j = Math.round(this.d.getMeasuredWidth() * f1);
        this.k = Math.round(f1 * this.d.getMeasuredHeight());
    }

    private fc i() {
        return new fe().b(this.g.a()).a(this.g.b()).c(this.g.f()).d(this.g.c()).e(this.g.d()).a();
    }

    void a() {
        int m = lw.c(this.e);
        float f1 = 160.0F / this.a.densityDpi;
        this.b = Math.round(this.a.widthPixels * f1);
        this.c = Math.round((this.a.heightPixels - m) * f1);
    }

    public void b() {
        e();
        f();
        d();
        c();
    }

    public void c() {
        if (mx.a(2)) {
            mx.c("Dispatching Ready Event.");
        }
        this.d.b("onReadyEventReceived", new JSONObject());
    }

    public void d() {
        try {
            JSONObject localJSONObject = new JSONObject().put("x", this.l[0]).put("y", this.l[1]).put("width", this.j).put("height", this.k);
            this.d.b("onDefaultPositionReceived", localJSONObject);
            return;
        } catch (JSONException localJSONException) {
            mx.b("Error occured while dispatching default position.", localJSONException);
        }
    }

    public void e() {
        try {
            JSONObject localJSONObject = new JSONObject().put("width", this.b).put("height", this.c).put("density", this.h).put("rotation", this.i);
            this.d.b("onScreenInfoChanged", localJSONObject);
            return;
        } catch (JSONException localJSONException) {
            mx.b("Error occured while obtaining screen information.", localJSONException);
        }
    }

    public void f() {
        fc localfc = i();
        this.d.b("onDeviceFeaturesReceived", localfc.a());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */