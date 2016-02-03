package javassist.expr;

import javassist.CtClass;
import javassist.bytecode.Bytecode;
import javassist.compiler.CompileError;
import javassist.compiler.JvstCodeGen;
import javassist.compiler.JvstTypeChecker;
import javassist.compiler.ProceedHandler;
import javassist.compiler.ast.ASTList;

class Instanceof$ProceedForInstanceof
        implements ProceedHandler {
    int index;

    Instanceof$ProceedForInstanceof(int paramInt) {
        this.index = paramInt;
    }

    public void doit(JvstCodeGen paramJvstCodeGen, Bytecode paramBytecode, ASTList paramASTList) {
        if (paramJvstCodeGen.getMethodArgsLength(paramASTList) != 1) {
            throw new CompileError("$proceed() cannot take more than one parameter for instanceof");
        }
        paramJvstCodeGen.atMethodArgs(paramASTList, new int[1], new int[1], new String[1]);
        paramBytecode.addOpcode(193);
        paramBytecode.addIndex(this.index);
        paramJvstCodeGen.setType(CtClass.booleanType);
    }

    public void setReturnType(JvstTypeChecker paramJvstTypeChecker, ASTList paramASTList) {
        paramJvstTypeChecker.atMethodArgs(paramASTList, new int[1], new int[1], new String[1]);
        paramJvstTypeChecker.setType(CtClass.booleanType);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/expr/Instanceof$ProceedForInstanceof.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */