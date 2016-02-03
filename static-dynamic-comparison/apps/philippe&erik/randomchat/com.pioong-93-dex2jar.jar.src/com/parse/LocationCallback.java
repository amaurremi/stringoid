package com.parse;

public abstract class LocationCallback
  extends ParseCallback<ParseGeoPoint>
{
  public abstract void done(ParseGeoPoint paramParseGeoPoint, ParseException paramParseException);
  
  final void internalDone(ParseGeoPoint paramParseGeoPoint, ParseException paramParseException)
  {
    done(paramParseGeoPoint, paramParseException);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/LocationCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */