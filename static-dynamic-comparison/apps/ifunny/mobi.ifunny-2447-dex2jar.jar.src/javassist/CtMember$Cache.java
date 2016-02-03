package javassist;

class CtMember$Cache
        extends CtMember {
    private CtMember consTail = this;
    private CtMember fieldTail = this;
    private CtMember methodTail = this;

    CtMember$Cache(CtClassType paramCtClassType) {
        super(paramCtClassType);
        this.fieldTail.next = this;
    }

    static int count(CtMember paramCtMember1, CtMember paramCtMember2) {
        int i = 0;
        while (paramCtMember1 != paramCtMember2) {
            i += 1;
            paramCtMember1 = paramCtMember1.next;
        }
        return i;
    }

    void addConstructor(CtMember paramCtMember) {
        paramCtMember.next = this.consTail.next;
        this.consTail.next = paramCtMember;
        if (this.consTail == this.fieldTail) {
            this.fieldTail = paramCtMember;
        }
        this.consTail = paramCtMember;
    }

    void addField(CtMember paramCtMember) {
        paramCtMember.next = this;
        this.fieldTail.next = paramCtMember;
        this.fieldTail = paramCtMember;
    }

    void addMethod(CtMember paramCtMember) {
        paramCtMember.next = this.methodTail.next;
        this.methodTail.next = paramCtMember;
        if (this.methodTail == this.consTail) {
            this.consTail = paramCtMember;
            if (this.methodTail == this.fieldTail) {
                this.fieldTail = paramCtMember;
            }
        }
        this.methodTail = paramCtMember;
    }

    CtMember consHead() {
        return this.methodTail;
    }

    protected void extendToString(StringBuffer paramStringBuffer) {
    }

    CtMember fieldHead() {
        return this.consTail;
    }

    public Object getAnnotation(Class paramClass) {
        return null;
    }

    public Object[] getAnnotations() {
        return null;
    }

    public byte[] getAttribute(String paramString) {
        return null;
    }

    public Object[] getAvailableAnnotations() {
        return null;
    }

    public int getModifiers() {
        return 0;
    }

    public String getName() {
        return null;
    }

    public String getSignature() {
        return null;
    }

    public boolean hasAnnotation(Class paramClass) {
        return false;
    }

    CtMember lastCons() {
        return this.consTail;
    }

    CtMember lastField() {
        return this.fieldTail;
    }

    CtMember lastMethod() {
        return this.methodTail;
    }

    CtMember methodHead() {
        return this;
    }

    void remove(CtMember paramCtMember) {
        for (Object localObject = this; ; localObject = ((CtMember) localObject).next) {
            CtMember localCtMember = ((CtMember) localObject).next;
            if (localCtMember != this) {
                if (localCtMember != paramCtMember) {
                    continue;
                }
                ((CtMember) localObject).next = localCtMember.next;
                if (localCtMember == this.methodTail) {
                    this.methodTail = ((CtMember) localObject);
                }
                if (localCtMember == this.consTail) {
                    this.consTail = ((CtMember) localObject);
                }
                if (localCtMember == this.fieldTail) {
                    this.fieldTail = ((CtMember) localObject);
                }
            }
            return;
        }
    }

    public void setAttribute(String paramString, byte[] paramArrayOfByte) {
    }

    public void setModifiers(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtMember$Cache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */