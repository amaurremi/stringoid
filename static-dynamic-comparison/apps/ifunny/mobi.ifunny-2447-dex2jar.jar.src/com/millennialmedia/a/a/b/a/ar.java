package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.d.a;
import com.millennialmedia.a.a.d.d;
import com.millennialmedia.a.a.r;
import com.millennialmedia.a.a.t;
import com.millennialmedia.a.a.w;
import com.millennialmedia.a.a.y;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class ar
        extends ae<t> {
    public t a(a parama) {
        switch (ay.a[parama.f().ordinal()]) {
            default:
                throw new IllegalArgumentException();
            case 3:
                return new y(parama.h());
            case 1:
                return new y(new com.millennialmedia.a.a.b.v(parama.h()));
            case 2:
                return new y(Boolean.valueOf(parama.i()));
            case 4:
                parama.j();
                return com.millennialmedia.a.a.v.a;
            case 5:
                localObject = new r();
                parama.a();
                while (parama.e()) {
                    ((r) localObject).a(a(parama));
                }
                parama.b();
                return (t) localObject;
        }
        Object localObject = new w();
        parama.c();
        while (parama.e()) {
            ((w) localObject).a(parama.g(), a(parama));
        }
        parama.d();
        return (t) localObject;
    }

    public void a(d paramd, t paramt) {
        if ((paramt == null) || (paramt.j())) {
            paramd.f();
            return;
        }
        if (paramt.i()) {
            paramt = paramt.m();
            if (paramt.p()) {
                paramd.a(paramt.a());
                return;
            }
            if (paramt.o()) {
                paramd.a(paramt.f());
                return;
            }
            paramd.b(paramt.b());
            return;
        }
        if (paramt.g()) {
            paramd.b();
            paramt = paramt.l().iterator();
            while (paramt.hasNext()) {
                a(paramd, (t) paramt.next());
            }
            paramd.c();
            return;
        }
        if (paramt.h()) {
            paramd.d();
            paramt = paramt.k().o().iterator();
            while (paramt.hasNext()) {
                Map.Entry localEntry = (Map.Entry) paramt.next();
                paramd.a((String) localEntry.getKey());
                a(paramd, (t) localEntry.getValue());
            }
            paramd.e();
            return;
        }
        throw new IllegalArgumentException("Couldn't write " + paramt.getClass());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */