package javassist.bytecode;

class CodeIterator$Table
        extends CodeIterator.Switcher {
    int high;
    int low;

    CodeIterator$Table(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt) {
        super(paramInt1, paramInt2, paramArrayOfInt);
        this.low = paramInt3;
        this.high = paramInt4;
    }

    int tableSize() {
        return this.offsets.length * 4 + 8;
    }

    int write2(int paramInt, byte[] paramArrayOfByte) {
        ByteArray.write32bit(this.low, paramArrayOfByte, paramInt);
        ByteArray.write32bit(this.high, paramArrayOfByte, paramInt + 4);
        int j = this.offsets.length;
        int i = paramInt + 8;
        paramInt = 0;
        while (paramInt < j) {
            ByteArray.write32bit(this.offsets[paramInt], paramArrayOfByte, i);
            i += 4;
            paramInt += 1;
        }
        return j * 4 + 8;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/CodeIterator$Table.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */