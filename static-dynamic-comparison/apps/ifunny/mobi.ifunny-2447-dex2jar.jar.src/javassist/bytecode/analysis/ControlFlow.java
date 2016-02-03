package javassist.bytecode.analysis;

import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.MethodInfo;

public class ControlFlow {
    private ControlFlow.Block[] basicBlocks;
    private CtClass clazz;
    private Frame[] frames;
    private MethodInfo methodInfo;

    public ControlFlow(CtClass paramCtClass, MethodInfo paramMethodInfo) {
        this.clazz = paramCtClass;
        this.methodInfo = paramMethodInfo;
        this.frames = null;
        this.basicBlocks = ((ControlFlow.Block[]) new ControlFlow .1 (this).make(paramMethodInfo));
        int k = this.basicBlocks.length;
        paramCtClass = new int[k];
        int i = 0;
        while (i < k) {
            paramMethodInfo = this.basicBlocks[i];
            paramMethodInfo.index = i;
            paramMethodInfo.entrances = new ControlFlow.Block[paramMethodInfo.incomings()];
            paramCtClass[i] = 0;
            i += 1;
        }
        i = 0;
        while (i < k) {
            paramMethodInfo = this.basicBlocks[i];
            int j = 0;
            while (j < paramMethodInfo.exits()) {
                ControlFlow.Block localBlock = paramMethodInfo.exit(j);
                ControlFlow.Block[] arrayOfBlock = localBlock.entrances;
                int m = localBlock.index;
                int n = paramCtClass[m];
                paramCtClass[m] = (n + 1);
                arrayOfBlock[n] = paramMethodInfo;
                j += 1;
            }
            i += 1;
        }
    }

    public ControlFlow(CtMethod paramCtMethod) {
        this(paramCtMethod.getDeclaringClass(), paramCtMethod.getMethodInfo2());
    }

    public ControlFlow.Block[] basicBlocks() {
        return this.basicBlocks;
    }

    public ControlFlow.Node[] dominatorTree() {
        int j = this.basicBlocks.length;
        if (j == 0) {
            return null;
        }
        ControlFlow.Node[] arrayOfNode = new ControlFlow.Node[j];
        boolean[] arrayOfBoolean = new boolean[j];
        int[] arrayOfInt = new int[j];
        int i = 0;
        while (i < j) {
            arrayOfNode[i] = new ControlFlow.Node(this.basicBlocks[i]);
            arrayOfBoolean[i] = false;
            i += 1;
        }
        ControlFlow .2 local2 = new ControlFlow .2 (this, arrayOfNode);
        arrayOfNode[0].makeDepth1stTree(null, arrayOfBoolean, 0, arrayOfInt, local2);
        i = 0;
        while (i < j) {
            arrayOfBoolean[i] = false;
            i += 1;
        }
        while (arrayOfNode[0].makeDominatorTree(arrayOfBoolean, arrayOfInt, local2)) {
        }
        ControlFlow.Node.access$200(arrayOfNode);
        return arrayOfNode;
    }

    public Frame frameAt(int paramInt) {
        if (this.frames == null) {
            this.frames = new Analyzer().analyze(this.clazz, this.methodInfo);
        }
        return this.frames[paramInt];
    }

    public ControlFlow.Node[] postDominatorTree() {
        int m = this.basicBlocks.length;
        if (m == 0) {
            return null;
        }
        ControlFlow.Node[] arrayOfNode = new ControlFlow.Node[m];
        boolean[] arrayOfBoolean = new boolean[m];
        int[] arrayOfInt = new int[m];
        int i = 0;
        while (i < m) {
            arrayOfNode[i] = new ControlFlow.Node(this.basicBlocks[i]);
            arrayOfBoolean[i] = false;
            i += 1;
        }
        ControlFlow .3 local3 = new ControlFlow .3 (this, arrayOfNode);
        i = 0;
        int k;
        for (int j = 0; i < m; j = k) {
            k = j;
            if (ControlFlow.Node.access$100(arrayOfNode[i]).exits() == 0) {
                k = arrayOfNode[i].makeDepth1stTree(null, arrayOfBoolean, j, arrayOfInt, local3);
            }
            i += 1;
        }
        i = 0;
        while (i < m) {
            arrayOfBoolean[i] = false;
            i += 1;
        }
        do {
            i = 0;
            for (j = 0; i < m; j = k) {
                k = j;
                if (ControlFlow.Node.access$100(arrayOfNode[i]).exits() == 0) {
                    k = j;
                    if (arrayOfNode[i].makeDominatorTree(arrayOfBoolean, arrayOfInt, local3)) {
                        k = 1;
                    }
                }
                i += 1;
            }
        } while (j != 0);
        ControlFlow.Node.access$200(arrayOfNode);
        return arrayOfNode;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/analysis/ControlFlow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */