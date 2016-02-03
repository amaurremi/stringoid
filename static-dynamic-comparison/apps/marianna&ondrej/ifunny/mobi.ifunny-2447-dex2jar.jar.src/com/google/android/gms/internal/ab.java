package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@ii
public class ab {
    private final Object a = new Object();
    private int b;
    private List<aa> c = new LinkedList();

    public aa a() {
        Object localObject1 = null;
        label146:
        label149:
        for (; ; ) {
            synchronized (this.a) {
                if (this.c.size() == 0) {
                    mx.a("Queue empty");
                    return null;
                }
                if (this.c.size() >= 2) {
                    int i = Integer.MIN_VALUE;
                    Iterator localIterator = this.c.iterator();
                    if (localIterator.hasNext()) {
                        aa localaa2 = (aa) localIterator.next();
                        int j = localaa2.g();
                        if (j <= i) {
                            break label146;
                        }
                        localObject1 = localaa2;
                        i = j;
                        break label149;
                    }
                    this.c.remove(localObject1);
                    return (aa) localObject1;
                }
            }
            aa localaa1 = (aa) this.c.get(0);
            localaa1.c();
            return localaa1;
        }
    }

    public boolean a(aa paramaa) {
        synchronized (this.a) {
            return this.c.contains(paramaa);
        }
    }

    public boolean b(aa paramaa) {
        synchronized (this.a) {
            Iterator localIterator = this.c.iterator();
            while (localIterator.hasNext()) {
                aa localaa = (aa) localIterator.next();
                if ((paramaa != localaa) && (localaa.b().equals(paramaa.b()))) {
                    this.c.remove(paramaa);
                    return true;
                }
            }
            return false;
        }
    }

    public void c(aa paramaa) {
        synchronized (this.a) {
            if (this.c.size() >= 10) {
                mx.a("Queue is full, current size = " + this.c.size());
                this.c.remove(0);
            }
            int i = this.b;
            this.b = (i + 1);
            paramaa.a(i);
            this.c.add(paramaa);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */