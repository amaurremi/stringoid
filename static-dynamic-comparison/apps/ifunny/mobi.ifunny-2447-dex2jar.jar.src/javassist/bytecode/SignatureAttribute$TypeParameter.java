package javassist.bytecode;

public class SignatureAttribute$TypeParameter {
    String name;
    SignatureAttribute.ObjectType superClass;
    SignatureAttribute.ObjectType[] superInterfaces;

    SignatureAttribute$TypeParameter(String paramString, int paramInt1, int paramInt2, SignatureAttribute.ObjectType paramObjectType, SignatureAttribute.ObjectType[] paramArrayOfObjectType) {
        this.name = paramString.substring(paramInt1, paramInt2);
        this.superClass = paramObjectType;
        this.superInterfaces = paramArrayOfObjectType;
    }

    static void toString(StringBuffer paramStringBuffer, TypeParameter[] paramArrayOfTypeParameter) {
        paramStringBuffer.append('<');
        int i = 0;
        while (i < paramArrayOfTypeParameter.length) {
            if (i > 0) {
                paramStringBuffer.append(", ");
            }
            paramStringBuffer.append(paramArrayOfTypeParameter[i]);
            i += 1;
        }
        paramStringBuffer.append('>');
    }

    public SignatureAttribute.ObjectType getClassBound() {
        return this.superClass;
    }

    public SignatureAttribute.ObjectType[] getInterfaceBound() {
        return this.superInterfaces;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        StringBuffer localStringBuffer = new StringBuffer(getName());
        if (this.superClass != null) {
            localStringBuffer.append(" extends ").append(this.superClass.toString());
        }
        int j = this.superInterfaces.length;
        if (j > 0) {
            int i = 0;
            if (i < j) {
                if ((i > 0) || (this.superClass != null)) {
                    localStringBuffer.append(" & ");
                }
                for (; ; ) {
                    localStringBuffer.append(this.superInterfaces[i].toString());
                    i += 1;
                    break;
                    localStringBuffer.append(" extends ");
                }
            }
        }
        return localStringBuffer.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/SignatureAttribute$TypeParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */