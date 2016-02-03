package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class s
        extends aj {
    private static final String ID = a.J.toString();
    private static final String WC = b.aX.toString();
    private static final String Xn = b.cy.toString();
    private final a Xo;

    public s(a parama) {
        super(ID, new String[]{Xn});
        this.Xo = parama;
    }

    public boolean jX() {
        return false;
    }

    public d.a x(Map<String, d.a> paramMap) {
        String str = dh.j((d.a) paramMap.get(Xn));
        HashMap localHashMap = new HashMap();
        paramMap = (d.a) paramMap.get(WC);
        if (paramMap != null) {
            paramMap = dh.o(paramMap);
            if (!(paramMap instanceof Map)) {
                bh.z("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return dh.lT();
            }
            paramMap = ((Map) paramMap).entrySet().iterator();
            while (paramMap.hasNext()) {
                Map.Entry localEntry = (Map.Entry) paramMap.next();
                localHashMap.put(localEntry.getKey().toString(), localEntry.getValue());
            }
        }
        try {
            paramMap = dh.r(this.Xo.b(str, localHashMap));
            return paramMap;
        } catch (Exception paramMap) {
            bh.z("Custom macro/tag " + str + " threw exception " + paramMap.getMessage());
        }
        return dh.lT();
    }

    public static abstract interface a {
        public abstract Object b(String paramString, Map<String, Object> paramMap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */