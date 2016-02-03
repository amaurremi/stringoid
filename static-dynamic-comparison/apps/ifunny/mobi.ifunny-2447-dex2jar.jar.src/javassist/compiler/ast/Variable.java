package javassist.compiler.ast;

public class Variable
        extends Symbol {
    protected Declarator declarator;

    public Variable(String paramString, Declarator paramDeclarator) {
        super(paramString);
        this.declarator = paramDeclarator;
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atVariable(this);
    }

    public Declarator getDeclarator() {
        return this.declarator;
    }

    public String toString() {
        return this.identifier + ":" + this.declarator.getType();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/Variable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */