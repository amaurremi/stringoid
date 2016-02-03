package javassist.bytecode.stackmap;

import javassist.ClassPool;
import javassist.bytecode.ConstPool;

public class TypeData$UninitData
        extends TypeData {
    String className;
    boolean initialized;
    int offset;

    TypeData$UninitData(int paramInt, String paramString) {
        this.className = paramString;
        this.offset = paramInt;
        this.initialized = false;
    }

    public TypeData copy() {
        return new TypeData.ClassName(this.className);
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((paramObject instanceof UninitData)) {
            paramObject = (UninitData) paramObject;
            bool1 = bool2;
            if (this.offset == ((UninitData) paramObject).offset) {
                bool1 = bool2;
                if (this.className.equals(((UninitData) paramObject).className)) {
                    bool1 = true;
                }
            }
        }
        return bool1;
    }

    public void evalExpectedType(ClassPool paramClassPool) {
    }

    public String getExpected() {
        return this.className;
    }

    public String getName() {
        return this.className;
    }

    public TypeData getSelf() {
        Object localObject = this;
        if (this.initialized) {
            localObject = copy();
        }
        return (TypeData) localObject;
    }

    public int getTypeData(ConstPool paramConstPool) {
        return this.offset;
    }

    public int getTypeTag() {
        return 8;
    }

    public boolean isObjectType() {
        return true;
    }

    public void merge(TypeData paramTypeData) {
    }

    protected void setType(String paramString, ClassPool paramClassPool) {
        this.initialized = true;
    }

    public String toString() {
        return "uninit:" + this.className + "@" + this.offset;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/stackmap/TypeData$UninitData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */