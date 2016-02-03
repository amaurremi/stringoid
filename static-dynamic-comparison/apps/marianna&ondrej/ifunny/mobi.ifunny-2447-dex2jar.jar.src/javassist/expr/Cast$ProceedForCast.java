package javassist.expr;

import javassist.CtClass;
import javassist.bytecode.Bytecode;
import javassist.compiler.CompileError;
import javassist.compiler.JvstCodeGen;
import javassist.compiler.JvstTypeChecker;
import javassist.compiler.ProceedHandler;
import javassist.compiler.ast.ASTList;

class Cast$ProceedForCast
        implements ProceedHandler {
    int index;
    CtClass retType;

    Cast$ProceedForCast(int paramInt, CtClass paramCtClass) {
        this.index = paramInt;
        this.retType = paramCtClass;
    }

    public void doit(JvstCodeGen paramJvstCodeGen, Bytecode paramBytecode, ASTList paramASTList) {
        if (paramJvstCodeGen.getMethodArgsLength(paramASTList) != 1) {
            throw new CompileError("$proceed() cannot take more than one parameter for cast");
        }
        paramJvstCodeGen.atMethodArgs(paramASTList, new int[1], new int[1], new String[1]);
        paramBytecode.addOpcode(192);
        paramBytecode.addIndex(this.index);
        paramJvstCodeGen.setType(this.retType);
    }

    public void setReturnType(JvstTypeChecker paramJvstTypeChecker, ASTList paramASTList) {
        paramJvstTypeChecker.atMethodArgs(paramASTList, new int[1], new int[1], new String[1]);
        paramJvstTypeChecker.setType(this.retType);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/expr/Cast$ProceedForCast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */