package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UnclaimBleDeviceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<UnclaimBleDeviceRequest> CREATOR = new ag();
  private final int BR;
  private final String TX;
  
  UnclaimBleDeviceRequest(int paramInt, String paramString)
  {
    this.BR = paramInt;
    this.TX = paramString;
  }
  
  public UnclaimBleDeviceRequest(String paramString)
  {
    this(3, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDeviceAddress()
  {
    return this.TX;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public String toString()
  {
    return String.format("UnclaimBleDeviceRequest{%s}", new Object[] { this.TX });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ag.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/UnclaimBleDeviceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */