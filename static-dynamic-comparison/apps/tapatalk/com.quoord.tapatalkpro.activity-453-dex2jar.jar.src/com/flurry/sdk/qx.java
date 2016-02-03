package com.flurry.sdk;

public class qx {
    public static String a(mr parammr) {
        String str3 = parammr.b();
        String str2 = b(parammr, str3);
        String str1 = str2;
        if (str2 == null) {
            str1 = a(parammr, str3);
        }
        return str1;
    }

    public static String a(mr parammr, String paramString) {
        if (paramString.startsWith("get")) {
            if (!"getCallbacks".equals(paramString)) {
                break label27;
            }
            if (!c(parammr)) {
                break label43;
            }
        }
        label27:
        while (("getMetaClass".equals(paramString)) && (e(parammr))) {
            return null;
        }
        label43:
        return a(paramString.substring(3));
    }

    protected static String a(String paramString) {
        Object localObject1 = null;
        int j = paramString.length();
        if (j == 0) {
            paramString = null;
            return paramString;
        }
        int i = 0;
        for (; ; ) {
            char c2;
            if (i < j) {
                char c1 = paramString.charAt(i);
                c2 = Character.toLowerCase(c1);
                if (c1 != c2) {
                }
            } else {
                if (localObject1 == null) {
                    break;
                }
                return ((StringBuilder) localObject1).toString();
            }
            Object localObject2 = localObject1;
            if (localObject1 == null) {
                localObject2 = new StringBuilder(paramString);
            }
            ((StringBuilder) localObject2).setCharAt(i, c2);
            i += 1;
            localObject1 = localObject2;
        }
    }

    public static String b(mr parammr) {
        String str = parammr.b();
        if (str.startsWith("set")) {
            str = a(str.substring(3));
            if (str != null) {
                break label29;
            }
        }
        label29:
        while (("metaClass".equals(str)) && (d(parammr))) {
            return null;
        }
        return str;
    }

    public static String b(mr parammr, String paramString) {
        if (paramString.startsWith("is")) {
            parammr = parammr.d();
            if ((parammr == Boolean.class) || (parammr == Boolean.TYPE)) {
            }
        } else {
            return null;
        }
        return a(paramString.substring(2));
    }

    protected static boolean c(mr parammr) {
        parammr = parammr.d();
        if ((parammr == null) || (!parammr.isArray())) {
        }
        do {
            do {
                return false;
                parammr = parammr.getComponentType().getPackage();
            } while (parammr == null);
            parammr = parammr.getName();
        } while ((!parammr.startsWith("net.sf.cglib")) && (!parammr.startsWith("org.hibernate.repackage.cglib")));
        return true;
    }

    protected static boolean d(mr parammr) {
        boolean bool2 = false;
        parammr = parammr.a(0).getPackage();
        boolean bool1 = bool2;
        if (parammr != null) {
            bool1 = bool2;
            if (parammr.getName().startsWith("groovy.lang")) {
                bool1 = true;
            }
        }
        return bool1;
    }

    protected static boolean e(mr parammr) {
        parammr = parammr.d();
        if ((parammr == null) || (parammr.isArray())) {
        }
        do {
            return false;
            parammr = parammr.getPackage();
        } while ((parammr == null) || (!parammr.getName().startsWith("groovy.lang")));
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/qx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */