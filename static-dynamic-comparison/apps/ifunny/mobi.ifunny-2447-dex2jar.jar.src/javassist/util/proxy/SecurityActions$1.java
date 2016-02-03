package javassist.util.proxy;

import java.security.PrivilegedAction;

final class SecurityActions$1
        implements PrivilegedAction {
    SecurityActions$1(Class paramClass) {
    }

    public Object run() {
        return this.val$clazz.getDeclaredMethods();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/proxy/SecurityActions$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */