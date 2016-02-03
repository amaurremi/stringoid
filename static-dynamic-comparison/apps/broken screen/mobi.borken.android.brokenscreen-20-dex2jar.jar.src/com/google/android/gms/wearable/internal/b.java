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
  public final ac alw;
  public final IntentFilter[] alx;
  final int xJ;
  
  b(int paramInt, IBinder paramIBinder, IntentFilter[] paramArrayOfIntentFilter)
  {
    this.xJ = paramInt;
    if (paramIBinder != null) {}
    for (this.alw = ac.a.bx(paramIBinder);; this.alw = null)
    {
      this.alx = paramArrayOfIntentFilter;
      return;
    }
  }
  
  public b(av paramav)
  {
    this.xJ = 1;
    this.alw = paramav;
    this.alx = paramav.np();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  IBinder nj()
  {
    if (this.alw == null) {
      return null;
    }
    return this.alw.asBinder();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wearable/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */