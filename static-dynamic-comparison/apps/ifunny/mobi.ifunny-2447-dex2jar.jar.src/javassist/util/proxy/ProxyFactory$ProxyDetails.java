package javassist.util.proxy;

import java.lang.ref.WeakReference;

class ProxyFactory$ProxyDetails {
    boolean isUseWriteReplace;
    WeakReference proxyClass;
    byte[] signature;

    ProxyFactory$ProxyDetails(byte[] paramArrayOfByte, Class paramClass, boolean paramBoolean) {
        this.signature = paramArrayOfByte;
        this.proxyClass = new WeakReference(paramClass);
        this.isUseWriteReplace = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/proxy/ProxyFactory$ProxyDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */