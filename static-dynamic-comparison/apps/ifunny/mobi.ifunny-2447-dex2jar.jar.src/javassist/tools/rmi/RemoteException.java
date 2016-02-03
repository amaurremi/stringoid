package javassist.tools.rmi;

public class RemoteException
        extends RuntimeException {
    public RemoteException(Exception paramException) {
        super("by " + paramException.toString());
    }

    public RemoteException(String paramString) {
        super(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/rmi/RemoteException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */