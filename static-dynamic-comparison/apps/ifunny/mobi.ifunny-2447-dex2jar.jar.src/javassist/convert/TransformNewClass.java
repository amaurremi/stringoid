package javassist.convert;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;

public final class TransformNewClass
        extends Transformer {
    private String classname;
    private int nested;
    private int newClassIndex;
    private String newClassName;
    private int newMethodIndex;
    private int newMethodNTIndex;

    public TransformNewClass(Transformer paramTransformer, String paramString1, String paramString2) {
        super(paramTransformer);
        this.classname = paramString1;
        this.newClassName = paramString2;
    }

    public void initialize(ConstPool paramConstPool, CodeAttribute paramCodeAttribute) {
        this.nested = 0;
        this.newMethodIndex = 0;
        this.newMethodNTIndex = 0;
        this.newClassIndex = 0;
    }

    public int transform(CtClass paramCtClass, int paramInt, CodeIterator paramCodeIterator, ConstPool paramConstPool) {
        int i = paramCodeIterator.byteAt(paramInt);
        if (i == 187) {
            if (paramConstPool.getClassInfo(paramCodeIterator.u16bitAt(paramInt + 1)).equals(this.classname)) {
                if (paramCodeIterator.byteAt(paramInt + 3) != 89) {
                    throw new CannotCompileException("NEW followed by no DUP was found");
                }
                if (this.newClassIndex == 0) {
                    this.newClassIndex = paramConstPool.addClassInfo(this.newClassName);
                }
                paramCodeIterator.write16bit(this.newClassIndex, paramInt + 1);
                this.nested += 1;
            }
        }
        do {
            do {
                return paramInt;
            } while (i != 183);
            i = paramCodeIterator.u16bitAt(paramInt + 1);
        } while ((paramConstPool.isConstructor(this.classname, i) == 0) || (this.nested <= 0));
        i = paramConstPool.getMethodrefNameAndType(i);
        if (this.newMethodNTIndex != i) {
            this.newMethodNTIndex = i;
            this.newMethodIndex = paramConstPool.addMethodrefInfo(this.newClassIndex, i);
        }
        paramCodeIterator.write16bit(this.newMethodIndex, paramInt + 1);
        this.nested -= 1;
        return paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/convert/TransformNewClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */