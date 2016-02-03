package com.facebook.widget;

import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;

abstract interface GraphObjectPagingLoader$PagedResults
        extends GraphObject {
    public abstract GraphObjectList<GraphObject> getData();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/GraphObjectPagingLoader$PagedResults.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */