package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class aq
  implements SafeParcelable
{
  public static final Parcelable.Creator<aq> CREATOR = new ar();
  final int BR;
  public final ae auZ;
  
  aq(int paramInt, IBinder paramIBinder)
  {
    this.BR = paramInt;
    if (paramIBinder != null)
    {
      this.auZ = ae.a.bS(paramIBinder);
      return;
    }
    this.auZ = null;
  }
  
  public aq(ae paramae)
  {
    this.BR = 1;
    this.auZ = paramae;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  IBinder pT()
  {
    if (this.auZ == null) {
      return null;
    }
    return this.auZ.asBinder();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ar.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wearable/internal/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */