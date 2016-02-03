package javassist;

import java.io.DataOutputStream;

import javassist.bytecode.ClassFile;

class CtNewClass
        extends CtClassType {
    protected boolean hasConstructor;

    CtNewClass(String paramString, ClassPool paramClassPool, boolean paramBoolean, CtClass paramCtClass) {
        super(paramString, paramClassPool);
        this.wasChanged = true;
        if ((paramBoolean) || (paramCtClass == null)) {
        }
        for (paramClassPool = null; ; paramClassPool = paramCtClass.getName()) {
            this.classfile = new ClassFile(paramBoolean, paramString, paramClassPool);
            if ((paramBoolean) && (paramCtClass != null)) {
                this.classfile.setInterfaces(new String[]{paramCtClass.getName()});
            }
            setModifiers(Modifier.setPublic(getModifiers()));
            this.hasConstructor = paramBoolean;
            return;
        }
    }

    private boolean isInheritable(int paramInt, CtClass paramCtClass) {
        boolean bool2 = true;
        boolean bool1;
        if (Modifier.isPrivate(paramInt)) {
            bool1 = false;
        }
        String str;
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (!Modifier.isPackage(paramInt));
            str = getPackageName();
            paramCtClass = paramCtClass.getPackageName();
            if (str != null) {
                break;
            }
            bool1 = bool2;
        } while (paramCtClass == null);
        return false;
        return str.equals(paramCtClass);
    }

    public void addConstructor(CtConstructor paramCtConstructor) {
        this.hasConstructor = true;
        super.addConstructor(paramCtConstructor);
    }

    protected void extendToString(StringBuffer paramStringBuffer) {
        if (this.hasConstructor) {
            paramStringBuffer.append("hasConstructor ");
        }
        super.extendToString(paramStringBuffer);
    }

    public void inheritAllConstructors() {
        int i = 0;
        CtClass localCtClass = getSuperclass();
        CtConstructor[] arrayOfCtConstructor = localCtClass.getDeclaredConstructors();
        int k;
        for (int j = 0; i < arrayOfCtConstructor.length; j = k) {
            CtConstructor localCtConstructor = arrayOfCtConstructor[i];
            int m = localCtConstructor.getModifiers();
            k = j;
            if (isInheritable(m, localCtClass)) {
                localCtConstructor = CtNewConstructor.make(localCtConstructor.getParameterTypes(), localCtConstructor.getExceptionTypes(), this);
                localCtConstructor.setModifiers(m & 0x7);
                addConstructor(localCtConstructor);
                k = j + 1;
            }
            i += 1;
        }
        if (j < 1) {
            throw new CannotCompileException("no inheritable constructor in " + localCtClass.getName());
        }
    }

    public void toBytecode(DataOutputStream paramDataOutputStream) {
        if (!this.hasConstructor) {
        }
        try {
            inheritAllConstructors();
            this.hasConstructor = true;
            super.toBytecode(paramDataOutputStream);
            return;
        } catch (NotFoundException paramDataOutputStream) {
            throw new CannotCompileException(paramDataOutputStream);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtNewClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */