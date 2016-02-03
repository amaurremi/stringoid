package com.flurry.sdk;

import java.io.IOException;
import java.net.InetAddress;

public class pl
        extends pt<InetAddress> {
    public static final pl a = new pl();

    public pl() {
        super(InetAddress.class);
    }

    public void a(InetAddress paramInetAddress, hf paramhf, jw paramjw)
            throws IOException, he {
        paramjw = paramInetAddress.toString().trim();
        int i = paramjw.indexOf('/');
        paramInetAddress = paramjw;
        if (i >= 0) {
            if (i != 0) {
                break label40;
            }
        }
        label40:
        for (paramInetAddress = paramjw.substring(1); ; paramInetAddress = paramjw.substring(0, i)) {
            paramhf.b(paramInetAddress);
            return;
        }
    }

    public void a(InetAddress paramInetAddress, hf paramhf, jw paramjw, jz paramjz)
            throws IOException, he {
        paramjz.a(paramInetAddress, paramhf, InetAddress.class);
        a(paramInetAddress, paramhf, paramjw);
        paramjz.d(paramInetAddress, paramhf);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/pl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */