package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;

class Utf8Info
        extends ConstInfo {
    static final int tag = 1;
    String string;

    public Utf8Info(DataInputStream paramDataInputStream, int paramInt) {
        super(paramInt);
        this.string = paramDataInputStream.readUTF();
    }

    public Utf8Info(String paramString, int paramInt) {
        super(paramInt);
        this.string = paramString;
    }

    public int copy(ConstPool paramConstPool1, ConstPool paramConstPool2, Map paramMap) {
        return paramConstPool2.addUtf8Info(this.string);
    }

    public boolean equals(Object paramObject) {
        return ((paramObject instanceof Utf8Info)) && (((Utf8Info) paramObject).string.equals(this.string));
    }

    public int getTag() {
        return 1;
    }

    public int hashCode() {
        return this.string.hashCode();
    }

    public void print(PrintWriter paramPrintWriter) {
        paramPrintWriter.print("UTF8 \"");
        paramPrintWriter.print(this.string);
        paramPrintWriter.println("\"");
    }

    public void write(DataOutputStream paramDataOutputStream) {
        paramDataOutputStream.writeByte(1);
        paramDataOutputStream.writeUTF(this.string);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/Utf8Info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */