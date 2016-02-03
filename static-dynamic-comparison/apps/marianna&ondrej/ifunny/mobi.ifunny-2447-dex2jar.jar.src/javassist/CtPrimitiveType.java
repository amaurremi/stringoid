package javassist;

public final class CtPrimitiveType
        extends CtClass {
    private int arrayType;
    private int dataSize;
    private char descriptor;
    private String getMethodName;
    private String mDescriptor;
    private int returnOp;
    private String wrapperName;

    CtPrimitiveType(String paramString1, char paramChar, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3) {
        super(paramString1);
        this.descriptor = paramChar;
        this.wrapperName = paramString2;
        this.getMethodName = paramString3;
        this.mDescriptor = paramString4;
        this.returnOp = paramInt1;
        this.arrayType = paramInt2;
        this.dataSize = paramInt3;
    }

    public int getArrayType() {
        return this.arrayType;
    }

    public int getDataSize() {
        return this.dataSize;
    }

    public char getDescriptor() {
        return this.descriptor;
    }

    public String getGetMethodDescriptor() {
        return this.mDescriptor;
    }

    public String getGetMethodName() {
        return this.getMethodName;
    }

    public int getModifiers() {
        return 17;
    }

    public int getReturnOp() {
        return this.returnOp;
    }

    public String getWrapperName() {
        return this.wrapperName;
    }

    public boolean isPrimitive() {
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtPrimitiveType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */