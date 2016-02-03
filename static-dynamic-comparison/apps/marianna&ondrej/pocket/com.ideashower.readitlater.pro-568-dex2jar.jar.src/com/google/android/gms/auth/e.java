package com.google.android.gms.auth;

import android.content.Intent;

public class e
  extends a
{
  private final Intent a;
  
  public e(String paramString, Intent paramIntent)
  {
    super(paramString);
    this.a = paramIntent;
  }
  
  public Intent b()
  {
    if (this.a == null) {
      return null;
    }
    return new Intent(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/auth/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */