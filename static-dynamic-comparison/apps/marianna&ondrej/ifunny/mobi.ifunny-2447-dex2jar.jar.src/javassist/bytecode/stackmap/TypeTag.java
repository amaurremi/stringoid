package javassist.bytecode.stackmap;

public abstract interface TypeTag {
    public static final TypeData DOUBLE = new TypeData.BasicType("double", 3);
    public static final TypeData FLOAT;
    public static final TypeData INTEGER;
    public static final TypeData LONG = new TypeData.BasicType("long", 4);
    public static final TypeData TOP = null;

    static {
        INTEGER = new TypeData.BasicType("int", 1);
        FLOAT = new TypeData.BasicType("float", 2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/stackmap/TypeTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */