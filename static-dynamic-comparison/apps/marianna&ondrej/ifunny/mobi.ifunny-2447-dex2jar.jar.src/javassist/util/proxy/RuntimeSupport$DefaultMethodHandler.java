package javassist.util.proxy;

import java.io.Serializable;
import java.lang.reflect.Method;

class RuntimeSupport$DefaultMethodHandler
        implements Serializable, MethodHandler {
    public Object invoke(Object paramObject, Method paramMethod1, Method paramMethod2, Object[] paramArrayOfObject) {
        return paramMethod2.invoke(paramObject, paramArrayOfObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/proxy/RuntimeSupport$DefaultMethodHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */