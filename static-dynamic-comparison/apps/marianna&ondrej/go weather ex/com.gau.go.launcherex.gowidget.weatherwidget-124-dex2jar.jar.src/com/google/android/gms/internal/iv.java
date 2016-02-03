package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class iv
  implements SafeParcelable
{
  public static final Parcelable.Creator<iv> CREATOR = new iw();
  int[] acs;
  private final int xH;
  
  iv()
  {
    this(1, null);
  }
  
  iv(int paramInt, int[] paramArrayOfInt)
  {
    this.xH = paramInt;
    this.acs = paramArrayOfInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.xH;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    iw.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/iv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */