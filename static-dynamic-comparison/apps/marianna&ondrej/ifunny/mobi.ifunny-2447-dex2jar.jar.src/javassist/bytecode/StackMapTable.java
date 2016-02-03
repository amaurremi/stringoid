package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Map;

import javassist.CannotCompileException;

public class StackMapTable
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
    public static final String tag = "StackMapTable";

    StackMapTable(ConstPool paramConstPool, int paramInt, DataInputStream paramDataInputStream) {
        super(paramConstPool, paramInt, paramDataInputStream);
    }

    StackMapTable(ConstPool paramConstPool, byte[] paramArrayOfByte) {
        super(paramConstPool, "StackMapTable", paramArrayOfByte);
    }

    public static int typeTagOf(char paramChar) {
        switch (paramChar) {
            default:
                return 1;
            case 'D':
                return 3;
            case 'F':
                return 2;
            case 'J':
                return 4;
        }
        return 7;
    }

    public AttributeInfo copy(ConstPool paramConstPool, Map paramMap) {
        try {
            paramConstPool = new StackMapTable(paramConstPool, new StackMapTable.Copier(this.constPool, this.info, paramConstPool).doit());
            return paramConstPool;
        } catch (BadBytecode paramConstPool) {
            throw new StackMapTable.RuntimeCopyException("bad bytecode. fatal?");
        }
    }

    public void insertLocal(int paramInt1, int paramInt2, int paramInt3) {
        set(new StackMapTable.InsertLocal(get(), paramInt1, paramInt2, paramInt3).doit());
    }

    public void println(PrintStream paramPrintStream) {
        StackMapTable.Printer.print(this, new PrintWriter(paramPrintStream, true));
    }

    public void println(PrintWriter paramPrintWriter) {
        StackMapTable.Printer.print(this, paramPrintWriter);
    }

    public void removeNew(int paramInt) {
        try {
            set(new StackMapTable.NewRemover(get(), paramInt).doit());
            return;
        } catch (BadBytecode localBadBytecode) {
            throw new CannotCompileException("bad stack map table", localBadBytecode);
        }
    }

    void shiftPc(int paramInt1, int paramInt2, boolean paramBoolean) {
        new StackMapTable.Shifter(this, paramInt1, paramInt2, paramBoolean).doit();
    }

    void write(DataOutputStream paramDataOutputStream) {
        super.write(paramDataOutputStream);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/StackMapTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */