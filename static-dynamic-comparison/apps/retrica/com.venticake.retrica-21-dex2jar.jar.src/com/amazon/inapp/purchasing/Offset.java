package com.amazon.inapp.purchasing;

public final class Offset
{
  public static final Offset BEGINNING = new Offset("BEGINNING");
  private static final String BEGINNING_ENCODED = "BEGINNING";
  private String _encodedOffset;
  
  Offset(String paramString)
  {
    this._encodedOffset = paramString;
  }
  
  public static Offset fromString(String paramString)
  {
    if ("BEGINNING".equals(paramString)) {
      return BEGINNING;
    }
    return new Offset(paramString);
  }
  
  public String toString()
  {
    return this._encodedOffset;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/Offset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */