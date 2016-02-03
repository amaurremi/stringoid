package javassist.compiler.ast;

import javassist.compiler.MemberResolver.Method;

public class CallExpr
        extends Expr {
    private MemberResolver.Method method = null;

    private CallExpr(ASTree paramASTree, ASTList paramASTList) {
        super(67, paramASTree, paramASTList);
    }

    public static CallExpr makeCall(ASTree paramASTree1, ASTree paramASTree2) {
        return new CallExpr(paramASTree1, new ASTList(paramASTree2));
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atCallExpr(this);
    }

    public MemberResolver.Method getMethod() {
        return this.method;
    }

    public void setMethod(MemberResolver.Method paramMethod) {
        this.method = paramMethod;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/CallExpr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */