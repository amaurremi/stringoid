package javassist.util.proxy;

import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.security.AccessController;
import java.security.PrivilegedActionException;

class SerializedProxy
        implements Serializable {
    private byte[] filterSignature;
    private MethodHandler handler;
    private String[] interfaces;
    private String superClass;

    SerializedProxy(Class paramClass, byte[] paramArrayOfByte, MethodHandler paramMethodHandler) {
        this.filterSignature = paramArrayOfByte;
        this.handler = paramMethodHandler;
        this.superClass = paramClass.getSuperclass().getName();
        paramClass = paramClass.getInterfaces();
        int j = paramClass.length;
        this.interfaces = new String[j - 1];
        paramArrayOfByte = ProxyObject.class.getName();
        paramMethodHandler = Proxy.class.getName();
        int i = 0;
        while (i < j) {
            String str = paramClass[i].getName();
            if ((!str.equals(paramArrayOfByte)) && (!str.equals(paramMethodHandler))) {
                this.interfaces[i] = str;
            }
            i += 1;
        }
    }

    protected Class loadClass(String paramString) {
        try {
            Class localClass = (Class) AccessController.doPrivileged(new SerializedProxy .1 (this, paramString));
            return localClass;
        } catch (PrivilegedActionException localPrivilegedActionException) {
            throw new RuntimeException("cannot load the class: " + paramString, localPrivilegedActionException.getException());
        }
    }

    Object readResolve() {
        try {
            int j = this.interfaces.length;
            Object localObject = new Class[j];
            int i = 0;
            while (i < j) {
                localObject[i] = loadClass(this.interfaces[i]);
                i += 1;
            }
            ProxyFactory localProxyFactory = new ProxyFactory();
            localProxyFactory.setSuperclass(loadClass(this.superClass));
            localProxyFactory.setInterfaces((Class[]) localObject);
            localObject = (Proxy) localProxyFactory.createClass(this.filterSignature).newInstance();
            ((Proxy) localObject).setHandler(this.handler);
            return localObject;
        } catch (ClassNotFoundException localClassNotFoundException) {
            throw new InvalidClassException(localClassNotFoundException.getMessage());
        } catch (InstantiationException localInstantiationException) {
            throw new InvalidObjectException(localInstantiationException.getMessage());
        } catch (IllegalAccessException localIllegalAccessException) {
            throw new InvalidClassException(localIllegalAccessException.getMessage());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/proxy/SerializedProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */