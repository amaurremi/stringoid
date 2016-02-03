package javassist.tools.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;

public class Viewer
        extends ClassLoader {
    private int port;
    private String server;

    public Viewer(String paramString, int paramInt) {
        this.server = paramString;
        this.port = paramInt;
    }

    public static void main(String[] paramArrayOfString) {
        if (paramArrayOfString.length >= 3) {
            Viewer localViewer = new Viewer(paramArrayOfString[0], Integer.parseInt(paramArrayOfString[1]));
            String[] arrayOfString = new String[paramArrayOfString.length - 3];
            System.arraycopy(paramArrayOfString, 3, arrayOfString, 0, paramArrayOfString.length - 3);
            localViewer.run(paramArrayOfString[2], arrayOfString);
            return;
        }
        System.err.println("Usage: java javassist.tools.web.Viewer <host> <port> class [args ...]");
    }

    private byte[] readStream(InputStream paramInputStream) {
        Object localObject1 = new byte['က'];
        int i = 0;
        int j = 0;
        int k;
        Object localObject2;
        int m;
        do {
            k = i + j;
            localObject2 = localObject1;
            if (localObject1.length - k <= 0) {
                localObject2 = new byte[localObject1.length * 2];
                System.arraycopy(localObject1, 0, localObject2, 0, k);
            }
            m = paramInputStream.read((byte[]) localObject2, k, localObject2.length - k);
            j = m;
            i = k;
            localObject1 = localObject2;
        } while (m >= 0);
        paramInputStream = new byte[k];
        System.arraycopy(localObject2, 0, paramInputStream, 0, k);
        return paramInputStream;
    }

    protected byte[] fetchClass(String paramString) {
        Object localObject = new URL("http", this.server, this.port, "/" + paramString.replace('.', '/') + ".class").openConnection();
        ((URLConnection) localObject).connect();
        int k = ((URLConnection) localObject).getContentLength();
        InputStream localInputStream = ((URLConnection) localObject).getInputStream();
        if (k <= 0) {
        }
        for (paramString = readStream(localInputStream); ; paramString = (String) localObject) {
            localInputStream.close();
            return paramString;
            localObject = new byte[k];
            int i = 0;
            int j;
            do {
                j = localInputStream.read((byte[]) localObject, i, k - i);
                if (j < 0) {
                    localInputStream.close();
                    throw new IOException("the stream was closed: " + paramString);
                }
                j = i + j;
                i = j;
            } while (j < k);
        }
    }

    protected Class findClass(String paramString) {
        Class localClass1 = null;
        if ((paramString.startsWith("java.")) || (paramString.startsWith("javax.")) || (paramString.equals("javassist.tools.web.Viewer"))) {
            localClass1 = findSystemClass(paramString);
        }
        Class localClass2 = localClass1;
        if (localClass1 == null) {
        }
        try {
            byte[] arrayOfByte = fetchClass(paramString);
            localClass2 = localClass1;
            if (arrayOfByte != null) {
                localClass2 = defineClass(paramString, arrayOfByte, 0, arrayOfByte.length);
            }
            return localClass2;
        } catch (Exception paramString) {
        }
        return localClass1;
    }

    public int getPort() {
        return this.port;
    }

    public String getServer() {
        return this.server;
    }

    protected Class loadClass(String paramString, boolean paramBoolean) {
        Class localClass1;
        try {
            Class localClass2 = findLoadedClass(paramString);
            localClass1 = localClass2;
            if (localClass2 == null) {
                localClass1 = findClass(paramString);
            }
            if (localClass1 == null) {
                throw new ClassNotFoundException(paramString);
            }
        } finally {
        }
        if (paramBoolean) {
            resolveClass(localClass1);
        }
        return localClass1;
    }

    public void run(String paramString, String[] paramArrayOfString) {
        paramString = loadClass(paramString);
        try {
            paramString.getDeclaredMethod("main", new Class[]{String[].class}).invoke(null, new Object[]{paramArrayOfString});
            return;
        } catch (InvocationTargetException paramString) {
            throw paramString.getTargetException();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/web/Viewer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */