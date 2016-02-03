package javassist.tools.rmi;

public class Sample {
    private ObjectImporter importer;
    private int objectId;

    public static Object forwardStatic(Object[] paramArrayOfObject, int paramInt) {
        throw new RemoteException("cannot call a static method.");
    }

    public Object forward(Object[] paramArrayOfObject, int paramInt) {
        return this.importer.call(this.objectId, paramInt, paramArrayOfObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/rmi/Sample.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */