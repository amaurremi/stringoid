package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class b
  implements SafeParcelable
{
  public static final Parcelable.Creator<b> CREATOR = new c();
  final int BR;
  public final ae auZ;
  public final IntentFilter[] ava;
  
  b(int paramInt, IBinder paramIBinder, IntentFilter[] paramArrayOfIntentFilter)
  {
    this.BR = paramInt;
    if (paramIBinder != null) {}
    for (this.auZ = ae.a.bS(paramIBinder);; this.auZ = null)
    {
      this.ava = paramArrayOfIntentFilter;
      return;
    }
  }
  
  public b(ax paramax)
  {
    this.BR = 1;
    this.auZ = paramax;
    this.ava = paramax.pZ();
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
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wearable/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */