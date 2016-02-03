package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class go
        extends gr {
    private static gj a = new gj().a(32);

    private static gq a(List<String> paramList1, List<String> paramList2) {
        Object[] arrayOfObject = new Object[paramList1.size()];
        int i = 0;
        if (i < arrayOfObject.length) {
            int j = paramList2.indexOf(paramList1.get(i));
            if (j == -1) {
            }
            for (Object localObject = "No match for " + (String) paramList1.get(i); ; localObject = new Integer(j)) {
                arrayOfObject[i] = localObject;
                i += 1;
                break;
            }
        }
        return new gq.c(paramList2.size(), arrayOfObject);
    }

    public static void a(gi paramgi, fn paramfn, hh paramhh)
            throws IOException {
        Object localObject2;
        Object localObject1;
        int i;
        switch (1. a[paramfn.a().ordinal()])
        {
            default:
                return;
            case 13:
                localObject2 = paramfn.b().iterator();
                while (((Iterator) localObject2).hasNext()) {
                    fn.f localf = (fn.f) ((Iterator) localObject2).next();
                    String str = localf.a();
                    localObject1 = paramhh.a(str);
                    paramfn = (fn) localObject1;
                    if (localObject1 == null) {
                        paramfn = localf.e();
                    }
                    if (paramfn == null) {
                        throw new fl("No default value for: " + str);
                    }
                    a(paramgi, localf.c(), paramfn);
                }
            case 10:
                paramgi.a(paramfn.c(paramhh.i()));
                return;
            case 11:
                paramgi.b();
                paramgi.a(paramhh.p());
                paramfn = paramfn.i();
                paramhh = paramhh.iterator();
                while (paramhh.hasNext()) {
                    localObject1 = (hh) paramhh.next();
                    paramgi.c();
                    a(paramgi, paramfn, (hh) localObject1);
                }
                paramgi.d();
                return;
            case 12:
                paramgi.e();
                paramgi.a(paramhh.p());
                paramfn = paramfn.j();
                localObject1 = paramhh.r();
                while (((Iterator) localObject1).hasNext()) {
                    paramgi.c();
                    localObject2 = (String) ((Iterator) localObject1).next();
                    paramgi.a((String) localObject2);
                    a(paramgi, paramfn, paramhh.a((String) localObject2));
                }
                paramgi.f();
                return;
            case 14:
                paramgi.b(0);
                a(paramgi, (fn) paramfn.k().get(0), paramhh);
                return;
            case 9:
                if (!paramhh.f()) {
                    throw new fl("Non-string default value for fixed: " + paramhh);
                }
                paramhh = paramhh.i().getBytes("ISO-8859-1");
                if (paramhh.length != paramfn.l()) {
                    localObject1 = new byte[paramfn.l()];
                    if (paramfn.l() > paramhh.length) {
                        i = paramhh.length;
                        System.arraycopy(paramhh, 0, localObject1, 0, i);
                    }
                }
                break;
        }
        for (paramfn = (fn) localObject1; ; paramfn = paramhh) {
            paramgi.b(paramfn);
            return;
            i = paramfn.l();
            break;
            if (!paramhh.f()) {
                throw new fl("Non-string default value for string: " + paramhh);
            }
            paramgi.a(paramhh.i());
            return;
            if (!paramhh.f()) {
                throw new fl("Non-string default value for bytes: " + paramhh);
            }
            paramgi.a(paramhh.i().getBytes("ISO-8859-1"));
            return;
            if (!paramhh.d()) {
                throw new fl("Non-numeric default value for int: " + paramhh);
            }
            paramgi.c(paramhh.k());
            return;
            if (!paramhh.d()) {
                throw new fl("Non-numeric default value for long: " + paramhh);
            }
            paramgi.b(paramhh.l());
            return;
            if (!paramhh.d()) {
                throw new fl("Non-numeric default value for float: " + paramhh);
            }
            paramgi.a((float) paramhh.m());
            return;
            if (!paramhh.d()) {
                throw new fl("Non-numeric default value for double: " + paramhh);
            }
            paramgi.a(paramhh.m());
            return;
            if (!paramhh.g()) {
                throw new fl("Non-boolean default for boolean: " + paramhh);
            }
            paramgi.a(paramhh.j());
            return;
            if (!paramhh.h()) {
                throw new fl("Non-null default value for null type: " + paramhh);
            }
            paramgi.a();
            return;
        }
    }

    private static byte[] a(fn paramfn, hh paramhh)
            throws IOException {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        gc localgc = a.a(localByteArrayOutputStream, null);
        a(localgc, paramfn, paramhh);
        localgc.flush();
        return localByteArrayOutputStream.toByteArray();
    }

    private static int b(fn paramfn1, fn paramfn2) {
        int j = 0;
        fn.v localv = paramfn2.a();
        Iterator localIterator = paramfn1.k().iterator();
        int i = 0;
        while (localIterator.hasNext()) {
            Object localObject = (fn) localIterator.next();
            if (localv == ((fn) localObject).a()) {
                if ((localv == fn.v.a) || (localv == fn.v.b) || (localv == fn.v.f)) {
                    String str = paramfn2.g();
                    localObject = ((fn) localObject).g();
                    if (((str == null) || (!str.equals(localObject))) && ((str != localObject) || (localv != fn.v.a))) {
                    }
                } else {
                    return i;
                }
            }
            i += 1;
        }
        paramfn1 = paramfn1.k().iterator();
        i = j;
        if (paramfn1.hasNext()) {
            paramfn2 = (fn) paramfn1.next();
            switch (1. a[localv.ordinal()])
            {
            }
            for (; ; ) {
                i += 1;
                break;
                switch (1. a[paramfn2.a().ordinal()])
                {
                    case 5:
                    default:
                        break;
                    case 4:
                    case 6:
                        return i;
                    switch (1. a[paramfn2.a().ordinal()])
                    {
                    }
                    break;
                }
            }
            return i;
        }
        return -1;
    }

    private gq b(fn paramfn1, fn paramfn2, Map<gr.a, gq> paramMap)
            throws IOException {
        Object localObject = paramfn1.k();
        int i = ((List) localObject).size();
        paramfn1 = new gq[i];
        String[] arrayOfString = new String[i];
        localObject = ((List) localObject).iterator();
        i = 0;
        while (((Iterator) localObject).hasNext()) {
            fn localfn = (fn) ((Iterator) localObject).next();
            paramfn1[i] = a(localfn, paramfn2, paramMap);
            arrayOfString[i] = localfn.g();
            i += 1;
        }
        return gq.b(new gq[]{gq.a(paramfn1, arrayOfString), new gq.q()});
    }

    private gq c(fn paramfn1, fn paramfn2, Map<gr.a, gq> paramMap)
            throws IOException {
        Object localObject3 = new a(paramfn1, paramfn2);
        Object localObject2 = (gq) paramMap.get(localObject3);
        Object localObject1 = localObject2;
        Object localObject5;
        Object localObject4;
        int k;
        int i;
        fn.f localf;
        int j;
        if (localObject2 == null) {
            localObject5 = paramfn1.b();
            localObject1 = paramfn2.b();
            localObject4 = new fn.f[((List) localObject1).size()];
            k = ((List) localObject5).size();
            localObject2 = ((List) localObject5).iterator();
            i = 0;
            if (((Iterator) localObject2).hasNext()) {
                localf = paramfn2.b(((fn.f) ((Iterator) localObject2).next()).a());
                if (localf == null) {
                    break label577;
                }
                j = i + 1;
                localObject4[i] = localf;
                i = j;
            }
        }
        label562:
        label577:
        for (; ; ) {
            break;
            localObject2 = ((List) localObject1).iterator();
            j = k + 1;
            if (((Iterator) localObject2).hasNext()) {
                localf = (fn.f) ((Iterator) localObject2).next();
                if (paramfn1.b(localf.a()) != null) {
                    break label562;
                }
                if (localf.e() == null) {
                    localObject1 = gq.a("Found " + paramfn1.a(true) + ", expecting " + paramfn2.a(true));
                    paramMap.put(localObject3, localObject1);
                    return (gq) localObject1;
                }
                localObject4[i] = localf;
                k = j + 3;
                j = i + 1;
                i = k;
            }
            for (; ; ) {
                k = j;
                j = i;
                i = k;
                break;
                localObject2 = new gq[j];
                i = j - 1;
                localObject2[i] = new gq.e((fn.f[]) localObject4);
                localObject4 = gq.b((gq[]) localObject2);
                paramMap.put(localObject3, localObject4);
                localObject3 = ((List) localObject5).iterator();
                if (((Iterator) localObject3).hasNext()) {
                    localObject5 = (fn.f) ((Iterator) localObject3).next();
                    localf = paramfn2.b(((fn.f) localObject5).a());
                    if (localf == null) {
                        i -= 1;
                        localObject2[i] = new gq.n(a(((fn.f) localObject5).c(), ((fn.f) localObject5).c(), paramMap));
                    }
                    for (; ; ) {
                        break;
                        i -= 1;
                        localObject2[i] = a(((fn.f) localObject5).c(), localf.c(), paramMap);
                    }
                }
                paramfn2 = ((List) localObject1).iterator();
                while (paramfn2.hasNext()) {
                    localObject1 = (fn.f) paramfn2.next();
                    if (paramfn1.b(((fn.f) localObject1).a()) == null) {
                        localObject3 = a(((fn.f) localObject1).c(), ((fn.f) localObject1).e());
                        i -= 1;
                        localObject2[i] = new gq.b((byte[]) localObject3);
                        i -= 1;
                        localObject2[i] = a(((fn.f) localObject1).c(), ((fn.f) localObject1).c(), paramMap);
                        i -= 1;
                        localObject2[i] = gq.x;
                    }
                }
                return (gq) localObject4;
                k = i;
                i = j;
                j = k;
            }
        }
    }

    public final gq a(fn paramfn1, fn paramfn2)
            throws IOException {
        return gq.a(new gq[]{a(paramfn1, paramfn2, new HashMap())});
    }

    public gq a(fn paramfn1, fn paramfn2, Map<gr.a, gq> paramMap)
            throws IOException {
        fn.v localv1 = paramfn1.a();
        fn.v localv2 = paramfn2.a();
        if (localv1 == localv2) {
            switch (1. a[localv1.ordinal()])
            {
                default:
                    throw new fl("Unkown type for schema: " + localv1);
                case 1:
                    return gq.c;
                case 2:
                    return gq.d;
                case 3:
                    return gq.e;
                case 4:
                    return gq.f;
                case 5:
                    return gq.g;
                case 6:
                    return gq.h;
                case 7:
                    return gq.i;
                case 8:
                    return gq.j;
                case 9:
                    if ((!paramfn1.g().equals(paramfn2.g())) || (paramfn1.l() != paramfn2.l())) {
                        break;
                    }
                    return gq.b(new gq[]{new gq.h(paramfn1.l()), gq.k});
                case 10:
                    if ((paramfn1.g() != null) && (!paramfn1.g().equals(paramfn2.g()))) {
                        break;
                    }
                    return gq.b(new gq[]{a(paramfn1.c(), paramfn2.c()), gq.l});
                case 11:
                    return gq.b(new gq[]{gq.a(gq.o, new gq[]{a(paramfn1.i(), paramfn2.i(), paramMap)}), gq.n});
                case 12:
                    return gq.b(new gq[]{gq.a(gq.q, new gq[]{a(paramfn1.j(), paramfn2.j(), paramMap), gq.i}), gq.p});
                case 13:
                    return c(paramfn1, paramfn2, paramMap);
                case 14:
                    return b(paramfn1, paramfn2, paramMap);
            }
        } else {
            if (localv1 == fn.v.e) {
                return b(paramfn1, paramfn2, paramMap);
            }
            switch (1. a[localv2.ordinal()])
            {
                case 9:
                default:
                    throw new RuntimeException("Unexpected schema type: " + localv2);
                case 4:
                    switch (1. a[localv1.ordinal()])
                {
                }
                break;
            }
        }
        int i;
        do {
            for (; ; ) {
                return gq.a("Found " + paramfn1.a(true) + ", expecting " + paramfn2.a(true));
                return gq.a(super.a(paramfn1, paramMap), gq.f);
                switch (1. a[localv1.ordinal()])
                {
                    default:
                        break;
                    case 3:
                    case 4:
                        return gq.a(super.a(paramfn1, paramMap), gq.g);
                    switch (1. a[localv1.ordinal()])
                    {
                    }
                    break;
                }
            }
            return gq.a(super.a(paramfn1, paramMap), gq.h);
            i = b(paramfn2, paramfn1);
        } while (i < 0);
        return gq.b(new gq[]{new gq.p(i, a(paramfn1, (fn) paramfn2.k().get(i), paramMap)), gq.m});
    }

    static class a
            extends gr.a {
        public fn a;

        public a(fn paramfn1, fn paramfn2) {
            super();
            this.a = paramfn2;
        }

        public boolean equals(Object paramObject) {
            if (!(paramObject instanceof a)) {
            }
            do {
                return false;
                paramObject = (a) paramObject;
            } while ((this.b != ((a) paramObject).b) || (this.a != ((a) paramObject).a));
            return true;
        }

        public int hashCode() {
            return super.hashCode() + this.a.hashCode();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/go.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */