package javassist.bytecode;

class StackMap$NewRemover
        extends StackMap.SimpleCopy {
    int posOfNew;

    StackMap$NewRemover(StackMap paramStackMap, int paramInt) {
        super(paramStackMap);
        this.posOfNew = paramInt;
    }

    private int stackTypeInfoArray(int paramInt1, int paramInt2, int paramInt3) {
        int j = 0;
        int i = 0;
        int k = paramInt1;
        if (j < paramInt3) {
            paramInt2 = this.info[k];
            if (paramInt2 == 7) {
                paramInt2 = k + 3;
            }
            for (; ; ) {
                j += 1;
                k = paramInt2;
                break;
                if (paramInt2 == 8) {
                    paramInt2 = i;
                    if (ByteArray.readU16bit(this.info, k + 1) == this.posOfNew) {
                        paramInt2 = i + 1;
                    }
                    k += 3;
                    i = paramInt2;
                    paramInt2 = k;
                } else {
                    paramInt2 = k + 1;
                }
            }
        }
        this.writer.write16bit(paramInt3 - i);
        paramInt2 = 0;
        if (paramInt2 < paramInt3) {
            byte b = this.info[paramInt1];
            if (b == 7) {
                objectVariable(paramInt1, ByteArray.readU16bit(this.info, paramInt1 + 1));
                paramInt1 += 3;
            }
            for (; ; ) {
                paramInt2 += 1;
                break;
                if (b == 8) {
                    i = ByteArray.readU16bit(this.info, paramInt1 + 1);
                    if (i != this.posOfNew) {
                        uninitialized(paramInt1, i);
                    }
                    paramInt1 += 3;
                } else {
                    typeInfo(paramInt1, b);
                    paramInt1 += 1;
                }
            }
        }
        return paramInt1;
    }

    public int stack(int paramInt1, int paramInt2, int paramInt3) {
        return stackTypeInfoArray(paramInt1, paramInt2, paramInt3);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/StackMap$NewRemover.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */