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
  public final IntentFilter[] alA;
  public final ac alz;
  final int xM;
  
  b(int paramInt, IBinder paramIBinder, IntentFilter[] paramArrayOfIntentFilter)
  {
    this.xM = paramInt;
    if (paramIBinder != null) {}
    for (this.alz = ac.a.bx(paramIBinder);; this.alz = null)
    {
      this.alA = paramArrayOfIntentFilter;
      return;
    }
  }
  
  public b(av paramav)
  {
    this.xM = 1;
    this.alz = paramav;
    this.alA = paramav.nu();
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
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */