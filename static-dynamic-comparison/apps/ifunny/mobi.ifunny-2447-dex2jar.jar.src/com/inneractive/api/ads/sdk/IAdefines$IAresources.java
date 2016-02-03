package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import android.util.DisplayMetrics;

import java.io.ByteArrayInputStream;

enum IAdefines$IAresources {
    private final String k;
    private BitmapDrawable l;

    private IAdefines$IAresources(String paramString1) {
        this.k = paramString1;
    }

    final BitmapDrawable a(Context paramContext) {
        if (this.l == null) {
            int n = c.a(paramContext.getResources().getDisplayMetrics().xdpi, paramContext);
            this.l = new BitmapDrawable(new ByteArrayInputStream(Base64.decode(this.k, 0)));
            this.l.setTargetDensity(n);
        }
        return this.l;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAdefines$IAresources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */