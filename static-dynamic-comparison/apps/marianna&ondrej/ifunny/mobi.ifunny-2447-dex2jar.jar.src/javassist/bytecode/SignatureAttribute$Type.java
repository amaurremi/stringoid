package javassist.bytecode;

public abstract class SignatureAttribute$Type {
    static void toString(StringBuffer paramStringBuffer, Type[] paramArrayOfType) {
        int i = 0;
        while (i < paramArrayOfType.length) {
            if (i > 0) {
                paramStringBuffer.append(", ");
            }
            paramStringBuffer.append(paramArrayOfType[i]);
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/SignatureAttribute$Type.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */