package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javassist.CannotCompileException;

public final class ClassFile {
    public static final int JAVA_1 = 45;
    public static final int JAVA_2 = 46;
    public static final int JAVA_3 = 47;
    public static final int JAVA_4 = 48;
    public static final int JAVA_5 = 49;
    public static final int JAVA_6 = 50;
    public static final int JAVA_7 = 51;
    public static int MAJOR_VERSION = 47;
    int accessFlags;
    ArrayList attributes;
    String[] cachedInterfaces;
    String cachedSuperclass;
    ConstPool constPool;
    ArrayList fields;
    int[] interfaces;
    int major;
    ArrayList methods;
    int minor;
    int superClass;
    int thisClass;
    String thisclassname;

    static {
        try {
            Class.forName("java.lang.StringBuilder");
            MAJOR_VERSION = 49;
            Class.forName("java.util.zip.DeflaterInputStream");
            MAJOR_VERSION = 50;
            return;
        } catch (Throwable localThrowable) {
        }
    }

    public ClassFile(DataInputStream paramDataInputStream) {
        read(paramDataInputStream);
    }

    public ClassFile(boolean paramBoolean, String paramString1, String paramString2) {
        this.major = MAJOR_VERSION;
        this.minor = 0;
        this.constPool = new ConstPool(paramString1);
        this.thisClass = this.constPool.getThisClassInfo();
        if (paramBoolean) {
        }
        for (this.accessFlags = 1536; ; this.accessFlags = 32) {
            initSuperclass(paramString2);
            this.interfaces = null;
            this.fields = new ArrayList();
            this.methods = new ArrayList();
            this.thisclassname = paramString1;
            this.attributes = new ArrayList();
            this.attributes.add(new SourceFileAttribute(this.constPool, getSourcefileName(this.thisclassname)));
            return;
        }
    }

    private ConstPool compact0() {
        ConstPool localConstPool = new ConstPool(this.thisclassname);
        this.thisClass = localConstPool.getThisClassInfo();
        if (getSuperclass() != null) {
            this.superClass = localConstPool.addClassInfo(getSuperclass());
        }
        if (this.interfaces != null) {
            int j = this.interfaces.length;
            int i = 0;
            while (i < j) {
                this.interfaces[i] = localConstPool.addClassInfo(this.constPool.getClassInfo(this.interfaces[i]));
                i += 1;
            }
        }
        return localConstPool;
    }

    private static String getSourcefileName(String paramString) {
        int i = paramString.lastIndexOf('.');
        String str = paramString;
        if (i >= 0) {
            str = paramString.substring(i + 1);
        }
        return str + ".java";
    }

    private void initSuperclass(String paramString) {
        if (paramString != null) {
            this.superClass = this.constPool.addClassInfo(paramString);
            this.cachedSuperclass = paramString;
            return;
        }
        this.superClass = this.constPool.addClassInfo("java.lang.Object");
        this.cachedSuperclass = "java.lang.Object";
    }

    private static boolean isDuplicated(MethodInfo paramMethodInfo1, String paramString1, String paramString2, MethodInfo paramMethodInfo2, ListIterator paramListIterator) {
        boolean bool = true;
        if (!paramMethodInfo2.getName().equals(paramString1)) {
        }
        do {
            return false;
            paramString1 = paramMethodInfo2.getDescriptor();
        } while (!Descriptor.eqParamTypes(paramString1, paramString2));
        if (paramString1.equals(paramString2)) {
            if (notBridgeMethod(paramMethodInfo2)) {
                return true;
            }
            paramListIterator.remove();
            return false;
        }
        if ((notBridgeMethod(paramMethodInfo2)) && (notBridgeMethod(paramMethodInfo1))) {
        }
        for (; ; ) {
            return bool;
            bool = false;
        }
    }

    private static boolean notBridgeMethod(MethodInfo paramMethodInfo) {
        return (paramMethodInfo.getAccessFlags() & 0x40) == 0;
    }

    private void read(DataInputStream paramDataInputStream) {
        int j = 0;
        int i = paramDataInputStream.readInt();
        if (i != -889275714) {
            throw new IOException("bad magic number: " + Integer.toHexString(i));
        }
        this.minor = paramDataInputStream.readUnsignedShort();
        this.major = paramDataInputStream.readUnsignedShort();
        this.constPool = new ConstPool(paramDataInputStream);
        this.accessFlags = paramDataInputStream.readUnsignedShort();
        this.thisClass = paramDataInputStream.readUnsignedShort();
        this.constPool.setThisClassInfo(this.thisClass);
        this.superClass = paramDataInputStream.readUnsignedShort();
        int k = paramDataInputStream.readUnsignedShort();
        if (k == 0) {
            this.interfaces = null;
        }
        ConstPool localConstPool;
        for (; ; ) {
            localConstPool = this.constPool;
            k = paramDataInputStream.readUnsignedShort();
            this.fields = new ArrayList();
            i = 0;
            while (i < k) {
                addField2(new FieldInfo(localConstPool, paramDataInputStream));
                i += 1;
            }
            this.interfaces = new int[k];
            i = 0;
            while (i < k) {
                this.interfaces[i] = paramDataInputStream.readUnsignedShort();
                i += 1;
            }
        }
        k = paramDataInputStream.readUnsignedShort();
        this.methods = new ArrayList();
        i = 0;
        while (i < k) {
            addMethod2(new MethodInfo(localConstPool, paramDataInputStream));
            i += 1;
        }
        this.attributes = new ArrayList();
        k = paramDataInputStream.readUnsignedShort();
        i = j;
        while (i < k) {
            addAttribute(AttributeInfo.read(localConstPool, paramDataInputStream));
            i += 1;
        }
        this.thisclassname = this.constPool.getClassInfo(this.thisClass);
    }

    private void testExistingField(String paramString1, String paramString2) {
        paramString2 = this.fields.listIterator(0);
        while (paramString2.hasNext()) {
            if (((FieldInfo) paramString2.next()).getName().equals(paramString1)) {
                throw new DuplicateMemberException("duplicate field: " + paramString1);
            }
        }
    }

    private void testExistingMethod(MethodInfo paramMethodInfo) {
        String str1 = paramMethodInfo.getName();
        String str2 = paramMethodInfo.getDescriptor();
        ListIterator localListIterator = this.methods.listIterator(0);
        while (localListIterator.hasNext()) {
            if (isDuplicated(paramMethodInfo, str1, str2, (MethodInfo) localListIterator.next(), localListIterator)) {
                throw new DuplicateMemberException("duplicate method: " + str1 + " in " + getName());
            }
        }
    }

    public void addAttribute(AttributeInfo paramAttributeInfo) {
        AttributeInfo.remove(this.attributes, paramAttributeInfo.getName());
        this.attributes.add(paramAttributeInfo);
    }

    public void addField(FieldInfo paramFieldInfo) {
        testExistingField(paramFieldInfo.getName(), paramFieldInfo.getDescriptor());
        this.fields.add(paramFieldInfo);
    }

    public final void addField2(FieldInfo paramFieldInfo) {
        this.fields.add(paramFieldInfo);
    }

    public void addInterface(String paramString) {
        this.cachedInterfaces = null;
        int i = this.constPool.addClassInfo(paramString);
        if (this.interfaces == null) {
            this.interfaces = new int[1];
            this.interfaces[0] = i;
            return;
        }
        int j = this.interfaces.length;
        paramString = new int[j + 1];
        System.arraycopy(this.interfaces, 0, paramString, 0, j);
        paramString[j] = i;
        this.interfaces = paramString;
    }

    public void addMethod(MethodInfo paramMethodInfo) {
        testExistingMethod(paramMethodInfo);
        this.methods.add(paramMethodInfo);
    }

    public final void addMethod2(MethodInfo paramMethodInfo) {
        this.methods.add(paramMethodInfo);
    }

    public void compact() {
        int j = 0;
        ConstPool localConstPool = compact0();
        ArrayList localArrayList = this.methods;
        int k = localArrayList.size();
        int i = 0;
        while (i < k) {
            ((MethodInfo) localArrayList.get(i)).compact(localConstPool);
            i += 1;
        }
        localArrayList = this.fields;
        k = localArrayList.size();
        i = j;
        while (i < k) {
            ((FieldInfo) localArrayList.get(i)).compact(localConstPool);
            i += 1;
        }
        this.attributes = AttributeInfo.copyAll(this.attributes, localConstPool);
        this.constPool = localConstPool;
    }

    public int getAccessFlags() {
        return this.accessFlags;
    }

    public AttributeInfo getAttribute(String paramString) {
        ArrayList localArrayList = this.attributes;
        int j = localArrayList.size();
        int i = 0;
        while (i < j) {
            AttributeInfo localAttributeInfo = (AttributeInfo) localArrayList.get(i);
            if (localAttributeInfo.getName().equals(paramString)) {
                return localAttributeInfo;
            }
            i += 1;
        }
        return null;
    }

    public List getAttributes() {
        return this.attributes;
    }

    public ConstPool getConstPool() {
        return this.constPool;
    }

    public List getFields() {
        return this.fields;
    }

    public int getInnerAccessFlags() {
        InnerClassesAttribute localInnerClassesAttribute = (InnerClassesAttribute) getAttribute("InnerClasses");
        if (localInnerClassesAttribute == null) {
            return -1;
        }
        String str = getName();
        int j = localInnerClassesAttribute.tableLength();
        int i = 0;
        while (i < j) {
            if (str.equals(localInnerClassesAttribute.innerClass(i))) {
                return localInnerClassesAttribute.accessFlags(i);
            }
            i += 1;
        }
        return -1;
    }

    public String[] getInterfaces() {
        int i = 0;
        if (this.cachedInterfaces != null) {
            return this.cachedInterfaces;
        }
        Object localObject;
        if (this.interfaces == null) {
            localObject = new String[0];
            this.cachedInterfaces = ((String[]) localObject);
            return (String[]) localObject;
        }
        int j = this.interfaces.length;
        String[] arrayOfString = new String[j];
        for (; ; ) {
            localObject = arrayOfString;
            if (i >= j) {
                break;
            }
            arrayOfString[i] = this.constPool.getClassInfo(this.interfaces[i]);
            i += 1;
        }
    }

    public int getMajorVersion() {
        return this.major;
    }

    public MethodInfo getMethod(String paramString) {
        ArrayList localArrayList = this.methods;
        int j = localArrayList.size();
        int i = 0;
        while (i < j) {
            MethodInfo localMethodInfo = (MethodInfo) localArrayList.get(i);
            if (localMethodInfo.getName().equals(paramString)) {
                return localMethodInfo;
            }
            i += 1;
        }
        return null;
    }

    public List getMethods() {
        return this.methods;
    }

    public int getMinorVersion() {
        return this.minor;
    }

    public String getName() {
        return this.thisclassname;
    }

    public final void getRefClasses(Map paramMap) {
        int j = 0;
        this.constPool.renameClass(paramMap);
        AttributeInfo.getRefClasses(this.attributes, paramMap);
        ArrayList localArrayList = this.methods;
        int k = localArrayList.size();
        int i = 0;
        Object localObject;
        while (i < k) {
            localObject = (MethodInfo) localArrayList.get(i);
            Descriptor.rename(((MethodInfo) localObject).getDescriptor(), paramMap);
            AttributeInfo.getRefClasses(((MethodInfo) localObject).getAttributes(), paramMap);
            i += 1;
        }
        localArrayList = this.fields;
        k = localArrayList.size();
        i = j;
        while (i < k) {
            localObject = (FieldInfo) localArrayList.get(i);
            Descriptor.rename(((FieldInfo) localObject).getDescriptor(), paramMap);
            AttributeInfo.getRefClasses(((FieldInfo) localObject).getAttributes(), paramMap);
            i += 1;
        }
    }

    public String getSourceFile() {
        SourceFileAttribute localSourceFileAttribute = (SourceFileAttribute) getAttribute("SourceFile");
        if (localSourceFileAttribute == null) {
            return null;
        }
        return localSourceFileAttribute.getFileName();
    }

    public MethodInfo getStaticInitializer() {
        return getMethod("<clinit>");
    }

    public String getSuperclass() {
        if (this.cachedSuperclass == null) {
            this.cachedSuperclass = this.constPool.getClassInfo(this.superClass);
        }
        return this.cachedSuperclass;
    }

    public int getSuperclassId() {
        return this.superClass;
    }

    public boolean isAbstract() {
        return (this.accessFlags & 0x400) != 0;
    }

    public boolean isFinal() {
        return (this.accessFlags & 0x10) != 0;
    }

    public boolean isInterface() {
        return (this.accessFlags & 0x200) != 0;
    }

    public void prune() {
        int j = 0;
        ConstPool localConstPool = compact0();
        ArrayList localArrayList = new ArrayList();
        Object localObject = getAttribute("RuntimeInvisibleAnnotations");
        if (localObject != null) {
            localArrayList.add(((AttributeInfo) localObject).copy(localConstPool, null));
        }
        localObject = getAttribute("RuntimeVisibleAnnotations");
        if (localObject != null) {
            localArrayList.add(((AttributeInfo) localObject).copy(localConstPool, null));
        }
        localObject = getAttribute("Signature");
        if (localObject != null) {
            localArrayList.add(((AttributeInfo) localObject).copy(localConstPool, null));
        }
        localObject = this.methods;
        int k = ((ArrayList) localObject).size();
        int i = 0;
        while (i < k) {
            ((MethodInfo) ((ArrayList) localObject).get(i)).prune(localConstPool);
            i += 1;
        }
        localObject = this.fields;
        k = ((ArrayList) localObject).size();
        i = j;
        while (i < k) {
            ((FieldInfo) ((ArrayList) localObject).get(i)).prune(localConstPool);
            i += 1;
        }
        this.attributes = localArrayList;
        this.constPool = localConstPool;
    }

    public final void renameClass(String paramString1, String paramString2) {
        int j = 0;
        if (paramString1.equals(paramString2)) {
        }
        for (; ; ) {
            return;
            if (paramString1.equals(this.thisclassname)) {
                this.thisclassname = paramString2;
            }
            paramString1 = Descriptor.toJvmName(paramString1);
            paramString2 = Descriptor.toJvmName(paramString2);
            this.constPool.renameClass(paramString1, paramString2);
            AttributeInfo.renameClass(this.attributes, paramString1, paramString2);
            ArrayList localArrayList = this.methods;
            int k = localArrayList.size();
            int i = 0;
            Object localObject;
            while (i < k) {
                localObject = (MethodInfo) localArrayList.get(i);
                ((MethodInfo) localObject).setDescriptor(Descriptor.rename(((MethodInfo) localObject).getDescriptor(), paramString1, paramString2));
                AttributeInfo.renameClass(((MethodInfo) localObject).getAttributes(), paramString1, paramString2);
                i += 1;
            }
            localArrayList = this.fields;
            k = localArrayList.size();
            i = j;
            while (i < k) {
                localObject = (FieldInfo) localArrayList.get(i);
                ((FieldInfo) localObject).setDescriptor(Descriptor.rename(((FieldInfo) localObject).getDescriptor(), paramString1, paramString2));
                AttributeInfo.renameClass(((FieldInfo) localObject).getAttributes(), paramString1, paramString2);
                i += 1;
            }
        }
    }

    public final void renameClass(Map paramMap) {
        int j = 0;
        Object localObject1 = (String) paramMap.get(Descriptor.toJvmName(this.thisclassname));
        if (localObject1 != null) {
            this.thisclassname = Descriptor.toJavaName((String) localObject1);
        }
        this.constPool.renameClass(paramMap);
        AttributeInfo.renameClass(this.attributes, paramMap);
        localObject1 = this.methods;
        int k = ((ArrayList) localObject1).size();
        int i = 0;
        Object localObject2;
        while (i < k) {
            localObject2 = (MethodInfo) ((ArrayList) localObject1).get(i);
            ((MethodInfo) localObject2).setDescriptor(Descriptor.rename(((MethodInfo) localObject2).getDescriptor(), paramMap));
            AttributeInfo.renameClass(((MethodInfo) localObject2).getAttributes(), paramMap);
            i += 1;
        }
        localObject1 = this.fields;
        k = ((ArrayList) localObject1).size();
        i = j;
        while (i < k) {
            localObject2 = (FieldInfo) ((ArrayList) localObject1).get(i);
            ((FieldInfo) localObject2).setDescriptor(Descriptor.rename(((FieldInfo) localObject2).getDescriptor(), paramMap));
            AttributeInfo.renameClass(((FieldInfo) localObject2).getAttributes(), paramMap);
            i += 1;
        }
    }

    public void setAccessFlags(int paramInt) {
        int i = paramInt;
        if ((paramInt & 0x200) == 0) {
            i = paramInt | 0x20;
        }
        this.accessFlags = i;
    }

    public void setInterfaces(String[] paramArrayOfString) {
        this.cachedInterfaces = null;
        if (paramArrayOfString != null) {
            int j = paramArrayOfString.length;
            this.interfaces = new int[j];
            int i = 0;
            while (i < j) {
                this.interfaces[i] = this.constPool.addClassInfo(paramArrayOfString[i]);
                i += 1;
            }
        }
    }

    public void setMajorVersion(int paramInt) {
        this.major = paramInt;
    }

    public void setMinorVersion(int paramInt) {
        this.minor = paramInt;
    }

    public void setName(String paramString) {
        renameClass(this.thisclassname, paramString);
    }

    public void setSuperclass(String paramString) {
        String str = paramString;
        if (paramString == null) {
            str = "java.lang.Object";
        }
        try {
            this.superClass = this.constPool.addClassInfo(str);
            paramString = this.methods;
            int j = paramString.size();
            int i = 0;
            while (i < j) {
                ((MethodInfo) paramString.get(i)).setSuperclass(str);
                i += 1;
            }
            this.cachedSuperclass = str;
        } catch (BadBytecode paramString) {
            throw new CannotCompileException(paramString);
        }
    }

    public void setVersionToJava5() {
        this.major = 49;
        this.minor = 0;
    }

    public void write(DataOutputStream paramDataOutputStream) {
        int k = 0;
        paramDataOutputStream.writeInt(-889275714);
        paramDataOutputStream.writeShort(this.minor);
        paramDataOutputStream.writeShort(this.major);
        this.constPool.write(paramDataOutputStream);
        paramDataOutputStream.writeShort(this.accessFlags);
        paramDataOutputStream.writeShort(this.thisClass);
        paramDataOutputStream.writeShort(this.superClass);
        if (this.interfaces == null) {
        }
        for (int i = 0; ; i = this.interfaces.length) {
            paramDataOutputStream.writeShort(i);
            j = 0;
            while (j < i) {
                paramDataOutputStream.writeShort(this.interfaces[j]);
                j += 1;
            }
        }
        ArrayList localArrayList = this.fields;
        int j = localArrayList.size();
        paramDataOutputStream.writeShort(j);
        i = 0;
        while (i < j) {
            ((FieldInfo) localArrayList.get(i)).write(paramDataOutputStream);
            i += 1;
        }
        localArrayList = this.methods;
        j = localArrayList.size();
        paramDataOutputStream.writeShort(j);
        i = k;
        while (i < j) {
            ((MethodInfo) localArrayList.get(i)).write(paramDataOutputStream);
            i += 1;
        }
        paramDataOutputStream.writeShort(this.attributes.size());
        AttributeInfo.writeAll(this.attributes, paramDataOutputStream);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/ClassFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */