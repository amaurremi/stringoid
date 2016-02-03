package com.flurry.sdk;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class pz {
    public static jk<?> a(sh paramsh, is paramis) {
        return new pj(paramsh, paramis);
    }

    public static pf<?> a(sh paramsh, boolean paramBoolean, jz paramjz, is paramis) {
        return new b(paramsh, paramBoolean, paramjz, paramis);
    }

    public static pf<?> a(sh paramsh, boolean paramBoolean, jz paramjz, is paramis, jk<Object> paramjk) {
        return new a(paramsh, paramBoolean, paramjz, paramis, paramjk);
    }

    public static pf<?> b(sh paramsh, boolean paramBoolean, jz paramjz, is paramis) {
        return new pm(paramsh, paramBoolean, paramjz, paramis);
    }

    public static pf<?> b(sh paramsh, boolean paramBoolean, jz paramjz, is paramis, jk<Object> paramjk) {
        return new pe(paramsh, paramBoolean, paramjz, paramis, paramjk);
    }

    @kb
    public static class a
            extends pb<List<?>> {
        public a(sh paramsh, boolean paramBoolean, jz paramjz, is paramis, jk<Object> paramjk) {
            super(paramsh, paramBoolean, paramjz, paramis, paramjk);
        }

        public pf<?> a(jz paramjz) {
            return new a(this.b, this.a, paramjz, this.e, this.d);
        }

        public void a(List<?> paramList, hf paramhf, jw paramjw)
                throws IOException, he {
            if (this.d != null) {
                a(paramList, paramhf, paramjw, this.d);
            }
            int k;
            do {
                return;
                if (this.c != null) {
                    b(paramList, paramhf, paramjw);
                    return;
                }
                k = paramList.size();
            } while (k == 0);
            int j = 0;
            int i = 0;
            for (; ; ) {
                Class localClass;
                try {
                    localObject1 = this.f;
                    if (i >= k) {
                        break;
                    }
                    j = i;
                    Object localObject4 = paramList.get(i);
                    if (localObject4 == null) {
                        j = i;
                        paramjw.a(paramhf);
                    } else {
                        j = i;
                        localClass = localObject4.getClass();
                        j = i;
                        jk localjk = ((ov) localObject1).a(localClass);
                        Object localObject2 = localObject1;
                        Object localObject3 = localjk;
                        if (localjk == null) {
                            j = i;
                            if (this.b.e()) {
                                j = i;
                                localObject1 = a((ov) localObject1, paramjw.a(this.b, localClass), paramjw);
                                j = i;
                                localObject2 = this.f;
                                localObject3 = localObject1;
                            }
                        } else {
                            j = i;
                            ((jk) localObject3).a(localObject4, paramhf, paramjw);
                            localObject1 = localObject2;
                        }
                    }
                } catch (Exception paramhf) {
                    a(paramjw, paramhf, paramList, j);
                    return;
                }
                j = i;
                Object localObject1 = a((ov) localObject1, localClass, paramjw);
                continue;
                i += 1;
            }
        }

        public void a(List<?> paramList, hf paramhf, jw paramjw, jk<Object> paramjk)
                throws IOException, he {
            int j = paramList.size();
            if (j == 0) {
            }
            for (; ; ) {
                return;
                jz localjz = this.c;
                int i = 0;
                while (i < j) {
                    Object localObject = paramList.get(i);
                    if (localObject == null) {
                    }
                    try {
                        paramjw.a(paramhf);
                    } catch (Exception localException) {
                        a(paramjw, localException, paramList, i);
                    }
                    if (localjz == null) {
                        paramjk.a(localObject, paramhf, paramjw);
                    } else {
                        paramjk.a(localException, paramhf, paramjw, localjz);
                    }
                    i += 1;
                }
            }
        }

        public void b(List<?> paramList, hf paramhf, jw paramjw)
                throws IOException, he {
            int m = paramList.size();
            if (m == 0) {
                return;
            }
            int k = 0;
            int i = 0;
            int j = k;
            for (; ; ) {
                Class localClass;
                try {
                    jz localjz = this.c;
                    j = k;
                    localObject1 = this.f;
                    if (i >= m) {
                        break;
                    }
                    j = i;
                    Object localObject4 = paramList.get(i);
                    if (localObject4 == null) {
                        j = i;
                        paramjw.a(paramhf);
                    } else {
                        j = i;
                        localClass = localObject4.getClass();
                        j = i;
                        jk localjk = ((ov) localObject1).a(localClass);
                        Object localObject2 = localObject1;
                        Object localObject3 = localjk;
                        if (localjk == null) {
                            j = i;
                            if (this.b.e()) {
                                j = i;
                                localObject1 = a((ov) localObject1, paramjw.a(this.b, localClass), paramjw);
                                j = i;
                                localObject2 = this.f;
                                localObject3 = localObject1;
                            }
                        } else {
                            j = i;
                            ((jk) localObject3).a(localObject4, paramhf, paramjw, localjz);
                            localObject1 = localObject2;
                        }
                    }
                } catch (Exception paramhf) {
                    a(paramjw, paramhf, paramList, j);
                    return;
                }
                j = i;
                Object localObject1 = a((ov) localObject1, localClass, paramjw);
                continue;
                i += 1;
            }
        }
    }

    @kb
    public static class b
            extends pb<Iterator<?>> {
        public b(sh paramsh, boolean paramBoolean, jz paramjz, is paramis) {
            super(paramsh, paramBoolean, paramjz, paramis, null);
        }

        public pf<?> a(jz paramjz) {
            return new b(this.b, this.a, paramjz, this.e);
        }

        public void a(Iterator<?> paramIterator, hf paramhf, jw paramjw)
                throws IOException, he {
            Object localObject1 = null;
            jz localjz;
            jk localjk;
            if (paramIterator.hasNext()) {
                localjz = this.c;
                localjk = null;
            }
            for (; ; ) {
                Object localObject3 = paramIterator.next();
                if (localObject3 == null) {
                    paramjw.a(paramhf);
                }
                while (!paramIterator.hasNext()) {
                    return;
                    Object localObject2 = localObject3.getClass();
                    if (localObject2 == localObject1) {
                    }
                    for (localObject2 = localjk; ; localObject2 = localjk) {
                        if (localjz != null) {
                            break label107;
                        }
                        ((jk) localObject2).a(localObject3, paramhf, paramjw);
                        break;
                        localjk = paramjw.a((Class) localObject2, this.e);
                        localObject1 = localObject2;
                    }
                    label107:
                    ((jk) localObject2).a(localObject3, paramhf, paramjw, localjz);
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/pz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */