package com.flurry.sdk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public final class rj
        extends ro {
    protected ArrayList<hh> c;

    public rj(rs paramrs) {
        super(paramrs);
    }

    private boolean a(ArrayList<hh> paramArrayList) {
        int j = paramArrayList.size();
        if (p() != j) {
            return false;
        }
        int i = 0;
        while (i < j) {
            if (!((hh) this.c.get(i)).equals(paramArrayList.get(i))) {
                return false;
            }
            i += 1;
        }
        return true;
    }

    private void b(hh paramhh) {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.add(paramhh);
    }

    public hh a(String paramString) {
        return null;
    }

    public final void a(hf paramhf, jw paramjw)
            throws IOException, hk {
        paramhf.b();
        if (this.c != null) {
            Iterator localIterator = this.c.iterator();
            while (localIterator.hasNext()) {
                ((rk) localIterator.next()).a(paramhf, paramjw);
            }
        }
        paramhf.c();
    }

    public void a(hf paramhf, jw paramjw, jz paramjz)
            throws IOException, hk {
        paramjz.c(this, paramhf);
        if (this.c != null) {
            Iterator localIterator = this.c.iterator();
            while (localIterator.hasNext()) {
                ((rk) localIterator.next()).a(paramhf, paramjw);
            }
        }
        paramjz.f(this, paramhf);
    }

    public void a(hh paramhh) {
        Object localObject = paramhh;
        if (paramhh == null) {
            localObject = s();
        }
        b((hh) localObject);
    }

    public boolean b() {
        return true;
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (paramObject == null) {
                return false;
            }
            if (paramObject.getClass() != getClass()) {
                return false;
            }
            paramObject = (rj) paramObject;
            if ((this.c != null) && (this.c.size() != 0)) {
                break;
            }
        } while (((rj) paramObject).p() == 0);
        return false;
        return ((rj) paramObject).a(this.c);
    }

    public int hashCode() {
        int j;
        if (this.c == null) {
            j = 1;
        }
        int i;
        Iterator localIterator;
        do {
            return j;
            i = this.c.size();
            localIterator = this.c.iterator();
            j = i;
        } while (!localIterator.hasNext());
        hh localhh = (hh) localIterator.next();
        if (localhh != null) {
            i = localhh.hashCode() ^ i;
        }
        for (; ; ) {
            break;
        }
    }

    public int p() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }

    public Iterator<hh> q() {
        if (this.c == null) {
            return ro.a.a();
        }
        return this.c.iterator();
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder((p() << 4) + 16);
        localStringBuilder.append('[');
        if (this.c != null) {
            int j = this.c.size();
            int i = 0;
            while (i < j) {
                if (i > 0) {
                    localStringBuilder.append(',');
                }
                localStringBuilder.append(((hh) this.c.get(i)).toString());
                i += 1;
            }
        }
        localStringBuilder.append(']');
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/rj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */