package javassist.util.proxy;

import java.security.PrivilegedExceptionAction;

class SerializedProxy$1
        implements PrivilegedExceptionAction {
    SerializedProxy$1(SerializedProxy paramSerializedProxy, String paramString) {
    }

    public Object run() {
        ClassLoader localClassLoader = Thread.currentThread().getContextClassLoader();
        return Class.forName(this.val$className, true, localClassLoader);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/proxy/SerializedProxy$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */