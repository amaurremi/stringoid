package javassist.compiler.ast;

import javassist.compiler.TokenId;

public class CastExpr
        extends ASTList
        implements TokenId {
    protected int arrayDim;
    protected int castType;

    public CastExpr(int paramInt1, int paramInt2, ASTree paramASTree) {
        super(null, new ASTList(paramASTree));
        this.castType = paramInt1;
        this.arrayDim = paramInt2;
    }

    public CastExpr(ASTList paramASTList, int paramInt, ASTree paramASTree) {
        super(paramASTList, new ASTList(paramASTree));
        this.castType = 307;
        this.arrayDim = paramInt;
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atCastExpr(this);
    }

    public int getArrayDim() {
        return this.arrayDim;
    }

    public ASTList getClassName() {
        return (ASTList) getLeft();
    }

    public ASTree getOprand() {
        return getRight().getLeft();
    }

    public String getTag() {
        return "cast:" + this.castType + ":" + this.arrayDim;
    }

    public int getType() {
        return this.castType;
    }

    public void setOprand(ASTree paramASTree) {
        getRight().setLeft(paramASTree);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/CastExpr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */