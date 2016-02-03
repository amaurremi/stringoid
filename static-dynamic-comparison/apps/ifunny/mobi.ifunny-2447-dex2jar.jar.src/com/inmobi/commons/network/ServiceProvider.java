package com.inmobi.commons.network;

import com.inmobi.commons.network.abstraction.INetworkListener;
import com.inmobi.commons.network.abstraction.INetworkServiceProvider;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceProvider
        implements INetworkServiceProvider {
    private static ServiceProvider a;
    private ExecutorService b = Executors.newFixedThreadPool(15);

    public static ServiceProvider getInstance() {
        if (a == null) {
        }
        try {
            if (a == null) {
                a = new ServiceProvider();
            }
            return a;
        } finally {
        }
    }

    public void executeTask(Request paramRequest, INetworkListener paramINetworkListener) {
        this.b.execute(new NetworkRequestTask(paramRequest, paramINetworkListener));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/network/ServiceProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */