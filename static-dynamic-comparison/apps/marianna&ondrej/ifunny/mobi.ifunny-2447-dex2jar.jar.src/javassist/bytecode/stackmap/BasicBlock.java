package javassist.bytecode.stackmap;

import javassist.bytecode.BadBytecode;

public class BasicBlock {
    protected BasicBlock[] exit;
    protected int incoming;
    protected int length;
    protected int position;
    protected boolean stop;
    protected BasicBlock.Catch toCatch;

    protected BasicBlock(int paramInt) {
        this.position = paramInt;
        this.length = 0;
        this.incoming = 0;
    }

    public static BasicBlock find(BasicBlock[] paramArrayOfBasicBlock, int paramInt) {
        int i = 0;
        while (i < paramArrayOfBasicBlock.length) {
            int j = paramArrayOfBasicBlock[i].position;
            if ((j <= paramInt) && (paramInt < j + paramArrayOfBasicBlock[i].length)) {
                return paramArrayOfBasicBlock[i];
            }
            i += 1;
        }
        throw new BadBytecode("no basic block at " + paramInt);
    }

    public String toString() {
        StringBuffer localStringBuffer = new StringBuffer();
        String str = getClass().getName();
        int i = str.lastIndexOf('.');
        if (i < 0) {
        }
        for (; ; ) {
            localStringBuffer.append(str);
            localStringBuffer.append("[");
            toString2(localStringBuffer);
            localStringBuffer.append("]");
            return localStringBuffer.toString();
            str = str.substring(i + 1);
        }
    }

    protected void toString2(StringBuffer paramStringBuffer) {
        paramStringBuffer.append("pos=").append(this.position).append(", len=").append(this.length).append(", in=").append(this.incoming).append(", exit{");
        if (this.exit != null) {
            int i = 0;
            while (i < this.exit.length) {
                paramStringBuffer.append(this.exit[i].position).append(",");
                i += 1;
            }
        }
        paramStringBuffer.append("}, {");
        for (BasicBlock.Catch localCatch = this.toCatch; localCatch != null; localCatch = localCatch.next) {
            paramStringBuffer.append("(").append(localCatch.body.position).append(", ").append(localCatch.typeIndex).append("), ");
        }
        paramStringBuffer.append("}");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/stackmap/BasicBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */