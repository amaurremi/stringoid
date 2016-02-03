package javassist.bytecode;

class StackMapTable$SimpleCopy
        extends StackMapTable.Walker {
    private StackMapTable.Writer writer;

    public StackMapTable$SimpleCopy(byte[] paramArrayOfByte) {
        super(paramArrayOfByte);
        this.writer = new StackMapTable.Writer(paramArrayOfByte.length);
    }

    public void appendFrame(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2) {
        this.writer.appendFrame(paramInt2, paramArrayOfInt1, copyData(paramArrayOfInt1, paramArrayOfInt2));
    }

    public void chopFrame(int paramInt1, int paramInt2, int paramInt3) {
        this.writer.chopFrame(paramInt2, paramInt3);
    }

    protected int copyData(int paramInt1, int paramInt2) {
        return paramInt2;
    }

    protected int[] copyData(int[] paramArrayOfInt1, int[] paramArrayOfInt2) {
        return paramArrayOfInt2;
    }

    public byte[] doit() {
        parse();
        return this.writer.toByteArray();
    }

    public void fullFrame(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4) {
        this.writer.fullFrame(paramInt2, paramArrayOfInt1, copyData(paramArrayOfInt1, paramArrayOfInt2), paramArrayOfInt3, copyData(paramArrayOfInt3, paramArrayOfInt4));
    }

    public void sameFrame(int paramInt1, int paramInt2) {
        this.writer.sameFrame(paramInt2);
    }

    public void sameLocals(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.writer.sameLocals(paramInt2, paramInt3, copyData(paramInt3, paramInt4));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/StackMapTable$SimpleCopy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */