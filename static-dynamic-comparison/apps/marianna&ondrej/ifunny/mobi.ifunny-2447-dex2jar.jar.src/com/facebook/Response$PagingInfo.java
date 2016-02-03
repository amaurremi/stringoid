package com.facebook;

import com.facebook.model.GraphObject;

abstract interface Response$PagingInfo
        extends GraphObject {
    public abstract String getNext();

    public abstract String getPrevious();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Response$PagingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */