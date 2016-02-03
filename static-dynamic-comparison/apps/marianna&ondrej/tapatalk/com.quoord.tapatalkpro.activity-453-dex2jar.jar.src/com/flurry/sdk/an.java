package com.flurry.sdk;

import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdSpaceLayout;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.avro.protocol.v10.ScreenOrientationType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class an {
    private static final String a = an.class.getSimpleName();
    private au b = new au();
    private int c = 0;
    private final Map<String, Integer> d = new HashMap();

    public List<AdUnit> a(String paramString, int paramInt1, int paramInt2) {
        label293:
        label362:
        label367:
        for (; ; ) {
            Object localObject3;
            Object localObject4;
            Object localObject1;
            try {
                localObject3 = cc.a();
                localObject4 = this.b.a(paramString, (ScreenOrientationType) localObject3);
                Object localObject2 = localObject4;
                localObject1 = localObject3;
                if (b((List) localObject4)) {
                    eo.a(3, a, "no valid ad units in cache for current orientation for " + paramString);
                    if (ScreenOrientationType.a.equals(localObject3)) {
                        localObject1 = ScreenOrientationType.b;
                        localObject2 = this.b.a(paramString, (ScreenOrientationType) localObject1);
                        if ((!b((List) localObject2)) && (a((AdUnit) ((List) localObject2).get(0)))) {
                            break label367;
                        }
                        eo.a(3, a, "no valid ad units in cache for other orientation for " + paramString);
                        break label367;
                    }
                } else {
                    localObject3 = new ArrayList();
                    if (localObject2 == null) {
                        break label362;
                    }
                    localObject2 = ((List) localObject2).iterator();
                    if ((!((Iterator) localObject2).hasNext()) || (((List) localObject3).size() >= paramInt2)) {
                        break label362;
                    }
                    localObject4 = (AdUnit) ((Iterator) localObject2).next();
                    if ((!fe.a(((AdUnit) localObject4).c().longValue())) || (((AdUnit) localObject4).e().intValue() != 1) || (((AdUnit) localObject4).d().size() <= 0)) {
                        break label293;
                    }
                    ((List) localObject3).add(localObject4);
                    eo.a(3, a, "Found combinable ad unit for " + paramString);
                    continue;
                }
                localObject1 = ScreenOrientationType.a;
            } finally {
            }
            continue;
            if ((!fe.a(((AdUnit) localObject4).c().longValue())) || (((AdUnit) localObject4).d().size() <= 0)) {
                this.b.a(paramString, (ScreenOrientationType) localObject1, (AdUnit) localObject4);
                eo.a(3, a, "Removed invalid or expired ad unit for " + paramString);
                continue;
                return (List<AdUnit>) localObject3;
            }
        }
    }

    public void a() {
        try {
            this.b.a();
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void a(String paramString) {
        try {
            this.b.a(paramString);
            return;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    public void a(String paramString, int paramInt) {
        try {
            this.b.a(paramString, cc.a(), paramInt);
            return;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    public void a(String paramString, AdUnit paramAdUnit) {
        try {
            this.b.a(paramString, cc.a(), paramAdUnit);
            return;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    public void a(String paramString1, String paramString2) {
        try {
            this.b.a(paramString1, cc.a(), paramString2);
            return;
        } finally {
            paramString1 =finally;
            throw paramString1;
        }
    }

    public void a(String paramString, List<AdUnit> paramList) {
        try {
            this.b.a(paramString, cc.a(), paramList);
            return;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    public void a(List<AdUnit> paramList) {
        ds localds;
        Object localObject1;
        try {
            localds = new ds();
            paramList = paramList.iterator();
            while (paramList.hasNext()) {
                localObject1 = (AdUnit) paramList.next();
                if (((AdUnit) localObject1).g().length() > 0) {
                    localObject2 = new x(((AdUnit) localObject1).g().toString(), ((AdUnit) localObject1).h().longValue(), ((AdUnit) localObject1).l().longValue(), ((AdUnit) localObject1).i().intValue(), ((AdUnit) localObject1).j().intValue(), ((AdUnit) localObject1).k().intValue());
                    y.a().a((x) localObject2);
                }
                Object localObject2 = ((AdUnit) localObject1).b().toString();
                if (localObject2 != null) {
                    localds.a(localObject2, localObject1);
                }
            }
            paramList = localds.c().iterator();
        } finally {
        }
        while (paramList.hasNext()) {
            localObject1 = (String) paramList.next();
            this.b.a((String) localObject1, localds.a(localObject1));
        }
    }

    public boolean a(AdUnit paramAdUnit) {
        return ((AdFrame) paramAdUnit.d().get(0)).e().e().equals("takeover");
    }

    public void b(String paramString) {
        if (paramString != null) {
        }
        try {
            if (paramString.length() > 0) {
                this.c = this.b.b(paramString, cc.a());
                this.d.put(paramString, Integer.valueOf(this.c));
            }
            return;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    public boolean b(List<AdUnit> paramList) {
        return (paramList == null) || (paramList.size() == 0) || (((AdUnit) paramList.get(0)).d().size() == 0) || (((AdFrame) ((AdUnit) paramList.get(0)).d().get(0)).e() == null);
    }

    public int c(String paramString) {
        for (; ; ) {
            try {
                paramString = (Integer) this.d.get(paramString);
                if (paramString != null) {
                    i = paramString.intValue();
                    return i;
                }
            } finally {
            }
            int i = 0;
        }
    }

    public List<AdUnit> d(String paramString) {
        for (; ; ) {
            ScreenOrientationType localScreenOrientationType;
            List localList;
            Iterator localIterator;
            AdUnit localAdUnit;
            try {
                localScreenOrientationType = cc.a();
                localList = this.b.a(paramString, localScreenOrientationType);
                if (b(localList)) {
                    eo.a(3, a, "no valid ad units in cache for current orientation for " + paramString);
                    paramString = Collections.emptyList();
                    return paramString;
                }
                if (b(localList)) {
                    break label226;
                }
                localIterator = localList.iterator();
                if (!localIterator.hasNext()) {
                    break label226;
                }
                localAdUnit = (AdUnit) localIterator.next();
                if (localAdUnit.d().size() <= 0) {
                    localIterator.remove();
                    this.b.a(paramString, localScreenOrientationType, localAdUnit);
                    eo.a(3, a, "Removed invalid ad unit -- adspace: " + paramString);
                    continue;
                }
                if (fe.a(localAdUnit.c().longValue())) {
                    continue;
                }
            } finally {
            }
            localIterator.remove();
            this.b.a(paramString, localScreenOrientationType, localAdUnit);
            eo.a(3, a, "Removed expired ad unit -- adspace: " + paramString);
            continue;
            label226:
            if (!b(localList)) {
                eo.a(3, a, "found valid ad units for " + paramString);
                paramString = localList;
            } else {
                eo.a(3, a, "no valid ad units for " + paramString);
                paramString = Collections.emptyList();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */