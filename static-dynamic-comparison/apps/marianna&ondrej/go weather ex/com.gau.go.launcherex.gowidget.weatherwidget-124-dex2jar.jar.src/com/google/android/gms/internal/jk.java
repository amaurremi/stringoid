package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jk
  implements SafeParcelable
{
  public static final Parcelable.Creator<jk> CREATOR = new jl();
  String label;
  String value;
  private final int xH;
  
  jk()
  {
    this.xH = 1;
  }
  
  jk(int paramInt, String paramString1, String paramString2)
  {
    this.xH = paramInt;
    this.label = paramString1;
    this.value = paramString2;
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
    jl.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/jk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */