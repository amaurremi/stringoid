package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;

public class LocalVariableTypeAttribute
        extends LocalVariableAttribute {
    public static final String tag = "LocalVariableTypeTable";

    public LocalVariableTypeAttribute(ConstPool paramConstPool) {
        super(paramConstPool, "LocalVariableTypeTable", new byte[2]);
        ByteArray.write16bit(0, this.info, 0);
    }

    LocalVariableTypeAttribute(ConstPool paramConstPool, int paramInt, DataInputStream paramDataInputStream) {
        super(paramConstPool, paramInt, paramDataInputStream);
    }

    private LocalVariableTypeAttribute(ConstPool paramConstPool, byte[] paramArrayOfByte) {
        super(paramConstPool, "LocalVariableTypeTable", paramArrayOfByte);
    }

    LocalVariableAttribute makeThisAttr(ConstPool paramConstPool, byte[] paramArrayOfByte) {
        return new LocalVariableTypeAttribute(paramConstPool, paramArrayOfByte);
    }

    String renameEntry(String paramString1, String paramString2, String paramString3) {
        return SignatureAttribute.renameClass(paramString1, paramString2, paramString3);
    }

    String renameEntry(String paramString, Map paramMap) {
        return SignatureAttribute.renameClass(paramString, paramMap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/LocalVariableTypeAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */