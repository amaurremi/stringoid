package javassist.bytecode;

public class SignatureAttribute$ArrayType
        extends SignatureAttribute.ObjectType {
    SignatureAttribute.Type componentType;
    int dim;

    public SignatureAttribute$ArrayType(int paramInt, SignatureAttribute.Type paramType) {
        this.dim = paramInt;
        this.componentType = paramType;
    }

    public SignatureAttribute.Type getComponentType() {
        return this.componentType;
    }

    public int getDimension() {
        return this.dim;
    }

    public String toString() {
        StringBuffer localStringBuffer = new StringBuffer(this.componentType.toString());
        int i = 0;
        while (i < this.dim) {
            localStringBuffer.append("[]");
            i += 1;
        }
        return localStringBuffer.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/SignatureAttribute$ArrayType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */