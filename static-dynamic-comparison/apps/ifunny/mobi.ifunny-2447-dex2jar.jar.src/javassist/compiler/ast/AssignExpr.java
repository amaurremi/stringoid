package javassist.compiler.ast;

public class AssignExpr
        extends Expr {
    private AssignExpr(int paramInt, ASTree paramASTree, ASTList paramASTList) {
        super(paramInt, paramASTree, paramASTList);
    }

    public static AssignExpr makeAssign(int paramInt, ASTree paramASTree1, ASTree paramASTree2) {
        return new AssignExpr(paramInt, paramASTree1, new ASTList(paramASTree2));
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atAssignExpr(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/AssignExpr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */