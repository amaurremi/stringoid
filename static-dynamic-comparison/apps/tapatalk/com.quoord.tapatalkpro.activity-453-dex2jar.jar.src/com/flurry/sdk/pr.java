package com.flurry.sdk;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@kb
public class pr
        extends py.a<Object[]>
        implements jt {
    protected final boolean a;
    protected final sh b;
    protected jk<Object> c;
    protected ov d;

    public pr(sh paramsh, boolean paramBoolean, jz paramjz, is paramis, jk<Object> paramjk) {
        super(Object[].class, paramjz, paramis);
        this.b = paramsh;
        this.a = paramBoolean;
        this.d = ov.a();
        this.c = paramjk;
    }

    protected final jk<Object> a(ov paramov, sh paramsh, jw paramjw)
            throws jh {
        paramsh = paramov.a(paramsh, paramjw, this.f);
        if (paramov != paramsh.b) {
            this.d = paramsh.b;
        }
        return paramsh.a;
    }

    protected final jk<Object> a(ov paramov, Class<?> paramClass, jw paramjw)
            throws jh {
        paramClass = paramov.a(paramClass, paramjw, this.f);
        if (paramov != paramClass.b) {
            this.d = paramClass.b;
        }
        return paramClass.a;
    }

    public pf<?> a(jz paramjz) {
        return new pr(this.b, this.a, paramjz, this.f, this.c);
    }

    public void a(jw paramjw)
            throws jh {
        if ((this.a) && (this.c == null)) {
            this.c = paramjw.a(this.b, this.f);
        }
    }

    public void a(Object[] paramArrayOfObject, hf paramhf, jw paramjw)
            throws IOException, he {
        int k = paramArrayOfObject.length;
        if (k == 0) {
            return;
        }
        if (this.c != null) {
            a(paramArrayOfObject, paramhf, paramjw, this.c);
            return;
        }
        if (this.e != null) {
            b(paramArrayOfObject, paramhf, paramjw);
            return;
        }
        int j = 0;
        int i = 0;
        Object localObject1 = null;
        for (; ; ) {
            try {
                localov = this.d;
                if (i >= k) {
                    break;
                }
                localObject2 = paramArrayOfObject[i];
                if (localObject2 == null) {
                    localObject1 = localObject2;
                    j = i;
                    paramjw.a(paramhf);
                    break label271;
                }
                localObject1 = localObject2;
                j = i;
                localClass = localObject2.getClass();
                localObject1 = localObject2;
                j = i;
                jk localjk2 = localov.a(localClass);
                localjk1 = localjk2;
                if (localjk2 == null) {
                    localObject1 = localObject2;
                    j = i;
                    if (!this.b.e()) {
                        continue;
                    }
                    localObject1 = localObject2;
                    j = i;
                    localjk1 = a(localov, paramjw.a(this.b, localClass), paramjw);
                }
            } catch (IOException paramArrayOfObject) {
                ov localov;
                Object localObject2;
                Class localClass;
                throw paramArrayOfObject;
                localObject1 = localObject2;
                j = i;
                jk localjk1 = a(localov, localClass, paramjw);
                continue;
                if ((!(paramArrayOfObject instanceof InvocationTargetException)) || (paramArrayOfObject.getCause() == null)) {
                    continue;
                }
                paramArrayOfObject = paramArrayOfObject.getCause();
                continue;
                if (!(paramArrayOfObject instanceof Error)) {
                    continue;
                }
                throw ((Error) paramArrayOfObject);
                throw jh.a(paramArrayOfObject, localObject1, j);
            } catch (Exception paramArrayOfObject) {
                continue;
            }
            localObject1 = localObject2;
            j = i;
            localjk1.a(localObject2, paramhf, paramjw);
            label271:
            i += 1;
        }
    }

    public void a(Object[] paramArrayOfObject, hf paramhf, jw paramjw, jk<Object> paramjk)
            throws IOException, he {
        int j = paramArrayOfObject.length;
        jz localjz = this.e;
        int i = 0;
        for (; ; ) {
            Object localObject;
            if (i < j) {
                localObject = paramArrayOfObject[i];
                if (localObject == null) {
                }
                try {
                    paramjw.a(paramhf);
                } catch (IOException paramArrayOfObject) {
                    throw paramArrayOfObject;
                    paramjk.a(localObject, paramhf, paramjw, localjz);
                } catch (Exception paramArrayOfObject) {
                    while (((paramArrayOfObject instanceof InvocationTargetException)) && (paramArrayOfObject.getCause() != null)) {
                        paramArrayOfObject = paramArrayOfObject.getCause();
                    }
                    if (!(paramArrayOfObject instanceof Error)) {
                        break label108;
                    }
                    throw ((Error) paramArrayOfObject);
                    throw jh.a(paramArrayOfObject, localObject, i);
                }
                if (localjz == null) {
                    paramjk.a(localObject, paramhf, paramjw);
                    break label118;
                }
            }
            label108:
            return;
            label118:
            i += 1;
        }
    }

    public void b(Object[] paramArrayOfObject, hf paramhf, jw paramjw)
            throws IOException, he {
        int k = paramArrayOfObject.length;
        jz localjz = this.e;
        int j = 0;
        int i = 0;
        Object localObject1 = null;
        for (; ; ) {
            try {
                ov localov = this.d;
                if (i < k) {
                    Object localObject2 = paramArrayOfObject[i];
                    if (localObject2 == null) {
                        localObject1 = localObject2;
                        j = i;
                        paramjw.a(paramhf);
                    } else {
                        localObject1 = localObject2;
                        j = i;
                        Class localClass = localObject2.getClass();
                        localObject1 = localObject2;
                        j = i;
                        jk localjk2 = localov.a(localClass);
                        jk localjk1 = localjk2;
                        if (localjk2 == null) {
                            localObject1 = localObject2;
                            j = i;
                            localjk1 = a(localov, localClass, paramjw);
                        }
                        localObject1 = localObject2;
                        j = i;
                        localjk1.a(localObject2, paramhf, paramjw, localjz);
                    }
                }
            } catch (IOException paramArrayOfObject) {
                throw paramArrayOfObject;
                if (((paramArrayOfObject instanceof InvocationTargetException)) && (paramArrayOfObject.getCause() != null)) {
                    paramArrayOfObject = paramArrayOfObject.getCause();
                    continue;
                }
                if ((paramArrayOfObject instanceof Error)) {
                    throw ((Error) paramArrayOfObject);
                }
                throw jh.a(paramArrayOfObject, localObject1, j);
                return;
            } catch (Exception paramArrayOfObject) {
                continue;
            }
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/pr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */