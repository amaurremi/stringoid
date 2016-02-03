package javassist.convert;

import javassist.CtClass;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.Opcode;

public abstract class Transformer
        implements Opcode {
    private Transformer next;

    public Transformer(Transformer paramTransformer) {
        this.next = paramTransformer;
    }

    public void clean() {
    }

    public int extraLocals() {
        return 0;
    }

    public int extraStack() {
        return 0;
    }

    public Transformer getNext() {
        return this.next;
    }

    public void initialize(ConstPool paramConstPool, CtClass paramCtClass, MethodInfo paramMethodInfo) {
        initialize(paramConstPool, paramMethodInfo.getCodeAttribute());
    }

    public void initialize(ConstPool paramConstPool, CodeAttribute paramCodeAttribute) {
    }

    public abstract int transform(CtClass paramCtClass, int paramInt, CodeIterator paramCodeIterator, ConstPool paramConstPool);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/convert/Transformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */