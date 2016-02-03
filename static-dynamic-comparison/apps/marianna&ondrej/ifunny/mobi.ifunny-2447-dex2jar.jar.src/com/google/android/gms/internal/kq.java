package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@ii
public final class kq
        extends kg {
    private static final Object a = new Object();
    private static kq b;
    private final Context c;
    private final la d;
    private final dd e;
    private final bs f;

    kq(Context paramContext, bs parambs, dd paramdd, la paramla) {
        this.c = paramContext;
        this.d = paramla;
        this.e = paramdd;
        this.f = parambs;
    }

    private static fk a(Context paramContext, bs parambs, dd paramdd, la paramla, fi paramfi) {
        mx.a("Starting ad request from service.");
        paramdd.a();
        kz localkz = new kz(paramContext);
        if (localkz.l == -1) {
            mx.a("Device is offline.");
            return new fk(2);
        }
        ku localku = new ku(paramfi.f.packageName);
        if (paramfi.c.c != null) {
            localObject = paramfi.c.c.getString("_ad");
            if (localObject != null) {
                return kt.a(paramContext, paramfi, (String) localObject);
            }
        }
        Object localObject = paramdd.a(250L);
        paramdd = parambs.a();
        parambs = kt.a(paramfi, localkz, (Location) localObject, parambs.b(), parambs.c());
        if (parambs == null) {
            return new fk(0);
        }
        parambs = a(parambs);
        mv.a.post(new kr(paramContext, paramfi, localku, parambs, paramdd));
        try {
            paramdd = (ky) localku.a().get(10L, TimeUnit.SECONDS);
            if (paramdd == null) {
                return new fk(0);
            }
        } catch (Exception paramContext) {
            return new fk(0);
        }
        if (paramdd.a() != -2) {
            return new fk(paramdd.a());
        }
        parambs = null;
        if (paramdd.f()) {
            parambs = paramla.a(paramfi.g.packageName);
        }
        return a(paramContext, paramfi.k.b, paramdd.d(), parambs, paramdd);
    }

    public static fk a(Context paramContext, String paramString1, String paramString2, String paramString3, ky paramky) {
        try {
            localkx = new kx();
            mx.a("AdRequestServiceImpl: Sending request: " + paramString2);
            paramString2 = new URL(paramString2);
            l = SystemClock.elapsedRealtime();
            i = 0;
        } catch (IOException paramContext) {
            try {
                for (; ; ) {
                    kx localkx;
                    long l;
                    int i;
                    lw.a(paramContext, paramString1, false, localHttpURLConnection);
                    if (!TextUtils.isEmpty(paramString3)) {
                        localHttpURLConnection.addRequestProperty("x-afma-drt-cookie", paramString3);
                    }
                    if ((paramky != null) && (!TextUtils.isEmpty(paramky.c()))) {
                        localHttpURLConnection.setDoOutput(true);
                        localObject = paramky.c().getBytes();
                        localHttpURLConnection.setFixedLengthStreamingMode(localObject.length);
                        BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localHttpURLConnection.getOutputStream());
                        localBufferedOutputStream.write((byte[]) localObject);
                        localBufferedOutputStream.close();
                    }
                    int j = localHttpURLConnection.getResponseCode();
                    Object localObject = localHttpURLConnection.getHeaderFields();
                    if ((j >= 200) && (j < 300)) {
                        paramContext = paramString2.toString();
                        paramString1 = lw.a(new InputStreamReader(localHttpURLConnection.getInputStream()));
                        a(paramContext, (Map) localObject, paramString1, j);
                        localkx.a(paramContext, (Map) localObject, paramString1);
                        paramContext = localkx.a(l);
                        return paramContext;
                    }
                    a(paramString2.toString(), (Map) localObject, null, j);
                    if ((j >= 300) && (j < 400)) {
                        paramString2 = localHttpURLConnection.getHeaderField("Location");
                        if (TextUtils.isEmpty(paramString2)) {
                            mx.e("No location header to follow redirect.");
                            paramContext = new fk(0);
                            return paramContext;
                        }
                        paramString2 = new URL(paramString2);
                        i += 1;
                        if (i > 5) {
                            mx.e("Too many redirects.");
                            paramContext = new fk(0);
                            return paramContext;
                        }
                    } else {
                        mx.e("Received error HTTP response code: " + j);
                        paramContext = new fk(0);
                        return paramContext;
                    }
                    localkx.a((Map) localObject);
                    localHttpURLConnection.disconnect();
                }
            } finally {
                HttpURLConnection localHttpURLConnection;
                localHttpURLConnection.disconnect();
            }
            paramContext = paramContext;
            mx.e("Error while connecting to ad server: " + paramContext.getMessage());
            return new fk(2);
        }
        localHttpURLConnection = (HttpURLConnection) paramString2.openConnection();
    }

    public static kq a(Context paramContext, bs parambs, dd paramdd, la paramla) {
        synchronized (a) {
            if (b == null) {
                b = new kq(paramContext.getApplicationContext(), parambs, paramdd, paramla);
            }
            paramContext = b;
            return paramContext;
        }
    }

    private static nd a(String paramString) {
        return new ks(paramString);
    }

    private static void a(String paramString1, Map<String, List<String>> paramMap, String paramString2, int paramInt) {
        if (mx.a(2)) {
            mx.d("Http Response: {\n  URL:\n    " + paramString1 + "\n  Headers:");
            if (paramMap != null) {
                paramString1 = paramMap.keySet().iterator();
                while (paramString1.hasNext()) {
                    Object localObject = (String) paramString1.next();
                    mx.d("    " + (String) localObject + ":");
                    localObject = ((List) paramMap.get(localObject)).iterator();
                    while (((Iterator) localObject).hasNext()) {
                        String str = (String) ((Iterator) localObject).next();
                        mx.d("      " + str);
                    }
                }
            }
            mx.d("  Body:");
            if (paramString2 != null) {
                int i = 0;
                while (i < Math.min(paramString2.length(), 100000)) {
                    mx.d(paramString2.substring(i, Math.min(paramString2.length(), i + 1000)));
                    i += 1000;
                }
            }
            mx.d("    null");
            mx.d("  Response Code:\n    " + paramInt + "\n}");
        }
    }

    public fk a(fi paramfi) {
        return a(this.c, this.f, this.e, this.d, paramfi);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/kq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */