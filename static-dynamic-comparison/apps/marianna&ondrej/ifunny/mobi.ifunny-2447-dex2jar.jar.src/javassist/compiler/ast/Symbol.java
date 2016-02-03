package javassist.compiler.ast;

public class Symbol
        extends ASTree {
    protected String identifier;

    public Symbol(String paramString) {
        this.identifier = paramString;
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atSymbol(this);
    }

    public String get() {
        return this.identifier;
    }

    public String toString() {
        return this.identifier;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/Symbol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */