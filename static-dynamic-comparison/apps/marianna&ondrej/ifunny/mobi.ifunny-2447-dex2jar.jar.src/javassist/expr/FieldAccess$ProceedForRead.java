package javassist.expr;

import javassist.CtClass;
import javassist.CtPrimitiveType;
import javassist.bytecode.Bytecode;
import javassist.compiler.CompileError;
import javassist.compiler.JvstCodeGen;
import javassist.compiler.JvstTypeChecker;
import javassist.compiler.ProceedHandler;
import javassist.compiler.ast.ASTList;

class FieldAccess$ProceedForRead
        implements ProceedHandler {
    CtClass fieldType;
    int index;
    int opcode;
    int targetVar;

    FieldAccess$ProceedForRead(CtClass paramCtClass, int paramInt1, int paramInt2, int paramInt3) {
        this.fieldType = paramCtClass;
        this.targetVar = paramInt3;
        this.opcode = paramInt1;
        this.index = paramInt2;
    }

    public void doit(JvstCodeGen paramJvstCodeGen, Bytecode paramBytecode, ASTList paramASTList) {
        if ((paramASTList != null) && (!paramJvstCodeGen.isParamListName(paramASTList))) {
            throw new CompileError("$proceed() cannot take a parameter for field reading");
        }
        int i;
        if (FieldAccess.isStatic(this.opcode)) {
            i = 0;
            if (!(this.fieldType instanceof CtPrimitiveType)) {
                break label105;
            }
            i = ((CtPrimitiveType) this.fieldType).getDataSize() + i;
        }
        for (; ; ) {
            paramBytecode.add(this.opcode);
            paramBytecode.addIndex(this.index);
            paramBytecode.growStack(i);
            paramJvstCodeGen.setType(this.fieldType);
            return;
            paramBytecode.addAload(this.targetVar);
            i = -1;
            break;
            label105:
            i += 1;
        }
    }

    public void setReturnType(JvstTypeChecker paramJvstTypeChecker, ASTList paramASTList) {
        paramJvstTypeChecker.setType(this.fieldType);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/expr/FieldAccess$ProceedForRead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */