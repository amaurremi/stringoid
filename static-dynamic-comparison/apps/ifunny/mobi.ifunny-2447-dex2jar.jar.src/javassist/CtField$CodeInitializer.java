package javassist;

import javassist.bytecode.ConstPool;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;
import javassist.compiler.SymbolTable;

class CtField$CodeInitializer
        extends CtField.CodeInitializer0 {
    private String expression;

    CtField$CodeInitializer(String paramString) {
        this.expression = paramString;
    }

    void compileExpr(Javac paramJavac) {
        paramJavac.compileExpr(this.expression);
    }

    int getConstantValue(ConstPool paramConstPool, CtClass paramCtClass) {
        try {
            int i = getConstantValue2(paramConstPool, paramCtClass, Javac.parseExpr(this.expression, new SymbolTable()));
            return i;
        } catch (CompileError paramConstPool) {
        }
        return 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtField$CodeInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */