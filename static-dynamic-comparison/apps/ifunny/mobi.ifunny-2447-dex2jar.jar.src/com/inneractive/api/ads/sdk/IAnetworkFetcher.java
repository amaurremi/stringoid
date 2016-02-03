package com.inneractive.api.ads.sdk;

import android.os.AsyncTask;

import java.lang.reflect.Field;
import java.util.concurrent.Executor;

final class IAnetworkFetcher {
    static int a = IAdefines.h;
    static int b = IAdefines.g;
    private P c;
    private String d;
    private final R e;
    private P.a f;

    IAnetworkFetcher(String paramString, P.a parama) {
        this.d = paramString;
        this.e = new R();
        this.f = parama;
    }

    final void a() {
        if (this.c != null) {
            InneractiveAdView.Log.v("Inneractive_verbose", "Canceling network fetch ad for task #" + this.e.a());
            this.c.cancel(true);
        }
        this.d = "";
    }

    final void a(String paramString) {
        this.e.b();
        InneractiveAdView.Log.v("Inneractive_verbose", "Network fetching ad for task #" + this.e.a());
        if (this.c != null) {
            this.c.cancel(true);
        }
        this.c = Q.a(this.e, this.d);
        this.c.a(this.f);
        P localP;
        String[] arrayOfString;
        try {
            localP = this.c;
            arrayOfString = new String[1];
            arrayOfString[0] = paramString;
            if (localP == null) {
                throw new IllegalArgumentException("Unable to execute null AsyncTask.");
            }
        } catch (Exception paramString) {
            InneractiveAdView.Log.d("Inneractive_debug", "Error executing AdFetchTask");
            return;
        }
        if (IAdefines.ApiLevel.a().a(IAdefines.ApiLevel.c)) {
            paramString = (Executor) AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get(AsyncTask.class);
            new IAreflectionHandler.a(localP, "executeOnExecutor").a(Executor.class, paramString).a(Object[].class, arrayOfString).a();
            return;
        }
        localP.execute(arrayOfString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAnetworkFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */