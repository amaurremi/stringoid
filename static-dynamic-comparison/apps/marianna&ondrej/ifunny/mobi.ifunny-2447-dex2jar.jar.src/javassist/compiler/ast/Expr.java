package javassist.compiler.ast;

import javassist.compiler.TokenId;

public class Expr
        extends ASTList
        implements TokenId {
    protected int operatorId;

    Expr(int paramInt, ASTree paramASTree) {
        super(paramASTree);
        this.operatorId = paramInt;
    }

    Expr(int paramInt, ASTree paramASTree, ASTList paramASTList) {
        super(paramASTree, paramASTList);
        this.operatorId = paramInt;
    }

    public static Expr make(int paramInt, ASTree paramASTree) {
        return new Expr(paramInt, paramASTree);
    }

    public static Expr make(int paramInt, ASTree paramASTree1, ASTree paramASTree2) {
        return new Expr(paramInt, paramASTree1, new ASTList(paramASTree2));
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atExpr(this);
    }

    public String getName() {
        int i = this.operatorId;
        if (i < 128) {
            return String.valueOf((char) i);
        }
        if ((350 <= i) && (i <= 371)) {
            return opNames[(i - 350)];
        }
        if (i == 323) {
            return "instanceof";
        }
        return String.valueOf(i);
    }

    public int getOperator() {
        return this.operatorId;
    }

    protected String getTag() {
        return "op:" + getName();
    }

    public ASTree oprand1() {
        return getLeft();
    }

    public ASTree oprand2() {
        return getRight().getLeft();
    }

    public void setOperator(int paramInt) {
        this.operatorId = paramInt;
    }

    public void setOprand1(ASTree paramASTree) {
        setLeft(paramASTree);
    }

    public void setOprand2(ASTree paramASTree) {
        getRight().setLeft(paramASTree);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/Expr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */