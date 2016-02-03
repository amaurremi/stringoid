package javassist.util.proxy;

import java.security.PrivilegedExceptionAction;

final class SecurityActions$4
        implements PrivilegedExceptionAction {
    SecurityActions$4(Class paramClass, Class[] paramArrayOfClass) {
    }

    public Object run() {
        return this.val$clazz.getDeclaredConstructor(this.val$types);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/proxy/SecurityActions$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */