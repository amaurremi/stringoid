package javassist.tools.rmi;

import java.io.Serializable;

public class RemoteRef
        implements Serializable {
    public String classname;
    public int oid;

    public RemoteRef(int paramInt) {
        this.oid = paramInt;
        this.classname = null;
    }

    public RemoteRef(int paramInt, String paramString) {
        this.oid = paramInt;
        this.classname = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/rmi/RemoteRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */