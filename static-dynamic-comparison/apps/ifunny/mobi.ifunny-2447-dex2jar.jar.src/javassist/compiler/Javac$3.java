package javassist.compiler;

import javassist.bytecode.Bytecode;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;

class Javac$3
        implements ProceedHandler {
    Javac$3(Javac paramJavac, ASTree paramASTree, String paramString1, String paramString2, String paramString3) {
    }

    public void doit(JvstCodeGen paramJvstCodeGen, Bytecode paramBytecode, ASTList paramASTList) {
        paramJvstCodeGen.compileInvokeSpecial(this.val$texpr, this.val$cname, this.val$method, this.val$desc, paramASTList);
    }

    public void setReturnType(JvstTypeChecker paramJvstTypeChecker, ASTList paramASTList) {
        paramJvstTypeChecker.compileInvokeSpecial(this.val$texpr, this.val$cname, this.val$method, this.val$desc, paramASTList);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/Javac$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */