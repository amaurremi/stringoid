package com.facebook;

import com.facebook.model.GraphObject;

abstract interface TestSession$TestAccount
        extends GraphObject {
    public abstract String getAccessToken();

    public abstract String getId();

    public abstract String getName();

    public abstract void setName(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/TestSession$TestAccount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */