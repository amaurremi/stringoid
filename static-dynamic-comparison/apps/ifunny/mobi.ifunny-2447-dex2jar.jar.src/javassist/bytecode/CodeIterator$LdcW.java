package javassist.bytecode;

class CodeIterator$LdcW
        extends CodeIterator.Branch {
    int index;
    boolean state;

    CodeIterator$LdcW(int paramInt1, int paramInt2) {
        super(paramInt1);
        this.index = paramInt2;
        this.state = true;
    }

    int deltaSize() {
        return 1;
    }

    boolean expanded() {
        boolean bool = false;
        if (this.state) {
            this.state = false;
            bool = true;
        }
        return bool;
    }

    int write(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2) {
        paramArrayOfByte2[paramInt2] = 19;
        ByteArray.write16bit(this.index, paramArrayOfByte2, paramInt2 + 1);
        return 2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/CodeIterator$LdcW.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */