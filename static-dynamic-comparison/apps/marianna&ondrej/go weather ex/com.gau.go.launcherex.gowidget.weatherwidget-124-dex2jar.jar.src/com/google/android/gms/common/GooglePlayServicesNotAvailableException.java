package com.google.android.gms.common;

public final class GooglePlayServicesNotAvailableException
  extends Exception
{
  public final int errorCode;
  
  public GooglePlayServicesNotAvailableException(int paramInt)
  {
    this.errorCode = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/common/GooglePlayServicesNotAvailableException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */