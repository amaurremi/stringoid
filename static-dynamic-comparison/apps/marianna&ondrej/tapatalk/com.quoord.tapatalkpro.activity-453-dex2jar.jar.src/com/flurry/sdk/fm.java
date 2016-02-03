package com.flurry.sdk;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class fm {
    public static final fn a;
    public static final fn b;
    private static final Set<String> d = new HashSet();
    private static final Set<String> j;
    fn.r c = new fn.r(j);
    private String e;
    private String f;
    private String g;
    private fn.o h = new fn.o();
    private Map<String, a> i = new LinkedHashMap();

    static {
        Collections.addAll(d, new String[]{"doc", "response", "request", "errors", "one-way"});
        a = fn.a(fn.v.g);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(a);
        b = fn.b(localArrayList);
        j = new HashSet();
        Collections.addAll(j, new String[]{"namespace", "protocol", "doc", "messages", "types", "errors"});
    }

    private a a(String paramString, hh paramhh) {
        String str = d(paramhh);
        LinkedHashMap localLinkedHashMap = new LinkedHashMap();
        Object localObject1 = paramhh.r();
        while (((Iterator) localObject1).hasNext()) {
            localObject2 = (String) ((Iterator) localObject1).next();
            if (!d.contains(localObject2)) {
                localObject3 = paramhh.a((String) localObject2);
                if ((((hh) localObject3).a()) && (((hh) localObject3).f())) {
                    localLinkedHashMap.put(localObject2, ((hh) localObject3).i());
                }
            }
        }
        Object localObject2 = paramhh.a("request");
        if ((localObject2 == null) || (!((hh) localObject2).b())) {
            throw new fo("No request specified: " + paramhh);
        }
        localObject1 = new ArrayList();
        localObject2 = ((hh) localObject2).iterator();
        Object localObject5;
        while (((Iterator) localObject2).hasNext()) {
            localObject3 = (hh) ((Iterator) localObject2).next();
            localObject4 = ((hh) localObject3).a("name");
            if (localObject4 == null) {
                throw new fo("No param name: " + localObject3);
            }
            localObject5 = ((hh) localObject3).a("type");
            if (localObject5 == null) {
                throw new fo("No param type: " + localObject3);
            }
            ((List) localObject1).add(new fn.f(((hh) localObject4).i(), fn.a((hh) localObject5, this.h), null, ((hh) localObject3).a("default")));
        }
        localObject1 = fn.a((List) localObject1);
        boolean bool = false;
        localObject2 = paramhh.a("one-way");
        if (localObject2 != null) {
            if (!((hh) localObject2).g()) {
                throw new fo("one-way must be boolean: " + paramhh);
            }
            bool = ((hh) localObject2).j();
        }
        localObject2 = paramhh.a("response");
        if ((!bool) && (localObject2 == null)) {
            throw new fo("No response specified: " + paramhh);
        }
        Object localObject4 = paramhh.a("errors");
        if (bool) {
            if (localObject4 != null) {
                throw new fo("one-way can't have errors: " + paramhh);
            }
            if ((localObject2 != null) && (fn.a((hh) localObject2, this.h).a() != fn.v.n)) {
                throw new fo("One way response must be null: " + paramhh);
            }
            return new a(paramString, str, localLinkedHashMap, (fn) localObject1, null);
        }
        localObject2 = fn.a((hh) localObject2, this.h);
        Object localObject3 = new ArrayList();
        ((List) localObject3).add(a);
        if (localObject4 != null) {
            if (!((hh) localObject4).b()) {
                throw new fo("Errors not an array: " + paramhh);
            }
            paramhh = ((hh) localObject4).iterator();
            while (paramhh.hasNext()) {
                localObject4 = ((hh) paramhh.next()).i();
                localObject5 = this.h.a(localObject4);
                if (localObject5 == null) {
                    throw new fo("Undefined error: " + (String) localObject4);
                }
                if (!((fn) localObject5).h()) {
                    throw new fo("Not an error: " + (String) localObject4);
                }
                ((List) localObject3).add(localObject5);
            }
        }
        return new b(paramString, str, localLinkedHashMap, (fn) localObject1, (fn) localObject2, fn.b((List) localObject3), null);
    }

    private static fm a(hj paramhj) {
        try {
            fm localfm = new fm();
            localfm.a(fn.b.a(paramhj));
            return localfm;
        } catch (IOException paramhj) {
            throw new fo(paramhj);
        }
    }

    public static fm a(String paramString) {
        try {
            paramString = a(fn.a.a(new ByteArrayInputStream(paramString.getBytes("UTF-8"))));
            return paramString;
        } catch (IOException paramString) {
            throw new fk(paramString);
        }
    }

    private void a(hh paramhh) {
        b(paramhh);
        e(paramhh);
        f(paramhh);
        h(paramhh);
        c(paramhh);
        g(paramhh);
    }

    private void b(hh paramhh) {
        paramhh = paramhh.a("namespace");
        if (paramhh == null) {
            return;
        }
        this.f = paramhh.i();
        this.h.a(this.f);
    }

    private void c(hh paramhh) {
        this.g = d(paramhh);
    }

    private String d(hh paramhh) {
        paramhh = paramhh.a("doc");
        if (paramhh == null) {
            return null;
        }
        return paramhh.i();
    }

    private void e(hh paramhh) {
        hh localhh = paramhh.a("protocol");
        if (localhh == null) {
            throw new fo("No protocol name specified: " + paramhh);
        }
        this.e = localhh.i();
    }

    private void f(hh paramhh) {
        paramhh = paramhh.a("types");
        if (paramhh == null) {
        }
        for (; ; ) {
            return;
            if (!paramhh.b()) {
                throw new fo("Types not an array: " + paramhh);
            }
            paramhh = paramhh.iterator();
            while (paramhh.hasNext()) {
                hh localhh = (hh) paramhh.next();
                if (!localhh.c()) {
                    throw new fo("Type not an object: " + localhh);
                }
                fn.a(localhh, this.h);
            }
        }
    }

    private void g(hh paramhh) {
        Iterator localIterator = paramhh.r();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            if (!j.contains(str)) {
                hh localhh = paramhh.a(str);
                if ((localhh.a()) && (localhh.f())) {
                    a(str, localhh.i());
                }
            }
        }
    }

    private void h(hh paramhh) {
        paramhh = paramhh.a("messages");
        if (paramhh == null) {
        }
        for (; ; ) {
            return;
            Iterator localIterator = paramhh.r();
            while (localIterator.hasNext()) {
                String str = (String) localIterator.next();
                this.i.put(str, a(str, paramhh.a(str)));
            }
        }
    }

    public String a(boolean paramBoolean) {
        try {
            Object localObject = new StringWriter();
            hf localhf = fn.a.a((Writer) localObject);
            if (paramBoolean) {
                localhf.a();
            }
            a(localhf);
            localhf.g();
            localObject = ((StringWriter) localObject).toString();
            return (String) localObject;
        } catch (IOException localIOException) {
            throw new fk(localIOException);
        }
    }

    void a(hf paramhf)
            throws IOException {
        this.h.a(this.f);
        paramhf.d();
        paramhf.a("protocol", this.e);
        paramhf.a("namespace", this.f);
        if (this.g != null) {
            paramhf.a("doc", this.g);
        }
        this.c.a(paramhf);
        paramhf.f("types");
        Object localObject1 = new fn.o(this.f);
        Object localObject2 = this.h.values().iterator();
        while (((Iterator) localObject2).hasNext()) {
            fn localfn = (fn) ((Iterator) localObject2).next();
            if (!((fn.o) localObject1).a(localfn)) {
                localfn.a((fn.o) localObject1, paramhf);
            }
        }
        paramhf.c();
        paramhf.g("messages");
        localObject1 = this.i.entrySet().iterator();
        while (((Iterator) localObject1).hasNext()) {
            localObject2 = (Map.Entry) ((Iterator) localObject1).next();
            paramhf.a((String) ((Map.Entry) localObject2).getKey());
            ((a) ((Map.Entry) localObject2).getValue()).a(paramhf);
        }
        paramhf.e();
        paramhf.e();
    }

    public void a(String paramString1, String paramString2) {
        try {
            this.c.a(paramString1, paramString2);
            return;
        } finally {
            paramString1 =finally;
            throw paramString1;
        }
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (!(paramObject instanceof fm)) {
                return false;
            }
            paramObject = (fm) paramObject;
        }
        while ((this.e.equals(((fm) paramObject).e)) && (this.f.equals(((fm) paramObject).f)) && (this.h.equals(((fm) paramObject).h)) && (this.i.equals(((fm) paramObject).i)) && (this.c.equals(this.c)));
        return false;
    }

    public int hashCode() {
        return this.e.hashCode() + this.f.hashCode() + this.h.hashCode() + this.i.hashCode() + this.c.hashCode();
    }

    public String toString() {
        return a(false);
    }

    public class a {
        private String b;
        private String c;
        private fn d;
        private final fn.r e = new fn.r(fm.a());

        private a(String paramString, Map<String, String> paramMap, fn paramfn) {
            this.b = paramString;
            this.c = paramMap;
            fn localfn;
            this.d = localfn;
            if (paramfn != null) {
                this$1 = paramfn.entrySet().iterator();
                while (fm.this.hasNext()) {
                    paramString = (Map.Entry) fm.this.next();
                    a((String) paramString.getKey(), (String) paramString.getValue());
                }
            }
        }

        void a(hf paramhf)
                throws IOException {
            paramhf.d();
            if (this.c != null) {
                paramhf.a("doc", this.c);
            }
            this.e.a(paramhf);
            paramhf.a("request");
            this.d.b(fm.a(fm.this), paramhf);
            b(paramhf);
            paramhf.e();
        }

        public void a(String paramString1, String paramString2) {
            try {
                this.e.a(paramString1, paramString2);
                return;
            } finally {
                paramString1 =finally;
                throw paramString1;
            }
        }

        void b(hf paramhf)
                throws IOException {
            paramhf.a("response", "null");
            paramhf.a("one-way", true);
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
            while ((this.b.equals(((a) paramObject).b)) && (this.d.equals(((a) paramObject).d)) && (this.e.equals(((a) paramObject).e)));
            return false;
        }

        public int hashCode() {
            return this.b.hashCode() + this.d.hashCode() + this.e.hashCode();
        }

        public String toString() {
            try {
                Object localObject = new StringWriter();
                hf localhf = fn.a.a((Writer) localObject);
                a(localhf);
                localhf.g();
                localObject = ((StringWriter) localObject).toString();
                return (String) localObject;
            } catch (IOException localIOException) {
                throw new fk(localIOException);
            }
        }
    }

    class b
            extends fm.a {
        private fn c;
        private fn d;

        private b(String paramString, Map<String, String> paramMap, fn paramfn1, fn paramfn2, fn paramfn3) {
            super(paramString, paramMap, paramfn1, paramfn2, null);
            this.c = paramfn3;
            fn localfn;
            this.d = localfn;
        }

        void b(hf paramhf)
                throws IOException {
            paramhf.a("response");
            this.c.a(fm.a(fm.this), paramhf);
            Object localObject = this.d.k();
            if (((List) localObject).size() > 1) {
                localObject = fn.b(((List) localObject).subList(1, ((List) localObject).size()));
                paramhf.a("errors");
                ((fn) localObject).a(fm.a(fm.this), paramhf);
            }
        }

        public boolean equals(Object paramObject) {
            if (!super.equals(paramObject)) {
            }
            do {
                do {
                    return false;
                } while (!(paramObject instanceof b));
                paramObject = (b) paramObject;
            } while ((!this.c.equals(((b) paramObject).c)) || (!this.d.equals(((b) paramObject).d)));
            return true;
        }

        public int hashCode() {
            return super.hashCode() + this.c.hashCode() + this.d.hashCode();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/fm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */