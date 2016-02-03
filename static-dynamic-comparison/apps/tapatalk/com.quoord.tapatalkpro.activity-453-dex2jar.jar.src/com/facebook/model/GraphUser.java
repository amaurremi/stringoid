package com.facebook.model;

public abstract interface GraphUser
        extends GraphObject {
    public abstract String getBirthday();

    public abstract String getFirstName();

    public abstract String getId();

    public abstract String getLastName();

    public abstract String getLink();

    public abstract GraphLocation getLocation();

    public abstract String getMiddleName();

    public abstract String getName();

    public abstract String getUsername();

    public abstract void setBirthday(String paramString);

    public abstract void setFirstName(String paramString);

    public abstract void setId(String paramString);

    public abstract void setLastName(String paramString);

    public abstract void setLink(String paramString);

    public abstract void setLocation(GraphLocation paramGraphLocation);

    public abstract void setMiddleName(String paramString);

    public abstract void setName(String paramString);

    public abstract void setUsername(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/model/GraphUser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */