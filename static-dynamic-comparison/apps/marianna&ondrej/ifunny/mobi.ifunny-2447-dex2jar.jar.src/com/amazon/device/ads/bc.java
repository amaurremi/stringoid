package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

import org.json.JSONObject;

class bc {
    private ah a;
    private ec b;

    public bc(ah paramah) {
        this.a = paramah;
    }

    protected static void a(JSONObject paramJSONObject, ec paramec) {
        if (paramec == null) {
            return;
        }
        Object localObject1 = new HashMap();
        Object localObject2 = new HashMap();
        String str = paramec.b();
        if (str != null) {
            str = str + "_";
        }
        for (; ; ) {
            Object localObject3 = (ee[]) paramec.a().toArray(new ee[paramec.a().size()]);
            int k = localObject3.length;
            int i = 0;
            Long localLong;
            if (i < k) {
                localLong = localObject3[i];
                paramec = localLong.a.a();
                if ((str == null) || (!localLong.a.b())) {
                    break label474;
                }
                paramec = str + paramec;
            }
            label474:
            for (; ; ) {
                if ((localLong instanceof eg)) {
                    paramec = (eg) localLong;
                    ((HashMap) localObject1).put(localLong.a, Long.valueOf(paramec.b));
                }
                for (; ; ) {
                    i += 1;
                    break;
                    Object localObject4;
                    if ((localLong instanceof eh)) {
                        localObject4 = (eh) localLong;
                        localLong = (Long) ((HashMap) localObject1).get(localLong.a);
                        if (localLong != null) {
                            du.b(paramJSONObject, paramec, ((eh) localObject4).b - localLong.longValue());
                        }
                    } else if ((localLong instanceof ej)) {
                        du.b(paramJSONObject, paramec, ((ej) localLong).b);
                    } else {
                        if ((localLong instanceof ef)) {
                            paramec = (ef) localLong;
                            localObject4 = (Integer) ((HashMap) localObject2).get(localLong.a);
                            if (localObject4 == null) {
                            }
                            for (int j = paramec.b; ; j = paramec.b + j) {
                                ((HashMap) localObject2).put(localLong.a, Integer.valueOf(j));
                                break;
                                j = ((Integer) localObject4).intValue();
                            }
                        }
                        if ((localLong instanceof ei)) {
                            du.b(paramJSONObject, paramec, ((ei) localLong).b);
                        }
                    }
                }
                localObject2 = ((HashMap) localObject2).entrySet().iterator();
                while (((Iterator) localObject2).hasNext()) {
                    localObject3 = (Map.Entry) ((Iterator) localObject2).next();
                    localObject1 = ((eb) ((Map.Entry) localObject3).getKey()).a();
                    paramec = (ec) localObject1;
                    if (str != null) {
                        paramec = (ec) localObject1;
                        if (((eb) ((Map.Entry) localObject3).getKey()).b()) {
                            paramec = str + (String) localObject1;
                        }
                    }
                    du.b(paramJSONObject, paramec, ((Integer) ((Map.Entry) localObject3).getValue()).intValue());
                }
                break;
            }
        }
    }

    private String d() {
        String str = hu.b(c());
        str = this.a.g() + str;
        this.a.o();
        return str;
    }

    public hy a() {
        hy localhy = hy.c();
        localhy.d(d());
        return localhy;
    }

    public void a(ec paramec) {
        this.b = paramec;
    }

    public boolean b() {
        if (this.a == null) {
        }
        do {
            return false;
            str = this.a.g();
        } while ((str == null) || (str.equals("")));
        String str = dn.i().c().e();
        if ((str == null) || (str.equals("123"))) {
            dv.b("AdMetrics", "Not submitting metrics because the AppKey is either not set or set to a test key.");
            return false;
        }
        return true;
    }

    protected String c() {
        Object localObject = new JSONObject();
        du.b((JSONObject) localObject, "c", "msdk");
        du.b((JSONObject) localObject, "v", hv.a());
        a((JSONObject) localObject, this.a.n());
        a((JSONObject) localObject, this.b);
        localObject = ((JSONObject) localObject).toString();
        return ((String) localObject).substring(1, ((String) localObject).length() - 1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */