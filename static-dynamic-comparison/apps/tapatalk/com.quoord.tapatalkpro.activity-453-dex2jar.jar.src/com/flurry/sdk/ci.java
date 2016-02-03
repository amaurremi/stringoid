package com.flurry.sdk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ci {
    private int a;
    private List<cq> b;
    private boolean c;
    private boolean d;

    public static ci a(ci paramci1, ci paramci2) {
        if ((paramci1 == null) || (paramci2 == null)) {
            return null;
        }
        Object localObject1 = paramci1.a();
        paramci2 = paramci2.a();
        if ((localObject1 == null) || (((List) localObject1).isEmpty()) || (paramci2 == null) || (paramci2.isEmpty())) {
            return null;
        }
        localObject1 = (cq) ((List) localObject1).get(0);
        paramci2 = (cq) paramci2.get(0);
        Object localObject3 = ((cq) localObject1).c();
        paramci2 = paramci2.c();
        if ((localObject3 == null) || (paramci2 == null)) {
            return null;
        }
        if ((!cl.c.equals(((cs) localObject3).a())) || ((!cl.b.equals(paramci2.a())) && (!cl.c.equals(paramci2.a())))) {
            return null;
        }
        Object localObject5 = ((cs) localObject3).g();
        Object localObject4 = paramci2.g();
        if ((localObject4 == null) || (((List) localObject4).isEmpty())) {
            return null;
        }
        Object localObject2 = new ArrayList(1);
        if ((localObject5 == null) || (((List) localObject5).isEmpty())) {
            ((List) localObject2).addAll((Collection) localObject4);
        }
        for (; ; ) {
            localObject4 = new cs.a();
            ((cs.a) localObject4).a(cl.c);
            ((cs.a) localObject4).a(paramci2.b());
            ((cs.a) localObject4).a(((cs) localObject3).c());
            localObject5 = new ArrayList();
            localObject6 = ((cs) localObject3).d();
            if (localObject6 != null) {
                ((List) localObject5).addAll((Collection) localObject6);
            }
            localObject6 = paramci2.d();
            if (localObject6 == null) {
                break label462;
            }
            Iterator localIterator = ((List) localObject6).iterator();
            do {
                if (!localIterator.hasNext()) {
                    break;
                }
            } while (!((List) localObject5).contains((String) localIterator.next()));
            return null;
            localObject5 = (ct) ((List) localObject5).get(0);
            localObject4 = (ct) ((List) localObject4).get(0);
            localObject5 = ((ct) localObject5).d();
            localObject6 = ((ct) localObject4).d();
            if ((localObject5 == null) || (localObject6 == null)) {
                return null;
            }
            localObject5 = cu.a((cu) localObject5, (cu) localObject6);
            if (localObject5 == null) {
                return null;
            }
            localObject6 = new ct.a();
            ((ct.a) localObject6).a(((ct) localObject4).a());
            ((ct.a) localObject6).a(((ct) localObject4).b());
            ((ct.a) localObject6).a(((ct) localObject4).c());
            ((ct.a) localObject6).a((cu) localObject5);
            ((List) localObject2).add(((ct.a) localObject6).a());
        }
        ((List) localObject5).addAll((Collection) localObject6);
        label462:
        ((cs.a) localObject4).a((List) localObject5);
        localObject5 = new ArrayList();
        Object localObject6 = ((cs) localObject3).e();
        if (localObject6 != null) {
            ((List) localObject5).addAll((Collection) localObject6);
        }
        localObject6 = paramci2.e();
        if (localObject6 != null) {
            ((List) localObject5).addAll((Collection) localObject6);
        }
        ((cs.a) localObject4).b((List) localObject5);
        localObject5 = new ArrayList();
        localObject3 = ((cs) localObject3).f();
        if (localObject3 != null) {
            ((List) localObject5).addAll((Collection) localObject3);
        }
        localObject3 = paramci2.f();
        if (localObject3 != null) {
            ((List) localObject5).addAll((Collection) localObject3);
        }
        ((cs.a) localObject4).c((List) localObject5);
        ((cs.a) localObject4).d((List) localObject2);
        localObject2 = ((cs.a) localObject4).a();
        localObject3 = new cq.a();
        ((cq.a) localObject3).a(((cq) localObject1).a());
        ((cq.a) localObject3).a(((cq) localObject1).b());
        ((cq.a) localObject3).a((cs) localObject2);
        localObject2 = ((cq.a) localObject3).a();
        localObject1 = new ArrayList(1);
        ((List) localObject1).add(localObject2);
        localObject2 = new a();
        ((a) localObject2).a((List) localObject1);
        ((a) localObject2).a(paramci1.b());
        ((a) localObject2).a(cl.b.equals(paramci2.a()));
        return ((a) localObject2).b();
    }

    public String a(cp paramcp) {
        Object localObject = a();
        if ((localObject != null) && (!((List) localObject).isEmpty())) {
            localObject = ((cq) ((List) localObject).get(0)).c();
            if (localObject != null) {
                localObject = ((cs) localObject).g();
                if ((localObject != null) && (!((List) localObject).isEmpty())) {
                    localObject = ((ct) ((List) localObject).get(0)).d();
                    if (localObject != null) {
                        localObject = ((cu) localObject).d();
                        if (localObject != null) {
                            return (String) ((Map) localObject).get(paramcp);
                        }
                    }
                }
            }
        }
        return null;
    }

    public List<cq> a() {
        return this.b;
    }

    public List<String> a(co paramco) {
        Object localObject = a();
        if ((localObject != null) && (!((List) localObject).isEmpty())) {
            localObject = ((cq) ((List) localObject).get(0)).c();
            if (localObject != null) {
                localObject = ((cs) localObject).g();
                if ((localObject != null) && (!((List) localObject).isEmpty())) {
                    localObject = ((ct) ((List) localObject).get(0)).d();
                    if (localObject != null) {
                        localObject = ((cu) localObject).c();
                        if (localObject != null) {
                            return ((ds) localObject).a(paramco);
                        }
                    }
                }
            }
        }
        return null;
    }

    public int b() {
        return this.a;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public String e() {
        Object localObject = a();
        if ((localObject != null) && (!((List) localObject).isEmpty())) {
            localObject = ((cq) ((List) localObject).get(0)).c();
            if (localObject != null) {
                localObject = ((cs) localObject).d();
                if ((localObject != null) && (!((List) localObject).isEmpty())) {
                    return (String) ((List) localObject).get(((List) localObject).size() - 1);
                }
            }
        }
        return null;
    }

    public String f() {
        Object localObject = a();
        if ((localObject != null) && (!((List) localObject).isEmpty())) {
            localObject = ((cq) ((List) localObject).get(0)).c();
            if (localObject != null) {
                localObject = ((cs) localObject).g();
                if ((localObject != null) && (!((List) localObject).isEmpty())) {
                    localObject = ((ct) ((List) localObject).get(0)).d();
                    if (localObject != null) {
                        localObject = ((cu) localObject).e();
                        if ((localObject != null) && (((cv) localObject).a() != null)) {
                            return ((cv) localObject).a();
                        }
                    }
                }
            }
        }
        return null;
    }

    public List<String> g() {
        Object localObject = a();
        if ((localObject != null) && (!((List) localObject).isEmpty())) {
            localObject = ((cq) ((List) localObject).get(0)).c();
            if (localObject != null) {
                return ((cs) localObject).f();
            }
        }
        return null;
    }

    public List<String> h() {
        Object localObject = a();
        if ((localObject != null) && (!((List) localObject).isEmpty())) {
            localObject = ((cq) ((List) localObject).get(0)).c();
            if (localObject != null) {
                return ((cs) localObject).e();
            }
        }
        return null;
    }

    public static class a {
        private ci a = new ci(null);

        public a a() {
            ci.b(this.a, true);
            return this;
        }

        public a a(int paramInt) {
            ci.a(this.a, paramInt);
            return this;
        }

        public a a(List<cq> paramList) {
            ci.a(this.a, paramList);
            return this;
        }

        public a a(boolean paramBoolean) {
            ci.a(this.a, paramBoolean);
            return this;
        }

        public ci b() {
            return this.a;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */