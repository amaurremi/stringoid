package com.amazon.device.ads;

import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

class ga
        implements ca {
    ga(fy paramfy) {
    }

    public boolean a(String paramString) {
        Object localObject1 = URI.create(paramString);
        paramString = ((URI) localObject1).getHost();
        Object localObject2 = URLEncodedUtils.parse((URI) localObject1, "UTF-8");
        localObject1 = new HashMap();
        localObject2 = ((List) localObject2).iterator();
        while (((Iterator) localObject2).hasNext()) {
            NameValuePair localNameValuePair = (NameValuePair) ((Iterator) localObject2).next();
            ((Map) localObject1).put(localNameValuePair.getName(), localNameValuePair.getValue());
        }
        localObject1 = fc.a(paramString, (Map) localObject1, this.a);
        if (localObject1 == null) {
            this.a.d(paramString);
            return false;
        }
        ((ew) localObject1).a();
        this.a.d(paramString);
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/ga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */