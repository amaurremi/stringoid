package javassist.runtime;

public class DotClass {
    public static NoClassDefFoundError fail(ClassNotFoundException paramClassNotFoundException) {
        return new NoClassDefFoundError(paramClassNotFoundException.getMessage());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/runtime/DotClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */