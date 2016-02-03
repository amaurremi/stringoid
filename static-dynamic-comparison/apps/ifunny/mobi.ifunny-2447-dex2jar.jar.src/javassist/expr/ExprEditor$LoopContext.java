package javassist.expr;

final class ExprEditor$LoopContext {
    int maxLocals;
    int maxStack;
    ExprEditor.NewOp newList;

    ExprEditor$LoopContext(int paramInt) {
        this.maxLocals = paramInt;
        this.maxStack = 0;
        this.newList = null;
    }

    void updateMax(int paramInt1, int paramInt2) {
        if (this.maxLocals < paramInt1) {
            this.maxLocals = paramInt1;
        }
        if (this.maxStack < paramInt2) {
            this.maxStack = paramInt2;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/expr/ExprEditor$LoopContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */