package javassist;

import javassist.bytecode.ConstPool;
import javassist.compiler.Javac;
import javassist.compiler.ast.ASTree;

class CtField$PtreeInitializer
        extends CtField.CodeInitializer0 {
    private ASTree expression;

    CtField$PtreeInitializer(ASTree paramASTree) {
        this.expression = paramASTree;
    }

    void compileExpr(Javac paramJavac) {
        paramJavac.compileExpr(this.expression);
    }

    int getConstantValue(ConstPool paramConstPool, CtClass paramCtClass) {
        return getConstantValue2(paramConstPool, paramCtClass, this.expression);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtField$PtreeInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */