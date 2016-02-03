package com.facebook.model;

public abstract interface GraphLocation
        extends GraphObject {
    public abstract String getCity();

    public abstract String getCountry();

    public abstract double getLatitude();

    public abstract double getLongitude();

    public abstract String getState();

    public abstract String getStreet();

    public abstract String getZip();

    public abstract void setCity(String paramString);

    public abstract void setCountry(String paramString);

    public abstract void setLatitude(double paramDouble);

    public abstract void setLongitude(double paramDouble);

    public abstract void setState(String paramString);

    public abstract void setStreet(String paramString);

    public abstract void setZip(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/model/GraphLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */