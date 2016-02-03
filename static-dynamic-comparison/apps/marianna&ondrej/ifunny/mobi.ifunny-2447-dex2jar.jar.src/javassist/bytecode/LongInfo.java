package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;

class LongInfo
        extends ConstInfo {
    static final int tag = 5;
    long value;

    public LongInfo(long paramLong, int paramInt) {
        super(paramInt);
        this.value = paramLong;
    }

    public LongInfo(DataInputStream paramDataInputStream, int paramInt) {
        super(paramInt);
        this.value = paramDataInputStream.readLong();
    }

    public int copy(ConstPool paramConstPool1, ConstPool paramConstPool2, Map paramMap) {
        return paramConstPool2.addLongInfo(this.value);
    }

    public boolean equals(Object paramObject) {
        return ((paramObject instanceof LongInfo)) && (((LongInfo) paramObject).value == this.value);
    }

    public int getTag() {
        return 5;
    }

    public int hashCode() {
        return (int) (this.value ^ this.value >>> 32);
    }

    public void print(PrintWriter paramPrintWriter) {
        paramPrintWriter.print("Long ");
        paramPrintWriter.println(this.value);
    }

    public void write(DataOutputStream paramDataOutputStream) {
        paramDataOutputStream.writeByte(5);
        paramDataOutputStream.writeLong(this.value);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/LongInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */