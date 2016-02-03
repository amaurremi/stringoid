package javassist.bytecode;

public class SignatureAttribute$ClassSignature {
    SignatureAttribute.ClassType[] interfaces;
    SignatureAttribute.TypeParameter[] params;
    SignatureAttribute.ClassType superClass;

    SignatureAttribute$ClassSignature(SignatureAttribute.TypeParameter[] paramArrayOfTypeParameter, SignatureAttribute.ClassType paramClassType, SignatureAttribute.ClassType[] paramArrayOfClassType) {
        this.params = paramArrayOfTypeParameter;
        this.superClass = paramClassType;
        this.interfaces = paramArrayOfClassType;
    }

    public SignatureAttribute.ClassType[] getInterfaces() {
        return this.interfaces;
    }

    public SignatureAttribute.TypeParameter[] getParameters() {
        return this.params;
    }

    public SignatureAttribute.ClassType getSuperClass() {
        return this.superClass;
    }

    public String toString() {
        StringBuffer localStringBuffer = new StringBuffer();
        SignatureAttribute.TypeParameter.toString(localStringBuffer, this.params);
        localStringBuffer.append(" extends ").append(this.superClass);
        if (this.interfaces.length > 0) {
            localStringBuffer.append(" implements ");
            SignatureAttribute.Type.toString(localStringBuffer, this.interfaces);
        }
        return localStringBuffer.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/SignatureAttribute$ClassSignature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */