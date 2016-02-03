package com.flurry.sdk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class so
        extends sn {
    protected final hj[] e;
    protected int f;

    protected so(hj[] paramArrayOfhj) {
        super(paramArrayOfhj[0]);
        this.e = paramArrayOfhj;
        this.f = 1;
    }

    public static so a(hj paramhj1, hj paramhj2) {
        if ((!(paramhj1 instanceof so)) && (!(paramhj2 instanceof so))) {
            return new so(new hj[]{paramhj1, paramhj2});
        }
        ArrayList localArrayList = new ArrayList();
        if ((paramhj1 instanceof so)) {
            ((so) paramhj1).a(localArrayList);
            if (!(paramhj2 instanceof so)) {
                break label103;
            }
            ((so) paramhj2).a(localArrayList);
        }
        for (; ; ) {
            return new so((hj[]) localArrayList.toArray(new hj[localArrayList.size()]));
            localArrayList.add(paramhj1);
            break;
            label103:
            localArrayList.add(paramhj2);
        }
    }

    protected boolean A() {
        if (this.f >= this.e.length) {
            return false;
        }
        hj[] arrayOfhj = this.e;
        int i = this.f;
        this.f = (i + 1);
        this.d = arrayOfhj[i];
        return true;
    }

    protected void a(List<hj> paramList) {
        int i = this.f;
        int j = this.e.length;
        i -= 1;
        if (i < j) {
            hj localhj = this.e[i];
            if ((localhj instanceof so)) {
                ((so) localhj).a(paramList);
            }
            for (; ; ) {
                i += 1;
                break;
                paramList.add(localhj);
            }
        }
    }

    public hm b()
            throws IOException, hi {
        hm localhm = this.d.b();
        if (localhm != null) {
            return localhm;
        }
        while (A()) {
            localhm = this.d.b();
            if (localhm != null) {
                return localhm;
            }
        }
        return null;
    }

    public void close()
            throws IOException {
        do {
            this.d.close();
        } while (A());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/so.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */