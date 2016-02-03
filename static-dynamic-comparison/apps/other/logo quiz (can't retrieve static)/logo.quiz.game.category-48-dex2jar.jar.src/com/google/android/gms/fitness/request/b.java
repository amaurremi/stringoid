package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;

public class b
  implements SafeParcelable
{
  public static final Parcelable.Creator<b> CREATOR = new c();
  private final int BR;
  private final String TX;
  private final BleDevice TY;
  
  b(int paramInt, String paramString, BleDevice paramBleDevice)
  {
    this.BR = paramInt;
    this.TX = paramString;
    this.TY = paramBleDevice;
  }
  
  public b(BleDevice paramBleDevice)
  {
    this(2, paramBleDevice.getAddress(), paramBleDevice);
  }
  
  public b(String paramString)
  {
    this(2, paramString, null);
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
  
  public BleDevice iW()
  {
    return this.TY;
  }
  
  public String toString()
  {
    return String.format("ClaimBleDeviceRequest{%s %s}", new Object[] { this.TX, this.TY });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */