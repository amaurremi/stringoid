package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

class NameAndTypeInfo
        extends ConstInfo {
    static final int tag = 12;
    int memberName;
    int typeDescriptor;

    public NameAndTypeInfo(int paramInt1, int paramInt2, int paramInt3) {
        super(paramInt3);
        this.memberName = paramInt1;
        this.typeDescriptor = paramInt2;
    }

    public NameAndTypeInfo(DataInputStream paramDataInputStream, int paramInt) {
        super(paramInt);
        this.memberName = paramDataInputStream.readUnsignedShort();
        this.typeDescriptor = paramDataInputStream.readUnsignedShort();
    }

    public int copy(ConstPool paramConstPool1, ConstPool paramConstPool2, Map paramMap) {
        String str = paramConstPool1.getUtf8Info(this.memberName);
        paramConstPool1 = Descriptor.rename(paramConstPool1.getUtf8Info(this.typeDescriptor), paramMap);
        return paramConstPool2.addNameAndTypeInfo(paramConstPool2.addUtf8Info(str), paramConstPool2.addUtf8Info(paramConstPool1));
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((paramObject instanceof NameAndTypeInfo)) {
            paramObject = (NameAndTypeInfo) paramObject;
            bool1 = bool2;
            if (((NameAndTypeInfo) paramObject).memberName == this.memberName) {
                bool1 = bool2;
                if (((NameAndTypeInfo) paramObject).typeDescriptor == this.typeDescriptor) {
                    bool1 = true;
                }
            }
        }
        return bool1;
    }

    public int getTag() {
        return 12;
    }

    public int hashCode() {
        return this.memberName << 16 ^ this.typeDescriptor;
    }

    public void print(PrintWriter paramPrintWriter) {
        paramPrintWriter.print("NameAndType #");
        paramPrintWriter.print(this.memberName);
        paramPrintWriter.print(", type #");
        paramPrintWriter.println(this.typeDescriptor);
    }

    public void renameClass(ConstPool paramConstPool, String paramString1, String paramString2, HashMap paramHashMap) {
        String str = paramConstPool.getUtf8Info(this.typeDescriptor);
        paramString1 = Descriptor.rename(str, paramString1, paramString2);
        if (str != paramString1) {
            if (paramHashMap == null) {
                this.typeDescriptor = paramConstPool.addUtf8Info(paramString1);
            }
        } else {
            return;
        }
        paramHashMap.remove(this);
        this.typeDescriptor = paramConstPool.addUtf8Info(paramString1);
        paramHashMap.put(this, this);
    }

    public void renameClass(ConstPool paramConstPool, Map paramMap, HashMap paramHashMap) {
        String str = paramConstPool.getUtf8Info(this.typeDescriptor);
        paramMap = Descriptor.rename(str, paramMap);
        if (str != paramMap) {
            if (paramHashMap == null) {
                this.typeDescriptor = paramConstPool.addUtf8Info(paramMap);
            }
        } else {
            return;
        }
        paramHashMap.remove(this);
        this.typeDescriptor = paramConstPool.addUtf8Info(paramMap);
        paramHashMap.put(this, this);
    }

    public void write(DataOutputStream paramDataOutputStream) {
        paramDataOutputStream.writeByte(12);
        paramDataOutputStream.writeShort(this.memberName);
        paramDataOutputStream.writeShort(this.typeDescriptor);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/NameAndTypeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */