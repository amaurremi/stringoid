package javassist;

class CtClass$1
        extends ClassMap {
    CtClass$1(CtClass paramCtClass) {
    }

    public void fix(String paramString) {
    }

    public Object get(Object paramObject) {
        paramObject = toJavaName((String) paramObject);
        put0(paramObject, paramObject);
        return null;
    }

    public void put(String paramString1, String paramString2) {
        put0(paramString1, paramString2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtClass$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */