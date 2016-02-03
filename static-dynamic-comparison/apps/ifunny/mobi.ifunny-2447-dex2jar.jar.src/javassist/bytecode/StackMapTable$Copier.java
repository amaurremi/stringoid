package javassist.bytecode;

class StackMapTable$Copier
        extends StackMapTable.SimpleCopy {
    private ConstPool destPool;
    private ConstPool srcPool;

    public StackMapTable$Copier(ConstPool paramConstPool1, byte[] paramArrayOfByte, ConstPool paramConstPool2) {
        super(paramArrayOfByte);
        this.srcPool = paramConstPool1;
        this.destPool = paramConstPool2;
    }

    protected int copyData(int paramInt1, int paramInt2) {
        int i = paramInt2;
        if (paramInt1 == 7) {
            i = this.srcPool.copy(paramInt2, this.destPool, null);
        }
        return i;
    }

    protected int[] copyData(int[] paramArrayOfInt1, int[] paramArrayOfInt2) {
        int[] arrayOfInt = new int[paramArrayOfInt2.length];
        int i = 0;
        if (i < paramArrayOfInt2.length) {
            if (paramArrayOfInt1[i] == 7) {
                arrayOfInt[i] = this.srcPool.copy(paramArrayOfInt2[i], this.destPool, null);
            }
            for (; ; ) {
                i += 1;
                break;
                arrayOfInt[i] = paramArrayOfInt2[i];
            }
        }
        return arrayOfInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/StackMapTable$Copier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */