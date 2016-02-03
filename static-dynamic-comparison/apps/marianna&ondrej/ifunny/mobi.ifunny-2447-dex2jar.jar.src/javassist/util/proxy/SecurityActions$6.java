package javassist.util.proxy;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;

final class SecurityActions$6
        implements PrivilegedExceptionAction {
    SecurityActions$6(Field paramField, Object paramObject1, Object paramObject2) {
    }

    public Object run() {
        this.val$fld.set(this.val$target, this.val$value);
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/proxy/SecurityActions$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */