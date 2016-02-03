package javassist.bytecode.stackmap;

import javassist.bytecode.ConstPool;

public class TypeData$UninitThis
        extends TypeData.UninitData {
    TypeData$UninitThis(String paramString) {
        super(-1, paramString);
    }

    public boolean equals(Object paramObject) {
        return paramObject instanceof UninitThis;
    }

    public int getTypeData(ConstPool paramConstPool) {
        return 0;
    }

    public int getTypeTag() {
        return 6;
    }

    public String toString() {
        return "uninit:this";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/stackmap/TypeData$UninitThis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */