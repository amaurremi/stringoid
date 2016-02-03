package javassist.bytecode;

class CodeIterator$Jump32
        extends CodeIterator.Branch {
    int offset;

    CodeIterator$Jump32(int paramInt1, int paramInt2) {
        super(paramInt1);
        this.offset = paramInt2;
    }

    void shift(int paramInt1, int paramInt2, boolean paramBoolean) {
        this.offset = shiftOffset(this.pos, this.offset, paramInt1, paramInt2, paramBoolean);
        super.shift(paramInt1, paramInt2, paramBoolean);
    }

    int write(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2) {
        paramArrayOfByte2[paramInt2] = paramArrayOfByte1[paramInt1];
        ByteArray.write32bit(this.offset, paramArrayOfByte2, paramInt2 + 1);
        return 5;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/CodeIterator$Jump32.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */