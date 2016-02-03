package com.flurry.sdk;

import java.io.IOException;

@kb
public class pu
        extends oq<ji> {
    public static final pu a = new pu();

    protected pu() {
        super(ji.class);
    }

    public void a(ji paramji, hf paramhf, jw paramjw)
            throws IOException, he {
        paramji.a(paramhf, paramjw);
    }

    public final void a(ji paramji, hf paramhf, jw paramjw, jz paramjz)
            throws IOException, he {
        if ((paramji instanceof jj)) {
            ((jj) paramji).a(paramhf, paramjw, paramjz);
            return;
        }
        a(paramji, paramhf, paramjw);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/pu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */