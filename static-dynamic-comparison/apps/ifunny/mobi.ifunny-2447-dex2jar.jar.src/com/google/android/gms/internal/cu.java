package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@ii
public final class cu
        implements cp {
    private final cq a;
    private final tk b;

    public cu(cq paramcq, tk paramtk) {
        this.a = paramcq;
        this.b = paramtk;
    }

    private static boolean a(Map<String, String> paramMap) {
        return "1".equals(paramMap.get("custom_close"));
    }

    private static int b(Map<String, String> paramMap) {
        paramMap = (String) paramMap.get("o");
        if (paramMap != null) {
            if ("p".equalsIgnoreCase(paramMap)) {
                return lw.c();
            }
            if ("l".equalsIgnoreCase(paramMap)) {
                return lw.b();
            }
        }
        return -1;
    }

    public void a(mz parammz, Map<String, String> paramMap) {
        String str = (String) paramMap.get("a");
        if (str == null) {
            mx.e("Action missing from an open GMSG.");
        }
        nb localnb;
        do {
            return;
            if ((this.b != null) && (!this.b.b())) {
                this.b.a((String) paramMap.get("u"));
                return;
            }
            localnb = parammz.f();
            if ("expand".equalsIgnoreCase(str)) {
                if (parammz.j()) {
                    mx.e("Cannot expand WebView that is already expanded.");
                    return;
                }
                localnb.a(a(paramMap), b(paramMap));
                return;
            }
            if ("webapp".equalsIgnoreCase(str)) {
                parammz = (String) paramMap.get("u");
                if (parammz != null) {
                    localnb.a(a(paramMap), b(paramMap), parammz);
                    return;
                }
                localnb.a(a(paramMap), b(paramMap), (String) paramMap.get("html"), (String) paramMap.get("baseurl"));
                return;
            }
            if (!"in_app_purchase".equalsIgnoreCase(str)) {
                break;
            }
            parammz = (String) paramMap.get("product_id");
            paramMap = (String) paramMap.get("report_urls");
        } while (this.a == null);
        if ((paramMap != null) && (!paramMap.isEmpty())) {
            paramMap = paramMap.split(" ");
            this.a.a(parammz, new ArrayList(Arrays.asList(paramMap)));
            return;
        }
        this.a.a(parammz, new ArrayList());
        return;
        localnb.a(new dj((String) paramMap.get("i"), (String) paramMap.get("u"), (String) paramMap.get("m"), (String) paramMap.get("p"), (String) paramMap.get("c"), (String) paramMap.get("f"), (String) paramMap.get("e")));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */