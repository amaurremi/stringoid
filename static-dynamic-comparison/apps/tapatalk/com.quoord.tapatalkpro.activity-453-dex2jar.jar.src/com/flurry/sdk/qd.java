package com.flurry.sdk;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

@kb
public class qd
        extends px<Collection<String>>
        implements jt {
    protected jk<String> a;

    public qd(is paramis) {
        super(Collection.class, paramis);
    }

    private final void b(Collection<String> paramCollection, hf paramhf, jw paramjw)
            throws IOException, he {
        if (this.a != null) {
            c(paramCollection, paramhf, paramjw);
        }
        for (; ; ) {
            return;
            Iterator localIterator = paramCollection.iterator();
            int i = 0;
            label91:
            while (localIterator.hasNext()) {
                String str = (String) localIterator.next();
                if (str == null) {
                }
                try {
                    paramjw.a(paramhf);
                } catch (Exception localException) {
                    a(paramjw, localException, paramCollection, i);
                    break label91;
                }
                paramhf.b(str);
                i += 1;
            }
        }
    }

    private void c(Collection<String> paramCollection, hf paramhf, jw paramjw)
            throws IOException, he {
        jk localjk = this.a;
        Iterator localIterator = paramCollection.iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            if (str == null) {
                try {
                    paramjw.a(paramhf);
                } catch (Exception localException) {
                    a(paramjw, localException, paramCollection, 0);
                }
            } else {
                localjk.a(localException, paramhf, paramjw);
            }
        }
    }

    public void a(jw paramjw)
            throws jh {
        paramjw = paramjw.a(String.class, this.b);
        if (!a(paramjw)) {
            this.a = paramjw;
        }
    }

    public void a(Collection<String> paramCollection, hf paramhf, jw paramjw)
            throws IOException, he {
        paramhf.b();
        if (this.a == null) {
            b(paramCollection, paramhf, paramjw);
        }
        for (; ; ) {
            paramhf.c();
            return;
            c(paramCollection, paramhf, paramjw);
        }
    }

    public void a(Collection<String> paramCollection, hf paramhf, jw paramjw, jz paramjz)
            throws IOException, he {
        paramjz.c(paramCollection, paramhf);
        if (this.a == null) {
            b(paramCollection, paramhf, paramjw);
        }
        for (; ; ) {
            paramjz.f(paramCollection, paramhf);
            return;
            c(paramCollection, paramhf, paramjw);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/qd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */