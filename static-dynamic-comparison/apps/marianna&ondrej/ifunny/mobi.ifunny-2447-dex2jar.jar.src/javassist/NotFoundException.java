package javassist;

public class NotFoundException
        extends Exception {
    public NotFoundException(String paramString) {
        super(paramString);
    }

    public NotFoundException(String paramString, Exception paramException) {
        super(paramString + " because of " + paramException.toString());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/NotFoundException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */