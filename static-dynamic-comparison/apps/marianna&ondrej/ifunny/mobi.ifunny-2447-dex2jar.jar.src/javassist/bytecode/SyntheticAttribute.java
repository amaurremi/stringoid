package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;

public class SyntheticAttribute
        extends AttributeInfo {
    public static final String tag = "Synthetic";

    public SyntheticAttribute(ConstPool paramConstPool) {
        super(paramConstPool, "Synthetic", new byte[0]);
    }

    SyntheticAttribute(ConstPool paramConstPool, int paramInt, DataInputStream paramDataInputStream) {
        super(paramConstPool, paramInt, paramDataInputStream);
    }

    public AttributeInfo copy(ConstPool paramConstPool, Map paramMap) {
        return new SyntheticAttribute(paramConstPool);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/SyntheticAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */