package javassist.bytecode.stackmap;

class BasicBlock$Mark
        implements Comparable {
    boolean alwaysJmp;
    BasicBlock block;
    BasicBlock.Catch catcher;
    BasicBlock[] jump;
    int position;
    int size;

    BasicBlock$Mark(int paramInt) {
        this.position = paramInt;
        this.block = null;
        this.jump = null;
        this.alwaysJmp = false;
        this.size = 0;
        this.catcher = null;
    }

    public int compareTo(Object paramObject) {
        if ((paramObject instanceof Mark)) {
            int i = ((Mark) paramObject).position;
            return this.position - i;
        }
        return -1;
    }

    void setJump(BasicBlock[] paramArrayOfBasicBlock, int paramInt, boolean paramBoolean) {
        this.jump = paramArrayOfBasicBlock;
        this.size = paramInt;
        this.alwaysJmp = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/stackmap/BasicBlock$Mark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */