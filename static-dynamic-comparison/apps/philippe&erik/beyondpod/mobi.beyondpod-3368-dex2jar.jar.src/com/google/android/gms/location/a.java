package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class a
  implements SafeParcelable
{
  public static final b CREATOR = new b();
  private final int kg;
  private final PendingIntent xr;
  
  public a(int paramInt, PendingIntent paramPendingIntent)
  {
    this.kg = paramInt;
    this.xr = paramPendingIntent;
  }
  
  public PendingIntent dB()
  {
    return this.xr;
  }
  
  public int describeContents()
  {
    b localb = CREATOR;
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.kg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b localb = CREATOR;
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/location/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */