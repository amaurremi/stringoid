package javassist.expr;

import javassist.CtClass;
import javassist.CtPrimitiveType;
import javassist.bytecode.Bytecode;
import javassist.compiler.CompileError;
import javassist.compiler.JvstCodeGen;
import javassist.compiler.JvstTypeChecker;
import javassist.compiler.ProceedHandler;
import javassist.compiler.ast.ASTList;

class FieldAccess$ProceedForWrite
        implements ProceedHandler {
    CtClass fieldType;
    int index;
    int opcode;
    int targetVar;

    FieldAccess$ProceedForWrite(CtClass paramCtClass, int paramInt1, int paramInt2, int paramInt3) {
        this.fieldType = paramCtClass;
        this.targetVar = paramInt3;
        this.opcode = paramInt1;
        this.index = paramInt2;
    }

    public void doit(JvstCodeGen paramJvstCodeGen, Bytecode paramBytecode, ASTList paramASTList) {
        if (paramJvstCodeGen.getMethodArgsLength(paramASTList) != 1) {
            throw new CompileError("$proceed() cannot take more than one parameter for field writing");
        }
        int i;
        if (FieldAccess.isStatic(this.opcode)) {
            i = 0;
            paramJvstCodeGen.atMethodArgs(paramASTList, new int[1], new int[1], new String[1]);
            paramJvstCodeGen.doNumCast(this.fieldType);
            if (!(this.fieldType instanceof CtPrimitiveType)) {
                break label128;
            }
            i -= ((CtPrimitiveType) this.fieldType).getDataSize();
        }
        for (; ; ) {
            paramBytecode.add(this.opcode);
            paramBytecode.addIndex(this.index);
            paramBytecode.growStack(i);
            paramJvstCodeGen.setType(CtClass.voidType);
            paramJvstCodeGen.addNullIfVoid();
            return;
            paramBytecode.addAload(this.targetVar);
            i = -1;
            break;
            label128:
            i -= 1;
        }
    }

    public void setReturnType(JvstTypeChecker paramJvstTypeChecker, ASTList paramASTList) {
        paramJvstTypeChecker.atMethodArgs(paramASTList, new int[1], new int[1], new String[1]);
        paramJvstTypeChecker.setType(CtClass.voidType);
        paramJvstTypeChecker.addNullIfVoid();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/expr/FieldAccess$ProceedForWrite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */