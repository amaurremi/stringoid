package com.flurry.sdk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@kb
public class mj
        extends lz<Object> {
    private static final Object[] a = new Object[0];

    public mj() {
        super(Object.class);
    }

    public Object a(hj paramhj, iz paramiz)
            throws IOException, hk {
        switch (1. a[paramhj.e().ordinal()])
        {
            case 2:
            case 4:
            default:
                throw paramiz.b(Object.class);
            case 1:
                return c(paramhj, paramiz);
            case 3:
                return b(paramhj, paramiz);
            case 5:
                return c(paramhj, paramiz);
            case 6:
                return paramhj.z();
            case 7:
                return paramhj.k();
            case 8:
                if (paramiz.a(iy.a.h)) {
                    return paramhj.v();
                }
                return paramhj.p();
            case 9:
                if (paramiz.a(iy.a.g)) {
                    return paramhj.y();
                }
                return Double.valueOf(paramhj.x());
            case 10:
                return Boolean.TRUE;
            case 11:
                return Boolean.FALSE;
        }
        return null;
    }

    public Object a(hj paramhj, iz paramiz, jy paramjy)
            throws IOException, hk {
        hm localhm = paramhj.e();
        switch (1. a[localhm.ordinal()])
        {
            case 2:
            case 4:
            default:
                throw paramiz.b(Object.class);
            case 1:
            case 3:
            case 5:
                return paramjy.d(paramhj, paramiz);
            case 7:
                return paramhj.k();
            case 8:
                if (paramiz.a(iy.a.h)) {
                    return paramhj.v();
                }
                return Integer.valueOf(paramhj.t());
            case 9:
                if (paramiz.a(iy.a.g)) {
                    return paramhj.y();
                }
                return Double.valueOf(paramhj.x());
            case 10:
                return Boolean.TRUE;
            case 11:
                return Boolean.FALSE;
            case 6:
                return paramhj.z();
        }
        return null;
    }

    protected Object b(hj paramhj, iz paramiz)
            throws IOException, hk {
        if (paramiz.a(iy.a.i)) {
            return d(paramhj, paramiz);
        }
        if (paramhj.b() == hm.e) {
            return new ArrayList(4);
        }
        re localre = paramiz.g();
        Object localObject2 = localre.a();
        int i = 0;
        int j = 0;
        Object localObject3 = a(paramhj, paramiz);
        int k = j + 1;
        Object localObject1;
        if (i >= localObject2.length) {
            localObject1 = localre.a((Object[]) localObject2);
            i = 0;
        }
        for (; ; ) {
            int m = i + 1;
            localObject1[i] = localObject3;
            j = k;
            i = m;
            localObject2 = localObject1;
            if (paramhj.b() != hm.e) {
                break;
            }
            paramhj = new ArrayList(k + (k >> 3) + 1);
            localre.a((Object[]) localObject1, m, paramhj);
            return paramhj;
            localObject1 = localObject2;
        }
    }

    protected Object c(hj paramhj, iz paramiz)
            throws IOException, hk {
        Object localObject2 = paramhj.e();
        Object localObject1 = localObject2;
        if (localObject2 == hm.b) {
            localObject1 = paramhj.b();
        }
        if (localObject1 != hm.f) {
            return new LinkedHashMap(4);
        }
        localObject1 = paramhj.k();
        paramhj.b();
        localObject2 = a(paramhj, paramiz);
        if (paramhj.b() != hm.f) {
            paramhj = new LinkedHashMap(4);
            paramhj.put(localObject1, localObject2);
            return paramhj;
        }
        String str = paramhj.k();
        paramhj.b();
        Object localObject3 = a(paramhj, paramiz);
        if (paramhj.b() != hm.f) {
            paramhj = new LinkedHashMap(4);
            paramhj.put(localObject1, localObject2);
            paramhj.put(str, localObject3);
            return paramhj;
        }
        LinkedHashMap localLinkedHashMap = new LinkedHashMap();
        localLinkedHashMap.put(localObject1, localObject2);
        localLinkedHashMap.put(str, localObject3);
        do {
            localObject1 = paramhj.k();
            paramhj.b();
            localLinkedHashMap.put(localObject1, a(paramhj, paramiz));
        } while (paramhj.b() != hm.c);
        return localLinkedHashMap;
    }

    protected Object[] d(hj paramhj, iz paramiz)
            throws IOException, hk {
        if (paramhj.b() == hm.e) {
            return a;
        }
        re localre = paramiz.g();
        Object localObject1 = localre.a();
        int i = 0;
        Object localObject3 = a(paramhj, paramiz);
        Object localObject2;
        if (i >= localObject1.length) {
            localObject2 = localre.a((Object[]) localObject1);
            i = 0;
        }
        for (; ; ) {
            int j = i + 1;
            localObject2[i] = localObject3;
            i = j;
            localObject1 = localObject2;
            if (paramhj.b() != hm.e) {
                break;
            }
            return localre.a((Object[]) localObject2, j);
            localObject2 = localObject1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/mj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */