package com.inmobi.commons.network.abstraction;

import com.inmobi.commons.network.Request;

public abstract interface INetworkServiceProvider {
    public abstract void executeTask(Request paramRequest, INetworkListener paramINetworkListener);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/network/abstraction/INetworkServiceProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */