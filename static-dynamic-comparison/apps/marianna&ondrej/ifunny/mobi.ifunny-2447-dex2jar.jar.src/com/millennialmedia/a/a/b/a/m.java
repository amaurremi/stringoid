package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.af;
import com.millennialmedia.a.a.b.w;
import com.millennialmedia.a.a.d.a;
import com.millennialmedia.a.a.d.d;
import com.millennialmedia.a.a.j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class m
        extends ae<Object> {
    public static final af a = new n();
    private final j b;

    private m(j paramj) {
        this.b = paramj;
    }

    public void a(d paramd, Object paramObject) {
        if (paramObject == null) {
            paramd.f();
            return;
        }
        ae localae = this.b.a(paramObject.getClass());
        if ((localae instanceof m)) {
            paramd.d();
            paramd.e();
            return;
        }
        localae.a(paramd, paramObject);
    }

    public Object b(a parama) {
        Object localObject = parama.f();
        switch (o.a[localObject.ordinal()]) {
            default:
                throw new IllegalStateException();
            case 1:
                localObject = new ArrayList();
                parama.a();
                while (parama.e()) {
                    ((List) localObject).add(b(parama));
                }
                parama.b();
                return localObject;
            case 2:
                localObject = new w();
                parama.c();
                while (parama.e()) {
                    ((Map) localObject).put(parama.g(), b(parama));
                }
                parama.d();
                return localObject;
            case 3:
                return parama.h();
            case 4:
                return Double.valueOf(parama.k());
            case 5:
                return Boolean.valueOf(parama.i());
        }
        parama.j();
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */