package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class hv$a
  implements SafeParcelable
{
  public static final hx CREATOR = new hx();
  final String GZ;
  final int Ha;
  final int versionCode;
  
  hv$a(int paramInt1, String paramString, int paramInt2)
  {
    this.versionCode = paramInt1;
    this.GZ = paramString;
    this.Ha = paramInt2;
  }
  
  hv$a(String paramString, int paramInt)
  {
    this.versionCode = 1;
    this.GZ = paramString;
    this.Ha = paramInt;
  }
  
  public int describeContents()
  {
    hx localhx = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hx localhx = CREATOR;
    hx.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/hv$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */