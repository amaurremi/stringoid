package javassist.util.proxy;

public abstract interface ProxyObject
        extends Proxy {
    public abstract MethodHandler getHandler();

    public abstract void setHandler(MethodHandler paramMethodHandler);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/proxy/ProxyObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */