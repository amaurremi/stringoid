package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class dx
  implements SafeParcelable
{
  public static final dy CREATOR = new dy();
  public String rq;
  public int rr;
  public int rs;
  public boolean rt;
  public final int versionCode;
  
  public dx(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  dx(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.versionCode = paramInt1;
    this.rq = paramString;
    this.rr = paramInt2;
    this.rs = paramInt3;
    this.rt = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    dy.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/dx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */