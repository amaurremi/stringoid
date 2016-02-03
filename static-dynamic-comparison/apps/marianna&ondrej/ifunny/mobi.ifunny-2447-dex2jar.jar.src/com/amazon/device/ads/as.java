package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"UseSparseArrays"})
class as {
    protected static final String a = as.class.getSimpleName();
    private static ay g = new ay();
    protected final bk b;
    protected final Map<Integer, bq> c;
    protected int d = 20000;
    protected aj e = null;
    protected ed f = null;

    public as(bk parambk, Map<Integer, bq> paramMap) {
        this.b = parambk;
        this.c = paramMap;
    }

    protected static void a(int paramInt, AtomicInteger paramAtomicInteger, br parambr, bq[] paramArrayOfbq) {
        if (paramAtomicInteger.decrementAndGet() == 0) {
            new av(paramInt, parambr, paramArrayOfbq).f();
        }
    }

    protected static void a(int paramInt1, AtomicInteger paramAtomicInteger, br parambr, bq[] paramArrayOfbq, int paramInt2) {
        paramArrayOfbq[paramInt2].a(-1);
        a(paramInt1, paramAtomicInteger, parambr, paramArrayOfbq);
    }

    private void a(aj paramaj) {
        Iterator localIterator = this.c.values().iterator();
        while (localIterator.hasNext()) {
            ((bq) localIterator.next()).a(paramaj);
        }
    }

    private static boolean a(bq[] paramArrayOfbq) {
        int i = 0;
        int j = dn.i().d();
        if (j > 0) {
            j /= 1000;
            Object localObject2;
            if (dn.i().e()) {
                localObject2 = "SDK Message: " + hu.b();
            }
            for (Object localObject1 = ak.d; ; localObject1 = ak.c) {
                dv.c(a, (String) localObject2);
                localObject1 = new aj((ak) localObject1, (String) localObject2);
                j = paramArrayOfbq.length;
                while (i < j) {
                    localObject2 = paramArrayOfbq[i];
                    if ((((bq) localObject2).e() != null) && (((bq) localObject2).e().n() != null)) {
                        ((bq) localObject2).e().n().a(eb.z);
                    }
                    if (((bq) localObject2).f() != null) {
                        ((bq) localObject2).f().a((aj) localObject1);
                    }
                    i += 1;
                }
                localObject2 = "SDK Message: " + "no results. Try again in " + j + " seconds.";
            }
            return true;
        }
        return false;
    }

    protected static boolean[] a(int paramInt, br parambr, bq... paramVarArgs) {
        br localbr = parambr;
        if (parambr == null) {
            localbr = new br();
        }
        parambr = new boolean[paramVarArgs.length];
        if (a(paramVarArgs)) {
            Arrays.fill(parambr, true);
            return parambr;
        }
        AtomicInteger localAtomicInteger = new AtomicInteger(paramVarArgs.length);
        az localaz = new az(paramInt, localAtomicInteger, localbr, paramVarArgs);
        int k = paramVarArgs.length;
        int i = 0;
        int j = 0;
        label70:
        if (i < k) {
            bq localbq = paramVarArgs[i];
            localbq.a(j + 1);
            int m = localbq.d().a(localaz);
            if (m == 0) {
                break label152;
            }
            a(paramInt, localAtomicInteger, localbr, paramVarArgs, j);
            if (m != -1) {
                break label144;
            }
            parambr[j] = 0;
        }
        for (; ; ) {
            j += 1;
            i += 1;
            break label70;
            break;
            label144:
            parambr[j] = 1;
            continue;
            label152:
            parambr[j] = 1;
        }
    }

    private static void b(aj paramaj, bq[] paramArrayOfbq) {
        int m = paramArrayOfbq.length;
        int i = 0;
        int k;
        for (int j = 0; i < m; j = k) {
            bq localbq = paramArrayOfbq[i];
            k = j;
            if (localbq.b() != -1) {
                localbq.f().a(paramaj);
                k = j + 1;
            }
            i += 1;
        }
        if (j > 0) {
            dv.d(a, "%s; code: %s", new Object[]{paramaj.b(), paramaj.a()});
        }
    }

    private static void c(int paramInt, br parambr, bq[] paramArrayOfbq) {
        Object localObject = new cc().b();
        if (!((cd) localObject).a()) {
            b(new aj(ak.d, "An internal request was not made on a background thread."), paramArrayOfbq);
        }
        do {
            return;
            parambr = new bk(parambr).a((cd) localObject);
            localObject = new HashMap();
            int j = paramArrayOfbq.length;
            int i = 0;
            while (i < j) {
                bq localbq = paramArrayOfbq[i];
                if (localbq.b() != -1) {
                    ((HashMap) localObject).put(Integer.valueOf(localbq.b()), localbq);
                    localbq.e().e(localbq.b());
                    parambr.a(localbq.e(), localbq.a());
                }
                i += 1;
            }
        } while (((HashMap) localObject).size() <= 0);
        parambr = g.a(parambr, (Map) localObject);
        parambr.a(paramInt);
        parambr.a();
    }

    private void c(JSONObject paramJSONObject) {
        long l1 = System.currentTimeMillis();
        Object localObject2 = du.a(paramJSONObject, "status", null);
        Object localObject1 = new HashSet(this.c.keySet());
        aj localaj = a(paramJSONObject);
        String str1 = du.a(paramJSONObject, "errorCode", "No Ad Received");
        this.b.a(du.a(paramJSONObject, "instrPixelURL", null));
        if ((localObject2 != null) && (((String) localObject2).equals("ok"))) {
            localObject2 = du.a(paramJSONObject, "ads");
            int m = 0;
            if (m < ((JSONArray) localObject2).length()) {
                JSONObject localJSONObject = du.a((JSONArray) localObject2, m);
                if (localJSONObject == null) {
                }
                for (; ; ) {
                    m += 1;
                    break;
                    int i = du.a(localJSONObject, "slotId", -1);
                    bq localbq = (bq) this.c.get(Integer.valueOf(i));
                    if (localbq != null) {
                        ((HashSet) localObject1).remove(Integer.valueOf(i));
                        paramJSONObject = du.a(localJSONObject, "instrPixelURL", this.b.a());
                        localbq.e().b(paramJSONObject);
                        paramJSONObject = du.a(localJSONObject, "impPixelURL", null);
                        localbq.e().c(paramJSONObject);
                        if (localbq.e().a().a()) {
                            localbq.e().n().a(eb.B);
                        }
                        String str2 = du.a(localJSONObject, "html", "");
                        JSONArray localJSONArray = du.a(localJSONObject, "creativeTypes");
                        HashSet localHashSet = new HashSet();
                        if (localJSONArray != null) {
                            i = 0;
                            while (i < localJSONArray.length()) {
                                paramJSONObject = ai.a(du.a(localJSONArray, i, 0));
                                if (paramJSONObject != null) {
                                    localHashSet.add(paramJSONObject);
                                }
                                i += 1;
                            }
                        }
                        if (localHashSet.isEmpty()) {
                            localbq.a(new aj(ak.d, "No valid creative types found"));
                            dv.c(a, "No valid creative types found");
                        } else {
                            paramJSONObject = du.a(localJSONObject, "size", "");
                            int k = 0;
                            i = 0;
                            int i1 = 0;
                            int j = 0;
                            int n = 0;
                            if (!localHashSet.contains(ai.c)) {
                                int i2 = 0;
                                if (paramJSONObject != null) {
                                    paramJSONObject = paramJSONObject.split("x");
                                    label409:
                                    if ((paramJSONObject != null) && (paramJSONObject.length == 2)) {
                                        break label468;
                                    }
                                    k = 1;
                                    i = i1;
                                    j = n;
                                }
                                for (; ; ) {
                                    if (k == 0) {
                                        break label509;
                                    }
                                    localbq.a(new aj(ak.d, "Server returned an invalid ad size"));
                                    dv.c(a, "Server returned an invalid ad size");
                                    break;
                                    paramJSONObject = null;
                                    break label409;
                                    label468:
                                    i = k;
                                    try {
                                        k = Integer.parseInt(paramJSONObject[0]);
                                        i = k;
                                        j = Integer.parseInt(paramJSONObject[1]);
                                        i = k;
                                        k = i2;
                                    } catch (NumberFormatException paramJSONObject) {
                                        k = 1;
                                        j = n;
                                    }
                                }
                            }
                            label509:
                            long l2 = du.a(localJSONObject, "cacheTTL", -1L);
                            if (l2 > -1L) {
                                localbq.e().a(l2 * 1000L + l1);
                            }
                            paramJSONObject = new bd(localJSONArray);
                            localbq.e().a(j);
                            localbq.e().b(i);
                            localbq.e().a(str2);
                            localbq.e().a(localHashSet);
                            localbq.e().a(paramJSONObject);
                            localbq.e().b(true);
                        }
                    }
                }
            }
        }
        paramJSONObject = ((HashSet) localObject1).iterator();
        while (paramJSONObject.hasNext()) {
            localObject1 = (Integer) paramJSONObject.next();
            ((bq) this.c.get(localObject1)).a(localaj);
            ((bq) this.c.get(localObject1)).e().b(this.b.a());
            dv.d(a, "%s; code: %s", new Object[]{localaj.b(), str1});
        }
    }

    private void f() {
        new Handler(Looper.getMainLooper()).post(new au(this));
    }

    private hy g() {
        h().b(eb.k);
        hy localhy = this.b.f();
        h().c(eb.k);
        return localhy;
    }

    private ec h() {
        if (this.f == null) {
            ArrayList localArrayList = new ArrayList();
            Iterator localIterator = this.c.entrySet().iterator();
            while (localIterator.hasNext()) {
                localArrayList.add(((bq) ((Map.Entry) localIterator.next()).getValue()).e().n());
            }
            this.f = new ed(localArrayList);
        }
        return this.f;
    }

    protected aj a(JSONObject paramJSONObject) {
        int i = b(paramJSONObject);
        dn.i().a(i);
        paramJSONObject = du.a(paramJSONObject, "errorMessage", "No Ad Received");
        dn.i().a(paramJSONObject.equalsIgnoreCase(hu.b()));
        String str = "Server Message: " + paramJSONObject;
        if (i > 0) {
            h().a(eb.A, i * 1000);
        }
        if ((i > 0) && (!dn.i().e())) {
            paramJSONObject = str + ". Try again in " + i + " seconds";
            return new aj(ak.c, paramJSONObject);
        }
        if (paramJSONObject.equals("no results")) {
            return new aj(ak.c, str);
        }
        return new aj(ak.d, str);
    }

    public void a() {
        h().c(eb.d);
        h().b(eb.e);
        b();
    }

    public void a(int paramInt) {
        this.d = paramInt;
    }

    protected int b(JSONObject paramJSONObject) {
        return cx.a("debug.noRetryTTL", du.a(paramJSONObject, "noretryTTL", 0));
    }

    protected void b() {
        ho.a(new at(this));
    }

    protected void c() {
        h().c(eb.e);
        h().b(eb.f);
        if (!cn.a().c()) {
            this.e = new aj(ak.e, "Unable to create the assets needed to display ads");
            dv.c(a, "Unable to create the assets needed to display ads");
            a(this.e);
            return;
        }
        try {
            Object localObject = e();
            if (!(( if)localObject).e())
            {
                localObject = (( if)localObject).d() + " - " + (( if)localObject).f();
                this.e = new aj(ak.a, (String) localObject);
                dv.c(a, (String) localObject);
                a(this.e);
                return;
            }
        } catch (ax localax) {
            this.e = localax.a();
            dv.c(a, localax.a().b());
            a(this.e);
            return;
        }
        JSONObject localJSONObject = localax.b();
        if (localJSONObject == null) {
            this.e = new aj(ak.d, "Unable to parse response");
            dv.c(a, "Unable to parse response");
            a(this.e);
            return;
        }
        c(localJSONObject);
        h().c(eb.g);
        h().b(eb.h);
    }

    protected void d() {
        Iterator localIterator = this.c.entrySet().iterator();
        while (localIterator.hasNext()) {
            bq localbq = (bq) ((Map.Entry) localIterator.next()).getValue();
            dk localdk = localbq.f();
            ah localah = localbq.e();
            localah.n().c(eb.h);
            if (!localah.j()) {
                localah.n().b(eb.j);
                if (localbq.c() != null) {
                    localdk.a(localbq.c());
                } else {
                    localdk.a(new aj(ak.d, "Unknown error occurred."));
                }
            } else {
                localah.n().b(eb.i);
                localdk.m();
            }
        }
    }

    protected if

    e() {
        Object localObject = g();
        ((hy) localObject).a(h());
        ((hy) localObject).a(eb.r);
        ((hy) localObject).a(this.d);
        h().c(eb.f);
        h().a(eb.T);
        try {
            localObject = ((hy) localObject).e();
            h().b(eb.g);
            return ( if)localObject;
        } catch (ic localic) {
            if (localic.a() != ie.a) {
                break label100;
            }
        }
        aj localaj = new aj(ak.a, "Could not contact Ad Server");
        for (; ; ) {
            throw new ax(this, localaj);
            label100:
            if (localaj.a() == ie.b) {
                localaj = new aj(ak.b, "Connection to Ad Server timed out");
            } else {
                localaj = new aj(ak.d, localaj.getMessage());
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */