package javassist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

final class DirClassPath
        implements ClassPath {
    String directory;

    DirClassPath(String paramString) {
        this.directory = paramString;
    }

    public void close() {
    }

    public URL find(String paramString) {
        char c = File.separatorChar;
        paramString = new File(this.directory + c + paramString.replace('.', c) + ".class");
        if (paramString.exists()) {
        }
        try {
            paramString = paramString.getCanonicalFile().toURI().toURL();
            return paramString;
        } catch (IOException paramString) {
            return null;
        } catch (MalformedURLException paramString) {
            for (; ; ) {
            }
        }
    }

    public InputStream openClassfile(String paramString) {
        try {
            char c = File.separatorChar;
            paramString = new FileInputStream((this.directory + c + paramString.replace('.', c) + ".class").toString());
            return paramString;
        } catch (SecurityException paramString) {
            return null;
        } catch (FileNotFoundException paramString) {
            for (; ; ) {
            }
        }
    }

    public String toString() {
        return this.directory;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/DirClassPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */