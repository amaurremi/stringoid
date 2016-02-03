package javassist.compiler.ast;

public class StringL
        extends ASTree {
    protected String text;

    public StringL(String paramString) {
        this.text = paramString;
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atStringL(this);
    }

    public String get() {
        return this.text;
    }

    public String toString() {
        return "\"" + this.text + "\"";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/StringL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */