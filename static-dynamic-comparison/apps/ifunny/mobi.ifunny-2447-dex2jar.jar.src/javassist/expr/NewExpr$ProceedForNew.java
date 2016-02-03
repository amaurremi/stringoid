package javassist.expr;

import javassist.CtClass;
import javassist.bytecode.Bytecode;
import javassist.compiler.JvstCodeGen;
import javassist.compiler.JvstTypeChecker;
import javassist.compiler.ProceedHandler;
import javassist.compiler.ast.ASTList;

class NewExpr$ProceedForNew
        implements ProceedHandler {
    int methodIndex;
    int newIndex;
    CtClass newType;

    NewExpr$ProceedForNew(CtClass paramCtClass, int paramInt1, int paramInt2) {
        this.newType = paramCtClass;
        this.newIndex = paramInt1;
        this.methodIndex = paramInt2;
    }

    public void doit(JvstCodeGen paramJvstCodeGen, Bytecode paramBytecode, ASTList paramASTList) {
        paramBytecode.addOpcode(187);
        paramBytecode.addIndex(this.newIndex);
        paramBytecode.addOpcode(89);
        paramJvstCodeGen.atMethodCallCore(this.newType, "<init>", paramASTList, false, true, -1, null);
        paramJvstCodeGen.setType(this.newType);
    }

    public void setReturnType(JvstTypeChecker paramJvstTypeChecker, ASTList paramASTList) {
        paramJvstTypeChecker.atMethodCallCore(this.newType, "<init>", paramASTList);
        paramJvstTypeChecker.setType(this.newType);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/expr/NewExpr$ProceedForNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */