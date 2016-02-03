package com.flurry.sdk;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class fn {
    static final hd a = new hd();
    static final jq b = new jq(a);
    static final Map<String, v> e;
    private static final Set<String> g;
    private static final Set<String> h;
    private static final ThreadLocal<Set> i;
    private static final ThreadLocal<Map> j;
    private static ThreadLocal<Boolean> k = new ThreadLocal() {
        protected Boolean a() {
            return Boolean.valueOf(true);
        }
    };
    r c = new r(g);
    int d = Integer.MIN_VALUE;
    private final v f;

    static {
        a.a(hj.a.b);
        a.a(b);
        g = new HashSet();
        Collections.addAll(g, new String[]{"doc", "fields", "items", "name", "namespace", "size", "symbols", "values", "type"});
        h = new HashSet();
        Collections.addAll(h, new String[]{"default", "doc", "name", "order", "type"});
        i = new ThreadLocal() {
            protected Set a() {
                return new HashSet();
            }
        };
        j = new ThreadLocal() {
            protected Map a() {
                return new IdentityHashMap();
            }
        };
        e = new HashMap();
        e.put("string", v.g);
        e.put("bytes", v.h);
        e.put("int", v.i);
        e.put("long", v.j);
        e.put("float", v.k);
        e.put("double", v.l);
        e.put("boolean", v.m);
        e.put("null", v.n);
    }

    fn(v paramv) {
        this.f = paramv;
    }

    public static fn a(v paramv) {
        switch (4. a[paramv.ordinal()])
        {
            default:
                throw new fk("Can't create a: " + paramv);
            case 1:
                return new u();
            case 2:
                return new c();
            case 3:
                return new i();
            case 4:
                return new k();
            case 5:
                return new h();
            case 6:
                return new d();
            case 7:
                return new b();
        }
        return new p();
    }

    public static fn a(fn paramfn) {
        return new a(paramfn);
    }

    public static fn a(fn paramfn1, fn paramfn2) {
        if (paramfn1 == paramfn2) {
        }
        IdentityHashMap localIdentityHashMap;
        HashMap localHashMap1;
        HashMap localHashMap2;
        do {
            return paramfn1;
            localIdentityHashMap = new IdentityHashMap(1);
            localHashMap1 = new HashMap(1);
            localHashMap2 = new HashMap(1);
            b(paramfn2, localIdentityHashMap, localHashMap1, localHashMap2);
        } while ((localHashMap1.size() == 0) && (localHashMap2.size() == 0));
        localIdentityHashMap.clear();
        return a(paramfn1, localIdentityHashMap, localHashMap1, localHashMap2);
    }

    private static fn a(fn paramfn, Map<fn, fn> paramMap, Map<m, m> paramMap1, Map<m, Map<String, String>> paramMap2) {
        if ((paramfn instanceof n)) {
        }
        for (Object localObject1 = ((n) paramfn).f; ; localObject1 = null) {
            switch (4. a[paramfn.a().ordinal()])
            {
                default:
                    paramMap = paramfn;
                    label66:
                    if (paramMap != paramfn) {
                        paramMap.c.putAll(paramfn.c);
                    }
                    return paramMap;
            }
        }
        if (paramMap.containsKey(paramfn)) {
            return (fn) paramMap.get(paramfn);
        }
        if (paramMap1.containsKey(localObject1)) {
            localObject1 = (m) paramMap1.get(localObject1);
        }
        for (; ; ) {
            Object localObject2 = a(m.a((m) localObject1), paramfn.e(), null, paramfn.h());
            paramMap.put(paramfn, localObject2);
            ArrayList localArrayList = new ArrayList();
            Iterator localIterator = paramfn.b().iterator();
            while (localIterator.hasNext()) {
                f localf = (f) localIterator.next();
                Object localObject3 = a(f.d(localf), paramMap, paramMap1, paramMap2);
                localObject3 = new f(a((m) localObject1, f.e(localf), paramMap2), (fn) localObject3, f.f(localf), f.g(localf), f.h(localf));
                f.c((f) localObject3).putAll(f.c(localf));
                localArrayList.add(localObject3);
            }
            ((fn) localObject2).c(localArrayList);
            paramMap = (Map<fn, fn>) localObject2;
            break label66;
            if (!paramMap1.containsKey(localObject1)) {
                break;
            }
            paramMap = a(m.a((m) paramMap1.get(localObject1)), paramfn.e(), null, paramfn.c());
            break label66;
            paramMap = a(paramfn.i(), paramMap, paramMap1, paramMap2);
            if (paramMap == paramfn.i()) {
                break;
            }
            paramMap = a(paramMap);
            break label66;
            paramMap = a(paramfn.j(), paramMap, paramMap1, paramMap2);
            if (paramMap == paramfn.j()) {
                break;
            }
            paramMap = b(paramMap);
            break label66;
            localObject1 = new ArrayList();
            localObject2 = paramfn.k().iterator();
            while (((Iterator) localObject2).hasNext()) {
                ((List) localObject1).add(a((fn) ((Iterator) localObject2).next(), paramMap, paramMap1, paramMap2));
            }
            paramMap = b((List) localObject1);
            break label66;
            if (!paramMap1.containsKey(localObject1)) {
                break;
            }
            paramMap = a(m.a((m) paramMap1.get(localObject1)), paramfn.e(), null, paramfn.l());
            break label66;
        }
    }

    static fn a(hh paramhh, o paramo) {
        Object localObject3 = null;
        Object localObject1;
        Object localObject5;
        Object localObject2;
        Object localObject4;
        if (paramhh.f()) {
            localObject1 = paramo.a(paramhh.i());
            paramo = (o) localObject1;
            if (localObject1 == null) {
                throw new fo("Undefined name: " + paramhh);
            }
        } else if (paramhh.c()) {
            localObject5 = a(paramhh, "type", "No type");
            if ((!((String) localObject5).equals("record")) && (!((String) localObject5).equals("error")) && (!((String) localObject5).equals("enum")) && (!((String) localObject5).equals("fixed"))) {
                break label1357;
            }
            localObject3 = a(paramhh, "namespace");
            localObject1 = a(paramhh, "doc");
            localObject2 = localObject3;
            if (localObject3 == null) {
                localObject2 = paramo.a();
            }
            localObject2 = new m(a(paramhh, "name", "No name in schema"), (String) localObject2);
            if (m.c((m) localObject2) == null) {
                break label1343;
            }
            localObject4 = paramo.a();
            paramo.a(m.c((m) localObject2));
            localObject3 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject4;
        }
        for (; ; ) {
            if (e.containsKey(localObject5)) {
                localObject1 = a((v) e.get(localObject5));
            }
            for (; ; ) {
                localObject3 = paramhh.r();
                while (((Iterator) localObject3).hasNext()) {
                    localObject4 = (String) ((Iterator) localObject3).next();
                    localObject5 = paramhh.a((String) localObject4).i();
                    if ((!g.contains(localObject4)) && (localObject5 != null)) {
                        ((fn) localObject1).a((String) localObject4, (String) localObject5);
                    }
                }
                if ((((String) localObject5).equals("record")) || (((String) localObject5).equals("error"))) {
                    ArrayList localArrayList = new ArrayList();
                    localObject4 = new s((m) localObject1, (String) localObject3, ((String) localObject5).equals("error"));
                    if (localObject1 != null) {
                        paramo.b((fn) localObject4);
                    }
                    localObject1 = paramhh.a("fields");
                    if ((localObject1 == null) || (!((hh) localObject1).b())) {
                        throw new fo("Record has no fields: " + paramhh);
                    }
                    Iterator localIterator = ((hh) localObject1).iterator();
                    while (localIterator.hasNext()) {
                        hh localhh = (hh) localIterator.next();
                        String str1 = a(localhh, "name", "No field name");
                        String str2 = a(localhh, "doc");
                        localObject1 = localhh.a("type");
                        if (localObject1 == null) {
                            throw new fo("No field type: " + localhh);
                        }
                        if ((((hh) localObject1).f()) && (paramo.a(((hh) localObject1).i()) == null)) {
                            throw new fo(localObject1 + " is not a defined name." + " The type of the \"" + str1 + "\" field must be" + " a defined name or a {\"type\": ...} expression.");
                        }
                        fn localfn = a((hh) localObject1, paramo);
                        localObject1 = fn.f.a.a;
                        localObject3 = localhh.a("order");
                        if (localObject3 != null) {
                            localObject1 = fn.f.a.valueOf(((hh) localObject3).i().toUpperCase());
                        }
                        localObject5 = localhh.a("default");
                        localObject3 = localObject5;
                        if (localObject5 != null) {
                            if (!v.k.equals(localfn.a())) {
                                localObject3 = localObject5;
                                if (!v.l.equals(localfn.a())) {
                                }
                            } else {
                                localObject3 = localObject5;
                                if (((hh) localObject5).f()) {
                                    localObject3 = new rq(Double.valueOf(((hh) localObject5).i()).doubleValue());
                                }
                            }
                        }
                        localObject1 = new f(str1, localfn, str2, (hh) localObject3, (fn.f.a) localObject1);
                        localObject3 = localhh.r();
                        while (((Iterator) localObject3).hasNext()) {
                            localObject5 = (String) ((Iterator) localObject3).next();
                            str1 = localhh.a((String) localObject5).i();
                            if ((!h.contains(localObject5)) && (str1 != null)) {
                                ((f) localObject1).a((String) localObject5, str1);
                            }
                        }
                        f.a((f) localObject1, a(localhh));
                        localArrayList.add(localObject1);
                    }
                    ((fn) localObject4).c(localArrayList);
                    localObject1 = localObject4;
                } else if (((String) localObject5).equals("enum")) {
                    localObject5 = paramhh.a("symbols");
                    if ((localObject5 == null) || (!((hh) localObject5).b())) {
                        throw new fo("Enum has no symbols: " + paramhh);
                    }
                    localObject4 = new j();
                    localObject5 = ((hh) localObject5).iterator();
                    while (((Iterator) localObject5).hasNext()) {
                        ((j) localObject4).add(((hh) ((Iterator) localObject5).next()).i());
                    }
                    localObject3 = new e((m) localObject1, (String) localObject3, (j) localObject4);
                    if (localObject1 != null) {
                        paramo.b((fn) localObject3);
                    }
                    localObject1 = localObject3;
                } else if (((String) localObject5).equals("array")) {
                    localObject1 = paramhh.a("items");
                    if (localObject1 == null) {
                        throw new fo("Array has no items type: " + paramhh);
                    }
                    localObject1 = new a(a((hh) localObject1, paramo));
                } else if (((String) localObject5).equals("map")) {
                    localObject1 = paramhh.a("values");
                    if (localObject1 == null) {
                        throw new fo("Map has no values type: " + paramhh);
                    }
                    localObject1 = new l(a((hh) localObject1, paramo));
                } else {
                    if (!((String) localObject5).equals("fixed")) {
                        break;
                    }
                    localObject4 = paramhh.a("size");
                    if ((localObject4 == null) || (!((hh) localObject4).e())) {
                        throw new fo("Invalid or no size: " + paramhh);
                    }
                    localObject3 = new g((m) localObject1, (String) localObject3, ((hh) localObject4).k());
                    if (localObject1 != null) {
                        paramo.b((fn) localObject3);
                    }
                    localObject1 = localObject3;
                }
            }
            throw new fo("Type not supported: " + (String) localObject5);
            if (localObject2 != null) {
                paramo.a((String) localObject2);
            }
            paramo = (o) localObject1;
            if ((localObject1 instanceof n)) {
                paramhh = a(paramhh);
                paramo = (o) localObject1;
                if (paramhh != null) {
                    paramhh = paramhh.iterator();
                    for (; ; ) {
                        paramo = (o) localObject1;
                        if (!paramhh.hasNext()) {
                            break;
                        }
                        ((fn) localObject1).d((String) paramhh.next());
                    }
                    if (!paramhh.b()) {
                        break label1315;
                    }
                    localObject1 = new j(paramhh.p());
                    paramhh = paramhh.iterator();
                    while (paramhh.hasNext()) {
                        ((j) localObject1).add(a((hh) paramhh.next(), paramo));
                    }
                    paramo = new w((j) localObject1);
                }
            }
            return paramo;
            label1315:
            throw new fo("Schema not yet supported: " + paramhh);
            label1343:
            localObject4 = null;
            localObject3 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject4;
            continue;
            label1357:
            localObject2 = null;
            localObject1 = null;
        }
    }

    public static fn a(String paramString1, String paramString2, String paramString3, int paramInt) {
        return new g(new m(paramString1, paramString3), paramString2, paramInt);
    }

    public static fn a(String paramString1, String paramString2, String paramString3, List<String> paramList) {
        return new e(new m(paramString1, paramString3), paramString2, new j(paramList));
    }

    public static fn a(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
        return new s(new m(paramString1, paramString3), paramString2, paramBoolean);
    }

    public static fn a(List<f> paramList) {
        fn localfn = a(null, null, null, false);
        localfn.c(paramList);
        return localfn;
    }

    private static String a(m paramm, String paramString, Map<m, Map<String, String>> paramMap) {
        paramm = (Map) paramMap.get(paramm);
        if (paramm == null) {
        }
        do {
            return paramString;
            paramm = (String) paramm.get(paramString);
        } while (paramm == null);
        return paramm;
    }

    private static String a(hh paramhh, String paramString) {
        paramhh = paramhh.a(paramString);
        if (paramhh != null) {
            return paramhh.i();
        }
        return null;
    }

    private static String a(hh paramhh, String paramString1, String paramString2) {
        paramString1 = a(paramhh, paramString1);
        if (paramString1 == null) {
            throw new fo(paramString2 + ": " + paramhh);
        }
        return paramString1;
    }

    private static Set<String> a(hh paramhh) {
        Object localObject = paramhh.a("aliases");
        if (localObject == null) {
            return null;
        }
        if (!((hh) localObject).b()) {
            throw new fo("aliases not an array: " + paramhh);
        }
        paramhh = new LinkedHashSet();
        localObject = ((hh) localObject).iterator();
        while (((Iterator) localObject).hasNext()) {
            hh localhh = (hh) ((Iterator) localObject).next();
            if (!localhh.f()) {
                throw new fo("alias not a string: " + localhh);
            }
            paramhh.add(localhh.i());
        }
        return paramhh;
    }

    public static fn b(fn paramfn) {
        return new l(paramfn);
    }

    public static fn b(List<fn> paramList) {
        return new w(new j(paramList));
    }

    private static void b(fn paramfn, Map<fn, fn> paramMap, Map<m, m> paramMap1, Map<m, Map<String, String>> paramMap2) {
        Object localObject1;
        Object localObject2;
        if ((paramfn instanceof n)) {
            localObject1 = (n) paramfn;
            if (((n) localObject1).h != null) {
                localObject2 = ((n) localObject1).h.iterator();
                while (((Iterator) localObject2).hasNext()) {
                    paramMap1.put((m) ((Iterator) localObject2).next(), ((n) localObject1).f);
                }
            }
        }
        switch (4. a[paramfn.a().ordinal()])
        {
        }
        for (; ; ) {
            return;
            if (!paramMap.containsKey(paramfn)) {
                paramMap.put(paramfn, paramfn);
                localObject2 = (s) paramfn;
                Iterator localIterator1 = paramfn.b().iterator();
                while (localIterator1.hasNext()) {
                    f localf = (f) localIterator1.next();
                    if (f.b(localf) != null) {
                        Iterator localIterator2 = f.b(localf).iterator();
                        while (localIterator2.hasNext()) {
                            String str = (String) localIterator2.next();
                            localObject1 = (Map) paramMap2.get(((s) localObject2).f);
                            paramfn = (fn) localObject1;
                            if (localObject1 == null) {
                                localObject1 = ((s) localObject2).f;
                                paramfn = new HashMap();
                                paramMap2.put(localObject1, paramfn);
                            }
                            paramfn.put(str, f.e(localf));
                        }
                    }
                    b(f.d(localf), paramMap, paramMap1, paramMap2);
                }
                if ((((s) localObject2).h != null) && (paramMap2.containsKey(((s) localObject2).f))) {
                    paramfn = ((s) localObject2).h.iterator();
                    while (paramfn.hasNext()) {
                        paramMap2.put((m) paramfn.next(), paramMap2.get(((s) localObject2).f));
                    }
                    continue;
                    b(paramfn.i(), paramMap, paramMap1, paramMap2);
                    return;
                    b(paramfn.j(), paramMap, paramMap1, paramMap2);
                    return;
                    paramfn = paramfn.k().iterator();
                    while (paramfn.hasNext()) {
                        b((fn) paramfn.next(), paramMap, paramMap1, paramMap2);
                    }
                }
            }
        }
    }

    public static fn f(String paramString) {
        return new q().a(paramString);
    }

    private static String h(String paramString) {
        if (!((Boolean) k.get()).booleanValue()) {
        }
        for (; ; ) {
            return paramString;
            int n = paramString.length();
            if (n == 0) {
                throw new fo("Empty name");
            }
            char c1 = paramString.charAt(0);
            if ((!Character.isLetter(c1)) && (c1 != '_')) {
                throw new fo("Illegal initial character: " + paramString);
            }
            int m = 1;
            while (m < n) {
                c1 = paramString.charAt(m);
                if ((!Character.isLetterOrDigit(c1)) && (c1 != '_')) {
                    throw new fo("Illegal character in: " + paramString);
                }
                m += 1;
            }
        }
    }

    public v a() {
        return this.f;
    }

    public String a(String paramString) {
        try {
            paramString = (String) this.c.get(paramString);
            return paramString;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    public String a(boolean paramBoolean) {
        try {
            Object localObject = new StringWriter();
            hf localhf = a.a((Writer) localObject);
            if (paramBoolean) {
                localhf.a();
            }
            a(new o(), localhf);
            localhf.g();
            localObject = ((StringWriter) localObject).toString();
            return (String) localObject;
        } catch (IOException localIOException) {
            throw new fk(localIOException);
        }
    }

    void a(o paramo, hf paramhf)
            throws IOException {
        if (this.c.size() == 0) {
            paramhf.b(d());
            return;
        }
        paramhf.d();
        paramhf.a("type", d());
        this.c.a(paramhf);
        paramhf.e();
    }

    public void a(String paramString1, String paramString2) {
        try {
            this.c.a(paramString1, paramString2);
            this.d = Integer.MIN_VALUE;
            return;
        } finally {
            paramString1 =finally;
            throw paramString1;
        }
    }

    public f b(String paramString) {
        throw new fk("Not a record: " + this);
    }

    public List<f> b() {
        throw new fk("Not a record: " + this);
    }

    void b(o paramo, hf paramhf)
            throws IOException {
        throw new fk("Not a record: " + this);
    }

    public int c(String paramString) {
        throw new fk("Not an enum: " + this);
    }

    public List<String> c() {
        throw new fk("Not an enum: " + this);
    }

    public void c(List<f> paramList) {
        throw new fk("Not a record: " + this);
    }

    final boolean c(fn paramfn) {
        return (this.d == paramfn.d) || (this.d == Integer.MIN_VALUE) || (paramfn.d == Integer.MIN_VALUE);
    }

    public String d() {
        return v.a(this.f);
    }

    public void d(String paramString) {
        throw new fk("Not a named type: " + this);
    }

    public Integer e(String paramString) {
        throw new fk("Not a union: " + this);
    }

    public String e() {
        return null;
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (!(paramObject instanceof fn)) {
                return false;
            }
            paramObject = (fn) paramObject;
            if (this.f != ((fn) paramObject).f) {
                return false;
            }
        } while ((c((fn) paramObject)) && (this.c.equals(((fn) paramObject).c)));
        return false;
    }

    public String f() {
        throw new fk("Not a named type: " + this);
    }

    public String g() {
        return d();
    }

    public boolean h() {
        throw new fk("Not a record: " + this);
    }

    public final int hashCode() {
        if (this.d == Integer.MIN_VALUE) {
            this.d = m();
        }
        return this.d;
    }

    public fn i() {
        throw new fk("Not an array: " + this);
    }

    public fn j() {
        throw new fk("Not a map: " + this);
    }

    public List<fn> k() {
        throw new fk("Not a union: " + this);
    }

    public int l() {
        throw new fk("Not fixed: " + this);
    }

    int m() {
        return a().hashCode() + this.c.hashCode();
    }

    public String toString() {
        return a(false);
    }

    static class a
            extends fn {
        private final fn f;

        public a(fn paramfn) {
            super();
            this.f = paramfn;
        }

        void a(fn.o paramo, hf paramhf)
                throws IOException {
            paramhf.d();
            paramhf.a("type", "array");
            paramhf.a("items");
            this.f.a(paramo, paramhf);
            this.c.a(paramhf);
            paramhf.e();
        }

        public boolean equals(Object paramObject) {
            if (paramObject == this) {
            }
            do {
                return true;
                if (!(paramObject instanceof a)) {
                    return false;
                }
                paramObject = (a) paramObject;
            }
            while ((c((fn) paramObject)) && (this.f.equals(((a) paramObject).f)) && (this.c.equals(((a) paramObject).c)));
            return false;
        }

        public fn i() {
            return this.f;
        }

        int m() {
            return super.m() + this.f.m();
        }
    }

    static class b
            extends fn {
        public b() {
            super();
        }
    }

    static class c
            extends fn {
        public c() {
            super();
        }
    }

    static class d
            extends fn {
        public d() {
            super();
        }
    }

    static class e
            extends fn.n {
        private final List<String> i;
        private final Map<String, Integer> j;

        public e(fn.m paramm, String paramString, fn.j<String> paramj) {
            super(paramm, paramString);
            this.i = paramj.a();
            this.j = new HashMap();
            paramm = paramj.iterator();
            int k = 0;
            while (paramm.hasNext()) {
                paramString = (String) paramm.next();
                if (this.j.put(fn.g(paramString), Integer.valueOf(k)) != null) {
                    throw new fo("Duplicate enum symbol: " + paramString);
                }
                k += 1;
            }
        }

        void a(fn.o paramo, hf paramhf)
                throws IOException {
            if (c(paramo, paramhf)) {
                return;
            }
            paramhf.d();
            paramhf.a("type", "enum");
            d(paramo, paramhf);
            if (e() != null) {
                paramhf.a("doc", e());
            }
            paramhf.f("symbols");
            paramo = this.i.iterator();
            while (paramo.hasNext()) {
                paramhf.b((String) paramo.next());
            }
            paramhf.c();
            this.c.a(paramhf);
            a(paramhf);
            paramhf.e();
        }

        public int c(String paramString) {
            return ((Integer) this.j.get(paramString)).intValue();
        }

        public List<String> c() {
            return this.i;
        }

        public boolean equals(Object paramObject) {
            if (paramObject == this) {
            }
            do {
                return true;
                if (!(paramObject instanceof e)) {
                    return false;
                }
                paramObject = (e) paramObject;
            }
            while ((c((fn) paramObject)) && (a((fn.n) paramObject)) && (this.i.equals(((e) paramObject).i)) && (this.c.equals(((e) paramObject).c)));
            return false;
        }

        int m() {
            return super.m() + this.i.hashCode();
        }
    }

    public static class f {
        private final String a;
        private transient int b = -1;
        private final fn c;
        private final String d;
        private final hh e;
        private final a f;
        private Set<String> g;
        private final fn.r h = new fn.r(fn.n());

        public f(String paramString1, fn paramfn, String paramString2, hh paramhh) {
            this(paramString1, paramfn, paramString2, paramhh, a.a);
        }

        public f(String paramString1, fn paramfn, String paramString2, hh paramhh, a parama) {
            this.a = fn.g(paramString1);
            this.c = paramfn;
            this.d = paramString2;
            this.e = paramhh;
            this.f = parama;
        }

        private boolean a(hh paramhh) {
            if (this.e == null) {
                return paramhh == null;
            }
            if (Double.isNaN(this.e.o())) {
                return Double.isNaN(paramhh.o());
            }
            return this.e.equals(paramhh);
        }

        public String a() {
            return this.a;
        }

        public void a(String paramString1, String paramString2) {
            try {
                this.h.a(paramString1, paramString2);
                return;
            } finally {
                paramString1 =finally;
                throw paramString1;
            }
        }

        public int b() {
            return this.b;
        }

        public fn c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public hh e() {
            return this.e;
        }

        public boolean equals(Object paramObject) {
            if (paramObject == this) {
            }
            do {
                return true;
                if (!(paramObject instanceof f)) {
                    return false;
                }
                paramObject = (f) paramObject;
            }
            while ((this.a.equals(((f) paramObject).a)) && (this.c.equals(((f) paramObject).c)) && (a(((f) paramObject).e)) && (this.h.equals(((f) paramObject).h)));
            return false;
        }

        public a f() {
            return this.f;
        }

        public int hashCode() {
            return this.a.hashCode() + this.c.m();
        }

        public String toString() {
            return this.a + " type:" + fn.d(this.c) + " pos:" + this.b;
        }

        public static enum a {
            private String d = name().toLowerCase();

            private a() {
            }
        }
    }

    static class g
            extends fn.n {
        private final int i;

        public g(fn.m paramm, String paramString, int paramInt) {
            super(paramm, paramString);
            if (paramInt < 0) {
                throw new IllegalArgumentException("Invalid fixed size: " + paramInt);
            }
            this.i = paramInt;
        }

        void a(fn.o paramo, hf paramhf)
                throws IOException {
            if (c(paramo, paramhf)) {
                return;
            }
            paramhf.d();
            paramhf.a("type", "fixed");
            d(paramo, paramhf);
            if (e() != null) {
                paramhf.a("doc", e());
            }
            paramhf.a("size", this.i);
            this.c.a(paramhf);
            a(paramhf);
            paramhf.e();
        }

        public boolean equals(Object paramObject) {
            if (paramObject == this) {
            }
            do {
                return true;
                if (!(paramObject instanceof g)) {
                    return false;
                }
                paramObject = (g) paramObject;
            }
            while ((c((fn) paramObject)) && (a((fn.n) paramObject)) && (this.i == ((g) paramObject).i) && (this.c.equals(((g) paramObject).c)));
            return false;
        }

        public int l() {
            return this.i;
        }

        int m() {
            return super.m() + this.i;
        }
    }

    static class h
            extends fn {
        public h() {
            super();
        }
    }

    static class i
            extends fn {
        public i() {
            super();
        }
    }

    static class j<E>
            extends ArrayList<E> {
        private boolean a = false;

        public j() {
        }

        public j(int paramInt) {
            super();
        }

        public j(List<E> paramList) {
            super();
        }

        private void b() {
            if (this.a) {
                throw new IllegalStateException();
            }
        }

        public List<E> a() {
            this.a = true;
            return this;
        }

        public boolean add(E paramE) {
            b();
            return super.add(paramE);
        }

        public boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
            b();
            return super.addAll(paramInt, paramCollection);
        }

        public boolean addAll(Collection<? extends E> paramCollection) {
            b();
            return super.addAll(paramCollection);
        }

        public void clear() {
            b();
            super.clear();
        }

        public E remove(int paramInt) {
            b();
            return (E) super.remove(paramInt);
        }

        public boolean remove(Object paramObject) {
            b();
            return super.remove(paramObject);
        }

        public boolean removeAll(Collection<?> paramCollection) {
            b();
            return super.removeAll(paramCollection);
        }

        public boolean retainAll(Collection<?> paramCollection) {
            b();
            return super.retainAll(paramCollection);
        }
    }

    static class k
            extends fn {
        public k() {
            super();
        }
    }

    static class l
            extends fn {
        private final fn f;

        public l(fn paramfn) {
            super();
            this.f = paramfn;
        }

        void a(fn.o paramo, hf paramhf)
                throws IOException {
            paramhf.d();
            paramhf.a("type", "map");
            paramhf.a("values");
            this.f.a(paramo, paramhf);
            this.c.a(paramhf);
            paramhf.e();
        }

        public boolean equals(Object paramObject) {
            if (paramObject == this) {
            }
            do {
                return true;
                if (!(paramObject instanceof l)) {
                    return false;
                }
                paramObject = (l) paramObject;
            }
            while ((c((fn) paramObject)) && (this.f.equals(((l) paramObject).f)) && (this.c.equals(((l) paramObject).c)));
            return false;
        }

        public fn j() {
            return this.f;
        }

        int m() {
            return super.m() + this.f.m();
        }
    }

    static class m {
        private final String a;
        private final String b;
        private final String c;

        public m(String paramString1, String paramString2) {
            if (paramString1 == null) {
                this.c = null;
                this.b = null;
                this.a = null;
                return;
            }
            int i = paramString1.lastIndexOf('.');
            if (i < 0) {
                this.b = paramString2;
                this.a = fn.g(paramString1);
                if (this.b != null) {
                    break label97;
                }
            }
            label97:
            for (paramString1 = this.a; ; paramString1 = this.b + "." + this.a) {
                this.c = paramString1;
                return;
                this.b = paramString1.substring(0, i);
                this.a = fn.g(paramString1.substring(i + 1, paramString1.length()));
                break;
            }
        }

        public String a(String paramString) {
            if ((this.b == null) || (this.b.equals(paramString))) {
                return this.a;
            }
            return this.c;
        }

        public void a(fn.o paramo, hf paramhf)
                throws IOException {
            if (this.a != null) {
                paramhf.a("name", this.a);
            }
            if (this.b != null) {
                if (!this.b.equals(paramo.a())) {
                    paramhf.a("namespace", this.b);
                }
                if (paramo.a() == null) {
                    paramo.a(this.b);
                }
            }
        }

        public boolean equals(Object paramObject) {
            if (paramObject == this) {
            }
            do {
                return true;
                if (!(paramObject instanceof m)) {
                    return false;
                }
                paramObject = (m) paramObject;
                if (this.c != null) {
                    break;
                }
            } while (((m) paramObject).c == null);
            return false;
            return this.c.equals(((m) paramObject).c);
        }

        public int hashCode() {
            if (this.c == null) {
                return 0;
            }
            return this.c.hashCode();
        }

        public String toString() {
            return this.c;
        }
    }

    static abstract class n
            extends fn {
        final fn.m f;
        final String g;
        Set<fn.m> h;

        public n(fn.v paramv, fn.m paramm, String paramString) {
            super();
            this.f = paramm;
            this.g = paramString;
            if (e.containsKey(fn.m.a(paramm))) {
                throw new fl("Schemas may not be named after primitives: " + fn.m.a(paramm));
            }
        }

        public void a(hf paramhf)
                throws IOException {
            if ((this.h == null) || (this.h.size() == 0)) {
                return;
            }
            paramhf.a("aliases");
            paramhf.b();
            Iterator localIterator = this.h.iterator();
            while (localIterator.hasNext()) {
                paramhf.b(((fn.m) localIterator.next()).a(fn.m.c(this.f)));
            }
            paramhf.c();
        }

        public boolean a(n paramn) {
            return this.f.equals(paramn.f);
        }

        public boolean c(fn.o paramo, hf paramhf)
                throws IOException {
            if (equals(paramo.a(this.f))) {
                paramhf.b(this.f.a(paramo.a()));
                return true;
            }
            if (fn.m.b(this.f) != null) {
                paramo.a(this.f, this);
            }
            return false;
        }

        public String d() {
            return fn.m.b(this.f);
        }

        public void d(fn.o paramo, hf paramhf)
                throws IOException {
            this.f.a(paramo, paramhf);
        }

        public void d(String paramString) {
            if (this.h == null) {
                this.h = new LinkedHashSet();
            }
            this.h.add(new fn.m(paramString, fn.m.c(this.f)));
        }

        public String e() {
            return this.g;
        }

        public String f() {
            return fn.m.c(this.f);
        }

        public String g() {
            return fn.m.a(this.f);
        }

        int m() {
            return super.m() + this.f.hashCode();
        }
    }

    static class o
            extends LinkedHashMap<fn.m, fn> {
        private String a;

        public o() {
        }

        public o(String paramString) {
            this.a = paramString;
        }

        public fn a(fn.m paramm, fn paramfn) {
            if (containsKey(paramm)) {
                throw new fo("Can't redefine: " + paramm);
            }
            return (fn) super.put(paramm, paramfn);
        }

        public fn a(Object paramObject) {
            if ((paramObject instanceof String)) {
                fn.v localv = (fn.v) fn.e.get((String) paramObject);
                if (localv != null) {
                    return fn.a(localv);
                }
            }
            for (paramObject = new fn.m((String) paramObject, this.a); ; paramObject = (fn.m) paramObject) {
                return (fn) super.get(paramObject);
            }
        }

        public String a() {
            return this.a;
        }

        public void a(String paramString) {
            this.a = paramString;
        }

        public boolean a(fn paramfn) {
            return a(((fn.n) paramfn).f) != null;
        }

        public void b(fn paramfn) {
            a(((fn.n) paramfn).f, paramfn);
        }
    }

    static class p
            extends fn {
        public p() {
            super();
        }
    }

    public static class q {
        private fn.o a = new fn.o();
        private boolean b = true;

        private fn a(hj paramhj)
                throws IOException {
            boolean bool = ((Boolean) fn.q().get()).booleanValue();
            try {
                fn.q().set(Boolean.valueOf(this.b));
                paramhj = fn.a(fn.b.a(paramhj), this.a);
                return paramhj;
            } catch (hi paramhj) {
                throw new fo(paramhj);
            } finally {
                fn.q().set(Boolean.valueOf(bool));
            }
        }

        public fn a(String paramString) {
            try {
                paramString = a(fn.a.a(new StringReader(paramString)));
                return paramString;
            } catch (IOException paramString) {
                throw new fo(paramString);
            }
        }
    }

    static final class r
            extends LinkedHashMap<String, String> {
        private Set<String> a;

        public r(Set<String> paramSet) {
            super();
            this.a = paramSet;
        }

        public void a(hf paramhf)
                throws IOException {
            Iterator localIterator = entrySet().iterator();
            while (localIterator.hasNext()) {
                Map.Entry localEntry = (Map.Entry) localIterator.next();
                paramhf.a((String) localEntry.getKey(), (String) localEntry.getValue());
            }
        }

        public void a(String paramString1, String paramString2) {
            if (this.a.contains(paramString1)) {
                throw new fk("Can't set reserved property: " + paramString1);
            }
            if (paramString2 == null) {
                throw new fk("Can't set a property to null: " + paramString1);
            }
            String str = (String) get(paramString1);
            if (str == null) {
                put(paramString1, paramString2);
            }
            while (str.equals(paramString2)) {
                return;
            }
            throw new fk("Can't overwrite property: " + paramString1);
        }
    }

    static class s
            extends fn.n {
        private List<fn.f> i;
        private Map<String, fn.f> j;
        private final boolean k;

        public s(fn.m paramm, String paramString, boolean paramBoolean) {
            super(paramm, paramString);
            this.k = paramBoolean;
        }

        void a(fn.o paramo, hf paramhf)
                throws IOException {
            if (c(paramo, paramhf)) {
                return;
            }
            String str2 = fn.o.a(paramo);
            paramhf.d();
            if (this.k) {
            }
            for (String str1 = "error"; ; str1 = "record") {
                paramhf.a("type", str1);
                d(paramo, paramhf);
                fn.o.a(paramo, fn.m.c(this.f));
                if (e() != null) {
                    paramhf.a("doc", e());
                }
                paramhf.a("fields");
                b(paramo, paramhf);
                this.c.a(paramhf);
                a(paramhf);
                paramhf.e();
                fn.o.a(paramo, str2);
                return;
            }
        }

        public fn.f b(String paramString) {
            if (this.j == null) {
                throw new fk("Schema fields not set yet");
            }
            return (fn.f) this.j.get(paramString);
        }

        public List<fn.f> b() {
            if (this.i == null) {
                throw new fk("Schema fields not set yet");
            }
            return this.i;
        }

        void b(fn.o paramo, hf paramhf)
                throws IOException {
            paramhf.b();
            Iterator localIterator1 = this.i.iterator();
            while (localIterator1.hasNext()) {
                fn.f localf = (fn.f) localIterator1.next();
                paramhf.d();
                paramhf.a("name", localf.a());
                paramhf.a("type");
                localf.c().a(paramo, paramhf);
                if (localf.d() != null) {
                    paramhf.a("doc", localf.d());
                }
                if (localf.e() != null) {
                    paramhf.a("default");
                    paramhf.a(localf.e());
                }
                if (localf.f() != fn.f.a.a) {
                    paramhf.a("order", fn.f.a.a(localf.f()));
                }
                if ((fn.f.b(localf) != null) && (fn.f.b(localf).size() != 0)) {
                    paramhf.a("aliases");
                    paramhf.b();
                    Iterator localIterator2 = fn.f.b(localf).iterator();
                    while (localIterator2.hasNext()) {
                        paramhf.b((String) localIterator2.next());
                    }
                    paramhf.c();
                }
                fn.f.c(localf).a(paramhf);
                paramhf.e();
            }
            paramhf.c();
        }

        public void c(List<fn.f> paramList) {
            if (this.i != null) {
                throw new fk("Fields are already set");
            }
            this.j = new HashMap();
            fn.j localj = new fn.j();
            paramList = paramList.iterator();
            int m = 0;
            while (paramList.hasNext()) {
                fn.f localf = (fn.f) paramList.next();
                if (fn.f.a(localf) != -1) {
                    throw new fk("Field already used: " + localf);
                }
                fn.f.a(localf, m);
                this.j.put(localf.a(), localf);
                localj.add(localf);
                m += 1;
            }
            this.i = localj.a();
            this.d = Integer.MIN_VALUE;
        }

        public boolean equals(Object paramObject) {
            if (paramObject == this) {
                return true;
            }
            if (!(paramObject instanceof s)) {
                return false;
            }
            Object localObject = (s) paramObject;
            if (!c((fn) localObject)) {
                return false;
            }
            if (!a((fn.n) localObject)) {
                return false;
            }
            if (!this.c.equals(((s) localObject).c)) {
                return false;
            }
            localObject = (Set) fn.o().get();
            fn.t localt = new fn.t(this, paramObject, null);
            if (((Set) localObject).contains(localt)) {
                return true;
            }
            boolean bool1 = ((Set) localObject).isEmpty();
            try {
                ((Set) localObject).add(localt);
                boolean bool2 = this.i.equals(((s) paramObject).i);
                return bool2;
            } finally {
                if (bool1) {
                    ((Set) localObject).clear();
                }
            }
        }

        public boolean h() {
            return this.k;
        }

        int m() {
            Map localMap = (Map) fn.p().get();
            if (localMap.containsKey(this)) {
                return 0;
            }
            boolean bool = localMap.isEmpty();
            try {
                localMap.put(this, this);
                int m = super.m();
                int n = this.i.hashCode();
                return m + n;
            } finally {
                if (bool) {
                    localMap.clear();
                }
            }
        }
    }

    static class t {
        private Object a;
        private Object b;

        private t(Object paramObject1, Object paramObject2) {
            this.a = paramObject1;
            this.b = paramObject2;
        }

        public boolean equals(Object paramObject) {
            return (this.a == ((t) paramObject).a) && (this.b == ((t) paramObject).b);
        }

        public int hashCode() {
            return System.identityHashCode(this.a) + System.identityHashCode(this.b);
        }
    }

    static class u
            extends fn {
        public u() {
            super();
        }
    }

    public static enum v {
        private String o = name().toLowerCase();

        private v() {
        }

        public String a() {
            return this.o;
        }
    }

    static class w
            extends fn {
        private final List<fn> f;
        private final Map<String, Integer> g = new HashMap();

        public w(fn.j<fn> paramj) {
            super();
            this.f = paramj.a();
            paramj = paramj.iterator();
            int i = 0;
            while (paramj.hasNext()) {
                Object localObject = (fn) paramj.next();
                if (((fn) localObject).a() == fn.v.e) {
                    throw new fk("Nested union: " + this);
                }
                localObject = ((fn) localObject).g();
                if (localObject == null) {
                    throw new fk("Nameless in union:" + this);
                }
                if (this.g.put(localObject, Integer.valueOf(i)) != null) {
                    throw new fk("Duplicate in union:" + (String) localObject);
                }
                i += 1;
            }
        }

        void a(fn.o paramo, hf paramhf)
                throws IOException {
            paramhf.b();
            Iterator localIterator = this.f.iterator();
            while (localIterator.hasNext()) {
                ((fn) localIterator.next()).a(paramo, paramhf);
            }
            paramhf.c();
        }

        public void a(String paramString1, String paramString2) {
            throw new fk("Can't set properties on a union: " + this);
        }

        public Integer e(String paramString) {
            return (Integer) this.g.get(paramString);
        }

        public boolean equals(Object paramObject) {
            if (paramObject == this) {
            }
            do {
                return true;
                if (!(paramObject instanceof w)) {
                    return false;
                }
                paramObject = (w) paramObject;
            }
            while ((c((fn) paramObject)) && (this.f.equals(((w) paramObject).f)) && (this.c.equals(((w) paramObject).c)));
            return false;
        }

        public List<fn> k() {
            return this.f;
        }

        int m() {
            int i = super.m();
            Iterator localIterator = this.f.iterator();
            while (localIterator.hasNext()) {
                i = ((fn) localIterator.next()).m() + i;
            }
            return i;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/fn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */