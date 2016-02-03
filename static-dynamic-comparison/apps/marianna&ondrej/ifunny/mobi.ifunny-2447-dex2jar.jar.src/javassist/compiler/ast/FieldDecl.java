package javassist.compiler.ast;

public class FieldDecl
        extends ASTList {
    public FieldDecl(ASTree paramASTree, ASTList paramASTList) {
        super(paramASTree, paramASTList);
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atFieldDecl(this);
    }

    public Declarator getDeclarator() {
        return (Declarator) tail().head();
    }

    public ASTree getInit() {
        return sublist(2).head();
    }

    public ASTList getModifiers() {
        return (ASTList) getLeft();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/FieldDecl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */