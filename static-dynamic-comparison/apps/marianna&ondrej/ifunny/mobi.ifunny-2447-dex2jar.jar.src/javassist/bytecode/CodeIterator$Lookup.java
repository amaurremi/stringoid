package javassist.bytecode;

class CodeIterator$Lookup
        extends CodeIterator.Switcher {
    int[] matches;

    CodeIterator$Lookup(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2) {
        super(paramInt1, paramInt2, paramArrayOfInt2);
        this.matches = paramArrayOfInt1;
    }

    int tableSize() {
        return this.matches.length * 8 + 4;
    }

    int write2(int paramInt, byte[] paramArrayOfByte) {
        int j = this.matches.length;
        ByteArray.write32bit(j, paramArrayOfByte, paramInt);
        int i = paramInt + 4;
        paramInt = 0;
        while (paramInt < j) {
            ByteArray.write32bit(this.matches[paramInt], paramArrayOfByte, i);
            ByteArray.write32bit(this.offsets[paramInt], paramArrayOfByte, i + 4);
            i += 8;
            paramInt += 1;
        }
        return j * 8 + 4;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/CodeIterator$Lookup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */