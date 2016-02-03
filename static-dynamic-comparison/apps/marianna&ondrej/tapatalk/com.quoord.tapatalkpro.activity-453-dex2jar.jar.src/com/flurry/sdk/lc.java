package com.flurry.sdk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class lc {
    private final b[] a;
    private final HashMap<String, Integer> b;
    private final String[] c;
    private final sq[] d;

    protected lc(lc paramlc) {
        this.a = paramlc.a;
        this.b = paramlc.b;
        int i = this.a.length;
        this.c = new String[i];
        this.d = new sq[i];
    }

    protected lc(b[] paramArrayOfb, HashMap<String, Integer> paramHashMap, String[] paramArrayOfString, sq[] paramArrayOfsq) {
        this.a = paramArrayOfb;
        this.b = paramHashMap;
        this.c = paramArrayOfString;
        this.d = paramArrayOfsq;
    }

    public lc a() {
        return new lc(this);
    }

    public Object a(hj paramhj, iz paramiz, Object paramObject)
            throws IOException, hk {
        int i = 0;
        int j = this.a.length;
        if (i < j) {
            if (this.c[i] == null) {
                if (this.d[i] != null) {
                }
            }
            for (; ; ) {
                i += 1;
                break;
                throw paramiz.b("Missing external type id property '" + this.a[i].a());
                if (this.d[i] == null) {
                    paramhj = this.a[i].b();
                    throw paramiz.b("Missing property '" + paramhj.c() + "' for external type id '" + this.a[i].a());
                }
                a(paramhj, paramiz, paramObject, i);
            }
        }
        return paramObject;
    }

    protected final void a(hj paramhj, iz paramiz, Object paramObject, int paramInt)
            throws IOException, hk {
        sq localsq = new sq(paramhj.a());
        localsq.b();
        localsq.b(this.c[paramInt]);
        hj localhj = this.d[paramInt].a(paramhj);
        localhj.b();
        localsq.c(localhj);
        localsq.c();
        paramhj = localsq.a(paramhj);
        paramhj.b();
        this.a[paramInt].b().a(paramhj, paramiz, paramObject);
    }

    public boolean a(hj paramhj, iz paramiz, String paramString, Object paramObject)
            throws IOException, hk {
        int j = 0;
        Integer localInteger = (Integer) this.b.get(paramString);
        if (localInteger == null) {
            return false;
        }
        int k = localInteger.intValue();
        int i;
        if (this.a[k].a(paramString)) {
            this.c[k] = paramhj.k();
            paramhj.d();
            if ((paramObject != null) && (this.d[k] != null)) {
                i = 1;
            }
        }
        for (; ; ) {
            if (i != 0) {
                a(paramhj, paramiz, paramObject, k);
                this.c[k] = null;
                this.d[k] = null;
            }
            return true;
            i = 0;
            continue;
            paramString = new sq(paramhj.a());
            paramString.c(paramhj);
            this.d[k] = paramString;
            i = j;
            if (paramObject != null) {
                i = j;
                if (this.c[k] != null) {
                    i = 1;
                }
            }
        }
    }

    public static class a {
        private final ArrayList<lc.b> a = new ArrayList();
        private final HashMap<String, Integer> b = new HashMap();

        public lc a() {
            return new lc((lc.b[]) this.a.toArray(new lc.b[this.a.size()]), this.b, null, null);
        }

        public void a(kt paramkt, String paramString) {
            Integer localInteger = Integer.valueOf(this.a.size());
            this.a.add(new lc.b(paramkt, paramString));
            this.b.put(paramkt.c(), localInteger);
            this.b.put(paramString, localInteger);
        }
    }

    static final class b {
        private final kt a;
        private final String b;

        public b(kt paramkt, String paramString) {
            this.a = paramkt;
            this.b = paramString;
        }

        public String a() {
            return this.b;
        }

        public boolean a(String paramString) {
            return paramString.equals(this.b);
        }

        public kt b() {
            return this.a;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/lc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */