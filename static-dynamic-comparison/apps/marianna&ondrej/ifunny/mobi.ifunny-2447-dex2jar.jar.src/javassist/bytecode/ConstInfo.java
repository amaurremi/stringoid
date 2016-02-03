package javassist.bytecode;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

abstract class ConstInfo {
    int index;

    public ConstInfo(int paramInt) {
        this.index = paramInt;
    }

    public abstract int copy(ConstPool paramConstPool1, ConstPool paramConstPool2, Map paramMap);

    public String getClassName(ConstPool paramConstPool) {
        return null;
    }

    public abstract int getTag();

    public abstract void print(PrintWriter paramPrintWriter);

    public void renameClass(ConstPool paramConstPool, String paramString1, String paramString2, HashMap paramHashMap) {
    }

    public void renameClass(ConstPool paramConstPool, Map paramMap, HashMap paramHashMap) {
    }

    public String toString() {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        print(new PrintWriter(localByteArrayOutputStream));
        return localByteArrayOutputStream.toString();
    }

    public abstract void write(DataOutputStream paramDataOutputStream);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/ConstInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */