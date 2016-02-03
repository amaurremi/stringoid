package javassist.compiler.ast;

import javassist.compiler.TokenId;

public class Declarator
        extends ASTList
        implements TokenId {
    protected int arrayDim;
    protected int localVar;
    protected String qualifiedClass;
    protected int varType;

    public Declarator(int paramInt1, int paramInt2) {
        super(null);
        this.varType = paramInt1;
        this.arrayDim = paramInt2;
        this.localVar = -1;
        this.qualifiedClass = null;
    }

    public Declarator(int paramInt1, String paramString, int paramInt2, int paramInt3, Symbol paramSymbol) {
        super(null);
        this.varType = paramInt1;
        this.arrayDim = paramInt2;
        this.localVar = paramInt3;
        this.qualifiedClass = paramString;
        setLeft(paramSymbol);
        append(this, null);
    }

    public Declarator(ASTList paramASTList, int paramInt) {
        super(null);
        this.varType = 307;
        this.arrayDim = paramInt;
        this.localVar = -1;
        this.qualifiedClass = astToClassName(paramASTList, '/');
    }

    public static String astToClassName(ASTList paramASTList, char paramChar) {
        if (paramASTList == null) {
            return null;
        }
        StringBuffer localStringBuffer = new StringBuffer();
        astToClassName(localStringBuffer, paramASTList, paramChar);
        return localStringBuffer.toString();
    }

    private static void astToClassName(StringBuffer paramStringBuffer, ASTList paramASTList, char paramChar) {
        for (; ; ) {
            ASTree localASTree = paramASTList.head();
            if ((localASTree instanceof Symbol)) {
                paramStringBuffer.append(((Symbol) localASTree).get());
            }
            for (; ; ) {
                paramASTList = paramASTList.tail();
                if (paramASTList != null) {
                    break;
                }
                return;
                if ((localASTree instanceof ASTList)) {
                    astToClassName(paramStringBuffer, (ASTList) localASTree, paramChar);
                }
            }
            paramStringBuffer.append(paramChar);
        }
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atDeclarator(this);
    }

    public void addArrayDim(int paramInt) {
        this.arrayDim += paramInt;
    }

    public int getArrayDim() {
        return this.arrayDim;
    }

    public String getClassName() {
        return this.qualifiedClass;
    }

    public ASTree getInitializer() {
        ASTList localASTList = tail();
        if (localASTList != null) {
            return localASTList.head();
        }
        return null;
    }

    public int getLocalVar() {
        return this.localVar;
    }

    public String getTag() {
        return "decl";
    }

    public int getType() {
        return this.varType;
    }

    public Symbol getVariable() {
        return (Symbol) getLeft();
    }

    public Declarator make(Symbol paramSymbol, int paramInt, ASTree paramASTree) {
        Declarator localDeclarator = new Declarator(this.varType, this.arrayDim + paramInt);
        localDeclarator.qualifiedClass = this.qualifiedClass;
        localDeclarator.setLeft(paramSymbol);
        append(localDeclarator, paramASTree);
        return localDeclarator;
    }

    public void setClassName(String paramString) {
        this.qualifiedClass = paramString;
    }

    public void setLocalVar(int paramInt) {
        this.localVar = paramInt;
    }

    public void setVariable(Symbol paramSymbol) {
        setLeft(paramSymbol);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/Declarator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */