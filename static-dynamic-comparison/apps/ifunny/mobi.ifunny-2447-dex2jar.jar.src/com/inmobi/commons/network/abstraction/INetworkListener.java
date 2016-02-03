package com.inmobi.commons.network.abstraction;

import com.inmobi.commons.network.Request;
import com.inmobi.commons.network.Response;

public abstract interface INetworkListener {
    public abstract void onRequestFailed(Request paramRequest, Response paramResponse);

    public abstract void onRequestSucceded(Request paramRequest, Response paramResponse);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/network/abstraction/INetworkListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */