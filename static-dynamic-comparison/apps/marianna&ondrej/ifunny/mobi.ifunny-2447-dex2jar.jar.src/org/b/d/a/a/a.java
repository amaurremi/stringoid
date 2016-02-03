package org.b.d.a.a;

public class a
        extends d {
    private Class<?> h;
    private Class<?> i;

    public a(Class<?> paramClass) {
        this(paramClass, null);
    }

    public a(Class<?> paramClass1, Class<?> paramClass2) {
        if (paramClass1 == null) {
            throw new NullPointerException();
        }
        a(a(paramClass1));
        this.h = paramClass1;
        this.i = paramClass2;
    }

    private String a(Class<?> paramClass) {
        if (paramClass == null) {
            paramClass = null;
        }
        String str;
        int j;
        do {
            return paramClass;
            str = paramClass.getName();
            j = str.lastIndexOf(".");
            paramClass = str;
        } while (j == -1);
        return str.substring(j + 1);
    }

    public Class<?> a() {
        return this.h;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */