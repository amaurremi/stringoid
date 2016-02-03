package javassist.util.proxy;

import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;

public class ProxyObjectOutputStream
        extends ObjectOutputStream {
    public ProxyObjectOutputStream(OutputStream paramOutputStream) {
        super(paramOutputStream);
    }

    protected void writeClassDescriptor(ObjectStreamClass paramObjectStreamClass) {
        int i = 0;
        Object localObject = paramObjectStreamClass.forClass();
        if (ProxyFactory.isProxyClass((Class) localObject)) {
            writeBoolean(true);
            Class localClass = ((Class) localObject).getSuperclass();
            paramObjectStreamClass = ((Class) localObject).getInterfaces();
            localObject = ProxyFactory.getFilterSignature((Class) localObject);
            writeObject(localClass.getName());
            writeInt(paramObjectStreamClass.length - 1);
            while (i < paramObjectStreamClass.length) {
                localClass = paramObjectStreamClass[i];
                if ((localClass != ProxyObject.class) && (localClass != Proxy.class)) {
                    writeObject(paramObjectStreamClass[i].getName());
                }
                i += 1;
            }
            writeInt(localObject.length);
            write((byte[]) localObject);
            return;
        }
        writeBoolean(false);
        super.writeClassDescriptor(paramObjectStreamClass);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/proxy/ProxyObjectOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */