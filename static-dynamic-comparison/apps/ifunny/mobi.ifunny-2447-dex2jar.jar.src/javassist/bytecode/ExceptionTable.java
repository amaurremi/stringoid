package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Map;

public class ExceptionTable
        implements Cloneable {
    private ConstPool constPool;
    private ArrayList entries;

    public ExceptionTable(ConstPool paramConstPool) {
        this.constPool = paramConstPool;
        this.entries = new ArrayList();
    }

    ExceptionTable(ConstPool paramConstPool, DataInputStream paramDataInputStream) {
        this.constPool = paramConstPool;
        int j = paramDataInputStream.readUnsignedShort();
        paramConstPool = new ArrayList(j);
        int i = 0;
        while (i < j) {
            paramConstPool.add(new ExceptionTableEntry(paramDataInputStream.readUnsignedShort(), paramDataInputStream.readUnsignedShort(), paramDataInputStream.readUnsignedShort(), paramDataInputStream.readUnsignedShort()));
            i += 1;
        }
        this.entries = paramConstPool;
    }

    private static int shiftPc(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
        int i;
        if (paramInt1 <= paramInt2) {
            i = paramInt1;
            if (paramBoolean) {
                i = paramInt1;
                if (paramInt1 != paramInt2) {
                }
            }
        } else {
            i = paramInt1 + paramInt3;
        }
        return i;
    }

    public void add(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (paramInt1 < paramInt2) {
            this.entries.add(new ExceptionTableEntry(paramInt1, paramInt2, paramInt3, paramInt4));
        }
    }

    public void add(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        if (paramInt2 < paramInt3) {
            this.entries.add(paramInt1, new ExceptionTableEntry(paramInt2, paramInt3, paramInt4, paramInt5));
        }
    }

    public void add(int paramInt1, ExceptionTable paramExceptionTable, int paramInt2) {
        int i = paramExceptionTable.size();
        for (; ; ) {
            i -= 1;
            if (i < 0) {
                break;
            }
            ExceptionTableEntry localExceptionTableEntry = (ExceptionTableEntry) paramExceptionTable.entries.get(i);
            add(paramInt1, localExceptionTableEntry.startPc + paramInt2, localExceptionTableEntry.endPc + paramInt2, localExceptionTableEntry.handlerPc + paramInt2, localExceptionTableEntry.catchType);
        }
    }

    public int catchType(int paramInt) {
        return ((ExceptionTableEntry) this.entries.get(paramInt)).catchType;
    }

    public Object clone() {
        ExceptionTable localExceptionTable = (ExceptionTable) super.clone();
        localExceptionTable.entries = new ArrayList(this.entries);
        return localExceptionTable;
    }

    public ExceptionTable copy(ConstPool paramConstPool, Map paramMap) {
        ExceptionTable localExceptionTable = new ExceptionTable(paramConstPool);
        ConstPool localConstPool = this.constPool;
        int j = size();
        int i = 0;
        while (i < j) {
            ExceptionTableEntry localExceptionTableEntry = (ExceptionTableEntry) this.entries.get(i);
            int k = localConstPool.copy(localExceptionTableEntry.catchType, paramConstPool, paramMap);
            localExceptionTable.add(localExceptionTableEntry.startPc, localExceptionTableEntry.endPc, localExceptionTableEntry.handlerPc, k);
            i += 1;
        }
        return localExceptionTable;
    }

    public int endPc(int paramInt) {
        return ((ExceptionTableEntry) this.entries.get(paramInt)).endPc;
    }

    public int handlerPc(int paramInt) {
        return ((ExceptionTableEntry) this.entries.get(paramInt)).handlerPc;
    }

    public void remove(int paramInt) {
        this.entries.remove(paramInt);
    }

    public void setCatchType(int paramInt1, int paramInt2) {
        ((ExceptionTableEntry) this.entries.get(paramInt1)).catchType = paramInt2;
    }

    public void setEndPc(int paramInt1, int paramInt2) {
        ((ExceptionTableEntry) this.entries.get(paramInt1)).endPc = paramInt2;
    }

    public void setHandlerPc(int paramInt1, int paramInt2) {
        ((ExceptionTableEntry) this.entries.get(paramInt1)).handlerPc = paramInt2;
    }

    public void setStartPc(int paramInt1, int paramInt2) {
        ((ExceptionTableEntry) this.entries.get(paramInt1)).startPc = paramInt2;
    }

    void shiftPc(int paramInt1, int paramInt2, boolean paramBoolean) {
        int j = size();
        int i = 0;
        while (i < j) {
            ExceptionTableEntry localExceptionTableEntry = (ExceptionTableEntry) this.entries.get(i);
            localExceptionTableEntry.startPc = shiftPc(localExceptionTableEntry.startPc, paramInt1, paramInt2, paramBoolean);
            localExceptionTableEntry.endPc = shiftPc(localExceptionTableEntry.endPc, paramInt1, paramInt2, paramBoolean);
            localExceptionTableEntry.handlerPc = shiftPc(localExceptionTableEntry.handlerPc, paramInt1, paramInt2, paramBoolean);
            i += 1;
        }
    }

    public int size() {
        return this.entries.size();
    }

    public int startPc(int paramInt) {
        return ((ExceptionTableEntry) this.entries.get(paramInt)).startPc;
    }

    void write(DataOutputStream paramDataOutputStream) {
        int j = size();
        paramDataOutputStream.writeShort(j);
        int i = 0;
        while (i < j) {
            ExceptionTableEntry localExceptionTableEntry = (ExceptionTableEntry) this.entries.get(i);
            paramDataOutputStream.writeShort(localExceptionTableEntry.startPc);
            paramDataOutputStream.writeShort(localExceptionTableEntry.endPc);
            paramDataOutputStream.writeShort(localExceptionTableEntry.handlerPc);
            paramDataOutputStream.writeShort(localExceptionTableEntry.catchType);
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/ExceptionTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */