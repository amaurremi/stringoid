package javassist.bytecode;

import java.io.DataInputStream;
import java.io.PrintWriter;
import java.util.Map;

public class StackMap
        extends AttributeInfo {
    public static final int DOUBLE = 3;
    public static final int FLOAT = 2;
    public static final int INTEGER = 1;
    public static final int LONG = 4;
    public static final int NULL = 5;
    public static final int OBJECT = 7;
    public static final int THIS = 6;
    public static final int TOP = 0;
    public static final int UNINIT = 8;
    public static final String tag = "StackMap";

    StackMap(ConstPool paramConstPool, int paramInt, DataInputStream paramDataInputStream) {
        super(paramConstPool, paramInt, paramDataInputStream);
    }

    StackMap(ConstPool paramConstPool, byte[] paramArrayOfByte) {
        super(paramConstPool, "StackMap", paramArrayOfByte);
    }

    public AttributeInfo copy(ConstPool paramConstPool, Map paramMap) {
        paramConstPool = new StackMap.Copier(this, paramConstPool, paramMap);
        paramConstPool.visit();
        return paramConstPool.getStackMap();
    }

    public void insertLocal(int paramInt1, int paramInt2, int paramInt3) {
        set(new StackMap.InsertLocal(this, paramInt1, paramInt2, paramInt3).doit());
    }

    public int numOfEntries() {
        return ByteArray.readU16bit(this.info, 0);
    }

    public void print(PrintWriter paramPrintWriter) {
        new StackMap.Printer(this, paramPrintWriter).print();
    }

    public void removeNew(int paramInt) {
        set(new StackMap.NewRemover(this, paramInt).doit());
    }

    void shiftPc(int paramInt1, int paramInt2, boolean paramBoolean) {
        new StackMap.Shifter(this, paramInt1, paramInt2, paramBoolean).visit();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/StackMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */