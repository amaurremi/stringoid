package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.ee.a;

public final class ConnectionResult
{
  public static final int DATE_INVALID = 12;
  public static final int DEVELOPER_ERROR = 10;
  public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
  public static final int INTERNAL_ERROR = 8;
  public static final int INVALID_ACCOUNT = 5;
  public static final int LICENSE_CHECK_FAILED = 11;
  public static final int NETWORK_ERROR = 7;
  public static final int RESOLUTION_REQUIRED = 6;
  public static final int SERVICE_DISABLED = 3;
  public static final int SERVICE_INVALID = 9;
  public static final int SERVICE_MISSING = 1;
  public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
  public static final int SIGN_IN_REQUIRED = 4;
  public static final int SUCCESS = 0;
  public static final ConnectionResult mB = new ConnectionResult(0, null);
  private final int mC;
  private final PendingIntent mPendingIntent;
  
  public ConnectionResult(int paramInt, PendingIntent paramPendingIntent)
  {
    this.mC = paramInt;
    this.mPendingIntent = paramPendingIntent;
  }
  
  private String bh()
  {
    switch (this.mC)
    {
    default: 
      return "unknown status code " + this.mC;
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
  
  public int getErrorCode()
  {
    return this.mC;
  }
  
  public PendingIntent getResolution()
  {
    return this.mPendingIntent;
  }
  
  public boolean hasResolution()
  {
    return (this.mC != 0) && (this.mPendingIntent != null);
  }
  
  public boolean isSuccess()
  {
    return this.mC == 0;
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    if (!hasResolution()) {
      return;
    }
    paramActivity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  public String toString()
  {
    return ee.e(this).a("statusCode", bh()).a("resolution", this.mPendingIntent).toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/common/ConnectionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */