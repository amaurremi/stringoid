package com.flurry.sdk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class nc {
    protected final jn<?> a;
    protected final boolean b;
    protected final sh c;
    protected final mn d;
    protected final ne<?> e;
    protected final iq f;
    protected final LinkedHashMap<String, nd> g = new LinkedHashMap();
    protected LinkedList<nd> h = null;
    protected LinkedList<mr> i = null;
    protected LinkedList<mr> j = null;
    protected LinkedList<mr> k = null;
    protected Set<String> l;
    protected Set<String> m;
    protected LinkedHashMap<Object, mq> n;

    protected nc(jn<?> paramjn, boolean paramBoolean, sh paramsh, mn parammn) {
        this.a = paramjn;
        this.b = paramBoolean;
        this.c = paramsh;
        this.d = parammn;
        paramsh = (sh) localObject;
        if (paramjn.b()) {
            paramsh = this.a.a();
        }
        this.f = paramsh;
        if (this.f == null) {
            this.e = this.a.e();
            return;
        }
        this.e = this.f.a(parammn, this.a.e());
    }

    private Set<String> a(Set<String> paramSet, String paramString) {
        Object localObject = paramSet;
        if (paramSet == null) {
            localObject = new HashSet();
        }
        ((Set) localObject).add(paramString);
        return (Set<String>) localObject;
    }

    private void a(nd paramnd) {
        if (this.b) {
        }
        String str;
        do {
            return;
            str = paramnd.a();
            this.l = a(this.l, str);
        } while (!paramnd.t());
        this.m = a(this.m, str);
    }

    public jn<?> a() {
        return this.a;
    }

    protected void a(jr paramjr) {
        nd[] arrayOfnd = (nd[]) this.g.values().toArray(new nd[this.g.size()]);
        this.g.clear();
        int i2 = arrayOfnd.length;
        int i1 = 0;
        nd localnd2;
        String str;
        if (i1 < i2) {
            localnd2 = arrayOfnd[i1];
            str = localnd2.a();
            if (this.b) {
                if (localnd2.b()) {
                    str = paramjr.a(this.a, localnd2.g(), str);
                }
            }
        }
        label90:
        label305:
        for (; ; ) {
            nd localnd1 = localnd2;
            if (!str.equals(localnd2.a())) {
                localnd1 = localnd2.a(str);
            }
            localnd2 = (nd) this.g.get(str);
            if (localnd2 == null) {
                this.g.put(str, localnd1);
            }
            for (; ; ) {
                i1 += 1;
                break;
                if (!localnd2.d()) {
                    break label305;
                }
                str = paramjr.a(this.a, localnd2.i(), str);
                break label90;
                if (localnd2.c()) {
                    str = paramjr.b(this.a, localnd2.h(), str);
                    break label90;
                }
                if (localnd2.e()) {
                    str = paramjr.a(this.a, localnd2.m(), str);
                    break label90;
                }
                if (localnd2.d()) {
                    str = paramjr.a(this.a, localnd2.i(), str);
                    break label90;
                }
                if (!localnd2.b()) {
                    break label305;
                }
                str = paramjr.a(this.a, localnd2.g(), str);
                break label90;
                localnd2.b(localnd1);
            }
            return;
        }
    }

    protected void a(Object paramObject, mq parammq) {
        if (paramObject == null) {
        }
        do {
            return;
            if (this.n == null) {
                this.n = new LinkedHashMap();
            }
        } while ((mq) this.n.put(paramObject, parammq) == null);
        if (paramObject == null) {
        }
        for (parammq = "[null]"; ; parammq = paramObject.getClass().getName()) {
            throw new IllegalArgumentException("Duplicate injectable value with id '" + String.valueOf(paramObject) + "' (of type " + parammq + ")");
        }
    }

    protected void a(String paramString) {
        throw new IllegalArgumentException("Problem with definition of " + this.d + ": " + paramString);
    }

    protected nd b(String paramString) {
        nd localnd2 = (nd) this.g.get(paramString);
        nd localnd1 = localnd2;
        if (localnd2 == null) {
            localnd1 = new nd(paramString);
            this.g.put(paramString, localnd1);
        }
        return localnd1;
    }

    public sh b() {
        return this.c;
    }

    public mn c() {
        return this.d;
    }

    public List<it> d() {
        return new ArrayList(this.g.values());
    }

    public Map<Object, mq> e() {
        return this.n;
    }

    public mr f() {
        if (this.k != null) {
            if (this.k.size() > 1) {
                a("Multiple value properties defined (" + this.k.get(0) + " vs " + this.k.get(1) + ")");
            }
            return (mr) this.k.get(0);
        }
        return null;
    }

    public mr g() {
        if (this.i != null) {
            if (this.i.size() > 1) {
                a("Multiple 'any-getters' defined (" + this.i.get(0) + " vs " + this.i.get(1) + ")");
            }
            return (mr) this.i.getFirst();
        }
        return null;
    }

    public mr h() {
        if (this.j != null) {
            if (this.j.size() > 1) {
                a("Multiple 'any-setters' defined (" + this.j.get(0) + " vs " + this.j.get(1) + ")");
            }
            return (mr) this.j.getFirst();
        }
        return null;
    }

    public Set<String> i() {
        return this.l;
    }

    public Set<String> j() {
        return this.m;
    }

    public nc k() {
        this.g.clear();
        m();
        o();
        n();
        p();
        q();
        r();
        Object localObject = this.a.j();
        if (localObject != null) {
            a((jr) localObject);
        }
        localObject = this.g.values().iterator();
        while (((Iterator) localObject).hasNext()) {
            ((nd) ((Iterator) localObject).next()).p();
        }
        localObject = this.g.values().iterator();
        while (((Iterator) localObject).hasNext()) {
            ((nd) ((Iterator) localObject).next()).a(this.b);
        }
        l();
        return this;
    }

    protected void l() {
        Object localObject1 = this.a.a();
        Object localObject2 = ((iq) localObject1).i(this.d);
        if (localObject2 == null) {
        }
        String[] arrayOfString;
        for (boolean bool = this.a.d(); ; bool = ((Boolean) localObject2).booleanValue()) {
            arrayOfString = ((iq) localObject1).h(this.d);
            if ((bool) || (this.h != null) || (arrayOfString != null)) {
                break;
            }
            return;
        }
        int i1 = this.g.size();
        if (bool) {
        }
        for (localObject1 = new TreeMap(); ; localObject1 = new LinkedHashMap(i1 + i1)) {
            localObject2 = this.g.values().iterator();
            while (((Iterator) localObject2).hasNext()) {
                localObject3 = (nd) ((Iterator) localObject2).next();
                ((Map) localObject1).put(((nd) localObject3).a(), localObject3);
            }
        }
        LinkedHashMap localLinkedHashMap = new LinkedHashMap(i1 + i1);
        String str;
        if (arrayOfString != null) {
            int i2 = arrayOfString.length;
            i1 = 0;
            if (i1 < i2) {
                str = arrayOfString[i1];
                localObject2 = (nd) ((Map) localObject1).get(str);
                if (localObject2 != null) {
                    break label383;
                }
                Iterator localIterator = this.g.values().iterator();
                while (localIterator.hasNext()) {
                    localObject3 = (nd) localIterator.next();
                    if (str.equals(((nd) localObject3).l())) {
                        str = ((nd) localObject3).a();
                        localObject2 = localObject3;
                    }
                }
            }
        }
        label383:
        for (Object localObject3 = str; ; localObject3 = str) {
            if (localObject2 != null) {
                localLinkedHashMap.put(localObject3, localObject2);
            }
            i1 += 1;
            break;
            if (this.h != null) {
                localObject2 = this.h.iterator();
                while (((Iterator) localObject2).hasNext()) {
                    localObject3 = (nd) ((Iterator) localObject2).next();
                    localLinkedHashMap.put(((nd) localObject3).a(), localObject3);
                }
            }
            localLinkedHashMap.putAll((Map) localObject1);
            this.g.clear();
            this.g.putAll(localLinkedHashMap);
            return;
        }
    }

    protected void m() {
        iq localiq = this.f;
        Iterator localIterator = this.d.l().iterator();
        mp localmp;
        String str;
        Object localObject;
        if (localIterator.hasNext()) {
            localmp = (mp) localIterator.next();
            str = localmp.b();
            if (localiq == null) {
                localObject = null;
                label56:
                if (!"".equals(localObject)) {
                    break label168;
                }
                localObject = str;
            }
        }
        label75:
        label165:
        label168:
        for (; ; ) {
            boolean bool1;
            if (localObject != null) {
                bool1 = true;
                if (bool1) {
                    break label165;
                }
                bool1 = this.e.a(localmp);
            }
            for (; ; ) {
                if ((localiq != null) && (localiq.c(localmp))) {
                }
                for (boolean bool2 = true; ; bool2 = false) {
                    b(str).a(localmp, (String) localObject, bool1, bool2);
                    break;
                    if (this.b) {
                        localObject = localiq.b(localmp);
                        break label56;
                    }
                    localObject = localiq.c(localmp);
                    break label56;
                    bool1 = false;
                    break label75;
                }
                return;
            }
        }
    }

    protected void n() {
        iq localiq = this.f;
        if (localiq == null) {
            return;
        }
        Iterator localIterator = this.d.i().iterator();
        Object localObject;
        int i2;
        int i1;
        mt localmt;
        String str;
        nd localnd;
        while (localIterator.hasNext()) {
            localObject = (mo) localIterator.next();
            if (this.h == null) {
                this.h = new LinkedList();
            }
            i2 = ((mo) localObject).f();
            i1 = 0;
            while (i1 < i2) {
                localmt = ((mo) localObject).c(i1);
                str = localiq.a(localmt);
                if (str != null) {
                    localnd = b(str);
                    localnd.a(localmt, str, true, false);
                    this.h.add(localnd);
                }
                i1 += 1;
            }
        }
        localIterator = this.d.j().iterator();
        while (localIterator.hasNext()) {
            localObject = (mr) localIterator.next();
            if (this.h == null) {
                this.h = new LinkedList();
            }
            i2 = ((mr) localObject).f();
            i1 = 0;
            while (i1 < i2) {
                localmt = ((mr) localObject).c(i1);
                str = localiq.a(localmt);
                if (str != null) {
                    localnd = b(str);
                    localnd.a(localmt, str, true, false);
                    this.h.add(localnd);
                }
                i1 += 1;
            }
        }
    }

    protected void o() {
        iq localiq = this.f;
        Iterator localIterator = this.d.k().iterator();
        while (localIterator.hasNext()) {
            mr localmr = (mr) localIterator.next();
            int i1 = localmr.f();
            Object localObject1;
            label147:
            Object localObject3;
            boolean bool1;
            Object localObject2;
            label206:
            boolean bool2;
            if (i1 == 0) {
                if (localiq != null) {
                    if (localiq.f(localmr)) {
                        if (this.i == null) {
                            this.i = new LinkedList();
                        }
                        this.i.add(localmr);
                        continue;
                    }
                    if (localiq.c(localmr)) {
                        if (this.k == null) {
                            this.k = new LinkedList();
                        }
                        this.k.add(localmr);
                        continue;
                    }
                }
                if (localiq == null) {
                    localObject1 = null;
                    if (localObject1 != null) {
                        break label266;
                    }
                    localObject3 = qx.a(localmr, localmr.b());
                    if (localObject3 != null) {
                        break label243;
                    }
                    localObject3 = qx.b(localmr, localmr.b());
                    if (localObject3 == null) {
                        continue;
                    }
                    bool1 = this.e.b(localmr);
                    localObject2 = localObject1;
                    localObject1 = localObject3;
                    if (localiq != null) {
                        break label318;
                    }
                }
                label243:
                label266:
                label318:
                for (bool2 = false; ; bool2 = localiq.c(localmr)) {
                    b((String) localObject1).a(localmr, (String) localObject2, bool1, bool2);
                    break;
                    localObject1 = localiq.b(localmr);
                    break label147;
                    bool1 = this.e.a(localmr);
                    localObject2 = localObject1;
                    localObject1 = localObject3;
                    break label206;
                    localObject3 = qx.a(localmr);
                    localObject2 = localObject3;
                    if (localObject3 == null) {
                        localObject2 = localmr.b();
                    }
                    localObject3 = localObject1;
                    if (((String) localObject1).length() == 0) {
                        localObject3 = localObject2;
                    }
                    localObject1 = localObject2;
                    localObject2 = localObject3;
                    bool1 = true;
                    break label206;
                }
            } else if (i1 == 1) {
                if (localiq == null) {
                    localObject1 = null;
                    label342:
                    if (localObject1 != null) {
                        break label416;
                    }
                    localObject3 = qx.b(localmr);
                    if (localObject3 == null) {
                        continue;
                    }
                    bool1 = this.e.c(localmr);
                    localObject2 = localObject1;
                    localObject1 = localObject3;
                    label379:
                    if (localiq != null) {
                        break label468;
                    }
                }
                label416:
                label468:
                for (bool2 = false; ; bool2 = localiq.c(localmr)) {
                    b((String) localObject1).b(localmr, (String) localObject2, bool1, bool2);
                    break;
                    localObject1 = localiq.d(localmr);
                    break label342;
                    localObject3 = qx.b(localmr);
                    localObject2 = localObject3;
                    if (localObject3 == null) {
                        localObject2 = localmr.b();
                    }
                    localObject3 = localObject1;
                    if (((String) localObject1).length() == 0) {
                        localObject3 = localObject2;
                    }
                    localObject1 = localObject2;
                    localObject2 = localObject3;
                    bool1 = true;
                    break label379;
                }
            } else if ((i1 == 2) && (localiq != null) && (localiq.e(localmr))) {
                if (this.j == null) {
                    this.j = new LinkedList();
                }
                this.j.add(localmr);
            }
        }
    }

    protected void p() {
        iq localiq = this.f;
        if (localiq == null) {
        }
        for (; ; ) {
            return;
            Iterator localIterator = this.d.l().iterator();
            Object localObject;
            while (localIterator.hasNext()) {
                localObject = (mp) localIterator.next();
                a(localiq.d((mq) localObject), (mq) localObject);
            }
            localIterator = this.d.k().iterator();
            while (localIterator.hasNext()) {
                localObject = (mr) localIterator.next();
                if (((mr) localObject).f() == 1) {
                    a(localiq.d((mq) localObject), (mq) localObject);
                }
            }
        }
    }

    protected void q() {
        Iterator localIterator = this.g.entrySet().iterator();
        while (localIterator.hasNext()) {
            nd localnd = (nd) ((Map.Entry) localIterator.next()).getValue();
            if (!localnd.r()) {
                localIterator.remove();
            } else if (localnd.s()) {
                a(localnd);
                if (!localnd.q()) {
                    localIterator.remove();
                } else {
                    localnd.n();
                }
            } else {
                localnd.o();
            }
        }
    }

    protected void r() {
        Object localObject3 = this.g.entrySet().iterator();
        Object localObject1 = null;
        nd localnd;
        Object localObject2;
        while (((Iterator) localObject3).hasNext()) {
            localnd = (nd) ((Map.Entry) ((Iterator) localObject3).next()).getValue();
            String str = localnd.u();
            if (str != null) {
                localObject2 = localObject1;
                if (localObject1 == null) {
                    localObject2 = new LinkedList();
                }
                ((LinkedList) localObject2).add(localnd.a(str));
                ((Iterator) localObject3).remove();
                localObject1 = localObject2;
            }
        }
        if (localObject1 != null) {
            localObject1 = ((LinkedList) localObject1).iterator();
            while (((Iterator) localObject1).hasNext()) {
                localObject2 = (nd) ((Iterator) localObject1).next();
                localObject3 = ((nd) localObject2).a();
                localnd = (nd) this.g.get(localObject3);
                if (localnd == null) {
                    this.g.put(localObject3, localObject2);
                } else {
                    localnd.b((nd) localObject2);
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/nc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */