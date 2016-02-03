package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;

public class ConstantAttribute
        extends AttributeInfo {
    public static final String tag = "ConstantValue";

    public ConstantAttribute(ConstPool paramConstPool, int paramInt) {
        super(paramConstPool, "ConstantValue");
        set(new byte[]{(byte) (paramInt >>> 8), (byte) paramInt});
    }

    ConstantAttribute(ConstPool paramConstPool, int paramInt, DataInputStream paramDataInputStream) {
        super(paramConstPool, paramInt, paramDataInputStream);
    }

    public AttributeInfo copy(ConstPool paramConstPool, Map paramMap) {
        return new ConstantAttribute(paramConstPool, getConstPool().copy(getConstantValue(), paramConstPool, paramMap));
    }

    public int getConstantValue() {
        return ByteArray.readU16bit(get(), 0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/ConstantAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */