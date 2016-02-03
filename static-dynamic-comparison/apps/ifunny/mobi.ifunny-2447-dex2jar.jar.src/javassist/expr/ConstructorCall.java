package javassist.expr;

import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.MethodInfo;

public class ConstructorCall
        extends MethodCall {
    protected ConstructorCall(int paramInt, CodeIterator paramCodeIterator, CtClass paramCtClass, MethodInfo paramMethodInfo) {
        super(paramInt, paramCodeIterator, paramCtClass, paramMethodInfo);
    }

    public CtConstructor getConstructor() {
        return getCtClass().getConstructor(getSignature());
    }

    public CtMethod getMethod() {
        throw new NotFoundException("this is a constructor call.  Call getConstructor().");
    }

    public String getMethodName() {
        if (isSuper()) {
            return "super";
        }
        return "this";
    }

    public boolean isSuper() {
        return super.isSuper();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/expr/ConstructorCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */