package javassist.compiler.ast;

public class ArrayInit
        extends ASTList {
    public ArrayInit(ASTree paramASTree) {
        super(paramASTree);
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atArrayInit(this);
    }

    public String getTag() {
        return "array";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/ArrayInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */