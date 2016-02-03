package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;

class IntegerInfo
        extends ConstInfo {
    static final int tag = 3;
    int value;

    public IntegerInfo(int paramInt1, int paramInt2) {
        super(paramInt2);
        this.value = paramInt1;
    }

    public IntegerInfo(DataInputStream paramDataInputStream, int paramInt) {
        super(paramInt);
        this.value = paramDataInputStream.readInt();
    }

    public int copy(ConstPool paramConstPool1, ConstPool paramConstPool2, Map paramMap) {
        return paramConstPool2.addIntegerInfo(this.value);
    }

    public boolean equals(Object paramObject) {
        return ((paramObject instanceof IntegerInfo)) && (((IntegerInfo) paramObject).value == this.value);
    }

    public int getTag() {
        return 3;
    }

    public int hashCode() {
        return this.value;
    }

    public void print(PrintWriter paramPrintWriter) {
        paramPrintWriter.print("Integer ");
        paramPrintWriter.println(this.value);
    }

    public void write(DataOutputStream paramDataOutputStream) {
        paramDataOutputStream.writeByte(3);
        paramDataOutputStream.writeInt(this.value);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/IntegerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */