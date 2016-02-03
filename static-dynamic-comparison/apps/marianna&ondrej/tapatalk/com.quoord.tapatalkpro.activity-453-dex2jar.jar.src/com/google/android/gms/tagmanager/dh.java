package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class dh {
    private static final Object aaF = null;
    private static Long aaG = new Long(0L);
    private static Double aaH = new Double(0.0D);
    private static dg aaI = dg.w(0L);
    private static String aaJ = new String("");
    private static Boolean aaK = new Boolean(false);
    private static List<Object> aaL = new ArrayList(0);
    private static Map<Object, Object> aaM = new HashMap();
    private static d.a aaN = r(aaJ);

    public static d.a bX(String paramString) {
        d.a locala = new d.a();
        locala.type = 5;
        locala.fS = paramString;
        return locala;
    }

    private static dg bY(String paramString) {
        try {
            dg localdg = dg.bW(paramString);
            return localdg;
        } catch (NumberFormatException localNumberFormatException) {
            bh.w("Failed to convert '" + paramString + "' to a number.");
        }
        return aaI;
    }

    private static Long bZ(String paramString) {
        paramString = bY(paramString);
        if (paramString == aaI) {
            return aaG;
        }
        return Long.valueOf(paramString.longValue());
    }

    private static Double ca(String paramString) {
        paramString = bY(paramString);
        if (paramString == aaI) {
            return aaH;
        }
        return Double.valueOf(paramString.doubleValue());
    }

    private static Boolean cb(String paramString) {
        if ("true".equalsIgnoreCase(paramString)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(paramString)) {
            return Boolean.FALSE;
        }
        return aaK;
    }

    private static double getDouble(Object paramObject) {
        if ((paramObject instanceof Number)) {
            return ((Number) paramObject).doubleValue();
        }
        bh.w("getDouble received non-Number");
        return 0.0D;
    }

    public static String j(d.a parama) {
        return m(o(parama));
    }

    public static dg k(d.a parama) {
        return n(o(parama));
    }

    public static Long l(d.a parama) {
        return o(o(parama));
    }

    public static Object lN() {
        return aaF;
    }

    public static Long lO() {
        return aaG;
    }

    public static Double lP() {
        return aaH;
    }

    public static Boolean lQ() {
        return aaK;
    }

    public static dg lR() {
        return aaI;
    }

    public static String lS() {
        return aaJ;
    }

    public static d.a lT() {
        return aaN;
    }

    public static Double m(d.a parama) {
        return p(o(parama));
    }

    public static String m(Object paramObject) {
        if (paramObject == null) {
            return aaJ;
        }
        return paramObject.toString();
    }

    public static dg n(Object paramObject) {
        if ((paramObject instanceof dg)) {
            return (dg) paramObject;
        }
        if (t(paramObject)) {
            return dg.w(u(paramObject));
        }
        if (s(paramObject)) {
            return dg.a(Double.valueOf(getDouble(paramObject)));
        }
        return bY(m(paramObject));
    }

    public static Boolean n(d.a parama) {
        return q(o(parama));
    }

    public static Long o(Object paramObject) {
        if (t(paramObject)) {
            return Long.valueOf(u(paramObject));
        }
        return bZ(m(paramObject));
    }

    public static Object o(d.a parama) {
        int k = 0;
        int j = 0;
        int i = 0;
        if (parama == null) {
            return aaF;
        }
        Object localObject1;
        Object localObject2;
        switch (parama.type) {
            default:
                bh.w("Failed to convert a value of type: " + parama.type);
                return aaF;
            case 1:
                return parama.fN;
            case 2:
                localObject1 = new ArrayList(parama.fO.length);
                parama = parama.fO;
                j = parama.length;
                while (i < j) {
                    localObject2 = o(parama[i]);
                    if (localObject2 == aaF) {
                        return aaF;
                    }
                    ((ArrayList) localObject1).add(localObject2);
                    i += 1;
                }
                return localObject1;
            case 3:
                if (parama.fP.length != parama.fQ.length) {
                    bh.w("Converting an invalid value to object: " + parama.toString());
                    return aaF;
                }
                localObject1 = new HashMap(parama.fQ.length);
                i = k;
                while (i < parama.fP.length) {
                    localObject2 = o(parama.fP[i]);
                    Object localObject3 = o(parama.fQ[i]);
                    if ((localObject2 == aaF) || (localObject3 == aaF)) {
                        return aaF;
                    }
                    ((Map) localObject1).put(localObject2, localObject3);
                    i += 1;
                }
                return localObject1;
            case 4:
                bh.w("Trying to convert a macro reference to object");
                return aaF;
            case 5:
                bh.w("Trying to convert a function id to object");
                return aaF;
            case 6:
                return Long.valueOf(parama.fT);
            case 7:
                localObject1 = new StringBuffer();
                parama = parama.fV;
                k = parama.length;
                i = j;
                while (i < k) {
                    localObject2 = j(parama[i]);
                    if (localObject2 == aaJ) {
                        return aaF;
                    }
                    ((StringBuffer) localObject1).append((String) localObject2);
                    i += 1;
                }
                return ((StringBuffer) localObject1).toString();
        }
        return Boolean.valueOf(parama.fU);
    }

    public static Double p(Object paramObject) {
        if (s(paramObject)) {
            return Double.valueOf(getDouble(paramObject));
        }
        return ca(m(paramObject));
    }

    public static Boolean q(Object paramObject) {
        if ((paramObject instanceof Boolean)) {
            return (Boolean) paramObject;
        }
        return cb(m(paramObject));
    }

    public static d.a r(Object paramObject) {
        boolean bool = false;
        Object localObject1 = new d.a();
        if ((paramObject instanceof d.a)) {
            return (d.a) paramObject;
        }
        if ((paramObject instanceof String)) {
            ((d.a) localObject1).type = 1;
            ((d.a) localObject1).fN = ((String) paramObject);
        }
        for (; ; ) {
            ((d.a) localObject1).fX = bool;
            return (d.a) localObject1;
            Object localObject2;
            Object localObject3;
            if ((paramObject instanceof List)) {
                ((d.a) localObject1).type = 2;
                localObject2 = (List) paramObject;
                paramObject = new ArrayList(((List) localObject2).size());
                localObject2 = ((List) localObject2).iterator();
                bool = false;
                if (((Iterator) localObject2).hasNext()) {
                    localObject3 = r(((Iterator) localObject2).next());
                    if (localObject3 == aaN) {
                        return aaN;
                    }
                    if ((bool) || (((d.a) localObject3).fX)) {
                    }
                    for (bool = true; ; bool = false) {
                        ((List) paramObject).add(localObject3);
                        break;
                    }
                }
                ((d.a) localObject1).fO = ((d.a[]) ((List) paramObject).toArray(new d.a[0]));
            } else if ((paramObject instanceof Map)) {
                ((d.a) localObject1).type = 3;
                localObject3 = ((Map) paramObject).entrySet();
                paramObject = new ArrayList(((Set) localObject3).size());
                localObject2 = new ArrayList(((Set) localObject3).size());
                localObject3 = ((Set) localObject3).iterator();
                bool = false;
                if (((Iterator) localObject3).hasNext()) {
                    Object localObject4 = (Map.Entry) ((Iterator) localObject3).next();
                    d.a locala = r(((Map.Entry) localObject4).getKey());
                    localObject4 = r(((Map.Entry) localObject4).getValue());
                    if ((locala == aaN) || (localObject4 == aaN)) {
                        return aaN;
                    }
                    if ((bool) || (locala.fX) || (((d.a) localObject4).fX)) {
                    }
                    for (bool = true; ; bool = false) {
                        ((List) paramObject).add(locala);
                        ((List) localObject2).add(localObject4);
                        break;
                    }
                }
                ((d.a) localObject1).fP = ((d.a[]) ((List) paramObject).toArray(new d.a[0]));
                ((d.a) localObject1).fQ = ((d.a[]) ((List) localObject2).toArray(new d.a[0]));
            } else if (s(paramObject)) {
                ((d.a) localObject1).type = 1;
                ((d.a) localObject1).fN = paramObject.toString();
            } else if (t(paramObject)) {
                ((d.a) localObject1).type = 6;
                ((d.a) localObject1).fT = u(paramObject);
            } else {
                if (!(paramObject instanceof Boolean)) {
                    break;
                }
                ((d.a) localObject1).type = 8;
                ((d.a) localObject1).fU = ((Boolean) paramObject).booleanValue();
            }
        }
        localObject1 = new StringBuilder().append("Converting to Value from unknown object type: ");
        if (paramObject == null) {
        }
        for (paramObject = "null"; ; paramObject = paramObject.getClass().toString()) {
            bh.w((String) paramObject);
            return aaN;
        }
    }

    private static boolean s(Object paramObject) {
        return ((paramObject instanceof Double)) || ((paramObject instanceof Float)) || (((paramObject instanceof dg)) && (((dg) paramObject).lI()));
    }

    private static boolean t(Object paramObject) {
        return ((paramObject instanceof Byte)) || ((paramObject instanceof Short)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || (((paramObject instanceof dg)) && (((dg) paramObject).lJ()));
    }

    private static long u(Object paramObject) {
        if ((paramObject instanceof Number)) {
            return ((Number) paramObject).longValue();
        }
        bh.w("getInt64 received non-Number");
        return 0L;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */