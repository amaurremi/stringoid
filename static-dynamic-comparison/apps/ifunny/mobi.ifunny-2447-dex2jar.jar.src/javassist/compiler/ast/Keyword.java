package javassist.compiler.ast;

public class Keyword
        extends ASTree {
    protected int tokenId;

    public Keyword(int paramInt) {
        this.tokenId = paramInt;
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atKeyword(this);
    }

    public int get() {
        return this.tokenId;
    }

    public String toString() {
        return "id:" + this.tokenId;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/Keyword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */