package javassist.util.proxy;

import java.security.PrivilegedExceptionAction;

final class SecurityActions$3
        implements PrivilegedExceptionAction {
    SecurityActions$3(Class paramClass, String paramString, Class[] paramArrayOfClass) {
    }

    public Object run() {
        return this.val$clazz.getDeclaredMethod(this.val$name, this.val$types);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/proxy/SecurityActions$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */