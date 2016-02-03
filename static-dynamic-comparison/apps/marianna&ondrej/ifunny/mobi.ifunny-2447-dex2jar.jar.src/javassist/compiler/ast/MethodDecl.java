package javassist.compiler.ast;

public class MethodDecl
        extends ASTList {
    public static final String initName = "<init>";

    public MethodDecl(ASTree paramASTree, ASTList paramASTList) {
        super(paramASTree, paramASTList);
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atMethodDecl(this);
    }

    public Stmnt getBody() {
        return (Stmnt) sublist(4).head();
    }

    public ASTList getModifiers() {
        return (ASTList) getLeft();
    }

    public ASTList getParams() {
        return (ASTList) sublist(2).head();
    }

    public Declarator getReturn() {
        return (Declarator) tail().head();
    }

    public ASTList getThrows() {
        return (ASTList) sublist(3).head();
    }

    public boolean isConstructor() {
        Symbol localSymbol = getReturn().getVariable();
        return (localSymbol != null) && ("<init>".equals(localSymbol.get()));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/MethodDecl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */