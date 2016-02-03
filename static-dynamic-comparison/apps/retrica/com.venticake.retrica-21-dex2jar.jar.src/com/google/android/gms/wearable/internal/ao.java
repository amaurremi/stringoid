package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ao
  implements SafeParcelable
{
  public static final Parcelable.Creator<ao> CREATOR = new ap();
  public final ac alz;
  final int xM;
  
  ao(int paramInt, IBinder paramIBinder)
  {
    this.xM = paramInt;
    if (paramIBinder != null)
    {
      this.alz = ac.a.bx(paramIBinder);
      return;
    }
    this.alz = null;
  }
  
  public ao(ac paramac)
  {
    this.xM = 1;
    this.alz = paramac;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  IBinder no()
  {
    if (this.alz == null) {
      return null;
    }
    return this.alz.asBinder();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ap.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */