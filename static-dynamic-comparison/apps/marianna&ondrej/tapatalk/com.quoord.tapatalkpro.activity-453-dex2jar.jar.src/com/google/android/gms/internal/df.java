package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class df {
    private int mOrientation = -1;
    private String pN;
    private String pO;
    private String pP;
    private List<String> pQ;
    private String pR;
    private String pS;
    private List<String> pT;
    private long pU = -1L;
    private boolean pV = false;
    private final long pW = -1L;
    private List<String> pX;
    private long pY = -1L;

    private static String a(Map<String, List<String>> paramMap, String paramString) {
        paramMap = (List) paramMap.get(paramString);
        if ((paramMap != null) && (!paramMap.isEmpty())) {
            return (String) paramMap.get(0);
        }
        return null;
    }

    private static long b(Map<String, List<String>> paramMap, String paramString) {
        paramMap = (List) paramMap.get(paramString);
        if ((paramMap != null) && (!paramMap.isEmpty())) {
            paramMap = (String) paramMap.get(0);
            try {
                float f = Float.parseFloat(paramMap);
                return (f * 1000.0F);
            } catch (NumberFormatException localNumberFormatException) {
                dw.z("Could not parse float from " + paramString + " header: " + paramMap);
            }
        }
        return -1L;
    }

    private static List<String> c(Map<String, List<String>> paramMap, String paramString) {
        paramMap = (List) paramMap.get(paramString);
        if ((paramMap != null) && (!paramMap.isEmpty())) {
            paramMap = (String) paramMap.get(0);
            if (paramMap != null) {
                return Arrays.asList(paramMap.trim().split("\\s+"));
            }
        }
        return null;
    }

    private void f(Map<String, List<String>> paramMap) {
        this.pN = a(paramMap, "X-Afma-Ad-Size");
    }

    private void g(Map<String, List<String>> paramMap) {
        paramMap = c(paramMap, "X-Afma-Click-Tracking-Urls");
        if (paramMap != null) {
            this.pQ = paramMap;
        }
    }

    private void h(Map<String, List<String>> paramMap) {
        paramMap = (List) paramMap.get("X-Afma-Debug-Dialog");
        if ((paramMap != null) && (!paramMap.isEmpty())) {
            this.pR = ((String) paramMap.get(0));
        }
    }

    private void i(Map<String, List<String>> paramMap) {
        paramMap = c(paramMap, "X-Afma-Tracking-Urls");
        if (paramMap != null) {
            this.pT = paramMap;
        }
    }

    private void j(Map<String, List<String>> paramMap) {
        long l = b(paramMap, "X-Afma-Interstitial-Timeout");
        if (l != -1L) {
            this.pU = l;
        }
    }

    private void k(Map<String, List<String>> paramMap) {
        this.pS = a(paramMap, "X-Afma-ActiveView");
    }

    private void l(Map<String, List<String>> paramMap) {
        paramMap = (List) paramMap.get("X-Afma-Mediation");
        if ((paramMap != null) && (!paramMap.isEmpty())) {
            this.pV = Boolean.valueOf((String) paramMap.get(0)).booleanValue();
        }
    }

    private void m(Map<String, List<String>> paramMap) {
        paramMap = c(paramMap, "X-Afma-Manual-Tracking-Urls");
        if (paramMap != null) {
            this.pX = paramMap;
        }
    }

    private void n(Map<String, List<String>> paramMap) {
        long l = b(paramMap, "X-Afma-Refresh-Rate");
        if (l != -1L) {
            this.pY = l;
        }
    }

    private void o(Map<String, List<String>> paramMap) {
        paramMap = (List) paramMap.get("X-Afma-Orientation");
        if ((paramMap != null) && (!paramMap.isEmpty())) {
            paramMap = (String) paramMap.get(0);
            if (!"portrait".equalsIgnoreCase(paramMap)) {
                break label53;
            }
            this.mOrientation = dq.bA();
        }
        label53:
        while (!"landscape".equalsIgnoreCase(paramMap)) {
            return;
        }
        this.mOrientation = dq.bz();
    }

    public void a(String paramString1, Map<String, List<String>> paramMap, String paramString2) {
        this.pO = paramString1;
        this.pP = paramString2;
        e(paramMap);
    }

    public void e(Map<String, List<String>> paramMap) {
        f(paramMap);
        g(paramMap);
        h(paramMap);
        i(paramMap);
        j(paramMap);
        l(paramMap);
        m(paramMap);
        n(paramMap);
        o(paramMap);
        k(paramMap);
    }

    public cz g(long paramLong) {
        return new cz(this.pO, this.pP, this.pQ, this.pT, this.pU, this.pV, -1L, this.pX, this.pY, this.mOrientation, this.pN, paramLong, this.pR, this.pS);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */