package javassist.bytecode.analysis;

import javassist.bytecode.stackmap.BasicBlock;
import javassist.bytecode.stackmap.BasicBlock.Maker;

class ControlFlow$1
        extends BasicBlock.Maker {
    ControlFlow$1(ControlFlow paramControlFlow) {
    }

    protected BasicBlock[] makeArray(int paramInt) {
        return new ControlFlow.Block[paramInt];
    }

    protected BasicBlock makeBlock(int paramInt) {
        return new ControlFlow.Block(paramInt, ControlFlow.access$000(this.this$0));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/analysis/ControlFlow$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */