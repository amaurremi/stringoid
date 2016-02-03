package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ii
public class kk
        implements Callable<lc> {
    private final Context a;
    private final ml b;
    private final te c;
    private final s d;
    private final Object e = new Object();
    private final ld f;
    private boolean g;
    private int h;
    private List<String> i;

    public kk(Context paramContext, te paramte, s params, ml paramml, ld paramld) {
        this.a = paramContext;
        this.c = paramte;
        this.b = paramml;
        this.d = params;
        this.f = paramld;
        this.g = false;
        this.h = -2;
        this.i = null;
    }

    private bx a(q paramq, kn paramkn, JSONObject paramJSONObject) {
        if (b()) {
            return null;
        }
        Object localObject = a(paramJSONObject.getJSONObject("tracking_urls_and_actions"), "impression_tracking_urls");
        if (localObject == null) {
        }
        for (localObject = null; ; localObject = Arrays.asList((Object[]) localObject)) {
            this.i = ((List) localObject);
            paramkn = paramkn.a(this, paramJSONObject);
            if (paramkn != null) {
                break;
            }
            mx.b("Failed to retrieve ad assets.");
            return null;
        }
        paramkn.a(new bw(this.c, paramq, paramJSONObject));
        return paramkn;
    }

    private lc a(bx parambx) {
        for (; ; ) {
            synchronized (this.e) {
                int k = this.h;
                int j = k;
                if (parambx == null) {
                    j = k;
                    if (this.h == -2) {
                        j = 0;
                    }
                }
                if (j != -2) {
                    parambx = null;
                    return new lc(this.f.a.c, null, this.f.b.d, j, this.f.b.f, this.i, this.f.b.l, this.f.b.k, this.f.a.i, false, null, null, null, null, null, 0L, this.f.d, this.f.b.g, this.f.f, this.f.g, this.f.b.o, this.f.h, parambx);
                }
            }
        }
    }

    private JSONObject a(q paramq) {
        if (b()) {
            return null;
        }
        ma localma = new ma();
        paramq.a("/nativeAdPreProcess", new kl(this, paramq, localma));
        paramq.a("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.f.b.c));
        return (JSONObject) localma.get();
    }

    private String[] a(JSONObject paramJSONObject, String paramString) {
        paramJSONObject = paramJSONObject.optJSONArray(paramString);
        if (paramJSONObject == null) {
            return null;
        }
        paramString = new String[paramJSONObject.length()];
        int j = 0;
        while (j < paramJSONObject.length()) {
            paramString[j] = paramJSONObject.getString(j);
            j += 1;
        }
        return paramString;
    }

    private q c() {
        if (b()) {
            return null;
        }
        q localq = (q) this.d.a(this.a, this.f.a.k, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html").get();
        localq.a(this.c, this.c, this.c, this.c, false, this.c);
        return localq;
    }

    protected kn a(JSONObject paramJSONObject) {
        if (b()) {
            return null;
        }
        paramJSONObject = paramJSONObject.getString("template_id");
        if ("2".equals(paramJSONObject)) {
            return new ko();
        }
        if ("1".equals(paramJSONObject)) {
            return new kp();
        }
        a(0);
        return null;
    }

    public lc a() {
        try {
            Object localObject = c();
            JSONObject localJSONObject = a((q) localObject);
            localObject = a(a((q) localObject, a(localJSONObject), localJSONObject));
            return (lc) localObject;
        } catch (JSONException localJSONException) {
            mx.d("Malformed native JSON response.", localJSONException);
            if (!this.g) {
                a(0);
            }
            return a(null);
        } catch (TimeoutException localTimeoutException) {
            for (; ; ) {
                mx.d("Timeout when loading native ad.", localTimeoutException);
            }
        } catch (InterruptedException localInterruptedException) {
            for (; ; ) {
            }
        } catch (ExecutionException localExecutionException) {
            for (; ; ) {
            }
        } catch (CancellationException localCancellationException) {
            for (; ; ) {
            }
        }
    }

    public Future<Drawable> a(JSONObject paramJSONObject, String paramString, boolean paramBoolean) {
        if (paramBoolean) {
            paramJSONObject = paramJSONObject.getJSONObject(paramString);
            paramString = paramJSONObject;
            if (paramJSONObject == null) {
                paramString = new JSONObject();
            }
            if (!paramBoolean) {
                break label67;
            }
        }
        label67:
        for (paramJSONObject = paramString.getString("url"); ; paramJSONObject = paramString.optString("url")) {
            if (!TextUtils.isEmpty(paramJSONObject)) {
                break label78;
            }
            a(0, paramBoolean);
            return new mc(null);
            paramJSONObject = paramJSONObject.optJSONObject(paramString);
            break;
        }
        label78:
        return this.b.a(paramJSONObject, new km(this, paramBoolean));
    }

    public void a(int paramInt) {
        synchronized (this.e) {
            this.g = true;
            this.h = paramInt;
            return;
        }
    }

    public void a(int paramInt, boolean paramBoolean) {
        if (paramBoolean) {
            a(paramInt);
        }
    }

    public boolean b() {
        synchronized (this.e) {
            boolean bool = this.g;
            return bool;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/kk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */