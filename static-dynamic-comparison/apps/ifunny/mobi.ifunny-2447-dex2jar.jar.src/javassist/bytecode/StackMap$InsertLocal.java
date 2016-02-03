package javassist.bytecode;

class StackMap$InsertLocal
        extends StackMap.SimpleCopy {
    private int varData;
    private int varIndex;
    private int varTag;

    StackMap$InsertLocal(StackMap paramStackMap, int paramInt1, int paramInt2, int paramInt3) {
        super(paramStackMap);
        this.varIndex = paramInt1;
        this.varTag = paramInt2;
        this.varData = paramInt3;
    }

    private void writeVarTypeInfo() {
        if (this.varTag == 7) {
            this.writer.writeVerifyTypeInfo(7, this.varData);
            return;
        }
        if (this.varTag == 8) {
            this.writer.writeVerifyTypeInfo(8, this.varData);
            return;
        }
        this.writer.writeVerifyTypeInfo(this.varTag, 0);
    }

    public int typeInfoArray(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
        if ((!paramBoolean) || (paramInt3 < this.varIndex)) {
            paramInt2 = super.typeInfoArray(paramInt1, paramInt2, paramInt3, paramBoolean);
        }
        do {
            return paramInt2;
            this.writer.write16bit(paramInt3 + 1);
            paramInt2 = 0;
            while (paramInt2 < paramInt3) {
                if (paramInt2 == this.varIndex) {
                    writeVarTypeInfo();
                }
                paramInt1 = typeInfoArray2(paramInt2, paramInt1);
                paramInt2 += 1;
            }
            paramInt2 = paramInt1;
        } while (paramInt3 != this.varIndex);
        writeVarTypeInfo();
        return paramInt1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/StackMap$InsertLocal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */