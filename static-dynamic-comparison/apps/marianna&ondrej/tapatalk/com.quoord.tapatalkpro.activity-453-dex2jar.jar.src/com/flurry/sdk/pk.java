package com.flurry.sdk;

import java.io.IOException;
import java.util.List;

@kb
public final class pk
        extends px<List<String>>
        implements jt {
    protected jk<String> a;

    public pk(is paramis) {
        super(List.class, paramis);
    }

    private final void b(List<String> paramList, hf paramhf, jw paramjw)
            throws IOException, he {
        int j = 0;
        int i = 0;
        for (; ; ) {
            try {
                int k = paramList.size();
                if (i < k) {
                    j = i;
                    String str = (String) paramList.get(i);
                    if (str == null) {
                        j = i;
                        paramjw.a(paramhf);
                    } else {
                        j = i;
                        paramhf.b(str);
                    }
                }
            } catch (Exception paramhf) {
                a(paramjw, paramhf, paramList, j);
            }
            return;
            i += 1;
        }
    }

    private final void c(List<String> paramList, hf paramhf, jw paramjw)
            throws IOException, he {
        int k = 0;
        int i = 0;
        int j = k;
        for (; ; ) {
            try {
                int m = paramList.size();
                j = k;
                jk localjk = this.a;
                if (i < m) {
                    j = i;
                    String str = (String) paramList.get(i);
                    if (str == null) {
                        j = i;
                        paramjw.a(paramhf);
                    } else {
                        j = i;
                        localjk.a(str, paramhf, paramjw);
                    }
                }
            } catch (Exception paramhf) {
                a(paramjw, paramhf, paramList, j);
            }
            return;
            i += 1;
        }
    }

    public void a(jw paramjw)
            throws jh {
        paramjw = paramjw.a(String.class, this.b);
        if (!a(paramjw)) {
            this.a = paramjw;
        }
    }

    public void a(List<String> paramList, hf paramhf, jw paramjw)
            throws IOException, he {
        paramhf.b();
        if (this.a == null) {
            b(paramList, paramhf, paramjw);
        }
        for (; ; ) {
            paramhf.c();
            return;
            c(paramList, paramhf, paramjw);
        }
    }

    public void a(List<String> paramList, hf paramhf, jw paramjw, jz paramjz)
            throws IOException, he {
        paramjz.c(paramList, paramhf);
        if (this.a == null) {
            b(paramList, paramhf, paramjw);
        }
        for (; ; ) {
            paramjz.f(paramList, paramhf);
            return;
            c(paramList, paramhf, paramjw);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/pk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */