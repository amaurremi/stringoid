package com.umeng.analytics.a;

import android.content.Context;
import com.umeng.analytics.b.m.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class d {
    private com.umeng.analytics.d.m a = null;
    private long b;
    private long c;
    private Set<a> d = new HashSet();
    private Context e;

    public d(Context paramContext) {
        this.e = paramContext;
        this.c = 86400000L;
    }

    private void g() {
        com.umeng.analytics.d.m localm = new com.umeng.analytics.d.m();
        HashMap localHashMap = new HashMap();
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext()) {
            a locala = (a) localIterator.next();
            if (locala.c()) {
                if (locala.d() != null) {
                    localHashMap.put(locala.b(), locala.d());
                }
                if ((locala.e() != null) && (!locala.e().isEmpty())) {
                    localArrayList.addAll(locala.e());
                }
            }
        }
        localm.a(localArrayList);
        localm.a(localHashMap);
        this.a = localm;
    }

    public void a() {
        long l = System.currentTimeMillis();
        int i;
        if (l - this.b >= this.c) {
            Iterator localIterator = this.d.iterator();
            i = 0;
            while (localIterator.hasNext()) {
                a locala = (a) localIterator.next();
                if (!locala.c()) {
                    i = 1;
                } else {
                    if (!locala.a()) {
                        break label97;
                    }
                    i = 1;
                }
            }
        }
        label97:
        for (; ; ) {
            break;
            if (i != 0) {
                g();
                f();
            }
            this.b = l;
            return;
        }
    }

    public void a(long paramLong) {
        this.c = paramLong;
    }

    public void a(a parama) {
        this.d.add(parama);
    }

    public com.umeng.analytics.d.m b() {
        return this.a;
    }

    public String c() {
        return null;
    }

    public void d() {
        Iterator localIterator = this.d.iterator();
        int i = 0;
        while (localIterator.hasNext()) {
            a locala = (a) localIterator.next();
            if (locala.c()) {
                if ((locala.e() == null) || (locala.e().isEmpty())) {
                    break label84;
                }
                locala.a(null);
                i = 1;
            }
        }
        label84:
        for (; ; ) {
            break;
            if (i != 0) {
                this.a.b(false);
                f();
            }
            return;
        }
    }

    public void e() {
        Object localObject1 = com.umeng.analytics.b.m.a(this.e);
        Object localObject2 = new ArrayList(this.d.size());
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext()) {
            a locala = (a) localIterator.next();
            String str = ((com.umeng.analytics.b.m) localObject1).a(locala.b(), null);
            if (str != null) {
                locala.b(str);
            }
            if (!locala.c()) {
                ((List) localObject2).add(locala);
            }
        }
        localObject1 = ((List) localObject2).iterator();
        while (((Iterator) localObject1).hasNext()) {
            localObject2 = (a) ((Iterator) localObject1).next();
            this.d.remove(localObject2);
        }
        g();
    }

    public void f() {
        m.a locala = com.umeng.analytics.b.m.a(this.e).a();
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext()) {
            a locala1 = (a) localIterator.next();
            String str = locala1.g();
            if (str != null) {
                locala.a(locala1.b(), str);
            }
        }
        locala.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */