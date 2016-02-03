package javassist.tools.reflect;

public abstract interface Metalevel {
    public abstract ClassMetaobject _getClass();

    public abstract Metaobject _getMetaobject();

    public abstract void _setMetaobject(Metaobject paramMetaobject);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/reflect/Metalevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */