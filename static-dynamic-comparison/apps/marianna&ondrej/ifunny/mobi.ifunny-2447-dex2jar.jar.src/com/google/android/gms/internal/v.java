package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import org.json.JSONObject;

@ii
public class v
        implements q {
    private final mz a;

    public v(Context paramContext, gt paramgt) {
        this.a = mz.a(paramContext, new ay(), false, false, null, paramgt);
    }

    private void a(Runnable paramRunnable) {
        if (mv.b()) {
            paramRunnable.run();
            return;
        }
        mv.a.post(paramRunnable);
    }

    public void a() {
        lw.a(this.a);
    }

    public void a(r paramr) {
        this.a.f().a(new z(this, paramr));
    }

    public void a(td paramtd, fq paramfq, cf paramcf, fv paramfv, boolean paramBoolean, cq paramcq) {
        this.a.f().a(paramtd, paramfq, paramcf, paramfv, paramBoolean, paramcq, new tk(false));
    }

    public void a(String paramString) {
        a(new y(this, paramString));
    }

    public void a(String paramString, cp paramcp) {
        this.a.f().a(paramString, paramcp);
    }

    public void a(String paramString, JSONObject paramJSONObject) {
        a(new w(this, paramString, paramJSONObject));
    }

    public void b() {
        lw.b(this.a);
    }

    public void b(String paramString) {
        this.a.f().a(paramString, null);
    }

    public void c() {
        this.a.destroy();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */