package javassist.bytecode.analysis;

import javassist.bytecode.stackmap.BasicBlock;

class ControlFlow$3
        extends ControlFlow.Access {
    ControlFlow$3(ControlFlow paramControlFlow, ControlFlow.Node[] paramArrayOfNode) {
        super(paramArrayOfNode);
    }

    BasicBlock[] entrances(ControlFlow.Node paramNode) {
        return ControlFlow.Node.access$100(paramNode).getExit();
    }

    BasicBlock[] exits(ControlFlow.Node paramNode) {
        return ControlFlow.Node.access$100(paramNode).entrances;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/analysis/ControlFlow$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */