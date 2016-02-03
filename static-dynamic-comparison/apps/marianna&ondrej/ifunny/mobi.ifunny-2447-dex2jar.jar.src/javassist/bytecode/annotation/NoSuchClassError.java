package javassist.bytecode.annotation;

public class NoSuchClassError
        extends Error {
    private String className;

    public NoSuchClassError(String paramString, Error paramError) {
        super(paramError.toString(), paramError);
        this.className = paramString;
    }

    public String getClassName() {
        return this.className;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/annotation/NoSuchClassError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */