package javassist.compiler.ast;

public class ASTList
        extends ASTree {
    private ASTree left;
    private ASTList right;

    public ASTList(ASTree paramASTree) {
        this.left = paramASTree;
        this.right = null;
    }

    public ASTList(ASTree paramASTree, ASTList paramASTList) {
        this.left = paramASTree;
        this.right = paramASTList;
    }

    public static ASTList append(ASTList paramASTList, ASTree paramASTree) {
        return concat(paramASTList, new ASTList(paramASTree));
    }

    public static ASTList concat(ASTList paramASTList1, ASTList paramASTList2) {
        if (paramASTList1 == null) {
            return paramASTList2;
        }
        for (ASTList localASTList = paramASTList1; localASTList.right != null; localASTList = localASTList.right) {
        }
        localASTList.right = paramASTList2;
        return paramASTList1;
    }

    public static int length(ASTList paramASTList) {
        int i = 0;
        int j = 0;
        ASTList localASTList = paramASTList;
        if (paramASTList == null) {
            return j;
        }
        for (; ; ) {
            j = i;
            if (localASTList == null) {
                break;
            }
            localASTList = localASTList.right;
            i += 1;
        }
    }

    public static ASTList make(ASTree paramASTree1, ASTree paramASTree2, ASTree paramASTree3) {
        return new ASTList(paramASTree1, new ASTList(paramASTree2, new ASTList(paramASTree3)));
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atASTList(this);
    }

    public ASTree getLeft() {
        return this.left;
    }

    public ASTree getRight() {
        return this.right;
    }

    public ASTree head() {
        return this.left;
    }

    public int length() {
        return length(this);
    }

    public void setHead(ASTree paramASTree) {
        this.left = paramASTree;
    }

    public void setLeft(ASTree paramASTree) {
        this.left = paramASTree;
    }

    public void setRight(ASTree paramASTree) {
        this.right = ((ASTList) paramASTree);
    }

    public void setTail(ASTList paramASTList) {
        this.right = paramASTList;
    }

    public ASTList sublist(int paramInt) {
        ASTList localASTList = this;
        while (paramInt > 0) {
            localASTList = localASTList.right;
            paramInt -= 1;
        }
        return localASTList;
    }

    public boolean subst(ASTree paramASTree1, ASTree paramASTree2) {
        for (ASTList localASTList = this; localASTList != null; localASTList = localASTList.right) {
            if (localASTList.left == paramASTree2) {
                localASTList.left = paramASTree1;
                return true;
            }
        }
        return false;
    }

    public ASTList tail() {
        return this.right;
    }

    public String toString() {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("(<");
        localStringBuffer.append(getTag());
        localStringBuffer.append('>');
        ASTList localASTList = this;
        if (localASTList != null) {
            localStringBuffer.append(' ');
            Object localObject = localASTList.left;
            if (localObject == null) {
            }
            for (localObject = "<null>"; ; localObject = ((ASTree) localObject).toString()) {
                localStringBuffer.append((String) localObject);
                localASTList = localASTList.right;
                break;
            }
        }
        localStringBuffer.append(')');
        return localStringBuffer.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/ASTList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */