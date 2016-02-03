package com.google.android.gms.common.api;

public class b
{
  public static String bk(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown status code: " + paramInt;
    case -1: 
      return "SUCCESS_CACHE";
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/common/api/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */