package javassist;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

final class JarDirClassPath
        implements ClassPath {
    JarClassPath[] jars;

    JarDirClassPath(String paramString) {
        paramString = new File(paramString).listFiles(new JarDirClassPath .1 (this));
        if (paramString != null) {
            this.jars = new JarClassPath[paramString.length];
            int i = 0;
            while (i < paramString.length) {
                this.jars[i] = new JarClassPath(paramString[i].getPath());
                i += 1;
            }
        }
    }

    public void close() {
        if (this.jars != null) {
            int i = 0;
            while (i < this.jars.length) {
                this.jars[i].close();
                i += 1;
            }
        }
    }

    public URL find(String paramString) {
        if (this.jars != null) {
            int i = 0;
            while (i < this.jars.length) {
                URL localURL = this.jars[i].find(paramString);
                if (localURL != null) {
                    return localURL;
                }
                i += 1;
            }
        }
        return null;
    }

    public InputStream openClassfile(String paramString) {
        if (this.jars != null) {
            int i = 0;
            while (i < this.jars.length) {
                InputStream localInputStream = this.jars[i].openClassfile(paramString);
                if (localInputStream != null) {
                    return localInputStream;
                }
                i += 1;
            }
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/JarDirClassPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */