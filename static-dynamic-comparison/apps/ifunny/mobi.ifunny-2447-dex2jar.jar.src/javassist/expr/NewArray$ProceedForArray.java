package javassist.expr;

import javassist.CtClass;
import javassist.bytecode.Bytecode;
import javassist.compiler.CompileError;
import javassist.compiler.JvstCodeGen;
import javassist.compiler.JvstTypeChecker;
import javassist.compiler.ProceedHandler;
import javassist.compiler.ast.ASTList;

class NewArray$ProceedForArray
        implements ProceedHandler {
    CtClass arrayType;
    int dimension;
    int index;
    int opcode;

    NewArray$ProceedForArray(CtClass paramCtClass, int paramInt1, int paramInt2, int paramInt3) {
        this.arrayType = paramCtClass;
        this.opcode = paramInt1;
        this.index = paramInt2;
        this.dimension = paramInt3;
    }

    public void doit(JvstCodeGen paramJvstCodeGen, Bytecode paramBytecode, ASTList paramASTList) {
        int i = paramJvstCodeGen.getMethodArgsLength(paramASTList);
        if (i != this.dimension) {
            throw new CompileError("$proceed() with a wrong number of parameters");
        }
        paramJvstCodeGen.atMethodArgs(paramASTList, new int[i], new int[i], new String[i]);
        paramBytecode.addOpcode(this.opcode);
        if (this.opcode == 189) {
            paramBytecode.addIndex(this.index);
        }
        for (; ; ) {
            paramJvstCodeGen.setType(this.arrayType);
            return;
            if (this.opcode == 188) {
                paramBytecode.add(this.index);
            } else {
                paramBytecode.addIndex(this.index);
                paramBytecode.add(this.dimension);
                paramBytecode.growStack(1 - this.dimension);
            }
        }
    }

    public void setReturnType(JvstTypeChecker paramJvstTypeChecker, ASTList paramASTList) {
        paramJvstTypeChecker.setType(this.arrayType);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/expr/NewArray$ProceedForArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */