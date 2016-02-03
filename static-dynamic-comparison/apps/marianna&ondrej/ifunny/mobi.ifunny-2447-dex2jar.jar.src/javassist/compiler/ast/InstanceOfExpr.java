package javassist.compiler.ast;

public class InstanceOfExpr
        extends CastExpr {
    public InstanceOfExpr(int paramInt1, int paramInt2, ASTree paramASTree) {
        super(paramInt1, paramInt2, paramASTree);
    }

    public InstanceOfExpr(ASTList paramASTList, int paramInt, ASTree paramASTree) {
        super(paramASTList, paramInt, paramASTree);
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atInstanceOfExpr(this);
    }

    public String getTag() {
        return "instanceof:" + this.castType + ":" + this.arrayDim;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/InstanceOfExpr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */