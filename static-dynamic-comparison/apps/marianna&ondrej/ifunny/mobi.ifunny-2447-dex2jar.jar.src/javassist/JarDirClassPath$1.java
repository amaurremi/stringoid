package javassist;

import java.io.File;
import java.io.FilenameFilter;

class JarDirClassPath$1
        implements FilenameFilter {
    JarDirClassPath$1(JarDirClassPath paramJarDirClassPath) {
    }

    public boolean accept(File paramFile, String paramString) {
        paramFile = paramString.toLowerCase();
        return (paramFile.endsWith(".jar")) || (paramFile.endsWith(".zip"));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/JarDirClassPath$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */