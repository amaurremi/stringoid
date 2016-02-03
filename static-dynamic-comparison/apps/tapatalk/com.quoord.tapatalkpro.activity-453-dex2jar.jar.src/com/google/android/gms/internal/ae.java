package com.google.android.gms.internal;

import android.content.Context;
import org.json.JSONObject;

public class ae
        implements ad {
    private final dz lC;

    public ae(Context paramContext, dx paramdx) {
        this.lC = dz.a(paramContext, new ak(), false, false, null, paramdx);
    }

    public void a(final ad.a parama) {
        this.lC.bI().a(new ea.a() {
            public void a(dz paramAnonymousdz) {
                parama.ay();
            }
        });
    }

    public void a(String paramString, bb parambb) {
        this.lC.bI().a(paramString, parambb);
    }

    public void a(String paramString, JSONObject paramJSONObject) {
        this.lC.a(paramString, paramJSONObject);
    }

    public void d(String paramString) {
        this.lC.loadUrl(paramString);
    }

    public void e(String paramString) {
        this.lC.bI().a(paramString, null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */