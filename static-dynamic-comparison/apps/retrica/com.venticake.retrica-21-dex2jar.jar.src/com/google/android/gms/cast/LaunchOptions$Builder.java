package com.google.android.gms.cast;

import com.google.android.gms.internal.gi;
import java.util.Locale;

public final class LaunchOptions$Builder
{
  private LaunchOptions As = new LaunchOptions();
  
  public LaunchOptions build()
  {
    return this.As;
  }
  
  public Builder setLocale(Locale paramLocale)
  {
    this.As.setLanguage(gi.b(paramLocale));
    return this;
  }
  
  public Builder setRelaunchIfRunning(boolean paramBoolean)
  {
    this.As.setRelaunchIfRunning(paramBoolean);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/LaunchOptions$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */