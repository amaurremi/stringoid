package javassist.bytecode;

class StackMap$Shifter
        extends StackMap.Walker {
    private boolean exclusive;
    private int gap;
    private int where;

    public StackMap$Shifter(StackMap paramStackMap, int paramInt1, int paramInt2, boolean paramBoolean) {
        super(paramStackMap);
        this.where = paramInt1;
        this.gap = paramInt2;
        this.exclusive = paramBoolean;
    }

    public int locals(int paramInt1, int paramInt2, int paramInt3) {
        if (this.exclusive) {
            if (this.where > paramInt2) {
            }
        }
        for (; ; ) {
            ByteArray.write16bit(this.gap + paramInt2, this.info, paramInt1 - 4);
            do {
                return super.locals(paramInt1, paramInt2, paramInt3);
            } while (this.where >= paramInt2);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/StackMap$Shifter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */