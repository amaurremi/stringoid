package javassist.bytecode;

public class SignatureAttribute$TypeVariable
        extends SignatureAttribute.ObjectType {
    String name;

    SignatureAttribute$TypeVariable(String paramString, int paramInt1, int paramInt2) {
        this.name = paramString.substring(paramInt1, paramInt2);
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/SignatureAttribute$TypeVariable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */