package javassist.bytecode.analysis;

import javassist.bytecode.ConstPool;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.stackmap.BasicBlock.Catch;

public class ControlFlow$Catcher {
    private ControlFlow.Block node;
    private int typeIndex;

    ControlFlow$Catcher(BasicBlock.Catch paramCatch) {
        this.node = ((ControlFlow.Block) paramCatch.body);
        this.typeIndex = paramCatch.typeIndex;
    }

    public ControlFlow.Block block() {
        return this.node;
    }

    public String type() {
        if (this.typeIndex == 0) {
            return "java.lang.Throwable";
        }
        return this.node.method.getConstPool().getClassInfo(this.typeIndex);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/analysis/ControlFlow$Catcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */