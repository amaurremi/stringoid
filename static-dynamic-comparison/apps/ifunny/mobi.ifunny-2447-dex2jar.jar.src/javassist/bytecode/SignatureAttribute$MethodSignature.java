package javassist.bytecode;

public class SignatureAttribute$MethodSignature {
    SignatureAttribute.ObjectType[] exceptions;
    SignatureAttribute.Type[] params;
    SignatureAttribute.Type retType;
    SignatureAttribute.TypeParameter[] typeParams;

    SignatureAttribute$MethodSignature(SignatureAttribute.TypeParameter[] paramArrayOfTypeParameter, SignatureAttribute.Type[] paramArrayOfType, SignatureAttribute.Type paramType, SignatureAttribute.ObjectType[] paramArrayOfObjectType) {
        this.typeParams = paramArrayOfTypeParameter;
        this.params = paramArrayOfType;
        this.retType = paramType;
        this.exceptions = paramArrayOfObjectType;
    }

    public SignatureAttribute.ObjectType[] getExceptionTypes() {
        return this.exceptions;
    }

    public SignatureAttribute.Type[] getParameterTypes() {
        return this.params;
    }

    public SignatureAttribute.Type getReturnType() {
        return this.retType;
    }

    public SignatureAttribute.TypeParameter[] getTypeParameters() {
        return this.typeParams;
    }

    public String toString() {
        StringBuffer localStringBuffer = new StringBuffer();
        SignatureAttribute.TypeParameter.toString(localStringBuffer, this.typeParams);
        localStringBuffer.append(" (");
        SignatureAttribute.Type.toString(localStringBuffer, this.params);
        localStringBuffer.append(") ");
        localStringBuffer.append(this.retType);
        if (this.exceptions.length > 0) {
            localStringBuffer.append(" throws ");
            SignatureAttribute.Type.toString(localStringBuffer, this.exceptions);
        }
        return localStringBuffer.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/SignatureAttribute$MethodSignature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */