package com.amazon.device.ads;

import java.util.Map;

class fb
        extends ew {
    fb(Map<String, String> paramMap, fy paramfy) {
        super(paramMap, paramfy);
    }

    void a() {
        Object localObject = d("position");
        Controller.Dimensions localDimensions;
        if (localObject[0].intValue() != -1) {
            localDimensions = new Controller.Dimensions();
            localDimensions.b = localObject[0].intValue();
            localDimensions.a = localObject[1].intValue();
            localDimensions.c = localObject[2].intValue();
            localDimensions.d = localObject[3].intValue();
        }
        for (; ; ) {
            localObject = b("url");
            Controller.PlayerProperties localPlayerProperties = new Controller.PlayerProperties();
            localPlayerProperties.a(c("audioMuted"), c("autoPlay"), c("controls"), true, c("loop"), b("startStyle"), b("stopStyle"));
            this.b.n().a((String) localObject, localDimensions, localPlayerProperties);
            return;
            localDimensions = null;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/fb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */