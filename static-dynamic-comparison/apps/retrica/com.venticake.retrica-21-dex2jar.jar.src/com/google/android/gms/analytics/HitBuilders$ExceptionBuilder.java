package com.google.android.gms.analytics;

public class HitBuilders$ExceptionBuilder
  extends HitBuilders.HitBuilder<ExceptionBuilder>
{
  public HitBuilders$ExceptionBuilder()
  {
    u.a().a(u.a.vD);
    set("&t", "exception");
  }
  
  public ExceptionBuilder setDescription(String paramString)
  {
    set("&exd", paramString);
    return this;
  }
  
  public ExceptionBuilder setFatal(boolean paramBoolean)
  {
    set("&exf", t.a(paramBoolean));
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/HitBuilders$ExceptionBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */