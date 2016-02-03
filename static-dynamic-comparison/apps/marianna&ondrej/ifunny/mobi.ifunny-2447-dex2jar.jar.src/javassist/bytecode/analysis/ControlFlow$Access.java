package javassist.bytecode.analysis;

import javassist.bytecode.stackmap.BasicBlock;

abstract class ControlFlow$Access {
    ControlFlow.Node[] all;

    ControlFlow$Access(ControlFlow.Node[] paramArrayOfNode) {
        this.all = paramArrayOfNode;
    }

    abstract BasicBlock[] entrances(ControlFlow.Node paramNode);

    abstract BasicBlock[] exits(ControlFlow.Node paramNode);

    ControlFlow.Node node(BasicBlock paramBasicBlock) {
        return this.all[((ControlFlow.Block) paramBasicBlock).index];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/analysis/ControlFlow$Access.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */