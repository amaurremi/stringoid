package javassist.bytecode;

abstract class CodeIterator$Branch16
        extends CodeIterator.Branch {
    static final int BIT16 = 0;
    static final int BIT32 = 2;
    static final int EXPAND = 1;
    int offset;
    int state;

    CodeIterator$Branch16(int paramInt1, int paramInt2) {
        super(paramInt1);
        this.offset = paramInt2;
        this.state = 0;
    }

    abstract int deltaSize();

    boolean expanded() {
        if (this.state == 1) {
            this.state = 2;
            return true;
        }
        return false;
    }

    void shift(int paramInt1, int paramInt2, boolean paramBoolean) {
        this.offset = shiftOffset(this.pos, this.offset, paramInt1, paramInt2, paramBoolean);
        super.shift(paramInt1, paramInt2, paramBoolean);
        if ((this.state == 0) && ((this.offset < 32768) || (32767 < this.offset))) {
            this.state = 1;
        }
    }

    int write(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2) {
        if (this.state == 2) {
            write32(paramInt1, paramArrayOfByte1, paramInt2, paramArrayOfByte2);
        }
        for (; ; ) {
            return 3;
            paramArrayOfByte2[paramInt2] = paramArrayOfByte1[paramInt1];
            ByteArray.write16bit(this.offset, paramArrayOfByte2, paramInt2 + 1);
        }
    }

    abstract void write32(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/CodeIterator$Branch16.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */