package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public class q {
    public final String a;
    public final Map<String, String> b;
    public final AdUnit c;
    public final e d;
    public final int e;
    private final WeakReference<Context> f;

    public q(String paramString, Map<String, String> paramMap, Context paramContext, AdUnit paramAdUnit, e parame, int paramInt) {
        this.a = paramString;
        this.b = paramMap;
        this.f = new WeakReference(paramContext);
        this.c = paramAdUnit;
        this.d = parame;
        this.e = paramInt;
    }

    public Context a() {
        return (Context) this.f.get();
    }

    public AdFrame b() {
        return (AdFrame) this.c.d().get(this.e);
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("event=").append(this.a);
        localStringBuilder.append(",params=").append(this.b);
        localStringBuilder.append(",adspace=").append(this.c.b());
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */