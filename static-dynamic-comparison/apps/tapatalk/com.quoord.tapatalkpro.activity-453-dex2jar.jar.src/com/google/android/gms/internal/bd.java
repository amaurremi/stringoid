package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public final class bd
        implements bb {
    private final bc mP;

    public bd(bc parambc) {
        this.mP = parambc;
    }

    private static boolean a(Map<String, String> paramMap) {
        return "1".equals(paramMap.get("custom_close"));
    }

    private static int b(Map<String, String> paramMap) {
        paramMap = (String) paramMap.get("o");
        if (paramMap != null) {
            if ("p".equalsIgnoreCase(paramMap)) {
                return dq.bA();
            }
            if ("l".equalsIgnoreCase(paramMap)) {
                return dq.bz();
            }
        }
        return -1;
    }

    public void b(dz paramdz, Map<String, String> paramMap) {
        String str = (String) paramMap.get("a");
        if (str == null) {
            dw.z("Action missing from an open GMSG.");
        }
        ea localea;
        do {
            return;
            localea = paramdz.bI();
            if ("expand".equalsIgnoreCase(str)) {
                if (paramdz.bL()) {
                    dw.z("Cannot expand WebView that is already expanded.");
                    return;
                }
                localea.a(a(paramMap), b(paramMap));
                return;
            }
            if ("webapp".equalsIgnoreCase(str)) {
                paramdz = (String) paramMap.get("u");
                if (paramdz != null) {
                    localea.a(a(paramMap), b(paramMap), paramdz);
                    return;
                }
                localea.a(a(paramMap), b(paramMap), (String) paramMap.get("html"), (String) paramMap.get("baseurl"));
                return;
            }
            if (!"in_app_purchase".equalsIgnoreCase(str)) {
                break;
            }
            paramdz = (String) paramMap.get("product_id");
            paramMap = (String) paramMap.get("report_urls");
        } while (this.mP == null);
        if ((paramMap != null) && (!paramMap.isEmpty())) {
            paramMap = paramMap.split(" ");
            this.mP.a(paramdz, new ArrayList(Arrays.asList(paramMap)));
            return;
        }
        this.mP.a(paramdz, new ArrayList());
        return;
        localea.a(new cb((String) paramMap.get("i"), (String) paramMap.get("u"), (String) paramMap.get("m"), (String) paramMap.get("p"), (String) paramMap.get("c"), (String) paramMap.get("f"), (String) paramMap.get("e")));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */