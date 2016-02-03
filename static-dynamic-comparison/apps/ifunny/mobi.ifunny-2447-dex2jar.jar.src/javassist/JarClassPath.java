package javassist;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.jar.JarFile;

final class JarClassPath
        implements ClassPath {
    JarFile jarfile;
    String jarfileURL;

    JarClassPath(String paramString) {
        try {
            this.jarfile = new JarFile(paramString);
            this.jarfileURL = new File(paramString).getCanonicalFile().toURI().toURL().toString();
            return;
        } catch (IOException localIOException) {
            throw new NotFoundException(paramString);
        }
    }

    public void close() {
        try {
            this.jarfile.close();
            this.jarfile = null;
            return;
        } catch (IOException localIOException) {
        }
    }

    public URL find(String paramString) {
        paramString = paramString.replace('.', '/') + ".class";
        if (this.jarfile.getJarEntry(paramString) != null) {
            try {
                paramString = new URL("jar:" + this.jarfileURL + "!/" + paramString);
                return paramString;
            } catch (MalformedURLException paramString) {
            }
        }
        return null;
    }

    public InputStream openClassfile(String paramString) {
        try {
            paramString = paramString.replace('.', '/') + ".class";
            paramString = this.jarfile.getJarEntry(paramString);
            if (paramString != null) {
                paramString = this.jarfile.getInputStream(paramString);
                return paramString;
            }
            return null;
        } catch (IOException paramString) {
            throw new NotFoundException("broken jar file?: " + this.jarfile.getName());
        }
    }

    public String toString() {
        if (this.jarfile == null) {
            return "<null>";
        }
        return this.jarfile.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/JarClassPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */