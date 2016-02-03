package javassist.compiler.ast;

public class CondExpr
        extends ASTList {
    public CondExpr(ASTree paramASTree1, ASTree paramASTree2, ASTree paramASTree3) {
        super(paramASTree1, new ASTList(paramASTree2, new ASTList(paramASTree3)));
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atCondExpr(this);
    }

    public ASTree condExpr() {
        return head();
    }

    public ASTree elseExpr() {
        return tail().tail().head();
    }

    public String getTag() {
        return "?:";
    }

    public void setCond(ASTree paramASTree) {
        setHead(paramASTree);
    }

    public void setElse(ASTree paramASTree) {
        tail().tail().setHead(paramASTree);
    }

    public void setThen(ASTree paramASTree) {
        tail().setHead(paramASTree);
    }

    public ASTree thenExpr() {
        return tail().head();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/CondExpr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */