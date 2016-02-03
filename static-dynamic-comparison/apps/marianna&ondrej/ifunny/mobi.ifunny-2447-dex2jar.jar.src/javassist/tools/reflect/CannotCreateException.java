package javassist.tools.reflect;

public class CannotCreateException
        extends Exception {
    public CannotCreateException(Exception paramException) {
        super("by " + paramException.toString());
    }

    public CannotCreateException(String paramString) {
        super(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/reflect/CannotCreateException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */