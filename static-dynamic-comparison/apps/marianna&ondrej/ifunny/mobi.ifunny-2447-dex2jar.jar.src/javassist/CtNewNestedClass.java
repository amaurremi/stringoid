package javassist;

import javassist.bytecode.ClassFile;
import javassist.bytecode.InnerClassesAttribute;

class CtNewNestedClass
        extends CtNewClass {
    CtNewNestedClass(String paramString, ClassPool paramClassPool, boolean paramBoolean, CtClass paramCtClass) {
        super(paramString, paramClassPool, paramBoolean, paramCtClass);
    }

    private static void updateInnerEntry(int paramInt, String paramString, CtClass paramCtClass, boolean paramBoolean) {
        int i = 0;
        Object localObject = (InnerClassesAttribute) paramCtClass.getClassFile2().getAttribute("InnerClasses");
        if (localObject == null) {
        }
        label140:
        for (; ; ) {
            return;
            int j = ((InnerClassesAttribute) localObject).tableLength();
            for (; ; ) {
                if (i >= j) {
                    break label140;
                }
                if (paramString.equals(((InnerClassesAttribute) localObject).innerClass(i))) {
                    ((InnerClassesAttribute) localObject).setAccessFlags(i, ((InnerClassesAttribute) localObject).accessFlags(i) & 0x8 | paramInt);
                    localObject = ((InnerClassesAttribute) localObject).outerClass(i);
                    if ((localObject == null) || (!paramBoolean)) {
                        break;
                    }
                    try {
                        updateInnerEntry(paramInt, paramString, paramCtClass.getClassPool().get((String) localObject), false);
                        return;
                    } catch (NotFoundException paramString) {
                        throw new RuntimeException("cannot find the declaring class: " + (String) localObject);
                    }
                }
                i += 1;
            }
        }
    }

    public void setModifiers(int paramInt) {
        paramInt &= 0xFFFFFFF7;
        super.setModifiers(paramInt);
        updateInnerEntry(paramInt, getName(), this, true);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtNewNestedClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */