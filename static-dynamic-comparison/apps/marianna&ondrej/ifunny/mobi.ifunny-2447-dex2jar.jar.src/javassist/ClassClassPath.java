package javassist;

import java.io.InputStream;
import java.net.URL;

public class ClassClassPath
        implements ClassPath {
    private Class thisClass;

    ClassClassPath() {
        this(Object.class);
    }

    public ClassClassPath(Class paramClass) {
        this.thisClass = paramClass;
    }

    public void close() {
    }

    public URL find(String paramString) {
        paramString = "/" + paramString.replace('.', '/') + ".class";
        return this.thisClass.getResource(paramString);
    }

    public InputStream openClassfile(String paramString) {
        paramString = "/" + paramString.replace('.', '/') + ".class";
        return this.thisClass.getResourceAsStream(paramString);
    }

    public String toString() {
        return this.thisClass.getName() + ".class";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/ClassClassPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */