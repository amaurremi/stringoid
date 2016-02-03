package org.b.g.a;

public final class a {
    private static final boolean a;

    static {
        try {
            boolean bool = System.getProperty("java.vm.name").equals("Dalvik");
            return;
        } finally {
            a = false;
        }
    }

    public static boolean a() {
        return a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/g/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */