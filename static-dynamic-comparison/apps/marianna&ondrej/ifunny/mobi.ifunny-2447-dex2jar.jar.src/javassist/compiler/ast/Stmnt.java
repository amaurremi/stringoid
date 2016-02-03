package javassist.compiler.ast;

import javassist.compiler.TokenId;

public class Stmnt
        extends ASTList
        implements TokenId {
    protected int operatorId;

    public Stmnt(int paramInt) {
        this(paramInt, null);
    }

    public Stmnt(int paramInt, ASTree paramASTree) {
        super(paramASTree);
        this.operatorId = paramInt;
    }

    public Stmnt(int paramInt, ASTree paramASTree, ASTList paramASTList) {
        super(paramASTree, paramASTList);
        this.operatorId = paramInt;
    }

    public static Stmnt make(int paramInt, ASTree paramASTree1, ASTree paramASTree2) {
        return new Stmnt(paramInt, paramASTree1, new ASTList(paramASTree2));
    }

    public static Stmnt make(int paramInt, ASTree paramASTree1, ASTree paramASTree2, ASTree paramASTree3) {
        return new Stmnt(paramInt, paramASTree1, new ASTList(paramASTree2, new ASTList(paramASTree3)));
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atStmnt(this);
    }

    public int getOperator() {
        return this.operatorId;
    }

    protected String getTag() {
        if (this.operatorId < 128) {
            return "stmnt:" + (char) this.operatorId;
        }
        return "stmnt:" + this.operatorId;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/Stmnt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */