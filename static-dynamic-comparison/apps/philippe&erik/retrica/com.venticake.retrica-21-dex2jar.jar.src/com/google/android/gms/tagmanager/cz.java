package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

class cz
{
  private GoogleAnalytics a;
  private Context b;
  private Tracker c;
  
  cz(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private void b(String paramString)
  {
    try
    {
      if (this.a == null)
      {
        this.a = GoogleAnalytics.getInstance(this.b);
        this.a.setLogger(new db());
        this.c = this.a.newTracker(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public Tracker a(String paramString)
  {
    b(paramString);
    return this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */