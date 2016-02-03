package javassist.bytecode.analysis;

public class ControlFlow$Node {
    private ControlFlow.Block block;
    private Node[] children;
    private Node parent;

    ControlFlow$Node(ControlFlow.Block paramBlock) {
        this.block = paramBlock;
        this.parent = null;
    }

    private static Node getAncestor(Node paramNode1, Node paramNode2, int[] paramArrayOfInt) {
        for (; ; ) {
            Node localNode = paramNode1;
            if (paramNode1 != paramNode2) {
                if (paramArrayOfInt[paramNode1.block.index] >= paramArrayOfInt[paramNode2.block.index]) {
                    break label49;
                }
                localNode = paramNode1.parent;
                paramNode1 = paramNode2;
                paramNode2 = localNode;
            }
            while ((paramNode2 == null) || (paramNode1 == null)) {
                localNode = null;
                return localNode;
                label49:
                localNode = paramNode2.parent;
                paramNode2 = paramNode1;
                paramNode1 = localNode;
            }
            localNode = paramNode1;
            paramNode1 = paramNode2;
            paramNode2 = localNode;
        }
    }

    private static void setChildren(Node[] paramArrayOfNode) {
        int k = 0;
        int m = paramArrayOfNode.length;
        int[] arrayOfInt = new int[m];
        int i = 0;
        while (i < m) {
            arrayOfInt[i] = 0;
            i += 1;
        }
        i = 0;
        Node localNode1;
        while (i < m) {
            localNode1 = paramArrayOfNode[i].parent;
            if (localNode1 != null) {
                j = localNode1.block.index;
                arrayOfInt[j] += 1;
            }
            i += 1;
        }
        i = 0;
        while (i < m) {
            paramArrayOfNode[i].children = new Node[arrayOfInt[i]];
            i += 1;
        }
        int j = 0;
        for (; ; ) {
            i = k;
            if (j >= m) {
                break;
            }
            arrayOfInt[j] = 0;
            j += 1;
        }
        while (i < m) {
            localNode1 = paramArrayOfNode[i];
            Node localNode2 = localNode1.parent;
            if (localNode2 != null) {
                Node[] arrayOfNode = localNode2.children;
                j = localNode2.block.index;
                k = arrayOfInt[j];
                arrayOfInt[j] = (k + 1);
                arrayOfNode[k] = localNode1;
            }
            i += 1;
        }
    }

    public ControlFlow.Block block() {
        return this.block;
    }

    public Node child(int paramInt) {
        return this.children[paramInt];
    }

    public int children() {
        return this.children.length;
    }

    int makeDepth1stTree(Node paramNode, boolean[] paramArrayOfBoolean, int paramInt, int[] paramArrayOfInt, ControlFlow.Access paramAccess) {
        int k = this.block.index;
        if (paramArrayOfBoolean[k] != 0) {
            return paramInt;
        }
        paramArrayOfBoolean[k] = true;
        this.parent = paramNode;
        paramNode = paramAccess.exits(this);
        if (paramNode != null) {
            int i = 0;
            for (; ; ) {
                j = paramInt;
                if (i >= paramNode.length) {
                    break;
                }
                paramInt = paramAccess.node(paramNode[i]).makeDepth1stTree(this, paramArrayOfBoolean, paramInt, paramArrayOfInt, paramAccess);
                i += 1;
            }
        }
        int j = paramInt;
        paramArrayOfInt[k] = j;
        return j + 1;
    }

    boolean makeDominatorTree(boolean[] paramArrayOfBoolean, int[] paramArrayOfInt, ControlFlow.Access paramAccess) {
        int j = 0;
        int i = this.block.index;
        if (paramArrayOfBoolean[i] != 0) {
            return false;
        }
        paramArrayOfBoolean[i] = true;
        Object localObject = paramAccess.exits(this);
        if (localObject != null) {
            i = 0;
            bool2 = false;
            for (; ; ) {
                bool1 = bool2;
                if (i >= localObject.length) {
                    break;
                }
                if (paramAccess.node(localObject[i]).makeDominatorTree(paramArrayOfBoolean, paramArrayOfInt, paramAccess)) {
                    bool2 = true;
                }
                i += 1;
            }
        }
        boolean bool1 = false;
        paramArrayOfBoolean = paramAccess.entrances(this);
        boolean bool2 = bool1;
        if (paramArrayOfBoolean != null) {
            i = j;
            for (; ; ) {
                bool2 = bool1;
                if (i >= paramArrayOfBoolean.length) {
                    break;
                }
                bool2 = bool1;
                if (this.parent != null) {
                    localObject = getAncestor(this.parent, paramAccess.node(paramArrayOfBoolean[i]), paramArrayOfInt);
                    bool2 = bool1;
                    if (localObject != this.parent) {
                        this.parent = ((Node) localObject);
                        bool2 = true;
                    }
                }
                i += 1;
                bool1 = bool2;
            }
        }
        return bool2;
    }

    public Node parent() {
        return this.parent;
    }

    public String toString() {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("Node[pos=").append(block().position());
        localStringBuffer.append(", parent=");
        if (this.parent == null) {
        }
        for (String str = "*"; ; str = Integer.toString(this.parent.block().position())) {
            localStringBuffer.append(str);
            localStringBuffer.append(", children{");
            int i = 0;
            while (i < this.children.length) {
                localStringBuffer.append(this.children[i].block().position()).append(", ");
                i += 1;
            }
        }
        localStringBuffer.append("}]");
        return localStringBuffer.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/analysis/ControlFlow$Node.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */