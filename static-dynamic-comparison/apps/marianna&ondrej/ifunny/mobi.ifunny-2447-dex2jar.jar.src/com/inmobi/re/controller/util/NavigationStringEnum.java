package com.inmobi.re.controller.util;

public enum NavigationStringEnum {
    private String a;

    static {
        CLOSE = new NavigationStringEnum("CLOSE", 1, "close");
    }

    private NavigationStringEnum(String paramString) {
        this.a = paramString;
    }

    public static NavigationStringEnum fromString(String paramString) {
        if (paramString != null) {
            NavigationStringEnum[] arrayOfNavigationStringEnum = values();
            int j = arrayOfNavigationStringEnum.length;
            int i = 0;
            while (i < j) {
                NavigationStringEnum localNavigationStringEnum = arrayOfNavigationStringEnum[i];
                if (paramString.equalsIgnoreCase(localNavigationStringEnum.a)) {
                    return localNavigationStringEnum;
                }
                i += 1;
            }
        }
        return null;
    }

    public String getText() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/util/NavigationStringEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */