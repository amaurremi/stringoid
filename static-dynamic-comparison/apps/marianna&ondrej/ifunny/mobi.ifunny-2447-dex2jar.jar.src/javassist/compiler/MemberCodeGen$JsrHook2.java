package javassist.compiler;

import javassist.bytecode.Bytecode;

class MemberCodeGen$JsrHook2
        extends CodeGen.ReturnHook {
    int target = paramArrayOfInt[0];
    int var = paramArrayOfInt[1];

    MemberCodeGen$JsrHook2(CodeGen paramCodeGen, int[] paramArrayOfInt) {
        super(paramCodeGen);
    }

    protected boolean doit(Bytecode paramBytecode, int paramInt) {
        switch (paramInt) {
            default:
                throw new RuntimeException("fatal");
            case 176:
                paramBytecode.addAstore(this.var);
        }
        for (; ; ) {
            paramBytecode.addOpcode(167);
            paramBytecode.addIndex(this.target - paramBytecode.currentPc() + 3);
            return true;
            paramBytecode.addIstore(this.var);
            continue;
            paramBytecode.addLstore(this.var);
            continue;
            paramBytecode.addDstore(this.var);
            continue;
            paramBytecode.addFstore(this.var);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/MemberCodeGen$JsrHook2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */