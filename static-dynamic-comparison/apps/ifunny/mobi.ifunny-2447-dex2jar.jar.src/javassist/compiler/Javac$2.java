package javassist.compiler;

import javassist.bytecode.Bytecode;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.CallExpr;
import javassist.compiler.ast.Expr;
import javassist.compiler.ast.Member;
import javassist.compiler.ast.Symbol;

class Javac$2
        implements ProceedHandler {
    Javac$2(Javac paramJavac, String paramString1, String paramString2) {
    }

    public void doit(JvstCodeGen paramJvstCodeGen, Bytecode paramBytecode, ASTList paramASTList) {
        paramJvstCodeGen.compileExpr(CallExpr.makeCall(Expr.make(35, new Symbol(this.val$c), new Member(this.val$m)), paramASTList));
        paramJvstCodeGen.addNullIfVoid();
    }

    public void setReturnType(JvstTypeChecker paramJvstTypeChecker, ASTList paramASTList) {
        CallExpr.makeCall(Expr.make(35, new Symbol(this.val$c), new Member(this.val$m)), paramASTList).accept(paramJvstTypeChecker);
        paramJvstTypeChecker.addNullIfVoid();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/Javac$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */