package com.flurry.sdk;

import java.io.IOException;
import java.util.HashSet;

public class mg
        extends ko {
    public mg(ko paramko) {
        super(paramko);
    }

    protected mg(ko paramko, boolean paramBoolean) {
        super(paramko, paramBoolean);
    }

    public jg<Object> a() {
        if (getClass() != mg.class) {
            return this;
        }
        return new mg(this, true);
    }

    public Object b(hj paramhj, iz paramiz)
            throws IOException, hk {
        int k = 0;
        if (this.f != null) {
            paramhj = i(paramhj, paramiz);
        }
        boolean bool1;
        int i;
        Object localObject2;
        Object localObject1;
        int j;
        do {
            return paramhj;
            if (this.e != null) {
                return this.d.a(this.e.a(paramhj, paramiz));
            }
            if (this.b.c()) {
                throw jh.a(paramhj, "Can not instantiate abstract type " + this.b + " (need to add/enable type information?)");
            }
            bool1 = this.d.c();
            boolean bool2 = this.d.h();
            if ((!bool1) && (!bool2)) {
                throw new jh("Can not deserialize Throwable of type " + this.b + " without having a default contructor, a single-String-arg constructor; or explicit @JsonCreator");
            }
            i = 0;
            localObject2 = null;
            localObject1 = null;
            if (paramhj.e() != hm.c) {
                Object localObject3 = paramhj.g();
                kt localkt = this.h.a((String) localObject3);
                paramhj.b();
                if (localkt != null) {
                    if (localObject1 != null) {
                        localkt.a(paramhj, paramiz, localObject1);
                        localObject3 = localObject2;
                        localObject2 = localObject1;
                        localObject1 = localObject3;
                    }
                }
                for (; ; ) {
                    paramhj.b();
                    localObject3 = localObject2;
                    localObject2 = localObject1;
                    localObject1 = localObject3;
                    break;
                    localObject3 = localObject2;
                    if (localObject2 == null) {
                        j = this.h.b();
                        localObject3 = new Object[j + j];
                    }
                    j = i + 1;
                    localObject3[i] = localkt;
                    i = j + 1;
                    localObject3[j] = localkt.a(paramhj, paramiz);
                    localObject2 = localObject1;
                    localObject1 = localObject3;
                    continue;
                    if (("message".equals(localObject3)) && (bool1)) {
                        localObject3 = this.d.a(paramhj.k());
                        localObject1 = localObject3;
                        if (localObject2 != null) {
                            j = 0;
                            while (j < i) {
                                ((kt) localObject2[j]).a(localObject3, localObject2[(j + 1)]);
                                j += 2;
                            }
                            localObject2 = localObject3;
                            localObject1 = null;
                        }
                    } else {
                        if ((this.k != null) && (this.k.contains(localObject3))) {
                            paramhj.d();
                            localObject3 = localObject1;
                            localObject1 = localObject2;
                            localObject2 = localObject3;
                            continue;
                        }
                        if (this.j != null) {
                            this.j.a(paramhj, paramiz, localObject1, (String) localObject3);
                            localObject3 = localObject1;
                            localObject1 = localObject2;
                            localObject2 = localObject3;
                            continue;
                        }
                        a(paramhj, paramiz, localObject1, (String) localObject3);
                    }
                    localObject3 = localObject1;
                    localObject1 = localObject2;
                    localObject2 = localObject3;
                }
            }
            paramhj = (hj) localObject1;
        } while (localObject1 != null);
        if (bool1) {
        }
        for (paramiz = this.d.a(null); ; paramiz = this.d.m()) {
            paramhj = paramiz;
            if (localObject2 == null) {
                break;
            }
            j = k;
            for (; ; ) {
                paramhj = paramiz;
                if (j >= i) {
                    break;
                }
                ((kt) localObject2[j]).a(paramiz, localObject2[(j + 1)]);
                j += 2;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/mg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */