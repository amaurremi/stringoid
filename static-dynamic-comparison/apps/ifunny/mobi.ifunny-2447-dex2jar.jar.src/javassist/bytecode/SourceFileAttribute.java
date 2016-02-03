package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;

public class SourceFileAttribute
        extends AttributeInfo {
    public static final String tag = "SourceFile";

    SourceFileAttribute(ConstPool paramConstPool, int paramInt, DataInputStream paramDataInputStream) {
        super(paramConstPool, paramInt, paramDataInputStream);
    }

    public SourceFileAttribute(ConstPool paramConstPool, String paramString) {
        super(paramConstPool, "SourceFile");
        int i = paramConstPool.addUtf8Info(paramString);
        set(new byte[]{(byte) (i >>> 8), (byte) i});
    }

    public AttributeInfo copy(ConstPool paramConstPool, Map paramMap) {
        return new SourceFileAttribute(paramConstPool, getFileName());
    }

    public String getFileName() {
        return getConstPool().getUtf8Info(ByteArray.readU16bit(get(), 0));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/SourceFileAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */