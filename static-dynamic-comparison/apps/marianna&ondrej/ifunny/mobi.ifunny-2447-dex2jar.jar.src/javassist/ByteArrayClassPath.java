package javassist;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ByteArrayClassPath
        implements ClassPath {
    protected byte[] classfile;
    protected String classname;

    public ByteArrayClassPath(String paramString, byte[] paramArrayOfByte) {
        this.classname = paramString;
        this.classfile = paramArrayOfByte;
    }

    public void close() {
    }

    public URL find(String paramString) {
        if (this.classname.equals(paramString)) {
            paramString = paramString.replace('.', '/') + ".class";
            try {
                paramString = new URL("file:/ByteArrayClassPath/" + paramString);
                return paramString;
            } catch (MalformedURLException paramString) {
            }
        }
        return null;
    }

    public InputStream openClassfile(String paramString) {
        if (this.classname.equals(paramString)) {
            return new ByteArrayInputStream(this.classfile);
        }
        return null;
    }

    public String toString() {
        return "byte[]:" + this.classname;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/ByteArrayClassPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */