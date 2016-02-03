package javassist;

final class CtArray
        extends CtClass {
    private CtClass[] interfaces = null;
    protected ClassPool pool;

    CtArray(String paramString, ClassPool paramClassPool) {
        super(paramString);
        this.pool = paramClassPool;
    }

    public ClassPool getClassPool() {
        return this.pool;
    }

    public CtClass getComponentType() {
        String str = getName();
        return this.pool.get(str.substring(0, str.length() - 2));
    }

    public CtConstructor[] getConstructors() {
        try {
            CtConstructor[] arrayOfCtConstructor = getSuperclass().getConstructors();
            return arrayOfCtConstructor;
        } catch (NotFoundException localNotFoundException) {
        }
        return super.getConstructors();
    }

    public CtClass[] getInterfaces() {
        if (this.interfaces == null) {
            Class[] arrayOfClass = Object[].class.getInterfaces();
            this.interfaces = new CtClass[arrayOfClass.length];
            int i = 0;
            while (i < arrayOfClass.length) {
                this.interfaces[i] = this.pool.get(arrayOfClass[i].getName());
                i += 1;
            }
        }
        return this.interfaces;
    }

    public CtMethod getMethod(String paramString1, String paramString2) {
        return getSuperclass().getMethod(paramString1, paramString2);
    }

    public CtMethod[] getMethods() {
        try {
            CtMethod[] arrayOfCtMethod = getSuperclass().getMethods();
            return arrayOfCtMethod;
        } catch (NotFoundException localNotFoundException) {
        }
        return super.getMethods();
    }

    public int getModifiers() {
        try {
            int i = getComponentType().getModifiers();
            return 0x10 | i & 0x7;
        } catch (NotFoundException localNotFoundException) {
        }
        return 16;
    }

    public CtClass getSuperclass() {
        return this.pool.get("java.lang.Object");
    }

    public boolean isArray() {
        return true;
    }

    public boolean subtypeOf(CtClass paramCtClass) {
        boolean bool2 = false;
        if (super.subtypeOf(paramCtClass)) {
        }
        while (paramCtClass.getName().equals("java.lang.Object")) {
            return true;
        }
        CtClass[] arrayOfCtClass = getInterfaces();
        int i = 0;
        for (; ; ) {
            if (i >= arrayOfCtClass.length) {
                break label58;
            }
            if (arrayOfCtClass[i].subtypeOf(paramCtClass)) {
                break;
            }
            i += 1;
        }
        label58:
        boolean bool1 = bool2;
        if (paramCtClass.isArray()) {
            bool1 = bool2;
            if (getComponentType().subtypeOf(paramCtClass.getComponentType())) {
                bool1 = true;
            }
        }
        return bool1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */