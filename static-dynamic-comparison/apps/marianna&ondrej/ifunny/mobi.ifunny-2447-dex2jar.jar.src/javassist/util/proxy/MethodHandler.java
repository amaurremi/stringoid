package javassist.util.proxy;

import java.lang.reflect.Method;

public abstract interface MethodHandler {
    public abstract Object invoke(Object paramObject, Method paramMethod1, Method paramMethod2, Object[] paramArrayOfObject);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/proxy/MethodHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */