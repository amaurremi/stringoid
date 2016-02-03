package javassist;

import java.net.URL;
import java.security.PrivilegedExceptionAction;
import java.security.ProtectionDomain;

final class ClassPool$1
        implements PrivilegedExceptionAction {
    public Object run() {
        Class localClass = Class.forName("java.lang.ClassLoader");
        ClassPool.access$002(localClass.getDeclaredMethod("defineClass", new Class[]{String.class, byte[].class, Integer.TYPE, Integer.TYPE}));
        ClassPool.access$102(localClass.getDeclaredMethod("defineClass", new Class[]{String.class, byte[].class, Integer.TYPE, Integer.TYPE, ProtectionDomain.class}));
        ClassPool.access$202(localClass.getDeclaredMethod("definePackage", new Class[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class, URL.class}));
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/ClassPool$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */