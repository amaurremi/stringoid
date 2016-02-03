package javassist.bytecode;

public class SignatureAttribute$ClassType
        extends SignatureAttribute.ObjectType {
    SignatureAttribute.TypeArgument[] arguments;
    String name;

    SignatureAttribute$ClassType(String paramString, int paramInt1, int paramInt2, SignatureAttribute.TypeArgument[] paramArrayOfTypeArgument) {
        this.name = paramString.substring(paramInt1, paramInt2).replace('/', '.');
        this.arguments = paramArrayOfTypeArgument;
    }

    static ClassType make(String paramString, int paramInt1, int paramInt2, SignatureAttribute.TypeArgument[] paramArrayOfTypeArgument, ClassType paramClassType) {
        if (paramClassType == null) {
            return new ClassType(paramString, paramInt1, paramInt2, paramArrayOfTypeArgument);
        }
        return new SignatureAttribute.NestedClassType(paramString, paramInt1, paramInt2, paramArrayOfTypeArgument, paramClassType);
    }

    public ClassType getDeclaringClass() {
        return null;
    }

    public String getName() {
        return this.name;
    }

    public SignatureAttribute.TypeArgument[] getTypeArguments() {
        return this.arguments;
    }

    public String toString() {
        StringBuffer localStringBuffer = new StringBuffer();
        ClassType localClassType = getDeclaringClass();
        if (localClassType != null) {
            localStringBuffer.append(localClassType.toString()).append('.');
        }
        localStringBuffer.append(this.name);
        if (this.arguments != null) {
            localStringBuffer.append('<');
            int j = this.arguments.length;
            int i = 0;
            while (i < j) {
                if (i > 0) {
                    localStringBuffer.append(", ");
                }
                localStringBuffer.append(this.arguments[i].toString());
                i += 1;
            }
            localStringBuffer.append('>');
        }
        return localStringBuffer.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/SignatureAttribute$ClassType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */