package javassist.convert;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.MethodInfo;

public class TransformCall
        extends Transformer {
    protected String classname;
    protected ConstPool constPool;
    protected String methodDescriptor;
    protected String methodname;
    protected String newClassname;
    protected int newIndex;
    protected boolean newMethodIsPrivate;
    protected String newMethodname;

    public TransformCall(Transformer paramTransformer, String paramString, CtMethod paramCtMethod) {
        super(paramTransformer);
        this.methodname = paramString;
        this.methodDescriptor = paramCtMethod.getMethodInfo2().getDescriptor();
        paramTransformer = paramCtMethod.getDeclaringClass().getName();
        this.newClassname = paramTransformer;
        this.classname = paramTransformer;
        this.newMethodname = paramCtMethod.getName();
        this.constPool = null;
        this.newMethodIsPrivate = Modifier.isPrivate(paramCtMethod.getModifiers());
    }

    public TransformCall(Transformer paramTransformer, CtMethod paramCtMethod1, CtMethod paramCtMethod2) {
        this(paramTransformer, paramCtMethod1.getName(), paramCtMethod2);
        this.classname = paramCtMethod1.getDeclaringClass().getName();
    }

    private boolean matchClass(String paramString, ClassPool paramClassPool) {
        if (this.classname.equals(paramString)) {
            return true;
        }
        try {
            paramString = paramClassPool.get(paramString);
            boolean bool = paramString.subtypeOf(paramClassPool.get(this.classname));
            if (bool) {
            }
            return false;
        } catch (NotFoundException paramString) {
            try {
                bool = paramString.getMethod(this.methodname, this.methodDescriptor).getDeclaringClass().getName().equals(this.classname);
                return bool;
            } catch (NotFoundException paramString) {
            }
            paramString = paramString;
            return false;
        }
        return true;
    }

    public void initialize(ConstPool paramConstPool, CodeAttribute paramCodeAttribute) {
        if (this.constPool != paramConstPool) {
            this.newIndex = 0;
        }
    }

    protected int match(int paramInt1, int paramInt2, CodeIterator paramCodeIterator, int paramInt3, ConstPool paramConstPool) {
        int i;
        if (this.newIndex == 0) {
            paramInt3 = paramConstPool.addNameAndTypeInfo(paramConstPool.addUtf8Info(this.newMethodname), paramInt3);
            i = paramConstPool.addClassInfo(this.newClassname);
            if (paramInt1 != 185) {
                break label75;
            }
        }
        for (this.newIndex = paramConstPool.addInterfaceMethodrefInfo(i, paramInt3); ; this.newIndex = paramConstPool.addMethodrefInfo(i, paramInt3)) {
            this.constPool = paramConstPool;
            paramCodeIterator.write16bit(this.newIndex, paramInt2 + 1);
            return paramInt2;
            label75:
            if ((this.newMethodIsPrivate) && (paramInt1 == 182)) {
                paramCodeIterator.writeByte(183, paramInt2);
            }
        }
    }

    public int transform(CtClass paramCtClass, int paramInt, CodeIterator paramCodeIterator, ConstPool paramConstPool) {
        int j = paramCodeIterator.byteAt(paramInt);
        int i;
        if ((j != 185) && (j != 183) && (j != 184)) {
            i = paramInt;
            if (j != 182) {
            }
        } else {
            int k = paramCodeIterator.u16bitAt(paramInt + 1);
            String str = paramConstPool.eqMember(this.methodname, this.methodDescriptor, k);
            i = paramInt;
            if (str != null) {
                i = paramInt;
                if (matchClass(str, paramCtClass.getClassPool())) {
                    i = match(j, paramInt, paramCodeIterator, paramConstPool.getNameAndTypeDescriptor(paramConstPool.getMemberNameAndType(k)), paramConstPool);
                }
            }
        }
        return i;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/convert/TransformCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */