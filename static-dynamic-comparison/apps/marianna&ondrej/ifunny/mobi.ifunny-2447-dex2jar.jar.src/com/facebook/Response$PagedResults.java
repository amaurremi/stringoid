package com.facebook;

import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;

abstract interface Response$PagedResults
        extends GraphObject {
    public abstract GraphObjectList<GraphObject> getData();

    public abstract Response.PagingInfo getPaging();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Response$PagedResults.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */