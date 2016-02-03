package javassist.bytecode;

public class BadBytecode
        extends Exception {
    public BadBytecode(int paramInt) {
        super("bytecode " + paramInt);
    }

    public BadBytecode(String paramString) {
        super(paramString);
    }

    public BadBytecode(String paramString, Throwable paramThrowable) {
        super(paramString, paramThrowable);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/BadBytecode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */