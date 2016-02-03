package com.androidquery.callback;

import java.net.Proxy;

import org.apache.http.HttpRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public abstract class ProxyHandle {
    public abstract void applyProxy(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback, HttpRequest paramHttpRequest, DefaultHttpClient paramDefaultHttpClient);

    public abstract Proxy makeProxy(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/callback/ProxyHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */