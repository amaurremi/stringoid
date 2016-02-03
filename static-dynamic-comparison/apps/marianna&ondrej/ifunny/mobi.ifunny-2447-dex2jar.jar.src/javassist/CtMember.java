package javassist;

public abstract class CtMember {
    protected CtClass declaringClass;
    CtMember next;

    protected CtMember(CtClass paramCtClass) {
        this.declaringClass = paramCtClass;
        this.next = null;
    }

    protected abstract void extendToString(StringBuffer paramStringBuffer);

    public abstract Object getAnnotation(Class paramClass);

    public abstract Object[] getAnnotations();

    public abstract byte[] getAttribute(String paramString);

    public abstract Object[] getAvailableAnnotations();

    public CtClass getDeclaringClass() {
        return this.declaringClass;
    }

    public abstract int getModifiers();

    public abstract String getName();

    public abstract String getSignature();

    public abstract boolean hasAnnotation(Class paramClass);

    void nameReplaced() {
    }

    final CtMember next() {
        return this.next;
    }

    public abstract void setAttribute(String paramString, byte[] paramArrayOfByte);

    public abstract void setModifiers(int paramInt);

    public String toString() {
        StringBuffer localStringBuffer = new StringBuffer(getClass().getName());
        localStringBuffer.append("@");
        localStringBuffer.append(Integer.toHexString(hashCode()));
        localStringBuffer.append("[");
        localStringBuffer.append(Modifier.toString(getModifiers()));
        extendToString(localStringBuffer);
        localStringBuffer.append("]");
        return localStringBuffer.toString();
    }

    public boolean visibleFrom(CtClass paramCtClass) {
        boolean bool1 = true;
        boolean bool2 = true;
        int i = getModifiers();
        if (Modifier.isPublic(i)) {
        }
        do {
            return bool2;
            if (!Modifier.isPrivate(i)) {
                break;
            }
        } while (paramCtClass == this.declaringClass);
        return false;
        String str1 = this.declaringClass.getPackageName();
        String str2 = paramCtClass.getPackageName();
        if (str1 == null) {
            if (str2 != null) {
            }
        }
        for (; ; ) {
            bool2 = bool1;
            if (bool1) {
                break;
            }
            bool2 = bool1;
            if (!Modifier.isProtected(i)) {
                break;
            }
            return paramCtClass.subclassOf(this.declaringClass);
            bool1 = false;
            continue;
            bool1 = str1.equals(str2);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */