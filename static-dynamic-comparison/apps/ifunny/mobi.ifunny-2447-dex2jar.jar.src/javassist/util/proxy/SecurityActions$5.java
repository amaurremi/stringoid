package javassist.util.proxy;

import java.lang.reflect.AccessibleObject;
import java.security.PrivilegedAction;

final class SecurityActions$5
        implements PrivilegedAction {
    SecurityActions$5(AccessibleObject paramAccessibleObject, boolean paramBoolean) {
    }

    public Object run() {
        this.val$ao.setAccessible(this.val$accessible);
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/proxy/SecurityActions$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */