package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.c.i;
import com.google.android.gms.internal.d.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class cs {
    private static final by<d.a> ZE = new by(dh.lT(), true);
    private final DataLayer WK;
    private final cq.c ZF;
    private final ag ZG;
    private final Map<String, aj> ZH;
    private final Map<String, aj> ZI;
    private final Map<String, aj> ZJ;
    private final k<cq.a, by<d.a>> ZK;
    private final k<String, b> ZL;
    private final Set<cq.e> ZM;
    private final Map<String, c> ZN;
    private volatile String ZO;
    private int ZP;

    public cs(Context paramContext, cq.c paramc, DataLayer paramDataLayer, s.a parama1, s.a parama2, ag paramag) {
        if (paramc == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.ZF = paramc;
        this.ZM = new HashSet(paramc.li());
        this.WK = paramDataLayer;
        this.ZG = paramag;
        paramc = new l.a() {
            public int a(cq.a paramAnonymousa, by<d.a> paramAnonymousby) {
                return ((d.a) paramAnonymousby.getObject()).mF();
            }
        };
        this.ZK = new l().a(1048576, paramc);
        paramc = new l.a() {
            public int a(String paramAnonymousString, cs.b paramAnonymousb) {
                return paramAnonymousString.length() + paramAnonymousb.getSize();
            }
        };
        this.ZL = new l().a(1048576, paramc);
        this.ZH = new HashMap();
        b(new i(paramContext));
        b(new s(parama2));
        b(new w(paramDataLayer));
        b(new di(paramContext, paramDataLayer));
        this.ZI = new HashMap();
        c(new q());
        c(new ad());
        c(new ae());
        c(new al());
        c(new am());
        c(new bd());
        c(new be());
        c(new ch());
        c(new db());
        this.ZJ = new HashMap();
        a(new b(paramContext));
        a(new c(paramContext));
        a(new e(paramContext));
        a(new f(paramContext));
        a(new g(paramContext));
        a(new h(paramContext));
        a(new m());
        a(new p(this.ZF.getVersion()));
        a(new s(parama1));
        a(new u(paramDataLayer));
        a(new z(paramContext));
        a(new aa());
        a(new ac());
        a(new ah(this));
        a(new an());
        a(new ao());
        a(new ax(paramContext));
        a(new az());
        a(new bc());
        a(new bk(paramContext));
        a(new bz());
        a(new cb());
        a(new ce());
        a(new cg());
        a(new ci(paramContext));
        a(new ct());
        a(new cu());
        a(new dd());
        this.ZN = new HashMap();
        paramDataLayer = this.ZM.iterator();
        while (paramDataLayer.hasNext()) {
            parama1 = (cq.e) paramDataLayer.next();
            if (paramag.kA()) {
                a(parama1.lq(), parama1.lr(), "add macro");
                a(parama1.lv(), parama1.ls(), "remove macro");
                a(parama1.lo(), parama1.lt(), "add tag");
                a(parama1.lp(), parama1.lu(), "remove tag");
            }
            int i = 0;
            while (i < parama1.lq().size()) {
                parama2 = (cq.a) parama1.lq().get(i);
                paramc = "Unknown";
                paramContext = paramc;
                if (paramag.kA()) {
                    paramContext = paramc;
                    if (i < parama1.lr().size()) {
                        paramContext = (String) parama1.lr().get(i);
                    }
                }
                paramc = d(this.ZN, h(parama2));
                paramc.b(parama1);
                paramc.a(parama1, parama2);
                paramc.a(parama1, paramContext);
                i += 1;
            }
            i = 0;
            while (i < parama1.lv().size()) {
                parama2 = (cq.a) parama1.lv().get(i);
                paramc = "Unknown";
                paramContext = paramc;
                if (paramag.kA()) {
                    paramContext = paramc;
                    if (i < parama1.ls().size()) {
                        paramContext = (String) parama1.ls().get(i);
                    }
                }
                paramc = d(this.ZN, h(parama2));
                paramc.b(parama1);
                paramc.b(parama1, parama2);
                paramc.b(parama1, paramContext);
                i += 1;
            }
        }
        paramContext = this.ZF.lj().entrySet().iterator();
        while (paramContext.hasNext()) {
            paramc = (Map.Entry) paramContext.next();
            paramDataLayer = ((List) paramc.getValue()).iterator();
            while (paramDataLayer.hasNext()) {
                parama1 = (cq.a) paramDataLayer.next();
                if (!dh.n((d.a) parama1.le().get(com.google.android.gms.internal.b.dh.toString())).booleanValue()) {
                    d(this.ZN, (String) paramc.getKey()).i(parama1);
                }
            }
        }
    }

    private by<d.a> a(d.a parama, Set<String> paramSet, dj paramdj) {
        if (!parama.fX) {
            return new by(parama, true);
        }
        by localby1;
        switch (parama.type) {
            case 5:
            case 6:
            default:
                bh.w("Unknown type: " + parama.type);
                return ZE;
            case 2:
                locala = cq.g(parama);
                locala.fO = new d.a[parama.fO.length];
                i = 0;
                while (i < parama.fO.length) {
                    localby1 = a(parama.fO[i], paramSet, paramdj.cd(i));
                    if (localby1 == ZE) {
                        return ZE;
                    }
                    locala.fO[i] = ((d.a) localby1.getObject());
                    i += 1;
                }
                return new by(locala, false);
            case 3:
                locala = cq.g(parama);
                if (parama.fP.length != parama.fQ.length) {
                    bh.w("Invalid serving value: " + parama.toString());
                    return ZE;
                }
                locala.fP = new d.a[parama.fP.length];
                locala.fQ = new d.a[parama.fP.length];
                i = 0;
                while (i < parama.fP.length) {
                    localby1 = a(parama.fP[i], paramSet, paramdj.ce(i));
                    by localby2 = a(parama.fQ[i], paramSet, paramdj.cf(i));
                    if ((localby1 == ZE) || (localby2 == ZE)) {
                        return ZE;
                    }
                    locala.fP[i] = ((d.a) localby1.getObject());
                    locala.fQ[i] = ((d.a) localby2.getObject());
                    i += 1;
                }
                return new by(locala, false);
            case 4:
                if (paramSet.contains(parama.fR)) {
                    bh.w("Macro cycle detected.  Current macro reference: " + parama.fR + "." + "  Previous macro references: " + paramSet.toString() + ".");
                    return ZE;
                }
                paramSet.add(parama.fR);
                paramdj = dk.a(a(parama.fR, paramSet, paramdj.kP()), parama.fW);
                paramSet.remove(parama.fR);
                return paramdj;
        }
        d.a locala = cq.g(parama);
        locala.fV = new d.a[parama.fV.length];
        int i = 0;
        while (i < parama.fV.length) {
            localby1 = a(parama.fV[i], paramSet, paramdj.cg(i));
            if (localby1 == ZE) {
                return ZE;
            }
            locala.fV[i] = ((d.a) localby1.getObject());
            i += 1;
        }
        return new by(locala, false);
    }

    private by<d.a> a(String paramString, Set<String> paramSet, bj parambj) {
        this.ZP += 1;
        Object localObject = (b) this.ZL.get(paramString);
        if ((localObject != null) && (!this.ZG.kA())) {
            a(((b) localObject).lf(), paramSet);
            this.ZP -= 1;
            return ((b) localObject).lz();
        }
        localObject = (c) this.ZN.get(paramString);
        if (localObject == null) {
            bh.w(ly() + "Invalid macro: " + paramString);
            this.ZP -= 1;
            return ZE;
        }
        by localby = a(paramString, ((c) localObject).lA(), ((c) localObject).lB(), ((c) localObject).lC(), ((c) localObject).lE(), ((c) localObject).lD(), paramSet, parambj.kr());
        if (((Set) localby.getObject()).isEmpty()) {
        }
        for (localObject = ((c) localObject).lF(); localObject == null; localObject = (cq.a) ((Set) localby.getObject()).iterator().next()) {
            this.ZP -= 1;
            return ZE;
            if (((Set) localby.getObject()).size() > 1) {
                bh.z(ly() + "Multiple macros active for macroName " + paramString);
            }
        }
        parambj = a(this.ZJ, (cq.a) localObject, paramSet, parambj.kG());
        boolean bool;
        if ((localby.kQ()) && (parambj.kQ())) {
            bool = true;
            if (parambj != ZE) {
                break label392;
            }
        }
        label392:
        for (parambj = ZE; ; parambj = new by(parambj.getObject(), bool)) {
            localObject = ((cq.a) localObject).lf();
            if (parambj.kQ()) {
                this.ZL.e(paramString, new b(parambj, (d.a) localObject));
            }
            a((d.a) localObject, paramSet);
            this.ZP -= 1;
            return parambj;
            bool = false;
            break;
        }
    }

    private by<d.a> a(Map<String, aj> paramMap, cq.a parama, Set<String> paramSet, cj paramcj) {
        boolean bool = true;
        Object localObject1 = (d.a) parama.le().get(com.google.android.gms.internal.b.cx.toString());
        if (localObject1 == null) {
            bh.w("No function id in properties");
            paramMap = ZE;
        }
        aj localaj;
        do {
            return paramMap;
            localObject1 = ((d.a) localObject1).fS;
            localaj = (aj) paramMap.get(localObject1);
            if (localaj == null) {
                bh.w((String) localObject1 + " has no backing implementation.");
                return ZE;
            }
            paramMap = (by) this.ZK.get(parama);
        } while ((paramMap != null) && (!this.ZG.kA()));
        paramMap = new HashMap();
        Iterator localIterator = parama.le().entrySet().iterator();
        int i = 1;
        if (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            Object localObject2 = paramcj.bH((String) localEntry.getKey());
            localObject2 = a((d.a) localEntry.getValue(), paramSet, ((cl) localObject2).e((d.a) localEntry.getValue()));
            if (localObject2 == ZE) {
                return ZE;
            }
            if (((by) localObject2).kQ()) {
                parama.a((String) localEntry.getKey(), (d.a) ((by) localObject2).getObject());
            }
            for (; ; ) {
                paramMap.put(localEntry.getKey(), ((by) localObject2).getObject());
                break;
                i = 0;
            }
        }
        if (!localaj.a(paramMap.keySet())) {
            bh.w("Incorrect keys for function " + (String) localObject1 + " required " + localaj.kC() + " had " + paramMap.keySet());
            return ZE;
        }
        if ((i != 0) && (localaj.jX())) {
        }
        for (; ; ) {
            paramMap = new by(localaj.x(paramMap), bool);
            if (bool) {
                this.ZK.e(parama, paramMap);
            }
            paramcj.d((d.a) paramMap.getObject());
            return paramMap;
            bool = false;
        }
    }

    private by<Set<cq.a>> a(Set<cq.e> paramSet, Set<String> paramSet1, a parama, cr paramcr) {
        HashSet localHashSet1 = new HashSet();
        HashSet localHashSet2 = new HashSet();
        paramSet = paramSet.iterator();
        boolean bool = true;
        if (paramSet.hasNext()) {
            cq.e locale = (cq.e) paramSet.next();
            cm localcm = paramcr.kO();
            by localby = a(locale, paramSet1, localcm);
            if (((Boolean) localby.getObject()).booleanValue()) {
                parama.a(locale, localHashSet1, localHashSet2, localcm);
            }
            if ((bool) && (localby.kQ())) {
            }
            for (bool = true; ; bool = false) {
                break;
            }
        }
        localHashSet1.removeAll(localHashSet2);
        paramcr.b(localHashSet1);
        return new by(localHashSet1, bool);
    }

    private void a(d.a parama, Set<String> paramSet) {
        if (parama == null) {
        }
        for (; ; ) {
            return;
            parama = a(parama, paramSet, new bw());
            if (parama != ZE) {
                parama = dh.o((d.a) parama.getObject());
                if ((parama instanceof Map)) {
                    parama = (Map) parama;
                    this.WK.push(parama);
                    return;
                }
                if (!(parama instanceof List)) {
                    break;
                }
                parama = ((List) parama).iterator();
                while (parama.hasNext()) {
                    paramSet = parama.next();
                    if ((paramSet instanceof Map)) {
                        paramSet = (Map) paramSet;
                        this.WK.push(paramSet);
                    } else {
                        bh.z("pushAfterEvaluate: value not a Map");
                    }
                }
            }
        }
        bh.z("pushAfterEvaluate: value not a Map or List");
    }

    private static void a(List<cq.a> paramList, List<String> paramList1, String paramString) {
        if (paramList.size() != paramList1.size()) {
            bh.x("Invalid resource: imbalance of rule names of functions for " + paramString + " operation. Using default rule name instead");
        }
    }

    private static void a(Map<String, aj> paramMap, aj paramaj) {
        if (paramMap.containsKey(paramaj.kB())) {
            throw new IllegalArgumentException("Duplicate function type name: " + paramaj.kB());
        }
        paramMap.put(paramaj.kB(), paramaj);
    }

    private static c d(Map<String, c> paramMap, String paramString) {
        c localc2 = (c) paramMap.get(paramString);
        c localc1 = localc2;
        if (localc2 == null) {
            localc1 = new c();
            paramMap.put(paramString, localc1);
        }
        return localc1;
    }

    private static String h(cq.a parama) {
        return dh.j((d.a) parama.le().get(com.google.android.gms.internal.b.cI.toString()));
    }

    private String ly() {
        if (this.ZP <= 1) {
            return "";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(Integer.toString(this.ZP));
        int i = 2;
        while (i < this.ZP) {
            localStringBuilder.append(' ');
            i += 1;
        }
        localStringBuilder.append(": ");
        return localStringBuilder.toString();
    }

    by<Boolean> a(cq.a parama, Set<String> paramSet, cj paramcj) {
        parama = a(this.ZI, parama, paramSet, paramcj);
        paramSet = dh.n((d.a) parama.getObject());
        paramcj.d(dh.r(paramSet));
        return new by(paramSet, parama.kQ());
    }

    by<Boolean> a(cq.e parame, Set<String> paramSet, cm paramcm) {
        Object localObject = parame.ln().iterator();
        boolean bool = true;
        if (((Iterator) localObject).hasNext()) {
            by localby = a((cq.a) ((Iterator) localObject).next(), paramSet, paramcm.kI());
            if (((Boolean) localby.getObject()).booleanValue()) {
                paramcm.f(dh.r(Boolean.valueOf(false)));
                return new by(Boolean.valueOf(false), localby.kQ());
            }
            if ((bool) && (localby.kQ())) {
            }
            for (bool = true; ; bool = false) {
                break;
            }
        }
        parame = parame.lm().iterator();
        while (parame.hasNext()) {
            localObject = a((cq.a) parame.next(), paramSet, paramcm.kJ());
            if (!((Boolean) ((by) localObject).getObject()).booleanValue()) {
                paramcm.f(dh.r(Boolean.valueOf(false)));
                return new by(Boolean.valueOf(false), ((by) localObject).kQ());
            }
            if ((bool) && (((by) localObject).kQ())) {
                bool = true;
            } else {
                bool = false;
            }
        }
        paramcm.f(dh.r(Boolean.valueOf(true)));
        return new by(Boolean.valueOf(true), bool);
    }

    by<Set<cq.a>> a(String paramString, Set<cq.e> paramSet, final Map<cq.e, List<cq.a>> paramMap1, final Map<cq.e, List<String>> paramMap2, final Map<cq.e, List<cq.a>> paramMap3, final Map<cq.e, List<String>> paramMap4, Set<String> paramSet1, cr paramcr) {
        a(paramSet, paramSet1, new a() {
            public void a(cq.e paramAnonymouse, Set<cq.a> paramAnonymousSet1, Set<cq.a> paramAnonymousSet2, cm paramAnonymouscm) {
                List localList1 = (List) paramMap1.get(paramAnonymouse);
                List localList2 = (List) paramMap2.get(paramAnonymouse);
                if (localList1 != null) {
                    paramAnonymousSet1.addAll(localList1);
                    paramAnonymouscm.kK().b(localList1, localList2);
                }
                paramAnonymousSet1 = (List) paramMap3.get(paramAnonymouse);
                paramAnonymouse = (List) paramMap4.get(paramAnonymouse);
                if (paramAnonymousSet1 != null) {
                    paramAnonymousSet2.addAll(paramAnonymousSet1);
                    paramAnonymouscm.kL().b(paramAnonymousSet1, paramAnonymouse);
                }
            }
        }, paramcr);
    }

    by<Set<cq.a>> a(Set<cq.e> paramSet, cr paramcr) {
        a(paramSet, new HashSet(), new a() {
            public void a(cq.e paramAnonymouse, Set<cq.a> paramAnonymousSet1, Set<cq.a> paramAnonymousSet2, cm paramAnonymouscm) {
                paramAnonymousSet1.addAll(paramAnonymouse.lo());
                paramAnonymousSet2.addAll(paramAnonymouse.lp());
                paramAnonymouscm.kM().b(paramAnonymouse.lo(), paramAnonymouse.lt());
                paramAnonymouscm.kN().b(paramAnonymouse.lp(), paramAnonymouse.lu());
            }
        }, paramcr);
    }

    void a(aj paramaj) {
        a(this.ZJ, paramaj);
    }

    void b(aj paramaj) {
        a(this.ZH, paramaj);
    }

    public by<d.a> bR(String paramString) {
        this.ZP = 0;
        af localaf = this.ZG.bA(paramString);
        paramString = a(paramString, new HashSet(), localaf.kx());
        localaf.kz();
        return paramString;
    }

    void bS(String paramString) {
        try {
            this.ZO = paramString;
            return;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    public void bp(String paramString) {
        try {
            bS(paramString);
            paramString = this.ZG.bB(paramString);
            t localt = paramString.ky();
            Iterator localIterator = ((Set) a(this.ZM, localt.kr()).getObject()).iterator();
            while (localIterator.hasNext()) {
                cq.a locala = (cq.a) localIterator.next();
                a(this.ZH, locala, new HashSet(), localt.kq());
            }
            paramString.kz();
        } finally {
        }
        bS(null);
    }

    void c(aj paramaj) {
        a(this.ZI, paramaj);
    }

    public void e(List<c.i> paramList) {
        for (; ; ) {
            try {
                paramList = paramList.iterator();
                if (!paramList.hasNext()) {
                    break;
                }
                c.i locali = (c.i) paramList.next();
                if ((locali.name == null) || (!locali.name.startsWith("gaExperiment:"))) {
                    bh.y("Ignored supplemental: " + locali);
                } else {
                    ai.a(this.WK, locali);
                }
            } finally {
            }
        }
    }

    String lx() {
        try {
            String str = this.ZO;
            return str;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    static abstract interface a {
        public abstract void a(cq.e parame, Set<cq.a> paramSet1, Set<cq.a> paramSet2, cm paramcm);
    }

    private static class b {
        private by<d.a> ZV;
        private d.a Zq;

        public b(by<d.a> paramby, d.a parama) {
            this.ZV = paramby;
            this.Zq = parama;
        }

        public int getSize() {
            int j = ((d.a) this.ZV.getObject()).mF();
            if (this.Zq == null) {
            }
            for (int i = 0; ; i = this.Zq.mF()) {
                return i + j;
            }
        }

        public d.a lf() {
            return this.Zq;
        }

        public by<d.a> lz() {
            return this.ZV;
        }
    }

    private static class c {
        private final Set<cq.e> ZM = new HashSet();
        private final Map<cq.e, List<cq.a>> ZW = new HashMap();
        private final Map<cq.e, List<cq.a>> ZX = new HashMap();
        private final Map<cq.e, List<String>> ZY = new HashMap();
        private final Map<cq.e, List<String>> ZZ = new HashMap();
        private cq.a aaa;

        public void a(cq.e parame, cq.a parama) {
            List localList = (List) this.ZW.get(parame);
            Object localObject = localList;
            if (localList == null) {
                localObject = new ArrayList();
                this.ZW.put(parame, localObject);
            }
            ((List) localObject).add(parama);
        }

        public void a(cq.e parame, String paramString) {
            List localList = (List) this.ZY.get(parame);
            Object localObject = localList;
            if (localList == null) {
                localObject = new ArrayList();
                this.ZY.put(parame, localObject);
            }
            ((List) localObject).add(paramString);
        }

        public void b(cq.e parame) {
            this.ZM.add(parame);
        }

        public void b(cq.e parame, cq.a parama) {
            List localList = (List) this.ZX.get(parame);
            Object localObject = localList;
            if (localList == null) {
                localObject = new ArrayList();
                this.ZX.put(parame, localObject);
            }
            ((List) localObject).add(parama);
        }

        public void b(cq.e parame, String paramString) {
            List localList = (List) this.ZZ.get(parame);
            Object localObject = localList;
            if (localList == null) {
                localObject = new ArrayList();
                this.ZZ.put(parame, localObject);
            }
            ((List) localObject).add(paramString);
        }

        public void i(cq.a parama) {
            this.aaa = parama;
        }

        public Set<cq.e> lA() {
            return this.ZM;
        }

        public Map<cq.e, List<cq.a>> lB() {
            return this.ZW;
        }

        public Map<cq.e, List<String>> lC() {
            return this.ZY;
        }

        public Map<cq.e, List<String>> lD() {
            return this.ZZ;
        }

        public Map<cq.e, List<cq.a>> lE() {
            return this.ZX;
        }

        public cq.a lF() {
            return this.aaa;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */