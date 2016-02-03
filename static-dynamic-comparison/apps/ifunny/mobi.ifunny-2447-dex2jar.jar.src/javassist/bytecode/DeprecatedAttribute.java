package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;

public class DeprecatedAttribute
        extends AttributeInfo {
    public static final String tag = "Deprecated";

    public DeprecatedAttribute(ConstPool paramConstPool) {
        super(paramConstPool, "Deprecated", new byte[0]);
    }

    DeprecatedAttribute(ConstPool paramConstPool, int paramInt, DataInputStream paramDataInputStream) {
        super(paramConstPool, paramInt, paramDataInputStream);
    }

    public AttributeInfo copy(ConstPool paramConstPool, Map paramMap) {
        return new DeprecatedAttribute(paramConstPool);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/DeprecatedAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */