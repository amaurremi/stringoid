package javassist.bytecode.stackmap;

import javassist.ClassPool;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.ConstPool;

public class TypeData$BasicType
        extends TypeData {
    private String name;
    private int typeTag;

    public TypeData$BasicType(String paramString, int paramInt) {
        this.name = paramString;
        this.typeTag = paramInt;
    }

    public TypeData copy() {
        return this;
    }

    public boolean equals(Object paramObject) {
        return this == paramObject;
    }

    public void evalExpectedType(ClassPool paramClassPool) {
    }

    public String getExpected() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public int getTypeData(ConstPool paramConstPool) {
        return 0;
    }

    public int getTypeTag() {
        return this.typeTag;
    }

    public boolean is2WordType() {
        return (this.typeTag == 4) || (this.typeTag == 3);
    }

    public boolean isObjectType() {
        return false;
    }

    public void merge(TypeData paramTypeData) {
    }

    protected void setType(String paramString, ClassPool paramClassPool) {
        throw new BadBytecode("conflict: " + this.name + " and " + paramString);
    }

    public String toString() {
        return this.name;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/stackmap/TypeData$BasicType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */