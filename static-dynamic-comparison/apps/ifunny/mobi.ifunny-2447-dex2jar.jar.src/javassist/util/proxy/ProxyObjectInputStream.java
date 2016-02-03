package javassist.util.proxy;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class ProxyObjectInputStream
        extends ObjectInputStream {
    private ClassLoader loader = Thread.currentThread().getContextClassLoader();

    public ProxyObjectInputStream(InputStream paramInputStream) {
        super(paramInputStream);
        if (this.loader == null) {
            this.loader = ClassLoader.getSystemClassLoader();
        }
    }

    protected ObjectStreamClass readClassDescriptor() {
        if (readBoolean()) {
            Object localObject1 = (String) readObject();
            localObject1 = this.loader.loadClass((String) localObject1);
            int j = readInt();
            Class[] arrayOfClass = new Class[j];
            int i = 0;
            while (i < j) {
                localObject2 = (String) readObject();
                arrayOfClass[i] = this.loader.loadClass((String) localObject2);
                i += 1;
            }
            Object localObject2 = new byte[readInt()];
            read((byte[]) localObject2);
            ProxyFactory localProxyFactory = new ProxyFactory();
            localProxyFactory.setUseCache(true);
            localProxyFactory.setUseWriteReplace(false);
            localProxyFactory.setSuperclass((Class) localObject1);
            localProxyFactory.setInterfaces(arrayOfClass);
            return ObjectStreamClass.lookup(localProxyFactory.createClass((byte[]) localObject2));
        }
        return super.readClassDescriptor();
    }

    public void setClassLoader(ClassLoader paramClassLoader) {
        if (paramClassLoader != null) {
            this.loader = paramClassLoader;
            return;
        }
        ClassLoader.getSystemClassLoader();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/proxy/ProxyObjectInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */