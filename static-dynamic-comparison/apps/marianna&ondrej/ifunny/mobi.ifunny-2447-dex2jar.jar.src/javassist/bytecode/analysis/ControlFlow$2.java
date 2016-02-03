package javassist.bytecode.analysis;

import javassist.bytecode.stackmap.BasicBlock;

class ControlFlow$2
        extends ControlFlow.Access {
    ControlFlow$2(ControlFlow paramControlFlow, ControlFlow.Node[] paramArrayOfNode) {
        super(paramArrayOfNode);
    }

    BasicBlock[] entrances(ControlFlow.Node paramNode) {
        return ControlFlow.Node.access$100(paramNode).entrances;
    }

    BasicBlock[] exits(ControlFlow.Node paramNode) {
        return ControlFlow.Node.access$100(paramNode).getExit();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/analysis/ControlFlow$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */