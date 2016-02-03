package com.google.android.gms.analytics;

public class HitBuilders$EventBuilder
  extends HitBuilders.HitBuilder<EventBuilder>
{
  public HitBuilders$EventBuilder()
  {
    u.a().a(u.a.vU);
    set("&t", "event");
  }
  
  public HitBuilders$EventBuilder(String paramString1, String paramString2)
  {
    this();
    setCategory(paramString1);
    setAction(paramString2);
  }
  
  public EventBuilder setAction(String paramString)
  {
    set("&ea", paramString);
    return this;
  }
  
  public EventBuilder setCategory(String paramString)
  {
    set("&ec", paramString);
    return this;
  }
  
  public EventBuilder setLabel(String paramString)
  {
    set("&el", paramString);
    return this;
  }
  
  public EventBuilder setValue(long paramLong)
  {
    set("&ev", Long.toString(paramLong));
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/HitBuilders$EventBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */