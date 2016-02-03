package com.facebook.model;

import java.util.Arrays;

public final class OpenGraphObject$Factory {
    public static <T extends OpenGraphObject> T createForPost(Class<T> paramClass, String paramString) {
        return createForPost(paramClass, paramString, null, null, null, null);
    }

    public static <T extends OpenGraphObject> T createForPost(Class<T> paramClass, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        paramClass = (OpenGraphObject) GraphObject.Factory.create(paramClass);
        if (paramString1 != null) {
            paramClass.setType(paramString1);
        }
        if (paramString2 != null) {
            paramClass.setTitle(paramString2);
        }
        if (paramString3 != null) {
            paramClass.setImageUrls(Arrays.asList(new String[]{paramString3}));
        }
        if (paramString4 != null) {
            paramClass.setUrl(paramString4);
        }
        if (paramString5 != null) {
            paramClass.setDescription(paramString5);
        }
        paramClass.setCreateObject(true);
        paramClass.setData(GraphObject.Factory.create());
        return paramClass;
    }

    public static OpenGraphObject createForPost(String paramString) {
        return createForPost(OpenGraphObject.class, paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/model/OpenGraphObject$Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */