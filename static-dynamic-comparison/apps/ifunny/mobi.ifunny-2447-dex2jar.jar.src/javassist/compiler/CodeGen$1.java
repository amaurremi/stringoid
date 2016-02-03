package javassist.compiler;

import javassist.bytecode.Bytecode;

class CodeGen$1
        extends CodeGen.ReturnHook {
    CodeGen$1(CodeGen paramCodeGen1, CodeGen paramCodeGen2, int paramInt) {
        super(paramCodeGen2);
    }

    protected boolean doit(Bytecode paramBytecode, int paramInt) {
        paramBytecode.addAload(this.val$var);
        paramBytecode.addOpcode(195);
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/CodeGen$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */