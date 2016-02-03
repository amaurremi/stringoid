package com.flurry.sdk;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@kb
public class po
        extends pf<Map<?, ?>>
        implements jt {
    protected static final sh a = ;
    protected final is b;
    protected final HashSet<String> c;
    protected final boolean d;
    protected final sh e;
    protected final sh f;
    protected jk<Object> g;
    protected jk<Object> h;
    protected final jz i;
    protected ov j;

    protected po() {
        this((HashSet) null, null, null, false, null, null, null, null);
    }

    protected po(HashSet<String> paramHashSet, sh paramsh1, sh paramsh2, boolean paramBoolean, jz paramjz, jk<Object> paramjk1, jk<Object> paramjk2, is paramis) {
        super(Map.class, false);
        this.b = paramis;
        this.c = paramHashSet;
        this.e = paramsh1;
        this.f = paramsh2;
        this.d = paramBoolean;
        this.i = paramjz;
        this.g = paramjk1;
        this.h = paramjk2;
        this.j = ov.a();
    }

    public static po a(String[] paramArrayOfString, sh paramsh, boolean paramBoolean, jz paramjz, is paramis, jk<Object> paramjk1, jk<Object> paramjk2) {
        HashSet localHashSet = a(paramArrayOfString);
        if (paramsh == null) {
            paramArrayOfString = a;
            paramsh = paramArrayOfString;
            if (paramBoolean) {
                break label71;
            }
            if ((paramsh == null) || (!paramsh.u())) {
                break label66;
            }
            paramBoolean = true;
        }
        label66:
        label71:
        for (; ; ) {
            return new po(localHashSet, paramArrayOfString, paramsh, paramBoolean, paramjz, paramjk1, paramjk2, paramis);
            paramArrayOfString = paramsh.k();
            paramsh = paramsh.g();
            break;
            paramBoolean = false;
        }
    }

    private static HashSet<String> a(String[] paramArrayOfString) {
        Object localObject;
        if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
            localObject = null;
            return (HashSet<String>) localObject;
        }
        HashSet localHashSet = new HashSet(paramArrayOfString.length);
        int m = paramArrayOfString.length;
        int k = 0;
        for (; ; ) {
            localObject = localHashSet;
            if (k >= m) {
                break;
            }
            localHashSet.add(paramArrayOfString[k]);
            k += 1;
        }
    }

    protected final jk<Object> a(ov paramov, sh paramsh, jw paramjw)
            throws jh {
        paramsh = paramov.a(paramsh, paramjw, this.b);
        if (paramov != paramsh.b) {
            this.j = paramsh.b;
        }
        return paramsh.a;
    }

    protected final jk<Object> a(ov paramov, Class<?> paramClass, jw paramjw)
            throws jh {
        paramClass = paramov.a(paramClass, paramjw, this.b);
        if (paramov != paramClass.b) {
            this.j = paramClass.b;
        }
        return paramClass.a;
    }

    public pf<?> a(jz paramjz) {
        paramjz = new po(this.c, this.e, this.f, this.d, paramjz, this.g, this.h, this.b);
        if (this.h != null) {
            paramjz.h = this.h;
        }
        return paramjz;
    }

    public void a(jw paramjw)
            throws jh {
        if ((this.d) && (this.h == null)) {
            this.h = paramjw.a(this.f, this.b);
        }
        if (this.g == null) {
            this.g = paramjw.b(this.e, this.b);
        }
    }

    public void a(Map<?, ?> paramMap, hf paramhf, jw paramjw)
            throws IOException, he {
        paramhf.d();
        if (!paramMap.isEmpty()) {
            if (this.h == null) {
                break label36;
            }
            a(paramMap, paramhf, paramjw, this.h);
        }
        for (; ; ) {
            paramhf.e();
            return;
            label36:
            b(paramMap, paramhf, paramjw);
        }
    }

    protected void a(Map<?, ?> paramMap, hf paramhf, jw paramjw, jk<Object> paramjk)
            throws IOException, he {
        jk localjk = this.g;
        HashSet localHashSet = this.c;
        jz localjz = this.i;
        int k;
        Iterator localIterator;
        if (!paramjw.a(ju.a.v)) {
            k = 1;
            localIterator = paramMap.entrySet().iterator();
        }
        for (; ; ) {
            label44:
            if (!localIterator.hasNext()) {
                return;
            }
            Object localObject2 = (Map.Entry) localIterator.next();
            Object localObject1 = ((Map.Entry) localObject2).getValue();
            localObject2 = ((Map.Entry) localObject2).getKey();
            if (localObject2 == null) {
                paramjw.c().a(null, paramhf, paramjw);
            }
            for (; ; ) {
                if (localObject1 != null) {
                    break label155;
                }
                paramjw.a(paramhf);
                break label44;
                k = 0;
                break;
                if (((k != 0) && (localObject1 == null)) || ((localHashSet != null) && (localHashSet.contains(localObject2)))) {
                    break label44;
                }
                localjk.a(localObject2, paramhf, paramjw);
            }
            label155:
            if (localjz == null) {
                try {
                    paramjk.a(localObject1, paramhf, paramjw);
                } catch (Exception localException) {
                    a(paramjw, localException, paramMap, "" + localObject2);
                }
            } else {
                paramjk.a(localException, paramhf, paramjw, localjz);
            }
        }
    }

    public void a(Map<?, ?> paramMap, hf paramhf, jw paramjw, jz paramjz)
            throws IOException, he {
        paramjz.b(paramMap, paramhf);
        if (!paramMap.isEmpty()) {
            if (this.h == null) {
                break label42;
            }
            a(paramMap, paramhf, paramjw, this.h);
        }
        for (; ; ) {
            paramjz.e(paramMap, paramhf);
            return;
            label42:
            b(paramMap, paramhf, paramjw);
        }
    }

    public void b(Map<?, ?> paramMap, hf paramhf, jw paramjw)
            throws IOException, he {
        label14:
        jk localjk;
        HashSet localHashSet;
        int k;
        label40:
        Object localObject1;
        Iterator localIterator;
        if (this.i != null) {
            c(paramMap, paramhf, paramjw);
            return;
        } else {
            localjk = this.g;
            localHashSet = this.c;
            if (paramjw.a(ju.a.v)) {
                break label127;
            }
            k = 1;
            localObject1 = this.j;
            localIterator = paramMap.entrySet().iterator();
        }
        label59:
        Object localObject4;
        Object localObject5;
        if (localIterator.hasNext()) {
            localObject2 = (Map.Entry) localIterator.next();
            localObject4 = ((Map.Entry) localObject2).getValue();
            localObject5 = ((Map.Entry) localObject2).getKey();
            if (localObject5 != null) {
                break label133;
            }
            paramjw.c().a(null, paramhf, paramjw);
        }
        for (; ; ) {
            if (localObject4 != null) {
                break label170;
            }
            paramjw.a(paramhf);
            break label59;
            break label14;
            label127:
            k = 0;
            break label40;
            label133:
            if (((k != 0) && (localObject4 == null)) || ((localHashSet != null) && (localHashSet.contains(localObject5)))) {
                break;
            }
            localjk.a(localObject5, paramhf, paramjw);
        }
        label170:
        Object localObject3 = localObject4.getClass();
        Object localObject2 = ((ov) localObject1).a((Class) localObject3);
        if (localObject2 == null) {
            if (this.f.e()) {
                localObject1 = a((ov) localObject1, paramjw.a(this.f, (Class) localObject3), paramjw);
                label220:
                localObject3 = this.j;
                localObject2 = localObject1;
                localObject1 = localObject3;
            }
        }
        for (; ; ) {
            try {
                ((jk) localObject2).a(localObject4, paramhf, paramjw);
            } catch (Exception localException) {
                a(paramjw, localException, paramMap, "" + localObject5);
            }
            break;
            localObject1 = a((ov) localObject1, (Class) localObject3, paramjw);
            break label220;
        }
    }

    protected void c(Map<?, ?> paramMap, hf paramhf, jw paramjw)
            throws IOException, he {
        jk localjk2 = this.g;
        HashSet localHashSet = this.c;
        int k;
        Object localObject2;
        Object localObject1;
        label44:
        Object localObject3;
        Object localObject5;
        Object localObject6;
        if (!paramjw.a(ju.a.v)) {
            k = 1;
            Iterator localIterator = paramMap.entrySet().iterator();
            localObject2 = null;
            localObject1 = null;
            if (!localIterator.hasNext()) {
                return;
            }
            localObject3 = (Map.Entry) localIterator.next();
            localObject5 = ((Map.Entry) localObject3).getValue();
            localObject6 = ((Map.Entry) localObject3).getKey();
            if (localObject6 != null) {
                break label118;
            }
            paramjw.c().a(null, paramhf, paramjw);
        }
        for (; ; ) {
            if (localObject5 != null) {
                break label155;
            }
            paramjw.a(paramhf);
            break label44;
            k = 0;
            break;
            label118:
            if (((k != 0) && (localObject5 == null)) || ((localHashSet != null) && (localHashSet.contains(localObject6)))) {
                break label44;
            }
            localjk2.a(localObject6, paramhf, paramjw);
        }
        label155:
        Object localObject4 = localObject5.getClass();
        if (localObject4 == localObject2) {
            localObject4 = localObject1;
            localObject3 = localObject1;
            localObject1 = localObject4;
        }
        for (; ; ) {
            try {
                ((jk) localObject3).a(localObject5, paramhf, paramjw, this.i);
            } catch (Exception localException) {
                a(paramjw, localException, paramMap, "" + localObject6);
            }
            break;
            jk localjk1 = paramjw.a((Class) localObject4, this.b);
            localObject1 = localjk1;
            localObject2 = localObject4;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/po.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */