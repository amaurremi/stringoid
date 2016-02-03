package com.google.android.gms.tagmanager;

import com.google.android.gms.analytics.Logger;

class db
  implements Logger
{
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    default: 
      return 3;
    case 5: 
      return 2;
    case 3: 
    case 4: 
      return 1;
    }
    return 0;
  }
  
  public void error(Exception paramException)
  {
    as.a("", paramException);
  }
  
  public void error(String paramString)
  {
    as.a(paramString);
  }
  
  public int getLogLevel()
  {
    return a(as.a());
  }
  
  public void info(String paramString)
  {
    as.c(paramString);
  }
  
  public void setLogLevel(int paramInt)
  {
    as.b("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
  }
  
  public void verbose(String paramString)
  {
    as.e(paramString);
  }
  
  public void warn(String paramString)
  {
    as.b(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */