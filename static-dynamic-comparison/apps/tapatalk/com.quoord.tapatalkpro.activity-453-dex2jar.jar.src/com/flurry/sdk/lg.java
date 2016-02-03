package com.flurry.sdk;

import java.io.IOException;
import java.util.ArrayList;

public class lg {
    protected final ArrayList<kt> a = new ArrayList();

    public Object a(hj paramhj, iz paramiz, Object paramObject, sq paramsq)
            throws IOException, hk {
        int j = this.a.size();
        int i = 0;
        while (i < j) {
            paramhj = (kt) this.a.get(i);
            hj localhj = paramsq.h();
            localhj.b();
            paramhj.a(localhj, paramiz, paramObject);
            i += 1;
        }
        return paramObject;
    }

    public void a(kt paramkt) {
        this.a.add(paramkt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/lg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */