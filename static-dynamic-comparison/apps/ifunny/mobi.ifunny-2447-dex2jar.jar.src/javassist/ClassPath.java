package javassist;

import java.io.InputStream;
import java.net.URL;

public abstract interface ClassPath {
    public abstract void close();

    public abstract URL find(String paramString);

    public abstract InputStream openClassfile(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/ClassPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */