package javassist.scopedpool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

import javassist.ClassPool;
import javassist.LoaderClassPath;

public class ScopedClassPoolRepositoryImpl
        implements ScopedClassPoolRepository {
    private static final ScopedClassPoolRepositoryImpl instance = new ScopedClassPoolRepositoryImpl();
    protected ClassPool classpool = ClassPool.getDefault();
    protected ScopedClassPoolFactory factory = new ScopedClassPoolFactoryImpl();
    private boolean prune = true;
    boolean pruneWhenCached;
    protected Map registeredCLs = Collections.synchronizedMap(new WeakHashMap());

    private ScopedClassPoolRepositoryImpl() {
        ClassLoader localClassLoader = Thread.currentThread().getContextClassLoader();
        this.classpool.insertClassPath(new LoaderClassPath(localClassLoader));
    }

    public static ScopedClassPoolRepository getInstance() {
        return instance;
    }

    public void clearUnregisteredClassLoaders() {
        ArrayList localArrayList = null;
        for (; ; ) {
            int i;
            synchronized (this.registeredCLs) {
                Iterator localIterator = this.registeredCLs.values().iterator();
                if (!localIterator.hasNext()) {
                    break label137;
                }
                Object localObject2 = (ScopedClassPool) localIterator.next();
                if (!((ScopedClassPool) localObject2).isUnloadedClassLoader()) {
                    break label134;
                }
                localIterator.remove();
                localObject2 = ((ScopedClassPool) localObject2).getClassLoader();
                if (localObject2 == null) {
                    break label134;
                }
                if (localArrayList == null) {
                    localArrayList = new ArrayList();
                    localArrayList.add(localObject2);
                    break label134;
                    if (i < localArrayList.size()) {
                        unregisterClassLoader((ClassLoader) localArrayList.get(i));
                        i += 1;
                        continue;
                    }
                    return;
                }
            }
            continue;
            label134:
            continue;
            label137:
            if (localObject1 != null) {
                i = 0;
            }
        }
    }

    public ScopedClassPool createScopedClassPool(ClassLoader paramClassLoader, ClassPool paramClassPool) {
        return this.factory.create(paramClassLoader, paramClassPool, this);
    }

    public ClassPool findClassPool(ClassLoader paramClassLoader) {
        if (paramClassLoader == null) {
            return registerClassLoader(ClassLoader.getSystemClassLoader());
        }
        return registerClassLoader(paramClassLoader);
    }

    public ScopedClassPoolFactory getClassPoolFactory() {
        return this.factory;
    }

    public Map getRegisteredCLs() {
        clearUnregisteredClassLoaders();
        return this.registeredCLs;
    }

    public void insertDelegate(ScopedClassPoolRepository paramScopedClassPoolRepository) {
    }

    public boolean isPrune() {
        return this.prune;
    }

    public ClassPool registerClassLoader(ClassLoader paramClassLoader) {
        synchronized (this.registeredCLs) {
            if (this.registeredCLs.containsKey(paramClassLoader)) {
                paramClassLoader = (ClassPool) this.registeredCLs.get(paramClassLoader);
                return paramClassLoader;
            }
            ScopedClassPool localScopedClassPool = createScopedClassPool(paramClassLoader, this.classpool);
            this.registeredCLs.put(paramClassLoader, localScopedClassPool);
            return localScopedClassPool;
        }
    }

    public void setClassPoolFactory(ScopedClassPoolFactory paramScopedClassPoolFactory) {
        this.factory = paramScopedClassPoolFactory;
    }

    public void setPrune(boolean paramBoolean) {
        this.prune = paramBoolean;
    }

    public void unregisterClassLoader(ClassLoader paramClassLoader) {
        synchronized (this.registeredCLs) {
            paramClassLoader = (ScopedClassPool) this.registeredCLs.remove(paramClassLoader);
            if (paramClassLoader != null) {
                paramClassLoader.close();
            }
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/scopedpool/ScopedClassPoolRepositoryImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */