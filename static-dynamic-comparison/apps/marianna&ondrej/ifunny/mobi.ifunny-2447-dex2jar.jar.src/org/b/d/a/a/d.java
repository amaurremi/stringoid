package org.b.d.a.a;

import java.util.HashMap;
import java.util.Map;

public class d {
    boolean a;
    boolean b;
    boolean c;
    String d;
    String e;
    String f;
    private Map<String, Object> h = new HashMap();

    static {
        if (!d.class.desiredAssertionStatus()) {
        }
        for (boolean bool = true; ; bool = false) {
            g = bool;
            return;
        }
    }

    public void a(String paramString) {
        this.e = paramString;
    }

    void a(d paramd) {
        if ((!g) && (!this.e.equals(paramd.e))) {
            throw new AssertionError();
        }
        this.c |= paramd.c;
        this.b |= paramd.b;
        this.a |= paramd.a;
        if (this.d == null) {
            this.d = paramd.d;
        }
        if (this.e == null) {
            this.e = paramd.e;
        }
        if (this.f == null) {
            this.f = paramd.f;
        }
    }

    public String b() {
        return this.e;
    }

    public String c() {
        if (this.f == null) {
            return b();
        }
        return this.f;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */