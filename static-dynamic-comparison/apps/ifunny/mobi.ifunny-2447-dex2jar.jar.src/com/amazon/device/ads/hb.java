package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONObject;

class hb {
    private final ha[] a;
    private final hc b;

    public hb(hc paramhc, ha... paramVarArgs) {
        this.b = paramhc;
        this.a = paramVarArgs;
    }

    public hb(ha... paramVarArgs) {
        this(null, paramVarArgs);
    }

    protected static String c() {
        String str2 = cq.a().a(cs.b);
        String str1 = str2;
        if (str2 != null) {
            int i = str2.indexOf("/");
            str1 = str2;
            if (i > -1) {
                str1 = str2.substring(0, i);
            }
        }
        return str1;
    }

    protected static String c(ha paramha) {
        String str2 = cq.a().a(cs.b);
        String str1 = str2;
        int i;
        if (str2 != null) {
            i = str2.indexOf("/");
            if (i <= -1) {
                break label63;
            }
        }
        label63:
        for (str1 = str2.substring(i); ; str1 = "") {
            return str1 + "/api3" + paramha.c();
        }
    }

    public void a() {
        b();
        hc localhc = d();
        if (localhc != null) {
            localhc.a();
        }
    }

    protected void a(ha paramha) {
        Object localObject = b(paramha);
        try {
            localObject = ((hy) localObject).e();
            localObject = (( if)localObject).b();
            if (localObject == null) {
                return;
            }
            int i = du.a((JSONObject) localObject, "rcode", 0);
            String str = du.a((JSONObject) localObject, "msg", "");
            if (i == 1) {
                dv.c(paramha.a(), "Result - code: %d, msg: %s", new Object[]{Integer.valueOf(i), str});
                paramha.a((JSONObject) localObject);
                return;
            }
            dv.d(paramha.a(), "Result - code: %d, msg: %s", new Object[]{Integer.valueOf(i), str});
            return;
        } catch (ic paramha) {
        }
    }

    protected hy b(ha paramha) {
        hy localhy = hy.c();
        localhy.h(paramha.a());
        localhy.a(ia.b);
        localhy.b(c());
        localhy.c(c(paramha));
        localhy.d(true);
        if (paramha.g() != null) {
            localObject = paramha.g().entrySet().iterator();
            while (((Iterator) localObject).hasNext()) {
                Map.Entry localEntry = (Map.Entry) ((Iterator) localObject).next();
                localhy.b((String) localEntry.getKey(), (String) localEntry.getValue());
            }
        }
        Object localObject = paramha.d();
        ((ib) localObject).a("appId", dn.i().c().e());
        ((ib) localObject).a("sdkVer", hv.b());
        localhy.a((ib) localObject);
        localhy.a(dy.a().b());
        localhy.a(paramha.b());
        return localhy;
    }

    protected void b() {
        ha[] arrayOfha = this.a;
        int j = arrayOfha.length;
        int i = 0;
        while (i < j) {
            a(arrayOfha[i]);
            i += 1;
        }
    }

    protected hc d() {
        return this.b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/hb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */