package javassist.convert;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;

public class TransformReadField
        extends Transformer {
    protected CtClass fieldClass;
    protected String fieldname;
    protected boolean isPrivate;
    protected String methodClassname;
    protected String methodName;

    public TransformReadField(Transformer paramTransformer, CtField paramCtField, String paramString1, String paramString2) {
        super(paramTransformer);
        this.fieldClass = paramCtField.getDeclaringClass();
        this.fieldname = paramCtField.getName();
        this.methodClassname = paramString1;
        this.methodName = paramString2;
        this.isPrivate = Modifier.isPrivate(paramCtField.getModifiers());
    }

    static String isField(ClassPool paramClassPool, ConstPool paramConstPool, CtClass paramCtClass, String paramString, boolean paramBoolean, int paramInt) {
        if (!paramConstPool.getFieldrefName(paramInt).equals(paramString)) {
        }
        for (; ; ) {
            return null;
            try {
                paramClassPool = paramClassPool.get(paramConstPool.getFieldrefClassName(paramInt));
                if ((paramClassPool == paramCtClass) || ((!paramBoolean) && (isFieldInSuper(paramClassPool, paramCtClass, paramString)))) {
                    paramClassPool = paramConstPool.getFieldrefType(paramInt);
                    return paramClassPool;
                }
            } catch (NotFoundException paramClassPool) {
            }
        }
        return null;
    }

    static boolean isFieldInSuper(CtClass paramCtClass1, CtClass paramCtClass2, String paramString) {
        if (!paramCtClass1.subclassOf(paramCtClass2)) {
        }
        for (; ; ) {
            return false;
            try {
                paramCtClass1 = paramCtClass1.getField(paramString).getDeclaringClass();
                if (paramCtClass1 == paramCtClass2) {
                    return true;
                }
            } catch (NotFoundException paramCtClass1) {
            }
        }
        return false;
    }

    public int transform(CtClass paramCtClass, int paramInt, CodeIterator paramCodeIterator, ConstPool paramConstPool) {
        int j = paramCodeIterator.byteAt(paramInt);
        int i;
        if (j != 180) {
            i = paramInt;
            if (j != 178) {
            }
        } else {
            i = paramCodeIterator.u16bitAt(paramInt + 1);
            paramCtClass = isField(paramCtClass.getClassPool(), paramConstPool, this.fieldClass, this.fieldname, this.isPrivate, i);
            i = paramInt;
            if (paramCtClass != null) {
                i = paramInt;
                if (j == 178) {
                    paramCodeIterator.move(paramInt);
                    paramCodeIterator.writeByte(1, paramCodeIterator.insertGap(1));
                    i = paramCodeIterator.next();
                }
                paramCtClass = "(Ljava/lang/Object;)" + paramCtClass;
                paramInt = paramConstPool.addMethodrefInfo(paramConstPool.addClassInfo(this.methodClassname), this.methodName, paramCtClass);
                paramCodeIterator.writeByte(184, i);
                paramCodeIterator.write16bit(paramInt, i + 1);
            }
        }
        return i;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/convert/TransformReadField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */