package javassist.compiler;

import javassist.bytecode.Bytecode;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.CallExpr;
import javassist.compiler.ast.Expr;
import javassist.compiler.ast.Member;

class Javac$1
        implements ProceedHandler {
    Javac$1(Javac paramJavac, String paramString, ASTree paramASTree) {
    }

    public void doit(JvstCodeGen paramJvstCodeGen, Bytecode paramBytecode, ASTList paramASTList) {
        Member localMember = new Member(this.val$m);
        paramBytecode = localMember;
        if (this.val$texpr != null) {
            paramBytecode = Expr.make(46, this.val$texpr, localMember);
        }
        paramJvstCodeGen.compileExpr(CallExpr.makeCall(paramBytecode, paramASTList));
        paramJvstCodeGen.addNullIfVoid();
    }

    public void setReturnType(JvstTypeChecker paramJvstTypeChecker, ASTList paramASTList) {
        Member localMember = new Member(this.val$m);
        Object localObject = localMember;
        if (this.val$texpr != null) {
            localObject = Expr.make(46, this.val$texpr, localMember);
        }
        CallExpr.makeCall((ASTree) localObject, paramASTList).accept(paramJvstTypeChecker);
        paramJvstTypeChecker.addNullIfVoid();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/Javac$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */