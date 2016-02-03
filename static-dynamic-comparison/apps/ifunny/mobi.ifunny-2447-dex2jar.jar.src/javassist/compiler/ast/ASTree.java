package javassist.compiler.ast;

import java.io.Serializable;

public abstract class ASTree
        implements Serializable {
    public abstract void accept(Visitor paramVisitor);

    public ASTree getLeft() {
        return null;
    }

    public ASTree getRight() {
        return null;
    }

    protected String getTag() {
        String str = getClass().getName();
        return str.substring(str.lastIndexOf('.') + 1);
    }

    public void setLeft(ASTree paramASTree) {
    }

    public void setRight(ASTree paramASTree) {
    }

    public String toString() {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append('<');
        localStringBuffer.append(getTag());
        localStringBuffer.append('>');
        return localStringBuffer.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/ASTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */