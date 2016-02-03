package javassist.tools.rmi;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Vector;

import javassist.ClassPool;
import javassist.tools.web.Webserver;

public class AppletServer
        extends Webserver {
    private static final byte[] okHeader = "HTTP/1.0 200 OK\r\n\r\n".getBytes();
    private Hashtable exportedNames = new Hashtable();
    private Vector exportedObjects = new Vector();
    private StubGenerator stubGen;

    public AppletServer(int paramInt) {
        this(ClassPool.getDefault(), new StubGenerator(), paramInt);
    }

    public AppletServer(int paramInt, ClassPool paramClassPool) {
        this(new ClassPool(paramClassPool), new StubGenerator(), paramInt);
    }

    public AppletServer(String paramString) {
        this(Integer.parseInt(paramString));
    }

    private AppletServer(ClassPool paramClassPool, StubGenerator paramStubGenerator, int paramInt) {
        super(paramInt);
        this.stubGen = paramStubGenerator;
        addTranslator(paramClassPool, paramStubGenerator);
    }

    private Object convertRvalue(Object paramObject) {
        Object localObject;
        if (paramObject == null) {
            localObject = null;
        }
        String str;
        do {
            return localObject;
            str = paramObject.getClass().getName();
            localObject = paramObject;
        } while (!this.stubGen.isProxyClass(str));
        return new RemoteRef(exportObject(null, paramObject), str);
    }

    private void lookupName(String paramString, InputStream paramInputStream, OutputStream paramOutputStream) {
        paramString = new ObjectInputStream(paramInputStream);
        paramInputStream = DataInputStream.readUTF(paramString);
        ExportedObject localExportedObject = (ExportedObject) this.exportedNames.get(paramInputStream);
        paramOutputStream.write(okHeader);
        paramOutputStream = new ObjectOutputStream(paramOutputStream);
        if (localExportedObject == null) {
            logging2(paramInputStream + "not found.");
            paramOutputStream.writeInt(-1);
            paramOutputStream.writeUTF("error");
        }
        for (; ; ) {
            paramOutputStream.flush();
            paramOutputStream.close();
            paramString.close();
            return;
            logging2(paramInputStream);
            paramOutputStream.writeInt(localExportedObject.identifier);
            paramOutputStream.writeUTF(localExportedObject.object.getClass().getName());
        }
    }

    private void processRMI(InputStream paramInputStream, OutputStream paramOutputStream) {
        Object localObject = null;
        ObjectInputStream localObjectInputStream = new ObjectInputStream(paramInputStream);
        int i = localObjectInputStream.readInt();
        int j = localObjectInputStream.readInt();
        try {
            paramInputStream = (ExportedObject) this.exportedObjects.elementAt(i);
            Object[] arrayOfObject = readParameters(localObjectInputStream);
            paramInputStream = convertRvalue(paramInputStream.methods[j].invoke(paramInputStream.object, arrayOfObject));
            paramOutputStream.write(okHeader);
            paramOutputStream = new ObjectOutputStream(paramOutputStream);
            if (localObject != null) {
                paramOutputStream.writeBoolean(false);
                paramOutputStream.writeUTF(((Exception) localObject).toString());
                paramOutputStream.flush();
                paramOutputStream.close();
                localObjectInputStream.close();
                return;
            }
        } catch (Exception localException) {
            for (; ; ) {
                logging2(localException.toString());
                paramInputStream = null;
                continue;
                try {
                    paramOutputStream.writeBoolean(true);
                    paramOutputStream.writeObject(paramInputStream);
                } catch (NotSerializableException paramInputStream) {
                    logging2(paramInputStream.toString());
                } catch (InvalidClassException paramInputStream) {
                    logging2(paramInputStream.toString());
                }
            }
        }
    }

    private Object[] readParameters(ObjectInputStream paramObjectInputStream) {
        int j = paramObjectInputStream.readInt();
        Object[] arrayOfObject = new Object[j];
        int i = 0;
        while (i < j) {
            Object localObject2 = paramObjectInputStream.readObject();
            Object localObject1 = localObject2;
            if ((localObject2 instanceof RemoteRef)) {
                localObject1 = (RemoteRef) localObject2;
                localObject1 = ((ExportedObject) this.exportedObjects.elementAt(((RemoteRef) localObject1).oid)).object;
            }
            arrayOfObject[i] = localObject1;
            i += 1;
        }
        return arrayOfObject;
    }

    public void doReply(InputStream paramInputStream, OutputStream paramOutputStream, String paramString) {
        if (paramString.startsWith("POST /rmi ")) {
            processRMI(paramInputStream, paramOutputStream);
            return;
        }
        if (paramString.startsWith("POST /lookup ")) {
            lookupName(paramString, paramInputStream, paramOutputStream);
            return;
        }
        super.doReply(paramInputStream, paramOutputStream, paramString);
    }

    /* Error */
    public int exportObject(String paramString, Object paramObject) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_2
        //   3: invokevirtual 78	java/lang/Object:getClass	()Ljava/lang/Class;
        //   6: astore 4
        //   8: new 115	javassist/tools/rmi/ExportedObject
        //   11: dup
        //   12: invokespecial 232	javassist/tools/rmi/ExportedObject:<init>	()V
        //   15: astore 5
        //   17: aload 5
        //   19: aload_2
        //   20: putfield 164	javassist/tools/rmi/ExportedObject:object	Ljava/lang/Object;
        //   23: aload 5
        //   25: aload 4
        //   27: invokevirtual 236	java/lang/Class:getMethods	()[Ljava/lang/reflect/Method;
        //   30: putfield 188	javassist/tools/rmi/ExportedObject:methods	[Ljava/lang/reflect/Method;
        //   33: aload_0
        //   34: getfield 64	javassist/tools/rmi/AppletServer:exportedObjects	Ljava/util/Vector;
        //   37: aload 5
        //   39: invokevirtual 239	java/util/Vector:addElement	(Ljava/lang/Object;)V
        //   42: aload 5
        //   44: aload_0
        //   45: getfield 64	javassist/tools/rmi/AppletServer:exportedObjects	Ljava/util/Vector;
        //   48: invokevirtual 242	java/util/Vector:size	()I
        //   51: iconst_1
        //   52: isub
        //   53: putfield 160	javassist/tools/rmi/ExportedObject:identifier	I
        //   56: aload_1
        //   57: ifnull +14 -> 71
        //   60: aload_0
        //   61: getfield 59	javassist/tools/rmi/AppletServer:exportedNames	Ljava/util/Hashtable;
        //   64: aload_1
        //   65: aload 5
        //   67: invokevirtual 246	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   70: pop
        //   71: aload_0
        //   72: getfield 66	javassist/tools/rmi/AppletServer:stubGen	Ljavassist/tools/rmi/StubGenerator;
        //   75: aload 4
        //   77: invokevirtual 250	javassist/tools/rmi/StubGenerator:makeProxyClass	(Ljava/lang/Class;)Z
        //   80: pop
        //   81: aload 5
        //   83: getfield 160	javassist/tools/rmi/ExportedObject:identifier	I
        //   86: istore_3
        //   87: aload_0
        //   88: monitorexit
        //   89: iload_3
        //   90: ireturn
        //   91: astore_1
        //   92: new 252	javassist/CannotCompileException
        //   95: dup
        //   96: aload_1
        //   97: invokespecial 255	javassist/CannotCompileException:<init>	(Ljavassist/NotFoundException;)V
        //   100: athrow
        //   101: astore_1
        //   102: aload_0
        //   103: monitorexit
        //   104: aload_1
        //   105: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	106	0	this	AppletServer
        //   0	106	1	paramString	String
        //   0	106	2	paramObject	Object
        //   86	4	3	i	int
        //   6	70	4	localClass	Class
        //   15	67	5	localExportedObject	ExportedObject
        // Exception table:
        //   from	to	target	type
        //   71	81	91	javassist/NotFoundException
        //   2	56	101	finally
        //   60	71	101	finally
        //   71	81	101	finally
        //   81	87	101	finally
        //   92	101	101	finally
    }

    public void run() {
        super.run();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/rmi/AppletServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */