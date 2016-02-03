package com.millennialmedia.android;

import android.content.Context;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

class MMAdImplController$RequestAdRunnable
        implements Runnable {
    HttpMMHeaders a;
    String b;

    private MMAdImplController$RequestAdRunnable(MMAdImplController paramMMAdImplController) {
    }

    private boolean a() {
        Object localObject1 = null;
        this.b = null;
        if (this.c.c != null) {
            localObject1 = (MMAdImpl) this.c.c.get();
        }
        if (localObject1 != null) {
            try {
                Object localObject2 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                ((MMAdImpl) localObject1).a((Map) localObject2);
                MMSDK.a(((MMAdImpl) localObject1).j(), (Map) localObject2);
                ((Map) localObject2).put("ua", ((MMAdImpl) localObject1).k.b());
                localObject1 = new StringBuilder(HandShake.a());
                MMLog.b("MMAdImplController", ((Map) localObject2).entrySet().toString());
                localObject2 = ((Map) localObject2).entrySet().iterator();
                while (((Iterator) localObject2).hasNext()) {
                    Map.Entry localEntry = (Map.Entry) ((Iterator) localObject2).next();
                    ((StringBuilder) localObject1).append(String.format("%s=%s&", new Object[]{localEntry.getKey(), URLEncoder.encode((String) localEntry.getValue(), "UTF-8")}));
                }
                localUnsupportedEncodingException.delete(localUnsupportedEncodingException.length() - 1, localUnsupportedEncodingException.length());
            } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                return a(new MMException(localUnsupportedEncodingException));
            }
            this.b = localUnsupportedEncodingException.toString();
            MMLog.b("MMAdImplController", String.format("Calling for an advertisement: %s", new Object[]{this.b}));
        } else {
            b(new MMException(25));
        }
        return true;
    }

    private boolean a(HttpEntity paramHttpEntity) {
        if (this.c.c != null) {
        }
        for (MMAdImpl localMMAdImpl = (MMAdImpl) this.c.c.get(); ; localMMAdImpl = null) {
            if (localMMAdImpl != null) {
                if (localMMAdImpl.isBanner()) {
                    return a(new MMException("Millennial ad return unsupported format.", 15));
                }
            }
            for (; ; ) {
                try {
                    paramHttpEntity = (VideoAd) CachedAd.a(HttpGetRequest.a(paramHttpEntity.getContent()));
                    if ((paramHttpEntity != null) && (paramHttpEntity.b())) {
                        MMLog.c("MMAdImplController", "Cached video ad JSON received: " + paramHttpEntity.e());
                        if (paramHttpEntity.a()) {
                            MMLog.c("MMAdImplController", "New ad has expiration date in the past. Not downloading ad content.");
                            paramHttpEntity.c(localMMAdImpl.j());
                            MMSDK.Event.a(localMMAdImpl, new MMException(15));
                        }
                    } else {
                        return true;
                    }
                } catch (IllegalStateException paramHttpEntity) {
                    paramHttpEntity.printStackTrace();
                    return b(new MMException("Millennial ad return failed. Invalid response data.", paramHttpEntity));
                } catch (IOException paramHttpEntity) {
                    paramHttpEntity.printStackTrace();
                    return b(new MMException("Millennial ad return failed. " + paramHttpEntity, paramHttpEntity));
                }
                if (AdCache.d(localMMAdImpl.j(), localMMAdImpl.k()) != null) {
                    MMLog.c("MMAdImplController", "Previously fetched ad exists in the playback queue. Not downloading ad content.");
                    paramHttpEntity.c(localMMAdImpl.j());
                    MMSDK.Event.a(localMMAdImpl, new MMException(17));
                } else {
                    AdCache.a(localMMAdImpl.j(), paramHttpEntity);
                    if (!paramHttpEntity.d(localMMAdImpl.j())) {
                        MMSDK.Event.a(paramHttpEntity.l);
                        MMLog.b("MMAdImplController", "Downloading ad...");
                        MMSDK.Event.b(localMMAdImpl);
                        paramHttpEntity.e = 3;
                        AdCache.a(localMMAdImpl.j(), localMMAdImpl.k(), paramHttpEntity, localMMAdImpl.k);
                    } else {
                        MMLog.b("MMAdImplController", "Cached ad is valid. Moving it to the front of the queue.");
                        AdCache.a(localMMAdImpl.j(), localMMAdImpl.k(), paramHttpEntity.e());
                        MMSDK.Event.b(localMMAdImpl);
                        MMSDK.Event.f(localMMAdImpl);
                    }
                }
            }
        }
    }

    private boolean a(HttpResponse paramHttpResponse) {
        HttpEntity localHttpEntity = paramHttpResponse.getEntity();
        if (localHttpEntity == null) {
            b(new MMException("Null HTTP entity", 14));
            return false;
        }
        if (localHttpEntity.getContentLength() == 0L) {
            b(new MMException("Millennial ad return failed. Zero content length returned.", 14));
            return false;
        }
        b(paramHttpResponse);
        Object localObject = localHttpEntity.getContentType();
        if ((localObject != null) && (((Header) localObject).getValue() != null)) {
            if (((Header) localObject).getValue().toLowerCase().startsWith("application/json")) {
                a(localHttpEntity);
            }
            for (; ; ) {
                return true;
                if (!((Header) localObject).getValue().toLowerCase().startsWith("text/html")) {
                    break;
                }
                localObject = paramHttpResponse.getFirstHeader("X-MM-Video");
                this.a = new HttpMMHeaders(paramHttpResponse.getAllHeaders());
                if ((localObject != null) && (((Header) localObject).getValue().equalsIgnoreCase("true"))) {
                    paramHttpResponse = null;
                    if (this.c.c != null) {
                        paramHttpResponse = (MMAdImpl) this.c.c.get();
                    }
                    if (paramHttpResponse != null) {
                        localObject = paramHttpResponse.j();
                        HandShake.a((Context) localObject).b((Context) localObject, paramHttpResponse.f);
                    }
                }
                b(localHttpEntity);
            }
            b(new MMException("Millennial ad return failed. Invalid (JSON/HTML expected) mime type returned.", 15));
            return false;
        }
        b(new MMException("Millennial ad return failed. HTTP Header value null.", 15));
        return false;
    }

    private void b(HttpResponse paramHttpResponse) {
        paramHttpResponse = paramHttpResponse.getHeaders("Set-Cookie");
        int j = paramHttpResponse.length;
        int i = 0;
        while (i < j) {
            String str = paramHttpResponse[i].getValue();
            int k = str.indexOf("MAC-ID=");
            if (k >= 0) {
                int m = str.indexOf(';', k);
                if (m > k) {
                    MMSDK.e = str.substring(k + 7, m);
                }
            }
            i += 1;
        }
    }

    private boolean b(HttpEntity paramHttpEntity) {
        MMAdImpl localMMAdImpl = null;
        try {
            if (this.c.c != null) {
                localMMAdImpl = (MMAdImpl) this.c.c.get();
            }
            if (localMMAdImpl != null) {
                if (!localMMAdImpl.isBanner()) {
                    InterstitialAd localInterstitialAd = new InterstitialAd();
                    localInterstitialAd.g = HttpGetRequest.a(paramHttpEntity.getContent());
                    localInterstitialAd.b(localMMAdImpl.f);
                    localInterstitialAd.h = this.b;
                    localInterstitialAd.i = this.a;
                    if (MMSDK.a >= 5) {
                        MMLog.a("MMAdImplController", String.format("Received interstitial ad with url %s.", new Object[]{localInterstitialAd.h}));
                        MMLog.a("MMAdImplController", localInterstitialAd.g);
                    }
                    AdCache.a(localMMAdImpl.j(), localInterstitialAd);
                    AdCache.a(localMMAdImpl.j(), localMMAdImpl.k(), localInterstitialAd.e());
                    MMSDK.Event.b(localMMAdImpl);
                    MMSDK.Event.f(localMMAdImpl);
                } else {
                    if (localMMAdImpl.k != null) {
                        localMMAdImpl.k.a(this.a);
                        localMMAdImpl.k.a(HttpGetRequest.a(paramHttpEntity.getContent()), this.b);
                    }
                    MMSDK.Event.f(localMMAdImpl);
                }
            }
        } catch (IOException paramHttpEntity) {
            return a(new MMException("Exception raised in HTTP stream: " + paramHttpEntity, paramHttpEntity));
        }
        return true;
    }

    boolean a(MMException paramMMException) {
        MMLog.e("MMAdImplController", paramMMException.getMessage());
        return c(paramMMException);
    }

    boolean b(MMException paramMMException) {
        MMLog.c("MMAdImplController", paramMMException.getMessage());
        return c(paramMMException);
    }

    boolean c(MMException paramMMException) {
        MMAdImpl localMMAdImpl = null;
        if (this.c.c != null) {
            localMMAdImpl = (MMAdImpl) this.c.c.get();
        }
        MMSDK.Event.a(localMMAdImpl, paramMMException);
        return false;
    }

    public void run() {
        try {
            if (this.c.c != null) {
                Object localObject1 = (MMAdImpl) this.c.c.get();
                if ((localObject1 != null) && (MMSDK.a(((MMAdImpl) localObject1).j()))) {
                    boolean bool = a();
                    if (!bool) {
                        return;
                    }
                    try {
                        localObject1 = new HttpGetRequest().a(this.b);
                        if (localObject1 == null) {
                            a(new MMException("HTTP response is null.", 14));
                            return;
                        }
                    } catch (Exception localException1) {
                        a(new MMException("Ad request HTTP error. " + localException1.getMessage(), 14));
                        return;
                    }
                    bool = a(localException1);
                    if (bool) {
                    }
                } else {
                    b(new MMException("No network available, can't call for ads.", 11));
                    return;
                }
            }
            return;
        } catch (Exception localException2) {
            b(new MMException("Request not filled, can't call for ads.", 14));
            return;
        } finally {
            this.c.d = null;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMAdImplController$RequestAdRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */