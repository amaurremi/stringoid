package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;

class FloatInfo
        extends ConstInfo {
    static final int tag = 4;
    float value;

    public FloatInfo(float paramFloat, int paramInt) {
        super(paramInt);
        this.value = paramFloat;
    }

    public FloatInfo(DataInputStream paramDataInputStream, int paramInt) {
        super(paramInt);
        this.value = paramDataInputStream.readFloat();
    }

    public int copy(ConstPool paramConstPool1, ConstPool paramConstPool2, Map paramMap) {
        return paramConstPool2.addFloatInfo(this.value);
    }

    public boolean equals(Object paramObject) {
        return ((paramObject instanceof FloatInfo)) && (((FloatInfo) paramObject).value == this.value);
    }

    public int getTag() {
        return 4;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value);
    }

    public void print(PrintWriter paramPrintWriter) {
        paramPrintWriter.print("Float ");
        paramPrintWriter.println(this.value);
    }

    public void write(DataOutputStream paramDataOutputStream) {
        paramDataOutputStream.writeByte(4);
        paramDataOutputStream.writeFloat(this.value);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/FloatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */