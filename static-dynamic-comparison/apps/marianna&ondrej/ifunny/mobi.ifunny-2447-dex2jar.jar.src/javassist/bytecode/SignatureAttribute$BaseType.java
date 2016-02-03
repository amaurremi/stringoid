package javassist.bytecode;

import javassist.CtClass;

public class SignatureAttribute$BaseType
        extends SignatureAttribute.Type {
    char descriptor;

    SignatureAttribute$BaseType(char paramChar) {
        this.descriptor = paramChar;
    }

    public CtClass getCtlass() {
        return Descriptor.toPrimitiveClass(this.descriptor);
    }

    public char getDescriptor() {
        return this.descriptor;
    }

    public String toString() {
        return Descriptor.toClassName(Character.toString(this.descriptor));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/SignatureAttribute$BaseType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */