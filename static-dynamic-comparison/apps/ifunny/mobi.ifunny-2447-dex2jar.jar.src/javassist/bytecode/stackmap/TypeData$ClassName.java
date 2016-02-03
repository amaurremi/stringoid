package javassist.bytecode.stackmap;

public class TypeData$ClassName
        extends TypeData.TypeName {
    private String name;

    public TypeData$ClassName(String paramString) {
        this.name = paramString;
    }

    public TypeData copy() {
        return new ClassName(this.name);
    }

    public String getName() {
        return this.name;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/stackmap/TypeData$ClassName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */