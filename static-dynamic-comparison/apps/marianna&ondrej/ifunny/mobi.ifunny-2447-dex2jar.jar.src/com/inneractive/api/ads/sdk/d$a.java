package com.inneractive.api.ads.sdk;

import android.net.Uri;

import java.io.InputStream;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

final class d$a {
    private final HttpResponse a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;

    d$a(HttpResponse paramHttpResponse, d.b paramb) {
        this.a = paramHttpResponse;
    }

    final d a() {
        this.i = c.a(this.a, IAdefines.HeaderParamsResponse.h);
        InneractiveAdView.Log.v("Inneractive_verbose", "SDK Adapter name extracted is: " + this.i);
        this.b = c.a(this.a, IAdefines.HeaderParamsResponse.a);
        InneractiveAdView.Log.v("Inneractive_verbose", "internal returned Ad type extracted from response header: " + this.b);
        this.c = c.a(this.a, IAdefines.HeaderParamsResponse.e);
        InneractiveAdView.Log.v("Inneractive_verbose", "internal Error code extracted from response header: " + this.c);
        this.d = c.a(this.a, IAdefines.HeaderParamsResponse.f);
        InneractiveAdView.Log.v("Inneractive_verbose", "internal Session id extracted from response header: " + this.d);
        this.e = c.a(this.a, IAdefines.HeaderParamsResponse.g);
        InneractiveAdView.Log.v("Inneractive_verbose", "internal integrated Sdks Site Ids extracted from response header: " + this.e);
        this.f = c.a(this.a, IAdefines.HeaderParamsResponse.c);
        InneractiveAdView.Log.v("Inneractive_verbose", "ad width extracted from response header: " + this.f);
        this.g = c.a(this.a, IAdefines.HeaderParamsResponse.b);
        InneractiveAdView.Log.v("Inneractive_verbose", "ad height extracted from response header: " + this.g);
        this.h = c.a(this.a, IAdefines.HeaderParamsResponse.d);
        InneractiveAdView.Log.v("Inneractive_verbose", "ad network extracted from response header: " + this.h);
        this.j = c.a(this.a, IAdefines.HeaderParamsResponse.i);
        InneractiveAdView.Log.v("Inneractive_verbose", "SDK Adapter data extracted from response header: " + this.j);
        localObject2 = this.a.getEntity();
        try {
            localObject1 = ((HttpEntity) localObject2).getContent();
            if (localObject1 == null) {
                break label545;
            }
            Object localObject3 = ((HttpEntity) localObject2).getContentEncoding();
            if (localObject3 == null) {
                break label545;
            }
            localObject3 = ((Header) localObject3).getValue();
            if ((localObject3 == null) || (!((String) localObject3).contains("gzip"))) {
                break label545;
            }
            localObject1 = new GZIPInputStream((InputStream) localObject1);
        } catch (Exception localException) {
            for (; ; ) {
                Object localObject1;
                InneractiveAdView.Log.d("Inneractive_debug", "failed to get the unzipped content.");
                String str = null;
                continue;
                str = "";
                continue;
                if (localObject2 != null) {
                    str = c.a(((HttpEntity) localObject2).getContent());
                } else {
                    str = "";
                }
            }
        }
        if (localObject1 != null) {
            if (localObject2 != null) {
                localObject1 = c.a((InputStream) localObject1);
                localObject2 = new IAresponseData();
                ((IAresponseData) localObject2).a = Uri.encode((String) localObject1);
                ((IAresponseData) localObject2).b = this.d;
                ((IAresponseData) localObject2).c = this.e;
                ((IAresponseData) localObject2).d = this.f;
                ((IAresponseData) localObject2).e = this.g;
                ((IAresponseData) localObject2).f = this.c;
                ((IAresponseData) localObject2).g = this.b;
                this.i = "inneractive_mraid";
                ((IAresponseData) localObject2).h = this.i;
                return new d.c((IAresponseData) localObject2);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/d$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */