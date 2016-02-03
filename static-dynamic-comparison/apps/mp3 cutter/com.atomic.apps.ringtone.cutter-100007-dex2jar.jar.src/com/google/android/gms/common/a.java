package com.google.android.gms.common;

import android.app.PendingIntent;
import com.google.android.gms.internal.c;
import com.google.android.gms.internal.cZ;

public final class a
{
  private final PendingIntent a;
  private final int b;
  
  static
  {
    new a(0, null);
  }
  
  public a(int paramInt, PendingIntent paramPendingIntent)
  {
    this.b = paramInt;
    this.a = paramPendingIntent;
  }
  
  public final String toString()
  {
    cZ localcZ = c.a(this);
    String str;
    switch (this.b)
    {
    case 12: 
    default: 
      str = "unknown status code " + this.b;
    }
    for (;;)
    {
      return localcZ.a("statusCode", str).a("resolution", this.a).toString();
      str = "SUCCESS";
      continue;
      str = "SERVICE_MISSING";
      continue;
      str = "SERVICE_VERSION_UPDATE_REQUIRED";
      continue;
      str = "SERVICE_DISABLED";
      continue;
      str = "SIGN_IN_REQUIRED";
      continue;
      str = "INVALID_ACCOUNT";
      continue;
      str = "RESOLUTION_REQUIRED";
      continue;
      str = "NETWORK_ERROR";
      continue;
      str = "INTERNAL_ERROR";
      continue;
      str = "SERVICE_INVALID";
      continue;
      str = "DEVELOPER_ERROR";
      continue;
      str = "LICENSE_CHECK_FAILED";
      continue;
      str = "CANCELED";
      continue;
      str = "TIMEOUT";
      continue;
      str = "INTERRUPTED";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/common/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */