package javassist.scopedpool;

import java.lang.ref.WeakReference;
import java.security.ProtectionDomain;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.LoaderClassPath;
import javassist.NotFoundException;

public class ScopedClassPool
        extends ClassPool {
    protected WeakReference classLoader;
    protected LoaderClassPath classPath;
    boolean isBootstrapCl = true;
    protected ScopedClassPoolRepository repository;
    protected SoftValueHashMap softcache = new SoftValueHashMap();

    static {
        ClassPool.doPruning = false;
        ClassPool.releaseUnmodifiedClassFile = false;
    }

    protected ScopedClassPool(ClassLoader paramClassLoader, ClassPool paramClassPool, ScopedClassPoolRepository paramScopedClassPoolRepository) {
        this(paramClassLoader, paramClassPool, paramScopedClassPoolRepository, false);
    }

    protected ScopedClassPool(ClassLoader paramClassLoader, ClassPool paramClassPool, ScopedClassPoolRepository paramScopedClassPoolRepository, boolean paramBoolean) {
        super(paramClassPool);
        this.repository = paramScopedClassPoolRepository;
        this.classLoader = new WeakReference(paramClassLoader);
        if (paramClassLoader != null) {
            this.classPath = new LoaderClassPath(paramClassLoader);
            insertClassPath(this.classPath);
        }
        this.childFirstLookup = true;
        if ((!paramBoolean) && (paramClassLoader == null)) {
            this.isBootstrapCl = true;
        }
    }

    protected void cacheCtClass(String paramString, CtClass paramCtClass, boolean paramBoolean) {
        if (paramBoolean) {
            super.cacheCtClass(paramString, paramCtClass, paramBoolean);
            return;
        }
        if (this.repository.isPrune()) {
            paramCtClass.prune();
        }
        this.softcache.put(paramString, paramCtClass);
    }

    public void close() {
        removeClassPath(this.classPath);
        this.classPath.close();
        this.classes.clear();
        this.softcache.clear();
    }

    public void flushClass(String paramString) {
        try {
            this.classes.remove(paramString);
            this.softcache.remove(paramString);
            return;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    protected CtClass getCached(String paramString) {
        Object localObject2 = getCachedLocally(paramString);
        int i;
        Object localObject1;
        if (localObject2 == null) {
            ???=getClassLoader0();
            if (???==null){
                break label232;
            }
            i = paramString.lastIndexOf('$');
            if (i < 0) {
                localObject1 = paramString.replaceAll("[\\.]", "/") + ".class";
                if (((ClassLoader) ? ??).getResource((String) localObject1) == null){
                    break label203;
                }
                i = 1;
                label72:
                if (i != 0) {
                    break label229;
                }
            }
        }
        for (; ; ) {
            synchronized (this.repository.getRegisteredCLs()) {
                Iterator localIterator = ((Map) ? ??).values().iterator();
                localObject1 = localObject2;
                if (!localIterator.hasNext()) {
                    break label224;
                }
                localObject2 = (ScopedClassPool) localIterator.next();
                if (!((ScopedClassPool) localObject2).isUnloadedClassLoader()) {
                    break label208;
                }
                this.repository.unregisterClassLoader(((ScopedClassPool) localObject2).getClassLoader());
            }
            localObject1 = paramString.substring(0, i).replaceAll("[\\.]", "/") + paramString.substring(i) + ".class";
            break;
            label203:
            i = 0;
            break label72;
            label208:
            localObject1 = ((ScopedClassPool) localObject2).getCachedLocally(paramString);
            if (localObject1 != null) {
                return (CtClass) localObject1;
                label224:
                return (CtClass) localObject1;
                label229:
                return (CtClass) localObject2;
                label232:
                i = 0;
                break label72;
            }
        }
    }

    protected CtClass getCachedLocally(String paramString) {
        ???=(CtClass) this.classes.get(paramString);
        if (???!=null){
            return (CtClass) ???;
        }
        synchronized (this.softcache) {
            paramString = (CtClass) this.softcache.get(paramString);
            return paramString;
        }
    }

    public ClassLoader getClassLoader() {
        ClassLoader localClassLoader = getClassLoader0();
        if ((localClassLoader == null) && (!this.isBootstrapCl)) {
            throw new IllegalStateException("ClassLoader has been garbage collected");
        }
        return localClassLoader;
    }

    protected ClassLoader getClassLoader0() {
        return (ClassLoader) this.classLoader.get();
    }

    public CtClass getLocally(String paramString) {
        CtClass localCtClass1;
        try {
            this.softcache.remove(paramString);
            CtClass localCtClass2 = (CtClass) this.classes.get(paramString);
            localCtClass1 = localCtClass2;
            if (localCtClass2 != null) {
                break label61;
            }
            localCtClass1 = createCtClass(paramString, true);
            if (localCtClass1 == null) {
                throw new NotFoundException(paramString);
            }
        } finally {
        }
        super.cacheCtClass(paramString, localCtClass1, false);
        label61:
        return localCtClass1;
    }

    public boolean isUnloadedClassLoader() {
        return false;
    }

    public void lockInCache(CtClass paramCtClass) {
        super.cacheCtClass(paramCtClass.getName(), paramCtClass, false);
    }

    public void soften(CtClass paramCtClass) {
        try {
            if (this.repository.isPrune()) {
                paramCtClass.prune();
            }
            this.classes.remove(paramCtClass.getName());
            this.softcache.put(paramCtClass.getName(), paramCtClass);
            return;
        } finally {
        }
    }

    public Class toClass(CtClass paramCtClass, ClassLoader paramClassLoader, ProtectionDomain paramProtectionDomain) {
        lockInCache(paramCtClass);
        return super.toClass(paramCtClass, getClassLoader0(), paramProtectionDomain);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/scopedpool/ScopedClassPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */