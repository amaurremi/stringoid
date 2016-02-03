package com.google.android.gms.analytics;

public class HitBuilders$TimingBuilder
  extends HitBuilders.HitBuilder<TimingBuilder>
{
  public HitBuilders$TimingBuilder()
  {
    u.a().a(u.a.vF);
    set("&t", "timing");
  }
  
  public HitBuilders$TimingBuilder(String paramString1, String paramString2, long paramLong)
  {
    this();
    setVariable(paramString2);
    setValue(paramLong);
    setCategory(paramString1);
  }
  
  public TimingBuilder setCategory(String paramString)
  {
    set("&utc", paramString);
    return this;
  }
  
  public TimingBuilder setLabel(String paramString)
  {
    set("&utl", paramString);
    return this;
  }
  
  public TimingBuilder setValue(long paramLong)
  {
    set("&utt", Long.toString(paramLong));
    return this;
  }
  
  public TimingBuilder setVariable(String paramString)
  {
    set("&utv", paramString);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/HitBuilders$TimingBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */