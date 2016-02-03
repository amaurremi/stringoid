package javassist.convert;

import javassist.CtClass;
import javassist.CtField;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;

public final class TransformWriteField
        extends TransformReadField {
    public TransformWriteField(Transformer paramTransformer, CtField paramCtField, String paramString1, String paramString2) {
        super(paramTransformer, paramCtField, paramString1, paramString2);
    }

    public int transform(CtClass paramCtClass, int paramInt, CodeIterator paramCodeIterator, ConstPool paramConstPool) {
        int j = paramCodeIterator.byteAt(paramInt);
        int i;
        CodeAttribute localCodeAttribute;
        if (j != 181) {
            i = paramInt;
            if (j != 179) {
            }
        } else {
            i = paramCodeIterator.u16bitAt(paramInt + 1);
            paramCtClass = isField(paramCtClass.getClassPool(), paramConstPool, this.fieldClass, this.fieldname, this.isPrivate, i);
            i = paramInt;
            if (paramCtClass != null) {
                i = paramInt;
                if (j == 179) {
                    localCodeAttribute = paramCodeIterator.get();
                    paramCodeIterator.move(paramInt);
                    paramInt = paramCtClass.charAt(0);
                    if ((paramInt != 74) && (paramInt != 68)) {
                        break label222;
                    }
                    paramInt = paramCodeIterator.insertGap(3);
                    paramCodeIterator.writeByte(1, paramInt);
                    paramCodeIterator.writeByte(91, paramInt + 1);
                    paramCodeIterator.writeByte(87, paramInt + 2);
                    localCodeAttribute.setMaxStack(localCodeAttribute.getMaxStack() + 2);
                }
            }
        }
        for (; ; ) {
            i = paramCodeIterator.next();
            paramInt = paramConstPool.addClassInfo(this.methodClassname);
            paramCtClass = "(Ljava/lang/Object;" + paramCtClass + ")V";
            paramInt = paramConstPool.addMethodrefInfo(paramInt, this.methodName, paramCtClass);
            paramCodeIterator.writeByte(184, i);
            paramCodeIterator.write16bit(paramInt, i + 1);
            return i;
            label222:
            paramInt = paramCodeIterator.insertGap(2);
            paramCodeIterator.writeByte(1, paramInt);
            paramCodeIterator.writeByte(95, paramInt + 1);
            localCodeAttribute.setMaxStack(localCodeAttribute.getMaxStack() + 1);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/convert/TransformWriteField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */