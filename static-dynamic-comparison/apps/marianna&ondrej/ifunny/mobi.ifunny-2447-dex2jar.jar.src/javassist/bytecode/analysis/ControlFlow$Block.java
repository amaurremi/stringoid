package javassist.bytecode.analysis;

import java.util.ArrayList;

import javassist.bytecode.MethodInfo;
import javassist.bytecode.stackmap.BasicBlock;
import javassist.bytecode.stackmap.BasicBlock.Catch;

public class ControlFlow$Block
        extends BasicBlock {
    public Object clientData = null;
    Block[] entrances;
    int index;
    MethodInfo method;

    ControlFlow$Block(int paramInt, MethodInfo paramMethodInfo) {
        super(paramInt);
        this.method = paramMethodInfo;
    }

    public ControlFlow.Catcher[] catchers() {
        ArrayList localArrayList = new ArrayList();
        for (BasicBlock.Catch localCatch = this.toCatch; localCatch != null; localCatch = localCatch.next) {
            localArrayList.add(new ControlFlow.Catcher(localCatch));
        }
        return (ControlFlow.Catcher[]) localArrayList.toArray(new ControlFlow.Catcher[localArrayList.size()]);
    }

    public Block exit(int paramInt) {
        return (Block) this.exit[paramInt];
    }

    public int exits() {
        if (this.exit == null) {
            return 0;
        }
        return this.exit.length;
    }

    BasicBlock[] getExit() {
        return this.exit;
    }

    public Block incoming(int paramInt) {
        return this.entrances[paramInt];
    }

    public int incomings() {
        return this.incoming;
    }

    public int index() {
        return this.index;
    }

    public int length() {
        return this.length;
    }

    public int position() {
        return this.position;
    }

    protected void toString2(StringBuffer paramStringBuffer) {
        super.toString2(paramStringBuffer);
        paramStringBuffer.append(", incomping{");
        int i = 0;
        while (i < this.entrances.length) {
            paramStringBuffer.append(this.entrances[i].position).append(", ");
            i += 1;
        }
        paramStringBuffer.append("}");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/analysis/ControlFlow$Block.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */