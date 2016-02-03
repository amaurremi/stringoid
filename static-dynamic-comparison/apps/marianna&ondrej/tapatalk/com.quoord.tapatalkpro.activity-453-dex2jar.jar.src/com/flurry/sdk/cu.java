package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;

public class cu {
    private int a;
    private int b;
    private ds<co, String> c;
    private Map<cp, String> d;
    private cv e;

    public static cu a(cu paramcu1, cu paramcu2) {
        if ((paramcu1 == null) || (paramcu2 == null)) {
            return null;
        }
        ds localds = new ds();
        Object localObject = paramcu1.c();
        if (localObject != null) {
            localds.a((ds) localObject);
        }
        localObject = paramcu2.c();
        if (localObject != null) {
            localds.a((ds) localObject);
        }
        localObject = new HashMap();
        paramcu1 = paramcu1.d();
        if (paramcu1 != null) {
            ((Map) localObject).putAll(paramcu1);
        }
        paramcu1 = paramcu2.d();
        if (paramcu1 != null) {
            ((Map) localObject).putAll(paramcu1);
        }
        paramcu1 = new a();
        paramcu1.a(paramcu2.a());
        paramcu1.b(paramcu2.b());
        paramcu1.a(localds);
        paramcu1.a((Map) localObject);
        paramcu1.a(paramcu2.e());
        return paramcu1.a();
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public ds<co, String> c() {
        return this.c;
    }

    public Map<cp, String> d() {
        return this.d;
    }

    public cv e() {
        return this.e;
    }

    public static class a {
        private cu a = new cu(null);

        public a a(int paramInt) {
            cu.a(this.a, paramInt);
            return this;
        }

        public a a(cv paramcv) {
            cu.a(this.a, paramcv);
            return this;
        }

        public a a(ds<co, String> paramds) {
            cu.a(this.a, paramds);
            return this;
        }

        public a a(Map<cp, String> paramMap) {
            cu.a(this.a, paramMap);
            return this;
        }

        public cu a() {
            return this.a;
        }

        public a b(int paramInt) {
            cu.b(this.a, paramInt);
            return this;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */