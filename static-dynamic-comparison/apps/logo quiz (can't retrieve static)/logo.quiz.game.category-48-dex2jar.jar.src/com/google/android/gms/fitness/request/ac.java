package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ac
  implements SafeParcelable
{
  public static final Parcelable.Creator<ac> CREATOR = new ad();
  private final int BR;
  private final k UF;
  
  ac(int paramInt, IBinder paramIBinder)
  {
    this.BR = paramInt;
    this.UF = k.a.ay(paramIBinder);
  }
  
  public ac(BleScanCallback paramBleScanCallback)
  {
    this.BR = 1;
    this.UF = a.a.iV().b(paramBleScanCallback);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public IBinder jz()
  {
    return this.UF.asBinder();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ad.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */