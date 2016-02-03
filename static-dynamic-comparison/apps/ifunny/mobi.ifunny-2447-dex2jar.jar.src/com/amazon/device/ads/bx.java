package com.amazon.device.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

class bx
        implements ca {
    private final bv a;
    private final Context b;

    bx(bv parambv, Context paramContext) {
        this.a = parambv;
        this.b = paramContext;
    }

    public boolean a(String paramString) {
        b(paramString);
        return true;
    }

    public void b(String paramString) {
        if ((this.a == null) || (!this.a.g())) {
            dv.b(bw.a(), "AdView is Null");
        }
        String str;
        do {
            do {
                Uri localUri;
                do {
                    do {
                        do {
                            return;
                            dv.b(bw.a(), "Executing AmazonMobile Intent");
                            localUri = Uri.parse(paramString);
                            try {
                                Object localObject = localUri.getQueryParameters("intent");
                                if ((localObject != null) && (((List) localObject).size() > 0)) {
                                    localObject = ((List) localObject).iterator();
                                    while (((Iterator) localObject).hasNext()) {
                                        if (d((String) ((Iterator) localObject).next())) {
                                            return;
                                        }
                                    }
                                }
                            } catch (UnsupportedOperationException localUnsupportedOperationException) {
                                for (; ; ) {
                                    str = null;
                                }
                                c(paramString);
                                return;
                            }
                            if (!ce.a(this.b)) {
                                break;
                            }
                        } while (!localUri.getHost().equals("shopping"));
                        str = localUri.getQueryParameter("app-action");
                    } while ((str == null) || (str.length() == 0));
                    if (!str.equals("detail")) {
                        break;
                    }
                    paramString = localUri.getQueryParameter("asin");
                } while ((paramString == null) || (paramString.length() == 0));
                ce.a(this.b, paramString);
                return;
                if (!str.equals("search")) {
                    break;
                }
                paramString = localUri.getQueryParameter("keyword");
            } while ((paramString == null) || (paramString.length() == 0));
            ce.b(this.b, paramString);
            return;
        } while (!str.equals("webview"));
        c(paramString);
        return;
        c(paramString);
    }

    protected void c(String paramString) {
        dv.c(bw.a(), "Special url clicked, but was not handled by SDK. Url: %s", new Object[]{paramString});
    }

    protected boolean d(String paramString) {
        Intent localIntent = new Intent();
        if (paramString.startsWith("intent:")) {
        }
        for (; ; ) {
            try {
                paramString = Intent.parseUri(paramString, 1);
            } catch (URISyntaxException paramString) {
                return false;
            }
            try {
                paramString.setAction("android.intent.action.VIEW");
                paramString.addFlags(268435456);
                this.b.startActivity(paramString);
                return true;
            } catch (ActivityNotFoundException paramString) {
            }
            localIntent.setData(Uri.parse(paramString));
            paramString = localIntent;
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */