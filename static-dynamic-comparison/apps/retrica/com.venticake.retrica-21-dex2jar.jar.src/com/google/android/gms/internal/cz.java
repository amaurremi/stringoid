package com.google.android.gms.internal;

import android.content.Intent;

public class cz
{
  private final String mz;
  
  public cz(String paramString)
  {
    this.mz = paramString;
  }
  
  public boolean a(String paramString, int paramInt, Intent paramIntent)
  {
    if ((paramString == null) || (paramIntent == null)) {}
    String str;
    do
    {
      return false;
      str = cy.d(paramIntent);
      paramIntent = cy.e(paramIntent);
    } while ((str == null) || (paramIntent == null));
    if (!paramString.equals(cy.p(str)))
    {
      eu.D("Developer payload not match.");
      return false;
    }
    if ((this.mz != null) && (!da.b(this.mz, str, paramIntent)))
    {
      eu.D("Fail to verify signature.");
      return false;
    }
    return true;
  }
  
  public String bm()
  {
    return eo.bT();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */