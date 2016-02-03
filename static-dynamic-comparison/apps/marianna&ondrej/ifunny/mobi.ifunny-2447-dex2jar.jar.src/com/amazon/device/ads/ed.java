package com.amazon.device.ads;

import java.util.ArrayList;
import java.util.Iterator;

class ed
        extends ec {
    private final ArrayList<ec> b;

    public ed(ArrayList<ec> paramArrayList) {
        this.b = paramArrayList;
    }

    public void a(eb parameb) {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
            ((ec) localIterator.next()).a(parameb);
        }
    }

    public void a(eb parameb, long paramLong) {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
            ((ec) localIterator.next()).a(parameb, paramLong);
        }
    }

    public void a(eb parameb, String paramString) {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
            ((ec) localIterator.next()).a(parameb, paramString);
        }
    }

    public void b(eb parameb) {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
            ((ec) localIterator.next()).b(parameb);
        }
    }

    public void b(eb parameb, long paramLong) {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
            ((ec) localIterator.next()).b(parameb, paramLong);
        }
    }

    public void c(eb parameb) {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
            ((ec) localIterator.next()).c(parameb);
        }
    }

    public void c(eb parameb, long paramLong) {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
            ((ec) localIterator.next()).c(parameb, paramLong);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/ed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */