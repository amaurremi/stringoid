package com.google.android.gms.analytics;

public class HitBuilders$SocialBuilder
  extends HitBuilders.HitBuilder<SocialBuilder>
{
  public HitBuilders$SocialBuilder()
  {
    u.a().a(u.a.vG);
    set("&t", "social");
  }
  
  public SocialBuilder setAction(String paramString)
  {
    set("&sa", paramString);
    return this;
  }
  
  public SocialBuilder setNetwork(String paramString)
  {
    set("&sn", paramString);
    return this;
  }
  
  public SocialBuilder setTarget(String paramString)
  {
    set("&st", paramString);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/HitBuilders$SocialBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */