package javassist.scopedpool;

import javassist.ClassPool;

public abstract interface ScopedClassPoolFactory {
    public abstract ScopedClassPool create(ClassLoader paramClassLoader, ClassPool paramClassPool, ScopedClassPoolRepository paramScopedClassPoolRepository);

    public abstract ScopedClassPool create(ClassPool paramClassPool, ScopedClassPoolRepository paramScopedClassPoolRepository);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/scopedpool/ScopedClassPoolFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */