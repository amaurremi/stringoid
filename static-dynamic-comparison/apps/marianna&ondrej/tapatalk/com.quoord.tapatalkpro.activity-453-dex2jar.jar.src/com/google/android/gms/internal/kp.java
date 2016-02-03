package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class kp<M extends kp<M>>
        extends kt {
    protected List<kv> adU;

    public final <T> T a(kq<M, T> paramkq) {
        return (T) paramkq.f(this.adU);
    }

    public void a(ko paramko)
            throws IOException {
        if (this.adU == null) {
        }
        for (int i = 0; ; i = this.adU.size()) {
            int j = 0;
            while (j < i) {
                kv localkv = (kv) this.adU.get(j);
                paramko.da(localkv.tag);
                paramko.p(localkv.adZ);
                j += 1;
            }
        }
    }

    protected final boolean a(kn paramkn, int paramInt)
            throws IOException {
        int i = paramkn.getPosition();
        if (!paramkn.cQ(paramInt)) {
            return false;
        }
        if (this.adU == null) {
            this.adU = new ArrayList();
        }
        paramkn = paramkn.h(i, paramkn.getPosition() - i);
        this.adU.add(new kv(paramInt, paramkn));
        return true;
    }

    protected int mx() {
        if (this.adU == null) {
        }
        int k;
        for (int i = 0; ; i = this.adU.size()) {
            int j = 0;
            k = 0;
            while (j < i) {
                kv localkv = (kv) this.adU.get(j);
                k = k + ko.db(localkv.tag) + localkv.adZ.length;
                j += 1;
            }
        }
        return k;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/kp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */