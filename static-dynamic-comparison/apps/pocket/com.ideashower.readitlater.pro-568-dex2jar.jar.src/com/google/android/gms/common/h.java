package com.google.android.gms.common;

import android.content.Intent;

public class h
  extends Exception
{
  private final Intent a;
  
  public h(String paramString, Intent paramIntent)
  {
    super(paramString);
    this.a = paramIntent;
  }
  
  public Intent b()
  {
    return new Intent(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/common/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */