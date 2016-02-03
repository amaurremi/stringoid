package javassist.compiler;

import java.util.ArrayList;

import javassist.bytecode.Bytecode;

class MemberCodeGen$JsrHook
        extends CodeGen.ReturnHook {
    CodeGen cgen;
    ArrayList jsrList = new ArrayList();
    int var;

    MemberCodeGen$JsrHook(CodeGen paramCodeGen) {
        super(paramCodeGen);
        this.cgen = paramCodeGen;
        this.var = -1;
    }

    private int getVar(int paramInt) {
        if (this.var < 0) {
            this.var = this.cgen.getMaxLocals();
            this.cgen.incMaxLocals(paramInt);
        }
        return this.var;
    }

    private void jsrJmp(Bytecode paramBytecode) {
        paramBytecode.addOpcode(167);
        this.jsrList.add(new int[]{paramBytecode.currentPc(), this.var});
        paramBytecode.addIndex(0);
    }

    protected boolean doit(Bytecode paramBytecode, int paramInt) {
        switch (paramInt) {
            default:
                throw new RuntimeException("fatal");
            case 177:
                jsrJmp(paramBytecode);
        }
        for (; ; ) {
            return false;
            paramBytecode.addAstore(getVar(1));
            jsrJmp(paramBytecode);
            paramBytecode.addAload(this.var);
            continue;
            paramBytecode.addIstore(getVar(1));
            jsrJmp(paramBytecode);
            paramBytecode.addIload(this.var);
            continue;
            paramBytecode.addLstore(getVar(2));
            jsrJmp(paramBytecode);
            paramBytecode.addLload(this.var);
            continue;
            paramBytecode.addDstore(getVar(2));
            jsrJmp(paramBytecode);
            paramBytecode.addDload(this.var);
            continue;
            paramBytecode.addFstore(getVar(1));
            jsrJmp(paramBytecode);
            paramBytecode.addFload(this.var);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/MemberCodeGen$JsrHook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */