package javassist.scopedpool;

import java.util.Map;

import javassist.ClassPool;

public abstract interface ScopedClassPoolRepository {
    public abstract void clearUnregisteredClassLoaders();

    public abstract ScopedClassPool createScopedClassPool(ClassLoader paramClassLoader, ClassPool paramClassPool);

    public abstract ClassPool findClassPool(ClassLoader paramClassLoader);

    public abstract ScopedClassPoolFactory getClassPoolFactory();

    public abstract Map getRegisteredCLs();

    public abstract boolean isPrune();

    public abstract ClassPool registerClassLoader(ClassLoader paramClassLoader);

    public abstract void setClassPoolFactory(ScopedClassPoolFactory paramScopedClassPoolFactory);

    public abstract void setPrune(boolean paramBoolean);

    public abstract void unregisterClassLoader(ClassLoader paramClassLoader);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/scopedpool/ScopedClassPoolRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */