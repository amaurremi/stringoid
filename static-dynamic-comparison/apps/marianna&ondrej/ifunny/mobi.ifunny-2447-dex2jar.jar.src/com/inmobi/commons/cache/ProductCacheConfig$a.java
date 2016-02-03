package com.inmobi.commons.cache;

import com.inmobi.commons.internal.InternalSDKUtil;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

class ProductCacheConfig$a
        implements RetryMechanism.RetryRunnable {
    ProductCacheConfig$a(ProductCacheConfig paramProductCacheConfig) {
    }

    public void completed() {
        ProductCacheConfig.b(this.a).set(false);
    }

    public void run() {
        try {
            if (InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext())) {
                ProductCacheConfig.a(this.a);
                return;
            }
            throw new IOException("Network unavailable");
        } catch (Exception localException) {
            throw localException;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/cache/ProductCacheConfig$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */