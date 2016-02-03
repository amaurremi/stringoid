package com.flurry.sdk;

import java.io.IOException;

public abstract class pc
        extends pw<Object>
        implements jt {
    protected static final oi[] a = new oi[0];
    protected final oi[] b;
    protected final oi[] c;
    protected final of d;
    protected final Object e;

    protected pc(pc parampc) {
        this(parampc.k, parampc.b, parampc.c, parampc.d, parampc.e);
    }

    protected pc(sh paramsh, oi[] paramArrayOfoi1, oi[] paramArrayOfoi2, of paramof, Object paramObject) {
        super(paramsh);
        this.b = paramArrayOfoi1;
        this.c = paramArrayOfoi2;
        this.d = paramof;
        this.e = paramObject;
    }

    public pc(Class<?> paramClass, oi[] paramArrayOfoi1, oi[] paramArrayOfoi2, of paramof, Object paramObject) {
        super(paramClass);
        this.b = paramArrayOfoi1;
        this.c = paramArrayOfoi2;
        this.d = paramof;
        this.e = paramObject;
    }

    public void a(jw paramjw)
            throws jh {
        int i;
        int j;
        label18:
        oi localoi;
        if (this.c == null) {
            i = 0;
            int k = this.b.length;
            j = 0;
            if (j >= k) {
                break label240;
            }
            localoi = this.b[j];
            if (!localoi.e()) {
                break label56;
            }
        }
        for (; ; ) {
            j += 1;
            break label18;
            i = this.c.length;
            break;
            label56:
            Object localObject1 = localoi.f();
            Object localObject2 = localObject1;
            if (localObject1 == null) {
                localObject1 = paramjw.a(localoi.g());
                localObject2 = localObject1;
                if (!((sh) localObject1).u()) {
                    if ((!((sh) localObject1).f()) && (((sh) localObject1).h() <= 0)) {
                        continue;
                    }
                    localoi.a((sh) localObject1);
                    continue;
                }
            }
            jk localjk = paramjw.a((sh) localObject2, localoi);
            localObject1 = localjk;
            if (((sh) localObject2).f()) {
                localObject2 = (jz) ((sh) localObject2).g().o();
                localObject1 = localjk;
                if (localObject2 != null) {
                    localObject1 = localjk;
                    if ((localjk instanceof pf)) {
                        localObject1 = ((pf) localjk).b((jz) localObject2);
                    }
                }
            }
            localObject2 = localoi.a((jk) localObject1);
            this.b[j] = localObject2;
            if (j < i) {
                localObject2 = this.c[j];
                if (localObject2 != null) {
                    this.c[j] = ((oi) localObject2).a((jk) localObject1);
                }
            }
        }
        label240:
        if (this.d != null) {
            this.d.a(paramjw);
        }
    }

    public void a(Object paramObject, hf paramhf, jw paramjw, jz paramjz)
            throws IOException, he {
        paramjz.b(paramObject, paramhf);
        if (this.e != null) {
            c(paramObject, paramhf, paramjw);
        }
        for (; ; ) {
            paramjz.e(paramObject, paramhf);
            return;
            b(paramObject, paramhf, paramjw);
        }
    }

    protected oh b(jw paramjw)
            throws jh {
        Object localObject = this.e;
        paramjw = paramjw.b();
        if (paramjw == null) {
            throw new jh("Can not resolve BeanPropertyFilter with id '" + localObject + "'; no FilterProvider configured");
        }
        return paramjw.a(localObject);
    }

    protected void b(Object paramObject, hf paramhf, jw paramjw)
            throws IOException, he {
        oi[] arrayOfoi;
        if ((this.c != null) && (paramjw.a() != null)) {
            arrayOfoi = this.c;
        }
        int k;
        for (; ; ) {
            int j = 0;
            k = 0;
            int i = 0;
            try {
                int m = arrayOfoi.length;
                for (; ; ) {
                    if (i < m) {
                        oi localoi = arrayOfoi[i];
                        if (localoi != null) {
                            j = i;
                            k = i;
                            localoi.a(paramObject, paramhf, paramjw);
                        }
                        i += 1;
                        continue;
                        arrayOfoi = this.b;
                        break;
                    }
                }
                j = i;
                k = i;
                if (this.d != null) {
                    j = i;
                    k = i;
                    this.d.a(paramObject, paramhf, paramjw);
                }
                return;
            } catch (Exception localException) {
                if (j == arrayOfoi.length) {
                }
                for (paramhf = "[anySetter]"; ; paramhf = arrayOfoi[j].d()) {
                    a(paramjw, localException, paramObject, paramhf);
                    return;
                }
            } catch (StackOverflowError paramhf) {
                paramjw = new jh("Infinite recursion (StackOverflowError)");
                if (k != arrayOfoi.length) {
                }
            }
        }
        for (paramhf = "[anySetter]"; ; paramhf = arrayOfoi[k].d()) {
            paramjw.a(new jh.a(paramObject, paramhf));
            throw paramjw;
        }
    }

    protected void c(Object paramObject, hf paramhf, jw paramjw)
            throws IOException, he {
        oi[] arrayOfoi;
        oh localoh;
        if ((this.c != null) && (paramjw.a() != null)) {
            arrayOfoi = this.c;
            localoh = b(paramjw);
            if (localoh != null) {
                break label49;
            }
            b(paramObject, paramhf, paramjw);
        }
        for (; ; ) {
            return;
            arrayOfoi = this.b;
            break;
            label49:
            int j = 0;
            int k = 0;
            int i = 0;
            try {
                int m = arrayOfoi.length;
                if (i < m) {
                    oi localoi = arrayOfoi[i];
                    if (localoi != null) {
                        j = i;
                        k = i;
                        localoh.a(paramObject, paramhf, paramjw, localoi);
                    }
                } else {
                    j = i;
                    k = i;
                    if (this.d == null) {
                        continue;
                    }
                    j = i;
                    k = i;
                    this.d.a(paramObject, paramhf, paramjw);
                    return;
                }
            } catch (Exception localException) {
                if (j == arrayOfoi.length) {
                }
                for (paramhf = "[anySetter]"; ; paramhf = arrayOfoi[j].d()) {
                    a(paramjw, localException, paramObject, paramhf);
                    return;
                }
            } catch (StackOverflowError paramhf) {
                for (; ; ) {
                    paramjw = new jh("Infinite recursion (StackOverflowError)");
                    if (k == arrayOfoi.length) {
                    }
                    for (paramhf = "[anySetter]"; ; paramhf = arrayOfoi[k].d()) {
                        paramjw.a(new jh.a(paramObject, paramhf));
                        throw paramjw;
                    }
                    i += 1;
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/pc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */