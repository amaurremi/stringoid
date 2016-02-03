package javassist.bytecode;

import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;

class ConstInfoPadding
        extends ConstInfo {
    public ConstInfoPadding(int paramInt) {
        super(paramInt);
    }

    public int copy(ConstPool paramConstPool1, ConstPool paramConstPool2, Map paramMap) {
        return paramConstPool2.addConstInfoPadding();
    }

    public int getTag() {
        return 0;
    }

    public void print(PrintWriter paramPrintWriter) {
        paramPrintWriter.println("padding");
    }

    public void write(DataOutputStream paramDataOutputStream) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/ConstInfoPadding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */