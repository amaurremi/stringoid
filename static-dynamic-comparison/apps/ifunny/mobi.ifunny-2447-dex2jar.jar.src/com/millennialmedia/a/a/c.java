package com.millennialmedia.a.a;

public enum c
        implements i {
    private c() {
    }

    private static String a(char paramChar, String paramString, int paramInt) {
        if (paramInt < paramString.length()) {
            return paramChar + paramString.substring(paramInt);
        }
        return String.valueOf(paramChar);
    }

    private static String b(String paramString) {
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        char c1 = paramString.charAt(0);
        String str;
        if ((i >= paramString.length() - 1) || (Character.isLetter(c1))) {
            if (i != paramString.length()) {
                break label70;
            }
            str = localStringBuilder.toString();
        }
        label70:
        do {
            return str;
            localStringBuilder.append(c1);
            i += 1;
            c1 = paramString.charAt(i);
            break;
            str = paramString;
        } while (Character.isUpperCase(c1));
        return a(Character.toUpperCase(c1), paramString, i + 1);
    }

    private static String b(String paramString1, String paramString2) {
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        while (i < paramString1.length()) {
            char c1 = paramString1.charAt(i);
            if ((Character.isUpperCase(c1)) && (localStringBuilder.length() != 0)) {
                localStringBuilder.append(paramString2);
            }
            localStringBuilder.append(c1);
            i += 1;
        }
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */