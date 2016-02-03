package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ao
  implements SafeParcelable
{
  public static final Parcelable.Creator<ao> CREATOR = new ap();
  public final ac alw;
  final int xJ;
  
  ao(int paramInt, IBinder paramIBinder)
  {
    this.xJ = paramInt;
    if (paramIBinder != null)
    {
      this.alw = ac.a.bx(paramIBinder);
      return;
    }
    this.alw = null;
  }
  
  public ao(ac paramac)
  {
    this.xJ = 1;
    this.alw = paramac;
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
    ap.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wearable/internal/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */