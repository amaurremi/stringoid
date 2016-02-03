package javassist.compiler.ast;

import javassist.compiler.TokenId;

public class NewExpr
        extends ASTList
        implements TokenId {
    protected int arrayType;
    protected boolean newArray;

    public NewExpr(int paramInt, ASTList paramASTList, ArrayInit paramArrayInit) {
        super(null, new ASTList(paramASTList));
        this.newArray = true;
        this.arrayType = paramInt;
        if (paramArrayInit != null) {
            append(this, paramArrayInit);
        }
    }

    public NewExpr(ASTList paramASTList1, ASTList paramASTList2) {
        super(paramASTList1, new ASTList(paramASTList2));
        this.newArray = false;
        this.arrayType = 307;
    }

    public static NewExpr makeObjectArray(ASTList paramASTList1, ASTList paramASTList2, ArrayInit paramArrayInit) {
        paramASTList1 = new NewExpr(paramASTList1, paramASTList2);
        paramASTList1.newArray = true;
        if (paramArrayInit != null) {
            append(paramASTList1, paramArrayInit);
        }
        return paramASTList1;
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atNewExpr(this);
    }

    public ASTList getArguments() {
        return (ASTList) getRight().getLeft();
    }

    public ASTList getArraySize() {
        return getArguments();
    }

    public int getArrayType() {
        return this.arrayType;
    }

    public ASTList getClassName() {
        return (ASTList) getLeft();
    }

    public ArrayInit getInitializer() {
        ASTree localASTree = getRight().getRight();
        if (localASTree == null) {
            return null;
        }
        return (ArrayInit) localASTree.getLeft();
    }

    protected String getTag() {
        if (this.newArray) {
            return "new[]";
        }
        return "new";
    }

    public boolean isArray() {
        return this.newArray;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/NewExpr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */