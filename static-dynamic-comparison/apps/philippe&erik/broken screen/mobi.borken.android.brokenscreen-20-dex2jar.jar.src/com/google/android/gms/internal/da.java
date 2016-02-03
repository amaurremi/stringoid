package com.google.android.gms.internal;

import android.content.Intent;

public class da
{
  private final String mx;
  
  public da(String paramString)
  {
    this.mx = paramString;
  }
  
  public boolean a(String paramString, int paramInt, Intent paramIntent)
  {
    if ((paramString == null) || (paramIntent == null)) {}
    String str;
    do
    {
      return false;
      str = cz.d(paramIntent);
      paramIntent = cz.e(paramIntent);
    } while ((str == null) || (paramIntent == null));
    if (!paramString.equals(cz.p(str)))
    {
      ev.D("Developer payload not match.");
      return false;
    }
    if ((this.mx != null) && (!db.b(this.mx, str, paramIntent)))
    {
      ev.D("Fail to verify signature.");
      return false;
    }
    return true;
  }
  
  public String bh()
  {
    return ep.bO();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */