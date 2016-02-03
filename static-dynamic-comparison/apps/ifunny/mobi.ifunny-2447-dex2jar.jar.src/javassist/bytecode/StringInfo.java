package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;

class StringInfo
        extends ConstInfo {
    static final int tag = 8;
    int string;

    public StringInfo(int paramInt1, int paramInt2) {
        super(paramInt2);
        this.string = paramInt1;
    }

    public StringInfo(DataInputStream paramDataInputStream, int paramInt) {
        super(paramInt);
        this.string = paramDataInputStream.readUnsignedShort();
    }

    public int copy(ConstPool paramConstPool1, ConstPool paramConstPool2, Map paramMap) {
        return paramConstPool2.addStringInfo(paramConstPool1.getUtf8Info(this.string));
    }

    public boolean equals(Object paramObject) {
        return ((paramObject instanceof StringInfo)) && (((StringInfo) paramObject).string == this.string);
    }

    public int getTag() {
        return 8;
    }

    public int hashCode() {
        return this.string;
    }

    public void print(PrintWriter paramPrintWriter) {
        paramPrintWriter.print("String #");
        paramPrintWriter.println(this.string);
    }

    public void write(DataOutputStream paramDataOutputStream) {
        paramDataOutputStream.writeByte(8);
        paramDataOutputStream.writeShort(this.string);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/StringInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */