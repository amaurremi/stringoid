package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ib$b
  implements SafeParcelable
{
  public static final ia CREATOR = new ia();
  final hy.a<?, ?> Hp;
  final String eM;
  final int versionCode;
  
  ib$b(int paramInt, String paramString, hy.a<?, ?> parama)
  {
    this.versionCode = paramInt;
    this.eM = paramString;
    this.Hp = parama;
  }
  
  ib$b(String paramString, hy.a<?, ?> parama)
  {
    this.versionCode = 1;
    this.eM = paramString;
    this.Hp = parama;
  }
  
  public int describeContents()
  {
    ia localia = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ia localia = CREATOR;
    ia.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ib$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */