package javassist;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;

public class LoaderClassPath
        implements ClassPath {
    private WeakReference clref;

    public LoaderClassPath(ClassLoader paramClassLoader) {
        this.clref = new WeakReference(paramClassLoader);
    }

    public void close() {
        this.clref = null;
    }

    public URL find(String paramString) {
        paramString = paramString.replace('.', '/') + ".class";
        ClassLoader localClassLoader = (ClassLoader) this.clref.get();
        if (localClassLoader == null) {
            return null;
        }
        return localClassLoader.getResource(paramString);
    }

    public InputStream openClassfile(String paramString) {
        paramString = paramString.replace('.', '/') + ".class";
        ClassLoader localClassLoader = (ClassLoader) this.clref.get();
        if (localClassLoader == null) {
            return null;
        }
        return localClassLoader.getResourceAsStream(paramString);
    }

    public String toString() {
        Object localObject = null;
        if (this.clref != null) {
            localObject = this.clref.get();
        }
        if (localObject == null) {
            return "<null>";
        }
        return localObject.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/LoaderClassPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */