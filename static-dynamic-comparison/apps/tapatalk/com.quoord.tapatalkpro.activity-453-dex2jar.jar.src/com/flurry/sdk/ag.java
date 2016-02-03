package com.flurry.sdk;

import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ag {
    private static final String a = ag.class.getSimpleName();
    private final FlurryAdModule b;

    public ag(FlurryAdModule paramFlurryAdModule) {
        this.b = paramFlurryAdModule;
    }

    private boolean a(String paramString1, String paramString2) {
        return paramString2.equals("%{" + paramString1 + "}");
    }

    public String a(e parame, AdUnit paramAdUnit, a parama, String paramString1, String paramString2) {
        if (a("fids", paramString2)) {
            parame = new StringBuilder();
            paramAdUnit = dn.a().l().entrySet().iterator();
            int i = 1;
            if (paramAdUnit.hasNext()) {
                parama = (Map.Entry) paramAdUnit.next();
                if (i == 0) {
                    parame.append(",");
                }
                parame.append(((dr) parama.getKey()).d).append(":");
                if (((dr) parama.getKey()).e) {
                    parame.append(new String(((ByteBuffer) parama.getValue()).array()));
                }
                for (; ; ) {
                    i = 0;
                    break;
                    parame.append(fe.a(((ByteBuffer) parama.getValue()).array()));
                }
            }
            eo.a(3, a, "Replacing param fids with: " + parame.toString());
            paramAdUnit = paramString1.replace(paramString2, fe.b(parame.toString()));
        }
        do {
            do {
                return paramAdUnit;
                if (a("sid", paramString2)) {
                    parame = String.valueOf(this.b.h());
                    eo.a(3, a, "Replacing param sid with: " + parame);
                    return paramString1.replace(paramString2, fe.b(parame));
                }
                if (a("lid", paramString2)) {
                    parame = String.valueOf(parame.a());
                    eo.a(3, a, "Replacing param lid with: " + parame);
                    return paramString1.replace(paramString2, fe.b(parame));
                }
                if (a("guid", paramString2)) {
                    parame = parame.b();
                    eo.a(3, a, "Replacing param guid with: " + parame);
                    return paramString1.replace(paramString2, fe.b(parame));
                }
                if (a("ats", paramString2)) {
                    parame = String.valueOf(System.currentTimeMillis());
                    eo.a(3, a, "Replacing param ats with: " + parame);
                    return paramString1.replace(paramString2, fe.b(parame));
                }
                if (a("apik", paramString2)) {
                    parame = this.b.j();
                    eo.a(3, a, "Replacing param apik with: " + parame);
                    return paramString1.replace(paramString2, fe.b(parame));
                }
                if (a("hid", paramString2)) {
                    parame = paramAdUnit.b().toString();
                    eo.a(3, a, "Replacing param hid with: " + parame);
                    return paramString1.replace(paramString2, fe.b(parame));
                }
                if (a("eso", paramString2)) {
                    parame = Long.toString(System.currentTimeMillis() - this.b.h());
                    eo.a(3, a, "Replacing param eso with: " + parame);
                    return paramString1.replace(paramString2, fe.b(parame));
                }
                if (!a("uc", paramString2)) {
                    break;
                }
                paramAdUnit = this.b.B().entrySet().iterator();
                for (parame = ""; paramAdUnit.hasNext(); parame = parame + "c_" + fe.b((String) parama.getKey()) + "=" + fe.b((String) parama.getValue()) + "&") {
                    parama = (Map.Entry) paramAdUnit.next();
                }
                eo.a(3, a, "Replacing param uc with: " + parame);
                parama = paramString1.replace(paramString2, parame);
                paramAdUnit = parama;
            } while (!parame.equals(""));
            paramAdUnit = parama;
        } while (parama.length() <= 0);
        return parama.substring(0, parama.length() - 1);
        eo.a(3, a, "Unknown param: " + paramString2);
        return paramString1.replace(paramString2, "");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */