package javassist.util.proxy;

import java.util.Comparator;
import java.util.Map.Entry;

final class ProxyFactory$2
        implements Comparator {
    public int compare(Object paramObject1, Object paramObject2) {
        paramObject1 = (Map.Entry) paramObject1;
        paramObject2 = (Map.Entry) paramObject2;
        return ((String) ((Map.Entry) paramObject1).getKey()).compareTo((String) ((Map.Entry) paramObject2).getKey());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/proxy/ProxyFactory$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */