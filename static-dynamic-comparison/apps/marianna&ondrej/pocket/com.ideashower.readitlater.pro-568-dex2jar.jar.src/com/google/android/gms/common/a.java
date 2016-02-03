package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import com.google.android.gms.internal.al;
import com.google.android.gms.internal.am;

public final class a
{
  public static final a a = new a(0, null);
  private final PendingIntent b;
  private final int c;
  
  public a(int paramInt, PendingIntent paramPendingIntent)
  {
    this.c = paramInt;
    this.b = paramPendingIntent;
  }
  
  private String d()
  {
    switch (this.c)
    {
    default: 
      return "unknown status code " + this.c;
    case 0: 
      return "SUCCESS";
    case 1: 
      return "SERVICE_MISSING";
    case 2: 
      return "SERVICE_VERSION_UPDATE_REQUIRED";
    case 3: 
      return "SERVICE_DISABLED";
    case 4: 
      return "SIGN_IN_REQUIRED";
    case 5: 
      return "INVALID_ACCOUNT";
    case 6: 
      return "RESOLUTION_REQUIRED";
    case 7: 
      return "NETWORK_ERROR";
    case 8: 
      return "INTERNAL_ERROR";
    case 9: 
      return "SERVICE_INVALID";
    case 10: 
      return "DEVELOPER_ERROR";
    }
    return "LICENSE_CHECK_FAILED";
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (!a()) {
      return;
    }
    paramActivity.startIntentSenderForResult(this.b.getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  public boolean a()
  {
    return (this.c != 0) && (this.b != null);
  }
  
  public boolean b()
  {
    return this.c == 0;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public String toString()
  {
    return al.a(this).a("statusCode", d()).a("resolution", this.b).toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/common/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */