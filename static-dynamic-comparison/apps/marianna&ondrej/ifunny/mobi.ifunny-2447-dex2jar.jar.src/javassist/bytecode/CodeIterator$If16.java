package javassist.bytecode;

class CodeIterator$If16
        extends CodeIterator.Branch16 {
    CodeIterator$If16(int paramInt1, int paramInt2) {
        super(paramInt1, paramInt2);
    }

    int deltaSize() {
        if (this.state == 2) {
            return 5;
        }
        return 0;
    }

    int opcode(int paramInt) {
        if (paramInt == 198) {
            return 199;
        }
        if (paramInt == 199) {
            return 198;
        }
        if ((paramInt - 153 & 0x1) == 0) {
            return paramInt + 1;
        }
        return paramInt - 1;
    }

    void write32(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2) {
        paramArrayOfByte2[paramInt2] = ((byte) opcode(paramArrayOfByte1[paramInt1] & 0xFF));
        paramArrayOfByte2[(paramInt2 + 1)] = 0;
        paramArrayOfByte2[(paramInt2 + 2)] = 8;
        paramArrayOfByte2[(paramInt2 + 3)] = -56;
        ByteArray.write32bit(this.offset - 3, paramArrayOfByte2, paramInt2 + 4);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/CodeIterator$If16.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */