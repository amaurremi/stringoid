package javassist.compiler.ast;

public class BinExpr
        extends Expr {
    private BinExpr(int paramInt, ASTree paramASTree, ASTList paramASTList) {
        super(paramInt, paramASTree, paramASTList);
    }

    public static BinExpr makeBin(int paramInt, ASTree paramASTree1, ASTree paramASTree2) {
        return new BinExpr(paramInt, paramASTree1, new ASTList(paramASTree2));
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atBinExpr(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/BinExpr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */