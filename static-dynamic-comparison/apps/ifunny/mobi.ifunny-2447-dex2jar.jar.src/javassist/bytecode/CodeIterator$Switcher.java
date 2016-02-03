package javassist.bytecode;

abstract class CodeIterator$Switcher
        extends CodeIterator.Branch {
    int defaultByte;
    int gap;
    int[] offsets;

    CodeIterator$Switcher(int paramInt1, int paramInt2, int[] paramArrayOfInt) {
        super(paramInt1);
        this.gap = (3 - (paramInt1 & 0x3));
        this.defaultByte = paramInt2;
        this.offsets = paramArrayOfInt;
    }

    void adjustOffsets(int paramInt1, int paramInt2) {
        if (this.defaultByte == paramInt1) {
            this.defaultByte -= paramInt2;
        }
        int i = 0;
        while (i < this.offsets.length) {
            if (this.offsets[i] == paramInt1) {
                int[] arrayOfInt = this.offsets;
                arrayOfInt[i] -= paramInt2;
            }
            i += 1;
        }
    }

    int deltaSize() {
        return this.gap - (3 - (this.orgPos & 0x3));
    }

    int gapChanged() {
        int i = 3 - (this.pos & 0x3);
        if (i > this.gap) {
            int j = this.gap;
            this.gap = i;
            return i - j;
        }
        return 0;
    }

    void shift(int paramInt1, int paramInt2, boolean paramBoolean) {
        int j = this.pos;
        this.defaultByte = shiftOffset(j, this.defaultByte, paramInt1, paramInt2, paramBoolean);
        int k = this.offsets.length;
        int i = 0;
        while (i < k) {
            this.offsets[i] = shiftOffset(j, this.offsets[i], paramInt1, paramInt2, paramBoolean);
            i += 1;
        }
        super.shift(paramInt1, paramInt2, paramBoolean);
    }

    abstract int tableSize();

    int write(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2) {
        int j = 3 - (this.pos & 0x3);
        int i = this.gap - j;
        adjustOffsets(3 - (this.orgPos & 0x3) + 5 + tableSize(), i);
        paramArrayOfByte2[paramInt2] = paramArrayOfByte1[paramInt1];
        paramInt1 = paramInt2 + 1;
        paramInt2 = j;
        while (paramInt2 > 0) {
            paramArrayOfByte2[paramInt1] = 0;
            paramInt1 += 1;
            paramInt2 -= 1;
        }
        ByteArray.write32bit(this.defaultByte, paramArrayOfByte2, paramInt1);
        j = write2(paramInt1 + 4, paramArrayOfByte2);
        paramInt2 = j + 4 + paramInt1;
        paramInt1 = i;
        while (paramInt1 > 0) {
            paramArrayOfByte2[paramInt2] = 0;
            paramInt2 += 1;
            paramInt1 -= 1;
        }
        return 3 - (this.orgPos & 0x3) + 5 + j;
    }

    abstract int write2(int paramInt, byte[] paramArrayOfByte);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/CodeIterator$Switcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */