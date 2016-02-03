package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.cz.a;

public final class b
{
  public static final b qv = new b(0, null);
  private final PendingIntent qw;
  private final int qx;
  
  public b(int paramInt, PendingIntent paramPendingIntent)
  {
    this.qx = paramInt;
    this.qw = paramPendingIntent;
  }
  
  private String mi()
  {
    switch (this.qx)
    {
    case 12: 
    default: 
      return "unknown status code " + this.qx;
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
    case 11: 
      return "LICENSE_CHECK_FAILED";
    case 13: 
      return "CANCELED";
    case 14: 
      return "TIMEOUT";
    }
    return "INTERRUPTED";
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (!mh()) {
      return;
    }
    paramActivity.startIntentSenderForResult(this.qw.getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  public int getErrorCode()
  {
    return this.qx;
  }
  
  public boolean mh()
  {
    return (this.qx != 0) && (this.qw != null);
  }
  
  public String toString()
  {
    return cz.M(this).a("statusCode", mi()).a("resolution", this.qw).toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/common/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */