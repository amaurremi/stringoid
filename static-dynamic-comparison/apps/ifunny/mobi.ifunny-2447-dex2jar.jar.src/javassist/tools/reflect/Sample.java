package javassist.tools.reflect;

public class Sample {
    private static ClassMetaobject _classobject;
    private Metaobject _metaobject;

    public static Object trapRead(Object[] paramArrayOfObject, String paramString) {
        if (paramArrayOfObject[0] == null) {
            return _classobject.trapFieldRead(paramString);
        }
        return ((Metalevel) paramArrayOfObject[0])._getMetaobject().trapFieldRead(paramString);
    }

    public static Object trapStatic(Object[] paramArrayOfObject, int paramInt) {
        return _classobject.trapMethodcall(paramInt, paramArrayOfObject);
    }

    public static Object trapWrite(Object[] paramArrayOfObject, String paramString) {
        Metalevel localMetalevel = (Metalevel) paramArrayOfObject[0];
        if (localMetalevel == null) {
            _classobject.trapFieldWrite(paramString, paramArrayOfObject[1]);
        }
        for (; ; ) {
            return null;
            localMetalevel._getMetaobject().trapFieldWrite(paramString, paramArrayOfObject[1]);
        }
    }

    public Object trap(Object[] paramArrayOfObject, int paramInt) {
        Metaobject localMetaobject = this._metaobject;
        if (localMetaobject == null) {
            return ClassMetaobject.invoke(this, paramInt, paramArrayOfObject);
        }
        return localMetaobject.trapMethodcall(paramInt, paramArrayOfObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/reflect/Sample.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */