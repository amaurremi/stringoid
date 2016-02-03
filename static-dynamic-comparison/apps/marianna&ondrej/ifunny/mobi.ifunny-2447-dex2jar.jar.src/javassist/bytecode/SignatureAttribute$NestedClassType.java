package javassist.bytecode;

public class SignatureAttribute$NestedClassType
        extends SignatureAttribute.ClassType {
    SignatureAttribute.ClassType parent;

    SignatureAttribute$NestedClassType(String paramString, int paramInt1, int paramInt2, SignatureAttribute.TypeArgument[] paramArrayOfTypeArgument, SignatureAttribute.ClassType paramClassType) {
        super(paramString, paramInt1, paramInt2, paramArrayOfTypeArgument);
        this.parent = paramClassType;
    }

    public SignatureAttribute.ClassType getDeclaringClass() {
        return this.parent;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/SignatureAttribute$NestedClassType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */