package javassist.compiler;

import javassist.CtClass;
import javassist.CtField;
import javassist.compiler.ast.ASTree;

public class Javac$CtFieldWithInit
        extends CtField {
    private ASTree init = null;

    Javac$CtFieldWithInit(CtClass paramCtClass1, String paramString, CtClass paramCtClass2) {
        super(paramCtClass1, paramString, paramCtClass2);
    }

    protected ASTree getInitAST() {
        return this.init;
    }

    protected void setInit(ASTree paramASTree) {
        this.init = paramASTree;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/Javac$CtFieldWithInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */