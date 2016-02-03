package javassist.bytecode;

class StackMapTable$InsertLocal
        extends StackMapTable.SimpleCopy {
    private int varData;
    private int varIndex;
    private int varTag;

    public StackMapTable$InsertLocal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3) {
        super(paramArrayOfByte);
        this.varIndex = paramInt1;
        this.varTag = paramInt2;
        this.varData = paramInt3;
    }

    public void fullFrame(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4) {
        int n = paramArrayOfInt1.length;
        if (n < this.varIndex) {
            super.fullFrame(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
            return;
        }
        if ((this.varTag == 4) || (this.varTag == 3)) {
        }
        int[] arrayOfInt1;
        int[] arrayOfInt2;
        int i1;
        for (int j = 2; ; j = 1) {
            arrayOfInt1 = new int[n + j];
            arrayOfInt2 = new int[n + j];
            i1 = this.varIndex;
            int i = 0;
            int k = 0;
            while (k < n) {
                int m = i;
                if (i == i1) {
                    m = i + j;
                }
                arrayOfInt1[m] = paramArrayOfInt1[k];
                arrayOfInt2[m] = paramArrayOfInt2[k];
                k += 1;
                i = m + 1;
            }
        }
        arrayOfInt1[i1] = this.varTag;
        arrayOfInt2[i1] = this.varData;
        if (j > 1) {
            arrayOfInt1[(i1 + 1)] = 0;
            arrayOfInt2[(i1 + 1)] = 0;
        }
        super.fullFrame(paramInt1, paramInt2, arrayOfInt1, arrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/StackMapTable$InsertLocal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */