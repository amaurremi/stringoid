package javassist.bytecode;

class StackMap$SimpleCopy
        extends StackMap.Walker {
    StackMap.Writer writer = new StackMap.Writer();

    StackMap$SimpleCopy(StackMap paramStackMap) {
        super(paramStackMap);
    }

    byte[] doit() {
        visit();
        return this.writer.toByteArray();
    }

    public int locals(int paramInt1, int paramInt2, int paramInt3) {
        this.writer.write16bit(paramInt2);
        return super.locals(paramInt1, paramInt2, paramInt3);
    }

    public void objectVariable(int paramInt1, int paramInt2) {
        this.writer.writeVerifyTypeInfo(7, paramInt2);
    }

    public void typeInfo(int paramInt, byte paramByte) {
        this.writer.writeVerifyTypeInfo(paramByte, 0);
    }

    public int typeInfoArray(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
        this.writer.write16bit(paramInt3);
        return super.typeInfoArray(paramInt1, paramInt2, paramInt3, paramBoolean);
    }

    public void uninitialized(int paramInt1, int paramInt2) {
        this.writer.writeVerifyTypeInfo(8, paramInt2);
    }

    public void visit() {
        int i = ByteArray.readU16bit(this.info, 0);
        this.writer.write16bit(i);
        super.visit();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/StackMap$SimpleCopy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */