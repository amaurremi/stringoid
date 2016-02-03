package com.facebook.model;

import java.util.List;

import org.json.JSONArray;

public abstract interface GraphObjectList<T>
        extends List<T> {
    public abstract <U extends GraphObject> GraphObjectList<U> castToListOf(Class<U> paramClass);

    public abstract JSONArray getInnerJSONArray();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/model/GraphObjectList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */