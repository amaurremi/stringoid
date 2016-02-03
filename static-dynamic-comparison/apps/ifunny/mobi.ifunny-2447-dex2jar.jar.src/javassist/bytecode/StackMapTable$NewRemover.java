package javassist.bytecode;

class StackMapTable$NewRemover
        extends StackMapTable.SimpleCopy {
    int posOfNew;

    public StackMapTable$NewRemover(byte[] paramArrayOfByte, int paramInt) {
        super(paramArrayOfByte);
        this.posOfNew = paramInt;
    }

    public void fullFrame(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4) {
        int i = 0;
        int k = paramArrayOfInt3.length - 1;
        int j = 0;
        while (j < k) {
            if ((paramArrayOfInt3[j] == 8) && (paramArrayOfInt4[j] == this.posOfNew) && (paramArrayOfInt3[(j + 1)] == 8) && (paramArrayOfInt4[(j + 1)] == this.posOfNew)) {
                int m = k + 1;
                int[] arrayOfInt3 = new int[m - 2];
                int[] arrayOfInt4 = new int[m - 2];
                k = 0;
                arrayOfInt2 = arrayOfInt3;
                arrayOfInt1 = arrayOfInt4;
                if (i >= m) {
                    break label176;
                }
                if (i == j) {
                    i += 1;
                }
                for (; ; ) {
                    i += 1;
                    break;
                    arrayOfInt3[k] = paramArrayOfInt3[i];
                    arrayOfInt4[k] = paramArrayOfInt4[i];
                    k += 1;
                }
            }
            j += 1;
        }
        int[] arrayOfInt1 = paramArrayOfInt4;
        int[] arrayOfInt2 = paramArrayOfInt3;
        label176:
        super.fullFrame(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, arrayOfInt2, arrayOfInt1);
    }

    public void sameLocals(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if ((paramInt3 == 8) && (paramInt4 == this.posOfNew)) {
            super.sameFrame(paramInt1, paramInt2);
            return;
        }
        super.sameLocals(paramInt1, paramInt2, paramInt3, paramInt4);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/StackMapTable$NewRemover.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */