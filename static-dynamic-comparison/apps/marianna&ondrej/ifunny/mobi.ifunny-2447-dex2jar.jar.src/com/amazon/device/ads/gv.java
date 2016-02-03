package com.amazon.device.ads;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

class gv
        implements ha {
    private static final eb a = eb.M;
    private final cd b;
    private final JSONArray c;

    public gv(cd paramcd, JSONArray paramJSONArray) {
        this.b = paramcd;
        this.c = paramJSONArray;
    }

    public String a() {
        return "SISRegisterEventRequest";
    }

    public void a(JSONObject paramJSONObject) {
        int i = du.a(paramJSONObject, "rcode", 0);
        if (i == 1) {
            dv.b("SISRegisterEventRequest", "Application events registered successfully.");
            cl.a().c();
            return;
        }
        dv.b("SISRegisterEventRequest", "Application events not registered. rcode:" + i);
    }

    public eb b() {
        return a;
    }

    public String c() {
        return "/register_event";
    }

    public ib d() {
        ib localib = new ib();
        localib.a("adId", this.b.e());
        localib.a("dt", cz.b());
        gs localgs = dn.i().c();
        localib.a("app", localgs.a());
        localib.a("appId", localgs.e());
        localib.a("aud", cq.a().a(cs.e));
        return localib;
    }

    public HashMap<String, String> g() {
        HashMap localHashMap = new HashMap();
        localHashMap.put("events", this.c.toString());
        return localHashMap;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/gv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */