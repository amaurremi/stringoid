package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javassist.ClassPool;
import javassist.bytecode.stackmap.MapMaker;

public class MethodInfo {
    public static boolean doPreverify = false;
    public static final String nameClinit = "<clinit>";
    public static final String nameInit = "<init>";
    int accessFlags;
    ArrayList attribute;
    String cachedName;
    ConstPool constPool;
    int descriptor;
    int name;

    private MethodInfo(ConstPool paramConstPool) {
        this.constPool = paramConstPool;
        this.attribute = null;
    }

    MethodInfo(ConstPool paramConstPool, DataInputStream paramDataInputStream) {
        this(paramConstPool);
        read(paramDataInputStream);
    }

    public MethodInfo(ConstPool paramConstPool, String paramString1, String paramString2) {
        this(paramConstPool);
        this.accessFlags = 0;
        this.name = paramConstPool.addUtf8Info(paramString1);
        this.cachedName = paramString1;
        this.descriptor = this.constPool.addUtf8Info(paramString2);
    }

    public MethodInfo(ConstPool paramConstPool, String paramString, MethodInfo paramMethodInfo, Map paramMap) {
        this(paramConstPool);
        read(paramMethodInfo, paramString, paramMap);
    }

    private void read(DataInputStream paramDataInputStream) {
        this.accessFlags = paramDataInputStream.readUnsignedShort();
        this.name = paramDataInputStream.readUnsignedShort();
        this.descriptor = paramDataInputStream.readUnsignedShort();
        int j = paramDataInputStream.readUnsignedShort();
        this.attribute = new ArrayList();
        int i = 0;
        while (i < j) {
            this.attribute.add(AttributeInfo.read(this.constPool, paramDataInputStream));
            i += 1;
        }
    }

    private void read(MethodInfo paramMethodInfo, String paramString, Map paramMap) {
        ConstPool localConstPool = this.constPool;
        this.accessFlags = paramMethodInfo.accessFlags;
        this.name = localConstPool.addUtf8Info(paramString);
        this.cachedName = paramString;
        this.descriptor = localConstPool.addUtf8Info(Descriptor.rename(paramMethodInfo.constPool.getUtf8Info(paramMethodInfo.descriptor), paramMap));
        this.attribute = new ArrayList();
        paramString = paramMethodInfo.getExceptionsAttribute();
        if (paramString != null) {
            this.attribute.add(paramString.copy(localConstPool, paramMap));
        }
        paramMethodInfo = paramMethodInfo.getCodeAttribute();
        if (paramMethodInfo != null) {
            this.attribute.add(paramMethodInfo.copy(localConstPool, paramMap));
        }
    }

    public void addAttribute(AttributeInfo paramAttributeInfo) {
        if (this.attribute == null) {
            this.attribute = new ArrayList();
        }
        AttributeInfo.remove(this.attribute, paramAttributeInfo.getName());
        this.attribute.add(paramAttributeInfo);
    }

    void compact(ConstPool paramConstPool) {
        this.name = paramConstPool.addUtf8Info(getName());
        this.descriptor = paramConstPool.addUtf8Info(getDescriptor());
        this.attribute = AttributeInfo.copyAll(this.attribute, paramConstPool);
        this.constPool = paramConstPool;
    }

    public int getAccessFlags() {
        return this.accessFlags;
    }

    public AttributeInfo getAttribute(String paramString) {
        return AttributeInfo.lookup(this.attribute, paramString);
    }

    public List getAttributes() {
        if (this.attribute == null) {
            this.attribute = new ArrayList();
        }
        return this.attribute;
    }

    public CodeAttribute getCodeAttribute() {
        return (CodeAttribute) AttributeInfo.lookup(this.attribute, "Code");
    }

    public ConstPool getConstPool() {
        return this.constPool;
    }

    public String getDescriptor() {
        return this.constPool.getUtf8Info(this.descriptor);
    }

    public ExceptionsAttribute getExceptionsAttribute() {
        return (ExceptionsAttribute) AttributeInfo.lookup(this.attribute, "Exceptions");
    }

    public int getLineNumber(int paramInt) {
        Object localObject = getCodeAttribute();
        if (localObject == null) {
            return -1;
        }
        localObject = (LineNumberAttribute) ((CodeAttribute) localObject).getAttribute("LineNumberTable");
        if (localObject == null) {
            return -1;
        }
        return ((LineNumberAttribute) localObject).toLineNumber(paramInt);
    }

    public String getName() {
        if (this.cachedName == null) {
            this.cachedName = this.constPool.getUtf8Info(this.name);
        }
        return this.cachedName;
    }

    public boolean isConstructor() {
        return getName().equals("<init>");
    }

    public boolean isMethod() {
        String str = getName();
        return (!str.equals("<init>")) && (!str.equals("<clinit>"));
    }

    public boolean isStaticInitializer() {
        return getName().equals("<clinit>");
    }

    void prune(ConstPool paramConstPool) {
        ArrayList localArrayList = new ArrayList();
        Object localObject = getAttribute("RuntimeInvisibleAnnotations");
        if (localObject != null) {
            localArrayList.add(((AttributeInfo) localObject).copy(paramConstPool, null));
        }
        localObject = getAttribute("RuntimeVisibleAnnotations");
        if (localObject != null) {
            localArrayList.add(((AttributeInfo) localObject).copy(paramConstPool, null));
        }
        localObject = getAttribute("RuntimeInvisibleParameterAnnotations");
        if (localObject != null) {
            localArrayList.add(((AttributeInfo) localObject).copy(paramConstPool, null));
        }
        localObject = getAttribute("RuntimeVisibleParameterAnnotations");
        if (localObject != null) {
            localArrayList.add(((AttributeInfo) localObject).copy(paramConstPool, null));
        }
        localObject = (AnnotationDefaultAttribute) getAttribute("AnnotationDefault");
        if (localObject != null) {
            localArrayList.add(localObject);
        }
        localObject = getExceptionsAttribute();
        if (localObject != null) {
            localArrayList.add(localObject);
        }
        localObject = getAttribute("Signature");
        if (localObject != null) {
            localArrayList.add(((AttributeInfo) localObject).copy(paramConstPool, null));
        }
        this.attribute = localArrayList;
        this.name = paramConstPool.addUtf8Info(getName());
        this.descriptor = paramConstPool.addUtf8Info(getDescriptor());
        this.constPool = paramConstPool;
    }

    public void rebuildStackMap(ClassPool paramClassPool) {
        CodeAttribute localCodeAttribute = getCodeAttribute();
        if (localCodeAttribute != null) {
            localCodeAttribute.setAttribute(MapMaker.make(paramClassPool, this));
        }
    }

    public void rebuildStackMapForME(ClassPool paramClassPool) {
        CodeAttribute localCodeAttribute = getCodeAttribute();
        if (localCodeAttribute != null) {
            localCodeAttribute.setAttribute(MapMaker.make2(paramClassPool, this));
        }
    }

    public void rebuildStackMapIf6(ClassPool paramClassPool, ClassFile paramClassFile) {
        if (paramClassFile.getMajorVersion() >= 50) {
            rebuildStackMap(paramClassPool);
        }
        if (doPreverify) {
            rebuildStackMapForME(paramClassPool);
        }
    }

    public void removeCodeAttribute() {
        AttributeInfo.remove(this.attribute, "Code");
    }

    public void removeExceptionsAttribute() {
        AttributeInfo.remove(this.attribute, "Exceptions");
    }

    public void setAccessFlags(int paramInt) {
        this.accessFlags = paramInt;
    }

    public void setCodeAttribute(CodeAttribute paramCodeAttribute) {
        removeCodeAttribute();
        if (this.attribute == null) {
            this.attribute = new ArrayList();
        }
        this.attribute.add(paramCodeAttribute);
    }

    public void setDescriptor(String paramString) {
        if (!paramString.equals(getDescriptor())) {
            this.descriptor = this.constPool.addUtf8Info(paramString);
        }
    }

    public void setExceptionsAttribute(ExceptionsAttribute paramExceptionsAttribute) {
        removeExceptionsAttribute();
        if (this.attribute == null) {
            this.attribute = new ArrayList();
        }
        this.attribute.add(paramExceptionsAttribute);
    }

    public void setName(String paramString) {
        this.name = this.constPool.addUtf8Info(paramString);
        this.cachedName = paramString;
    }

    public void setSuperclass(String paramString) {
        if (!isConstructor()) {
        }
        byte[] arrayOfByte;
        int i;
        do {
            return;
            localObject = getCodeAttribute();
            arrayOfByte = ((CodeAttribute) localObject).getCode();
            i = ((CodeAttribute) localObject).iterator().skipSuperConstructor();
        } while (i < 0);
        Object localObject = this.constPool;
        int j = ((ConstPool) localObject).getMethodrefNameAndType(ByteArray.readU16bit(arrayOfByte, i + 1));
        ByteArray.write16bit(((ConstPool) localObject).addMethodrefInfo(((ConstPool) localObject).addClassInfo(paramString), j), arrayOfByte, i + 1);
    }

    public String toString() {
        return getName() + " " + getDescriptor();
    }

    void write(DataOutputStream paramDataOutputStream) {
        paramDataOutputStream.writeShort(this.accessFlags);
        paramDataOutputStream.writeShort(this.name);
        paramDataOutputStream.writeShort(this.descriptor);
        if (this.attribute == null) {
            paramDataOutputStream.writeShort(0);
            return;
        }
        paramDataOutputStream.writeShort(this.attribute.size());
        AttributeInfo.writeAll(this.attribute, paramDataOutputStream);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/MethodInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */