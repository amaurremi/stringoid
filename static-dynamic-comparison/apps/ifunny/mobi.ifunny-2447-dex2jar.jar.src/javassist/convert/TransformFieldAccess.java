package javassist.convert;

import javassist.CtClass;
import javassist.CtField;
import javassist.Modifier;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;

public final class TransformFieldAccess
        extends Transformer {
    private ConstPool constPool;
    private CtClass fieldClass;
    private String fieldname;
    private boolean isPrivate;
    private String newClassname;
    private String newFieldname;
    private int newIndex;

    public TransformFieldAccess(Transformer paramTransformer, CtField paramCtField, String paramString1, String paramString2) {
        super(paramTransformer);
        this.fieldClass = paramCtField.getDeclaringClass();
        this.fieldname = paramCtField.getName();
        this.isPrivate = Modifier.isPrivate(paramCtField.getModifiers());
        this.newClassname = paramString1;
        this.newFieldname = paramString2;
        this.constPool = null;
    }

    public void initialize(ConstPool paramConstPool, CodeAttribute paramCodeAttribute) {
        if (this.constPool != paramConstPool) {
            this.newIndex = 0;
        }
    }

    public int transform(CtClass paramCtClass, int paramInt, CodeIterator paramCodeIterator, ConstPool paramConstPool) {
        int i = paramCodeIterator.byteAt(paramInt);
        if ((i == 180) || (i == 178) || (i == 181) || (i == 179)) {
            i = paramCodeIterator.u16bitAt(paramInt + 1);
            paramCtClass = TransformReadField.isField(paramCtClass.getClassPool(), paramConstPool, this.fieldClass, this.fieldname, this.isPrivate, i);
            if (paramCtClass != null) {
                if (this.newIndex == 0) {
                    i = paramConstPool.addNameAndTypeInfo(this.newFieldname, paramCtClass);
                    this.newIndex = paramConstPool.addFieldrefInfo(paramConstPool.addClassInfo(this.newClassname), i);
                    this.constPool = paramConstPool;
                }
                paramCodeIterator.write16bit(this.newIndex, paramInt + 1);
            }
        }
        return paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/convert/TransformFieldAccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */