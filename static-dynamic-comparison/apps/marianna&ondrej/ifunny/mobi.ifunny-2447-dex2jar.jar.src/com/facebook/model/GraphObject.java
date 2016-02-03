package com.facebook.model;

import java.util.Map;

import org.json.JSONObject;

public abstract interface GraphObject {
    public abstract Map<String, Object> asMap();

    public abstract <T extends GraphObject> T cast(Class<T> paramClass);

    public abstract JSONObject getInnerJSONObject();

    public abstract Object getProperty(String paramString);

    public abstract <T extends GraphObject> T getPropertyAs(String paramString, Class<T> paramClass);

    public abstract <T extends GraphObject> GraphObjectList<T> getPropertyAsList(String paramString, Class<T> paramClass);

    public abstract void removeProperty(String paramString);

    public abstract void setProperty(String paramString, Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/model/GraphObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */