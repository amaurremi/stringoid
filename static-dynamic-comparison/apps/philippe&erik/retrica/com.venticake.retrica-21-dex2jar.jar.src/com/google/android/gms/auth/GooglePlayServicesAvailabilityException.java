package com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException
  extends UserRecoverableAuthException
{
  private final int yY;
  
  GooglePlayServicesAvailabilityException(int paramInt, String paramString, Intent paramIntent)
  {
    super(paramString, paramIntent);
    this.yY = paramInt;
  }
  
  public int getConnectionStatusCode()
  {
    return this.yY;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/auth/GooglePlayServicesAvailabilityException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */