package javassist.compiler;

import javassist.bytecode.Bytecode;

public abstract class CodeGen$ReturnHook {
    ReturnHook next;

    protected CodeGen$ReturnHook(CodeGen paramCodeGen) {
        this.next = paramCodeGen.returnHooks;
        paramCodeGen.returnHooks = this;
    }

    protected abstract boolean doit(Bytecode paramBytecode, int paramInt);

    protected void remove(CodeGen paramCodeGen) {
        paramCodeGen.returnHooks = this.next;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/CodeGen$ReturnHook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */