package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;

import java.util.Iterator;
import java.util.List;

@ii
public final class df {
    private final fi a;
    private final dt b;
    private final Context c;
    private final Object d = new Object();
    private final di e;
    private boolean f = false;
    private dn g;

    public df(Context paramContext, fi paramfi, dt paramdt, di paramdi) {
        this.c = paramContext;
        this.a = paramfi;
        this.b = paramdt;
        this.e = paramdi;
    }

    public dp a(long paramLong1, long paramLong2) {
        mx.a("Starting mediation.");
        Object localObject2 = this.e.a.iterator();
        while (((Iterator) localObject2).hasNext()) {
            dh localdh = (dh) ((Iterator) localObject2).next();
            mx.c("Trying mediation network: " + localdh.b);
            Iterator localIterator = localdh.c.iterator();
            while (localIterator.hasNext()) {
                String str = (String) localIterator.next();
                synchronized (this.d) {
                    if (this.f) {
                        localObject2 = new dp(-1);
                        return (dp) localObject2;
                    }
                    this.g = new dn(this.c, str, this.b, this.e, localdh, this.a.c, this.a.d, this.a.k);
                    ???=this.g.a(paramLong1, paramLong2);
                    if (((dp) ? ??).a == 0)
                    {
                        mx.a("Adapter succeeded.");
                        return (dp) ???;
                    }
                }
                if (((dp) ? ??).c != null){
                    mv.a.post(new dg(this, (dp) ? ? ?));
                }
            }
        }
        return new dp(1);
    }

    public void a() {
        synchronized (this.d) {
            this.f = true;
            if (this.g != null) {
                this.g.a();
            }
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */