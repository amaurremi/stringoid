package javassist.bytecode.stackmap;

public class BasicBlock$Catch {
    public BasicBlock body;
    public Catch next;
    public int typeIndex;

    BasicBlock$Catch(BasicBlock paramBasicBlock, int paramInt, Catch paramCatch) {
        this.body = paramBasicBlock;
        this.typeIndex = paramInt;
        this.next = paramCatch;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/stackmap/BasicBlock$Catch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */