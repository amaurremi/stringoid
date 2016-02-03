package com.amazon.device.ads;

import android.net.Uri;

class ev
        extends ek {
    ev(fy paramfy) {
        super(paramfy);
    }

    protected void a(fy paramfy, String paramString) {
        if (paramfy.t() != null) {
            if (paramfy.n().i()) {
                paramfy.n().j();
            }
            paramfy.t().a(paramfy, paramString);
        }
    }

    protected void a(String paramString) {
        fy localfy = a();
        if ((paramString == null) || (paramString.length() == 0)) {
            dv.c("MraidBrowserController", "URI cannot be null or empty");
            return;
        }
        dv.a("MraidBrowserController", "Opening in-app browser: %s", new Object[]{paramString});
        Object localObject = Uri.parse(paramString);
        if ((((Uri) localObject).getScheme() != null) && (((Uri) localObject).getScheme().equals("amazonmobile"))) {
            a(localfy, paramString);
            return;
        }
        for (; ; ) {
            try {
                localObject = ((Uri) localObject).getQueryParameter("d.url");
                if (localObject != null) {
                    break label189;
                }
                if (paramString.startsWith("amazonmobile:")) {
                    a(localfy, paramString);
                    return;
                }
            } catch (UnsupportedOperationException localUnsupportedOperationException) {
                dv.b("MraidBrowserController", "Could not open non-hierarchical URI: %s", new Object[]{paramString});
                return;
            }
            if (localfy.s() != null) {
                localfy.s().a(localfy);
            }
            if ((paramString.startsWith("http:")) || (paramString.startsWith("https:"))) {
                new eu().a(a().getContext()).a(paramString).a().b();
                return;
            }
            localfy.c.a(paramString);
            return;
            label189:
            paramString = localUnsupportedOperationException;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/ev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */