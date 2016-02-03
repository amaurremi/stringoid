package javassist.scopedpool;

import javassist.ClassPool;

public class ScopedClassPoolFactoryImpl
        implements ScopedClassPoolFactory {
    public ScopedClassPool create(ClassLoader paramClassLoader, ClassPool paramClassPool, ScopedClassPoolRepository paramScopedClassPoolRepository) {
        return new ScopedClassPool(paramClassLoader, paramClassPool, paramScopedClassPoolRepository, false);
    }

    public ScopedClassPool create(ClassPool paramClassPool, ScopedClassPoolRepository paramScopedClassPoolRepository) {
        return new ScopedClassPool(null, paramClassPool, paramScopedClassPoolRepository, true);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/scopedpool/ScopedClassPoolFactoryImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */