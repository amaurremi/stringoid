package javassist;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLClassPath
        implements ClassPath {
    protected String directory;
    protected String hostname;
    protected String packageName;
    protected int port;

    public URLClassPath(String paramString1, int paramInt, String paramString2, String paramString3) {
        this.hostname = paramString1;
        this.port = paramInt;
        this.directory = paramString2;
        this.packageName = paramString3;
    }

    public static byte[] fetchClass(String paramString1, int paramInt, String paramString2, String paramString3) {
        paramString1 = fetchClass0(paramString1, paramInt, paramString2 + paramString3.replace('.', '/') + ".class");
        int j = paramString1.getContentLength();
        paramString2 = paramString1.getInputStream();
        if (j <= 0) {
        }
        for (; ; ) {
            try {
                paramString1 = ClassPoolTail.readStream(paramString2);
                return paramString1;
            } finally {
                paramString2.close();
            }
            paramString1 = new byte[j];
            paramInt = 0;
            int i = paramString2.read(paramString1, paramInt, j - paramInt);
            if (i < 0) {
                throw new IOException("the stream was closed: " + paramString3);
            }
            i = paramInt + i;
            paramInt = i;
            if (i < j) {
            }
        }
    }

    private static URLConnection fetchClass0(String paramString1, int paramInt, String paramString2) {
        try {
            paramString1 = new URL("http", paramString1, paramInt, paramString2);
            paramString1 = paramString1.openConnection();
            paramString1.connect();
            return paramString1;
        } catch (MalformedURLException paramString1) {
            throw new IOException("invalid URL?");
        }
    }

    private URLConnection openClassfile0(String paramString) {
        if ((this.packageName == null) || (paramString.startsWith(this.packageName))) {
            paramString = this.directory + paramString.replace('.', '/') + ".class";
            return fetchClass0(this.hostname, this.port, paramString);
        }
        return null;
    }

    public void close() {
    }

    public URL find(String paramString) {
        try {
            paramString = openClassfile0(paramString);
            InputStream localInputStream = paramString.getInputStream();
            if (localInputStream != null) {
                localInputStream.close();
                paramString = paramString.getURL();
                return paramString;
            }
        } catch (IOException paramString) {
        }
        return null;
    }

    public InputStream openClassfile(String paramString) {
        try {
            paramString = openClassfile0(paramString);
            if (paramString != null) {
                paramString = paramString.getInputStream();
                return paramString;
            }
        } catch (IOException paramString) {
        }
        return null;
    }

    public String toString() {
        return this.hostname + ":" + this.port + this.directory;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/URLClassPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */