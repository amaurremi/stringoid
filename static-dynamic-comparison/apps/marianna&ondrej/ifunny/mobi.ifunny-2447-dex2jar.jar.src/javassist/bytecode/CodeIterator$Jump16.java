package javassist.bytecode;

class CodeIterator$Jump16
        extends CodeIterator.Branch16 {
    CodeIterator$Jump16(int paramInt1, int paramInt2) {
        super(paramInt1, paramInt2);
    }

    int deltaSize() {
        if (this.state == 2) {
            return 2;
        }
        return 0;
    }

    void write32(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2) {
        if ((paramArrayOfByte1[paramInt1] & 0xFF) == 167) {
        }
        for (paramInt1 = 200; ; paramInt1 = 201) {
            paramArrayOfByte2[paramInt2] = ((byte) paramInt1);
            ByteArray.write32bit(this.offset, paramArrayOfByte2, paramInt2 + 1);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/CodeIterator$Jump16.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */