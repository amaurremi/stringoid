package javassist.compiler.ast;

public class Pair
        extends ASTree {
    protected ASTree left;
    protected ASTree right;

    public Pair(ASTree paramASTree1, ASTree paramASTree2) {
        this.left = paramASTree1;
        this.right = paramASTree2;
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atPair(this);
    }

    public ASTree getLeft() {
        return this.left;
    }

    public ASTree getRight() {
        return this.right;
    }

    public void setLeft(ASTree paramASTree) {
        this.left = paramASTree;
    }

    public void setRight(ASTree paramASTree) {
        this.right = paramASTree;
    }

    public String toString() {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("(<Pair> ");
        if (this.left == null) {
            str = "<null>";
            localStringBuffer.append(str);
            localStringBuffer.append(" . ");
            if (this.right != null) {
                break label77;
            }
        }
        label77:
        for (String str = "<null>"; ; str = this.right.toString()) {
            localStringBuffer.append(str);
            localStringBuffer.append(')');
            return localStringBuffer.toString();
            str = this.left.toString();
            break;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/Pair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */