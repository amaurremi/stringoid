package javassist.bytecode;

public class StackMap$Walker {
    byte[] info;

    public StackMap$Walker(StackMap paramStackMap) {
        this.info = paramStackMap.get();
    }

    public int locals(int paramInt1, int paramInt2, int paramInt3) {
        return typeInfoArray(paramInt1, paramInt2, paramInt3, true);
    }

    public void objectVariable(int paramInt1, int paramInt2) {
    }

    public int stack(int paramInt1, int paramInt2, int paramInt3) {
        return typeInfoArray(paramInt1, paramInt2, paramInt3, false);
    }

    public void typeInfo(int paramInt, byte paramByte) {
    }

    public int typeInfoArray(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
        int i = 0;
        paramInt2 = paramInt1;
        paramInt1 = i;
        while (paramInt1 < paramInt3) {
            paramInt2 = typeInfoArray2(paramInt1, paramInt2);
            paramInt1 += 1;
        }
        return paramInt2;
    }

    int typeInfoArray2(int paramInt1, int paramInt2) {
        byte b = this.info[paramInt2];
        if (b == 7) {
            objectVariable(paramInt2, ByteArray.readU16bit(this.info, paramInt2 + 1));
            return paramInt2 + 3;
        }
        if (b == 8) {
            uninitialized(paramInt2, ByteArray.readU16bit(this.info, paramInt2 + 1));
            return paramInt2 + 3;
        }
        typeInfo(paramInt2, b);
        return paramInt2 + 1;
    }

    public void uninitialized(int paramInt1, int paramInt2) {
    }

    public void visit() {
        int i = 0;
        int k = ByteArray.readU16bit(this.info, 0);
        int j = 2;
        while (i < k) {
            int m = ByteArray.readU16bit(this.info, j);
            j = locals(j + 4, m, ByteArray.readU16bit(this.info, j + 2));
            j = stack(j + 2, m, ByteArray.readU16bit(this.info, j));
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/StackMap$Walker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */