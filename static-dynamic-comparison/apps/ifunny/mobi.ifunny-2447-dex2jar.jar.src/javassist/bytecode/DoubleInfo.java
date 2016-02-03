package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;

class DoubleInfo
        extends ConstInfo {
    static final int tag = 6;
    double value;

    public DoubleInfo(double paramDouble, int paramInt) {
        super(paramInt);
        this.value = paramDouble;
    }

    public DoubleInfo(DataInputStream paramDataInputStream, int paramInt) {
        super(paramInt);
        this.value = paramDataInputStream.readDouble();
    }

    public int copy(ConstPool paramConstPool1, ConstPool paramConstPool2, Map paramMap) {
        return paramConstPool2.addDoubleInfo(this.value);
    }

    public boolean equals(Object paramObject) {
        return ((paramObject instanceof DoubleInfo)) && (((DoubleInfo) paramObject).value == this.value);
    }

    public int getTag() {
        return 6;
    }

    public int hashCode() {
        long l = Double.doubleToLongBits(this.value);
        return (int) (l ^ l >>> 32);
    }

    public void print(PrintWriter paramPrintWriter) {
        paramPrintWriter.print("Double ");
        paramPrintWriter.println(this.value);
    }

    public void write(DataOutputStream paramDataOutputStream) {
        paramDataOutputStream.writeByte(6);
        paramDataOutputStream.writeDouble(this.value);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/DoubleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */