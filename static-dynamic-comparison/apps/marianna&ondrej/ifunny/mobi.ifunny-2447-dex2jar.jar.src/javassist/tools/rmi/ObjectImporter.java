package javassist.tools.rmi;

import java.applet.Applet;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.net.Socket;
import java.net.URL;

public class ObjectImporter
        implements Serializable {
    private static final Class[] proxyConstructorParamTypes = {ObjectImporter.class, Integer.TYPE};
    private final byte[] endofline = {13, 10};
    protected byte[] lookupCommand = "POST /lookup HTTP/1.0".getBytes();
    private int orgPort;
    private String orgServername;
    private int port;
    protected byte[] rmiCommand = "POST /rmi HTTP/1.0".getBytes();
    private String servername;

    public ObjectImporter(Applet paramApplet) {
        paramApplet = paramApplet.getCodeBase();
        String str = paramApplet.getHost();
        this.servername = str;
        this.orgServername = str;
        int i = paramApplet.getPort();
        this.port = i;
        this.orgPort = i;
    }

    public ObjectImporter(String paramString, int paramInt) {
        this.servername = paramString;
        this.orgServername = paramString;
        this.port = paramInt;
        this.orgPort = paramInt;
    }

    private Object createProxy(int paramInt, String paramString) {
        return Class.forName(paramString).getConstructor(proxyConstructorParamTypes).newInstance(new Object[]{this, new Integer(paramInt)});
    }

    private void skipHeader(InputStream paramInputStream) {
        int i;
        do {
            i = 0;
            for (; ; ) {
                int j = paramInputStream.read();
                if ((j < 0) || (j == 13)) {
                    break;
                }
                i += 1;
            }
            paramInputStream.read();
        } while (i > 0);
    }

    private void writeParameters(ObjectOutputStream paramObjectOutputStream, Object[] paramArrayOfObject) {
        int j = paramArrayOfObject.length;
        paramObjectOutputStream.writeInt(j);
        int i = 0;
        if (i < j) {
            if ((paramArrayOfObject[i] instanceof Proxy)) {
                paramObjectOutputStream.writeObject(new RemoteRef(((Proxy) paramArrayOfObject[i])._getObjectId()));
            }
            for (; ; ) {
                i += 1;
                break;
                paramObjectOutputStream.writeObject(paramArrayOfObject[i]);
            }
        }
    }

    public Object call(int paramInt1, int paramInt2, Object[] paramArrayOfObject) {
        Object localObject2 = null;
        boolean bool;
        try {
            Socket localSocket = new Socket(this.servername, this.port);
            Object localObject1 = new BufferedOutputStream(localSocket.getOutputStream());
            ((OutputStream) localObject1).write(this.rmiCommand);
            ((OutputStream) localObject1).write(this.endofline);
            ((OutputStream) localObject1).write(this.endofline);
            ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream) localObject1);
            localObjectOutputStream.writeInt(paramInt1);
            localObjectOutputStream.writeInt(paramInt2);
            writeParameters(localObjectOutputStream, paramArrayOfObject);
            localObjectOutputStream.flush();
            paramArrayOfObject = new BufferedInputStream(localSocket.getInputStream());
            skipHeader(paramArrayOfObject);
            ObjectInputStream localObjectInputStream = new ObjectInputStream(paramArrayOfObject);
            bool = localObjectInputStream.readBoolean();
            if (bool) {
                paramArrayOfObject = localObjectInputStream.readObject();
                localObject1 = null;
            }
            for (; ; ) {
                localObjectInputStream.close();
                localObjectOutputStream.close();
                localSocket.close();
                localObject2 = paramArrayOfObject;
                if (!(paramArrayOfObject instanceof RemoteRef)) {
                    break;
                }
                paramArrayOfObject = (RemoteRef) paramArrayOfObject;
                localObject2 = createProxy(paramArrayOfObject.oid, paramArrayOfObject.classname);
                break;
                localObject1 = localObjectInputStream.readUTF();
                paramArrayOfObject = (Object[]) localObject2;
            }
            throw new RemoteException((String) localObject1);
        } catch (ClassNotFoundException paramArrayOfObject) {
            throw new RemoteException(paramArrayOfObject);
        } catch (IOException paramArrayOfObject) {
            throw new RemoteException(paramArrayOfObject);
        } catch (Exception paramArrayOfObject) {
            throw new RemoteException(paramArrayOfObject);
        }
        while (!bool) {
        }
        return localObject2;
    }

    public Object getObject(String paramString) {
        try {
            paramString = lookupObject(paramString);
            return paramString;
        } catch (ObjectNotFoundException paramString) {
        }
        return null;
    }

    public Object lookupObject(String paramString) {
        try {
            Object localObject1 = new Socket(this.servername, this.port);
            Object localObject2 = ((Socket) localObject1).getOutputStream();
            ((OutputStream) localObject2).write(this.lookupCommand);
            ((OutputStream) localObject2).write(this.endofline);
            ((OutputStream) localObject2).write(this.endofline);
            localObject2 = new ObjectOutputStream((OutputStream) localObject2);
            ((ObjectOutputStream) localObject2).writeUTF(paramString);
            ((ObjectOutputStream) localObject2).flush();
            Object localObject3 = new BufferedInputStream(((Socket) localObject1).getInputStream());
            skipHeader((InputStream) localObject3);
            localObject3 = new ObjectInputStream((InputStream) localObject3);
            int i = ((ObjectInputStream) localObject3).readInt();
            String str = ((ObjectInputStream) localObject3).readUTF();
            ((ObjectInputStream) localObject3).close();
            ((ObjectOutputStream) localObject2).close();
            ((Socket) localObject1).close();
            if (i >= 0) {
                localObject1 = createProxy(i, str);
                return localObject1;
            }
        } catch (Exception localException) {
            localException.printStackTrace();
            throw new ObjectNotFoundException(paramString, localException);
        }
        throw new ObjectNotFoundException(paramString);
    }

    public void setHttpProxy(String paramString, int paramInt) {
        String str = "POST http://" + this.orgServername + ":" + this.orgPort;
        this.lookupCommand = (str + "/lookup HTTP/1.0").getBytes();
        this.rmiCommand = (str + "/rmi HTTP/1.0").getBytes();
        this.servername = paramString;
        this.port = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/rmi/ObjectImporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */