package javassist.compiler;

import javassist.bytecode.Bytecode;
import javassist.compiler.ast.ASTList;

public abstract interface ProceedHandler {
    public abstract void doit(JvstCodeGen paramJvstCodeGen, Bytecode paramBytecode, ASTList paramASTList);

    public abstract void setReturnType(JvstTypeChecker paramJvstTypeChecker, ASTList paramASTList);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ProceedHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */