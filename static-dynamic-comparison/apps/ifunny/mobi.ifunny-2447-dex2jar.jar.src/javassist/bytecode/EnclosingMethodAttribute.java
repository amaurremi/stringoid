package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;

public class EnclosingMethodAttribute
        extends AttributeInfo {
    public static final String tag = "EnclosingMethod";

    EnclosingMethodAttribute(ConstPool paramConstPool, int paramInt, DataInputStream paramDataInputStream) {
        super(paramConstPool, paramInt, paramDataInputStream);
    }

    public EnclosingMethodAttribute(ConstPool paramConstPool, String paramString) {
        super(paramConstPool, "EnclosingMethod");
        int i = paramConstPool.addClassInfo(paramString);
        set(new byte[]{(byte) (i >>> 8), (byte) i, (byte) 0, (byte) 0});
    }

    public EnclosingMethodAttribute(ConstPool paramConstPool, String paramString1, String paramString2, String paramString3) {
        super(paramConstPool, "EnclosingMethod");
        int i = paramConstPool.addClassInfo(paramString1);
        int j = paramConstPool.addNameAndTypeInfo(paramString2, paramString3);
        set(new byte[]{(byte) (i >>> 8), (byte) i, (byte) (j >>> 8), (byte) j});
    }

    public int classIndex() {
        return ByteArray.readU16bit(get(), 0);
    }

    public String className() {
        return getConstPool().getClassInfo(classIndex());
    }

    public AttributeInfo copy(ConstPool paramConstPool, Map paramMap) {
        if (methodIndex() == 0) {
            return new EnclosingMethodAttribute(paramConstPool, className());
        }
        return new EnclosingMethodAttribute(paramConstPool, className(), methodName(), methodDescriptor());
    }

    public String methodDescriptor() {
        ConstPool localConstPool = getConstPool();
        return localConstPool.getUtf8Info(localConstPool.getNameAndTypeDescriptor(methodIndex()));
    }

    public int methodIndex() {
        return ByteArray.readU16bit(get(), 2);
    }

    public String methodName() {
        ConstPool localConstPool = getConstPool();
        return localConstPool.getUtf8Info(localConstPool.getNameAndTypeName(methodIndex()));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/EnclosingMethodAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */