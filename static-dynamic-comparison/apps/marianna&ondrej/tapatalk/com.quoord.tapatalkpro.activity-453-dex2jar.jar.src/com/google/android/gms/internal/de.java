package com.google.android.gms.internal;

import java.util.Map;

public final class de {
    private dz lC;
    private final Object li = new Object();
    private int oS = -2;
    private String pI;
    private String pJ;
    public final bb pK = new bb() {
        public void b(dz arg1, Map<String, String> paramAnonymousMap) {
            synchronized (de.a(de.this)) {
                String str = (String) paramAnonymousMap.get("type");
                paramAnonymousMap = (String) paramAnonymousMap.get("errors");
                dw.z("Invalid " + str + " request error: " + paramAnonymousMap);
                de.a(de.this, 1);
                de.a(de.this).notify();
                return;
            }
        }
    };
    public final bb pL = new bb() {
        public void b(dz paramAnonymousdz, Map<String, String> paramAnonymousMap) {
            synchronized (de.a(de.this)) {
                String str2 = (String) paramAnonymousMap.get("url");
                if (str2 == null) {
                    dw.z("URL missing in loadAdUrl GMSG.");
                    return;
                }
                String str1 = str2;
                if (str2.contains("%40mediation_adapters%40")) {
                    str1 = str2.replaceAll("%40mediation_adapters%40", dn.b(paramAnonymousdz.getContext(), (String) paramAnonymousMap.get("check_adapters"), de.b(de.this)));
                    dw.y("Ad request URL modified to " + str1);
                }
                de.a(de.this, str1);
                de.a(de.this).notify();
                return;
            }
        }
    };

    public de(String paramString) {
        this.pI = paramString;
    }

    public void b(dz paramdz) {
        synchronized (this.li) {
            this.lC = paramdz;
            return;
        }
    }

    public String bj() {
        synchronized (this.li) {
            while (this.pJ == null) {
                int i = this.oS;
                if (i == -2) {
                    try {
                        this.li.wait();
                    } catch (InterruptedException localInterruptedException) {
                        dw.z("Ad request service was interrupted.");
                        return null;
                    }
                }
            }
            String str = this.pJ;
            return str;
        }
    }

    public int getErrorCode() {
        synchronized (this.li) {
            int i = this.oS;
            return i;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */