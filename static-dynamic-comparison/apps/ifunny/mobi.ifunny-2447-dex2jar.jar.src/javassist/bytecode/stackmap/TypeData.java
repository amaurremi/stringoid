package javassist.bytecode.stackmap;

import javassist.ClassPool;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.ConstPool;

public abstract class TypeData {
    static void setType(TypeData paramTypeData, String paramString, ClassPool paramClassPool) {
        if (paramTypeData == TypeTag.TOP) {
            throw new BadBytecode("unset variable");
        }
        paramTypeData.setType(paramString, paramClassPool);
    }

    public abstract TypeData copy();

    public abstract boolean equals(Object paramObject);

    public abstract void evalExpectedType(ClassPool paramClassPool);

    public abstract String getExpected();

    public abstract String getName();

    public TypeData getSelf() {
        return this;
    }

    public abstract int getTypeData(ConstPool paramConstPool);

    public abstract int getTypeTag();

    public boolean is2WordType() {
        return false;
    }

    public boolean isNullType() {
        return false;
    }

    public abstract boolean isObjectType();

    public abstract void merge(TypeData paramTypeData);

    protected abstract void setType(String paramString, ClassPool paramClassPool);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/stackmap/TypeData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */