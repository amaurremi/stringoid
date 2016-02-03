package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jo
  implements SafeParcelable
{
  public static final Parcelable.Creator<jo> CREATOR = new jr();
  ju abJ;
  jp adg;
  String label;
  String type;
  private final int xH;
  
  jo()
  {
    this.xH = 1;
  }
  
  jo(int paramInt, String paramString1, jp paramjp, String paramString2, ju paramju)
  {
    this.xH = paramInt;
    this.label = paramString1;
    this.adg = paramjp;
    this.type = paramString2;
    this.abJ = paramju;
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
    jr.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/jo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */