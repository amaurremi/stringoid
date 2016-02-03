package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;

public final class FieldInfo {
    int accessFlags;
    ArrayList attribute;
    String cachedName;
    String cachedType;
    ConstPool constPool;
    int descriptor;
    int name;

    private FieldInfo(ConstPool paramConstPool) {
        this.constPool = paramConstPool;
        this.accessFlags = 0;
        this.attribute = null;
    }

    FieldInfo(ConstPool paramConstPool, DataInputStream paramDataInputStream) {
        this(paramConstPool);
        read(paramDataInputStream);
    }

    public FieldInfo(ConstPool paramConstPool, String paramString1, String paramString2) {
        this(paramConstPool);
        this.name = paramConstPool.addUtf8Info(paramString1);
        this.cachedName = paramString1;
        this.descriptor = paramConstPool.addUtf8Info(paramString2);
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

    public ConstPool getConstPool() {
        return this.constPool;
    }

    public int getConstantValue() {
        if ((this.accessFlags & 0x8) == 0) {
            return 0;
        }
        ConstantAttribute localConstantAttribute = (ConstantAttribute) getAttribute("ConstantValue");
        if (localConstantAttribute == null) {
            return 0;
        }
        return localConstantAttribute.getConstantValue();
    }

    public String getDescriptor() {
        return this.constPool.getUtf8Info(this.descriptor);
    }

    public String getName() {
        if (this.cachedName == null) {
            this.cachedName = this.constPool.getUtf8Info(this.name);
        }
        return this.cachedName;
    }

    void prune(ConstPool paramConstPool) {
        ArrayList localArrayList = new ArrayList();
        AttributeInfo localAttributeInfo = getAttribute("RuntimeInvisibleAnnotations");
        if (localAttributeInfo != null) {
            localArrayList.add(localAttributeInfo.copy(paramConstPool, null));
        }
        localAttributeInfo = getAttribute("RuntimeVisibleAnnotations");
        if (localAttributeInfo != null) {
            localArrayList.add(localAttributeInfo.copy(paramConstPool, null));
        }
        localAttributeInfo = getAttribute("Signature");
        if (localAttributeInfo != null) {
            localArrayList.add(localAttributeInfo.copy(paramConstPool, null));
        }
        int i = getConstantValue();
        if (i != 0) {
            localArrayList.add(new ConstantAttribute(paramConstPool, this.constPool.copy(i, paramConstPool, null)));
        }
        this.attribute = localArrayList;
        this.name = paramConstPool.addUtf8Info(getName());
        this.descriptor = paramConstPool.addUtf8Info(getDescriptor());
        this.constPool = paramConstPool;
    }

    public void setAccessFlags(int paramInt) {
        this.accessFlags = paramInt;
    }

    public void setDescriptor(String paramString) {
        if (!paramString.equals(getDescriptor())) {
            this.descriptor = this.constPool.addUtf8Info(paramString);
        }
    }

    public void setName(String paramString) {
        this.name = this.constPool.addUtf8Info(paramString);
        this.cachedName = paramString;
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/FieldInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */