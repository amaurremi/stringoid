package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class AttributeInfo {
    protected ConstPool constPool;
    byte[] info;
    int name;

    protected AttributeInfo(ConstPool paramConstPool, int paramInt, DataInputStream paramDataInputStream) {
        this.constPool = paramConstPool;
        this.name = paramInt;
        paramInt = paramDataInputStream.readInt();
        this.info = new byte[paramInt];
        if (paramInt > 0) {
            paramDataInputStream.readFully(this.info);
        }
    }

    protected AttributeInfo(ConstPool paramConstPool, int paramInt, byte[] paramArrayOfByte) {
        this.constPool = paramConstPool;
        this.name = paramInt;
        this.info = paramArrayOfByte;
    }

    protected AttributeInfo(ConstPool paramConstPool, String paramString) {
        this(paramConstPool, paramString, (byte[]) null);
    }

    public AttributeInfo(ConstPool paramConstPool, String paramString, byte[] paramArrayOfByte) {
        this(paramConstPool, paramConstPool.addUtf8Info(paramString), paramArrayOfByte);
    }

    static ArrayList copyAll(ArrayList paramArrayList, ConstPool paramConstPool) {
        if (paramArrayList == null) {
            return null;
        }
        ArrayList localArrayList = new ArrayList();
        int j = paramArrayList.size();
        int i = 0;
        while (i < j) {
            localArrayList.add(((AttributeInfo) paramArrayList.get(i)).copy(paramConstPool, null));
            i += 1;
        }
        return localArrayList;
    }

    static int getLength(ArrayList paramArrayList) {
        int k = paramArrayList.size();
        int i = 0;
        int j = 0;
        while (i < k) {
            j += ((AttributeInfo) paramArrayList.get(i)).length();
            i += 1;
        }
        return j;
    }

    static void getRefClasses(List paramList, Map paramMap) {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            ((AttributeInfo) paramList.next()).getRefClasses(paramMap);
        }
    }

    static AttributeInfo lookup(ArrayList paramArrayList, String paramString) {
        if (paramArrayList == null) {
            return null;
        }
        paramArrayList = paramArrayList.listIterator();
        while (paramArrayList.hasNext()) {
            AttributeInfo localAttributeInfo = (AttributeInfo) paramArrayList.next();
            if (localAttributeInfo.getName().equals(paramString)) {
                return localAttributeInfo;
            }
        }
        return null;
    }

    static AttributeInfo read(ConstPool paramConstPool, DataInputStream paramDataInputStream) {
        int i = paramDataInputStream.readUnsignedShort();
        String str = paramConstPool.getUtf8Info(i);
        if (str.charAt(0) < 'L') {
            if (str.equals("AnnotationDefault")) {
                return new AnnotationDefaultAttribute(paramConstPool, i, paramDataInputStream);
            }
            if (str.equals("Code")) {
                return new CodeAttribute(paramConstPool, i, paramDataInputStream);
            }
            if (str.equals("ConstantValue")) {
                return new ConstantAttribute(paramConstPool, i, paramDataInputStream);
            }
            if (str.equals("Deprecated")) {
                return new DeprecatedAttribute(paramConstPool, i, paramDataInputStream);
            }
            if (str.equals("EnclosingMethod")) {
                return new EnclosingMethodAttribute(paramConstPool, i, paramDataInputStream);
            }
            if (str.equals("Exceptions")) {
                return new ExceptionsAttribute(paramConstPool, i, paramDataInputStream);
            }
            if (str.equals("InnerClasses")) {
                return new InnerClassesAttribute(paramConstPool, i, paramDataInputStream);
            }
        } else {
            if (str.equals("LineNumberTable")) {
                return new LineNumberAttribute(paramConstPool, i, paramDataInputStream);
            }
            if (str.equals("LocalVariableTable")) {
                return new LocalVariableAttribute(paramConstPool, i, paramDataInputStream);
            }
            if (str.equals("LocalVariableTypeTable")) {
                return new LocalVariableTypeAttribute(paramConstPool, i, paramDataInputStream);
            }
            if ((str.equals("RuntimeVisibleAnnotations")) || (str.equals("RuntimeInvisibleAnnotations"))) {
                return new AnnotationsAttribute(paramConstPool, i, paramDataInputStream);
            }
            if ((str.equals("RuntimeVisibleParameterAnnotations")) || (str.equals("RuntimeInvisibleParameterAnnotations"))) {
                return new ParameterAnnotationsAttribute(paramConstPool, i, paramDataInputStream);
            }
            if (str.equals("Signature")) {
                return new SignatureAttribute(paramConstPool, i, paramDataInputStream);
            }
            if (str.equals("SourceFile")) {
                return new SourceFileAttribute(paramConstPool, i, paramDataInputStream);
            }
            if (str.equals("Synthetic")) {
                return new SyntheticAttribute(paramConstPool, i, paramDataInputStream);
            }
            if (str.equals("StackMap")) {
                return new StackMap(paramConstPool, i, paramDataInputStream);
            }
            if (str.equals("StackMapTable")) {
                return new StackMapTable(paramConstPool, i, paramDataInputStream);
            }
        }
        return new AttributeInfo(paramConstPool, i, paramDataInputStream);
    }

    /* Error */
    static void remove(ArrayList paramArrayList, String paramString) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: aload_0
        //   4: ifnonnull +7 -> 11
        //   7: ldc 2
        //   9: monitorexit
        //   10: return
        //   11: aload_0
        //   12: invokevirtual 98	java/util/ArrayList:listIterator	()Ljava/util/ListIterator;
        //   15: astore_0
        //   16: aload_0
        //   17: invokeinterface 101 1 0
        //   22: ifeq -15 -> 7
        //   25: aload_0
        //   26: invokeinterface 102 1 0
        //   31: checkcast 2	javassist/bytecode/AttributeInfo
        //   34: invokevirtual 106	javassist/bytecode/AttributeInfo:getName	()Ljava/lang/String;
        //   37: aload_1
        //   38: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   41: ifeq -25 -> 16
        //   44: aload_0
        //   45: invokeinterface 218 1 0
        //   50: goto -34 -> 16
        //   53: astore_0
        //   54: ldc 2
        //   56: monitorexit
        //   57: aload_0
        //   58: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	59	0	paramArrayList	ArrayList
        //   0	59	1	paramString	String
        // Exception table:
        //   from	to	target	type
        //   11	16	53	finally
        //   16	50	53	finally
    }

    static void renameClass(List paramList, String paramString1, String paramString2) {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            ((AttributeInfo) paramList.next()).renameClass(paramString1, paramString2);
        }
    }

    static void renameClass(List paramList, Map paramMap) {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            ((AttributeInfo) paramList.next()).renameClass(paramMap);
        }
    }

    static void writeAll(ArrayList paramArrayList, DataOutputStream paramDataOutputStream) {
        if (paramArrayList == null) {
        }
        for (; ; ) {
            return;
            int j = paramArrayList.size();
            int i = 0;
            while (i < j) {
                ((AttributeInfo) paramArrayList.get(i)).write(paramDataOutputStream);
                i += 1;
            }
        }
    }

    public AttributeInfo copy(ConstPool paramConstPool, Map paramMap) {
        int j = this.info.length;
        paramMap = this.info;
        byte[] arrayOfByte = new byte[j];
        int i = 0;
        while (i < j) {
            arrayOfByte[i] = paramMap[i];
            i += 1;
        }
        return new AttributeInfo(paramConstPool, getName(), arrayOfByte);
    }

    public byte[] get() {
        return this.info;
    }

    public ConstPool getConstPool() {
        return this.constPool;
    }

    public String getName() {
        return this.constPool.getUtf8Info(this.name);
    }

    void getRefClasses(Map paramMap) {
    }

    public int length() {
        return this.info.length + 6;
    }

    void renameClass(String paramString1, String paramString2) {
    }

    void renameClass(Map paramMap) {
    }

    public void set(byte[] paramArrayOfByte) {
        this.info = paramArrayOfByte;
    }

    void write(DataOutputStream paramDataOutputStream) {
        paramDataOutputStream.writeShort(this.name);
        paramDataOutputStream.writeInt(this.info.length);
        if (this.info.length > 0) {
            paramDataOutputStream.write(this.info);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/AttributeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */