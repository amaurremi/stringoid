package javassist.tools.rmi;

public class ObjectNotFoundException
        extends Exception {
    public ObjectNotFoundException(String paramString) {
        super(paramString + " is not exported");
    }

    public ObjectNotFoundException(String paramString, Exception paramException) {
        super(paramString + " because of " + paramException.toString());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/rmi/ObjectNotFoundException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */