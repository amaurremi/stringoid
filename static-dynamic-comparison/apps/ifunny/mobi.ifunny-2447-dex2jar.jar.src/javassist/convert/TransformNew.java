package javassist.convert;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.StackMap;
import javassist.bytecode.StackMapTable;

public final class TransformNew
        extends Transformer {
    private String classname;
    private int nested;
    private String trapClass;
    private String trapMethod;

    public TransformNew(Transformer paramTransformer, String paramString1, String paramString2, String paramString3) {
        super(paramTransformer);
        this.classname = paramString1;
        this.trapClass = paramString2;
        this.trapMethod = paramString3;
    }

    private int computeMethodref(int paramInt, ConstPool paramConstPool) {
        return paramConstPool.addMethodrefInfo(paramConstPool.addClassInfo(this.trapClass), paramConstPool.addNameAndTypeInfo(paramConstPool.addUtf8Info(this.trapMethod), paramConstPool.addUtf8Info(Descriptor.changeReturnType(this.classname, paramConstPool.getUtf8Info(paramInt)))));
    }

    public void initialize(ConstPool paramConstPool, CodeAttribute paramCodeAttribute) {
        this.nested = 0;
    }

    public int transform(CtClass paramCtClass, int paramInt, CodeIterator paramCodeIterator, ConstPool paramConstPool) {
        int i = paramCodeIterator.byteAt(paramInt);
        if (i == 187) {
            if (paramConstPool.getClassInfo(paramCodeIterator.u16bitAt(paramInt + 1)).equals(this.classname)) {
                if (paramCodeIterator.byteAt(paramInt + 3) != 89) {
                    throw new CannotCompileException("NEW followed by no DUP was found");
                }
                paramCodeIterator.writeByte(0, paramInt);
                paramCodeIterator.writeByte(0, paramInt + 1);
                paramCodeIterator.writeByte(0, paramInt + 2);
                paramCodeIterator.writeByte(0, paramInt + 3);
                this.nested += 1;
                paramCtClass = (StackMapTable) paramCodeIterator.get().getAttribute("StackMapTable");
                if (paramCtClass != null) {
                    paramCtClass.removeNew(paramInt);
                }
                paramCtClass = (StackMap) paramCodeIterator.get().getAttribute("StackMap");
                if (paramCtClass != null) {
                    paramCtClass.removeNew(paramInt);
                }
            }
        }
        do {
            do {
                return paramInt;
            } while (i != 183);
            i = paramCodeIterator.u16bitAt(paramInt + 1);
            i = paramConstPool.isConstructor(this.classname, i);
        } while ((i == 0) || (this.nested <= 0));
        i = computeMethodref(i, paramConstPool);
        paramCodeIterator.writeByte(184, paramInt);
        paramCodeIterator.write16bit(i, paramInt + 1);
        this.nested -= 1;
        return paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/convert/TransformNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */