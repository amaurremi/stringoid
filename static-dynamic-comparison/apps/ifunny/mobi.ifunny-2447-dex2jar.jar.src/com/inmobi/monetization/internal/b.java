package com.inmobi.monetization.internal;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.ErrorCode;
import com.inmobi.commons.network.Response;
import com.inmobi.commons.network.ServiceProvider;
import com.inmobi.commons.network.abstraction.INetworkListener;

class b {
    private static b c = null;
    private ServiceProvider a = ServiceProvider.getInstance();
    private INetworkListener b;

    public static b a() {
        if (c == null) {
            c = new b();
        }
        return c;
    }

    public void a(String paramString, i parami, INetworkListener paramINetworkListener) {
        this.b = paramINetworkListener;
        if (InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext())) {
            Log.internal("[InMobi]-[Monetization]", "Fetching  Ads");
            this.a.executeTask(parami, paramINetworkListener);
        }
        while (this.b == null) {
            return;
        }
        paramString = new Response(ErrorCode.NETWORK_ERROR);
        this.b.onRequestFailed(parami, paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */