package javassist.bytecode.stackmap;

import javassist.bytecode.BadBytecode;
import javassist.bytecode.ConstPool;

public class TypeData$NullType
        extends TypeData.ClassName {
    public TypeData$NullType() {
        super("null");
    }

    public TypeData copy() {
        return new NullType();
    }

    public String getExpected() {
        String str2 = this.expectedName;
        String str1 = str2;
        if (str2 == null) {
            str1 = "java.lang.Object";
        }
        return str1;
    }

    protected int getTypeData2(ConstPool paramConstPool, String paramString) {
        if ("null".equals(paramString)) {
            return 0;
        }
        return super.getTypeData2(paramConstPool, paramString);
    }

    public int getTypeTag() {
        try {
            if ("null".equals(getExpected())) {
                return 5;
            }
            int i = super.getTypeTag();
            return i;
        } catch (BadBytecode localBadBytecode) {
            throw new RuntimeException("fatal error: ", localBadBytecode);
        }
    }

    public boolean isNullType() {
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/stackmap/TypeData$NullType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */