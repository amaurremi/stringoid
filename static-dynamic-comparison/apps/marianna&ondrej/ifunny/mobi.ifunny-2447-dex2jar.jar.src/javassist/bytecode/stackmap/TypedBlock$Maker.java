package javassist.bytecode.stackmap;

public class TypedBlock$Maker
        extends BasicBlock.Maker {
    protected BasicBlock[] makeArray(int paramInt) {
        return new TypedBlock[paramInt];
    }

    protected BasicBlock makeBlock(int paramInt) {
        return new TypedBlock(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/stackmap/TypedBlock$Maker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */