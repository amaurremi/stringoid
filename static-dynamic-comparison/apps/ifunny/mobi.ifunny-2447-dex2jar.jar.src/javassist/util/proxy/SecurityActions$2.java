package javassist.util.proxy;

import java.security.PrivilegedAction;

final class SecurityActions$2
        implements PrivilegedAction {
    SecurityActions$2(Class paramClass) {
    }

    public Object run() {
        return this.val$clazz.getDeclaredConstructors();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/proxy/SecurityActions$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */