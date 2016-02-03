package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;

abstract class MemberrefInfo
        extends ConstInfo {
    int classIndex;
    int nameAndTypeIndex;

    public MemberrefInfo(int paramInt1, int paramInt2, int paramInt3) {
        super(paramInt3);
        this.classIndex = paramInt1;
        this.nameAndTypeIndex = paramInt2;
    }

    public MemberrefInfo(DataInputStream paramDataInputStream, int paramInt) {
        super(paramInt);
        this.classIndex = paramDataInputStream.readUnsignedShort();
        this.nameAndTypeIndex = paramDataInputStream.readUnsignedShort();
    }

    public int copy(ConstPool paramConstPool1, ConstPool paramConstPool2, Map paramMap) {
        return copy2(paramConstPool2, paramConstPool1.getItem(this.classIndex).copy(paramConstPool1, paramConstPool2, paramMap), paramConstPool1.getItem(this.nameAndTypeIndex).copy(paramConstPool1, paramConstPool2, paramMap));
    }

    protected abstract int copy2(ConstPool paramConstPool, int paramInt1, int paramInt2);

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((paramObject instanceof MemberrefInfo)) {
            paramObject = (MemberrefInfo) paramObject;
            bool1 = bool2;
            if (((MemberrefInfo) paramObject).classIndex == this.classIndex) {
                bool1 = bool2;
                if (((MemberrefInfo) paramObject).nameAndTypeIndex == this.nameAndTypeIndex) {
                    bool1 = bool2;
                    if (paramObject.getClass() == getClass()) {
                        bool1 = true;
                    }
                }
            }
        }
        return bool1;
    }

    public abstract String getTagName();

    public int hashCode() {
        return this.classIndex << 16 ^ this.nameAndTypeIndex;
    }

    public void print(PrintWriter paramPrintWriter) {
        paramPrintWriter.print(getTagName() + " #");
        paramPrintWriter.print(this.classIndex);
        paramPrintWriter.print(", name&type #");
        paramPrintWriter.println(this.nameAndTypeIndex);
    }

    public void write(DataOutputStream paramDataOutputStream) {
        paramDataOutputStream.writeByte(getTag());
        paramDataOutputStream.writeShort(this.classIndex);
        paramDataOutputStream.writeShort(this.nameAndTypeIndex);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/MemberrefInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */