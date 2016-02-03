package javassist.bytecode;

abstract class CodeIterator$Branch {
    int orgPos;
    int pos;

    CodeIterator$Branch(int paramInt) {
        this.orgPos = paramInt;
        this.pos = paramInt;
    }

    static int shiftOffset(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
        int i = paramInt1 + paramInt2;
        if (paramInt1 < paramInt3) {
            if (paramInt3 >= i) {
                paramInt1 = paramInt2;
                if (paramBoolean) {
                    paramInt1 = paramInt2;
                    if (paramInt3 != i) {
                    }
                }
            } else {
                paramInt1 = paramInt2 + paramInt4;
            }
        }
        do {
            do {
                do {
                    do {
                        return paramInt1;
                        if (paramInt1 != paramInt3) {
                            break;
                        }
                        if ((i < paramInt3) && (paramBoolean)) {
                            return paramInt2 - paramInt4;
                        }
                        paramInt1 = paramInt2;
                    } while (paramInt3 >= i);
                    paramInt1 = paramInt2;
                } while (paramBoolean);
                return paramInt2 + paramInt4;
                if (i < paramInt3) {
                    break;
                }
                paramInt1 = paramInt2;
            } while (paramBoolean);
            paramInt1 = paramInt2;
        } while (paramInt3 != i);
        return paramInt2 - paramInt4;
    }

    int deltaSize() {
        return 0;
    }

    boolean expanded() {
        return false;
    }

    int gapChanged() {
        return 0;
    }

    void shift(int paramInt1, int paramInt2, boolean paramBoolean) {
        if ((paramInt1 < this.pos) || ((paramInt1 == this.pos) && (paramBoolean))) {
            this.pos += paramInt2;
        }
    }

    abstract int write(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/CodeIterator$Branch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */