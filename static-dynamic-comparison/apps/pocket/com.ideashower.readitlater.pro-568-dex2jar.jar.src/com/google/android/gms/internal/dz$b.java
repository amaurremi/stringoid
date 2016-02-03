package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class dz$b
  implements SafeParcelable
{
  public static final au CREATOR = new au();
  final int a;
  final String b;
  final dw.a c;
  
  dz$b(int paramInt, String paramString, dw.a parama)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = parama;
  }
  
  dz$b(String paramString, dw.a parama)
  {
    this.a = 1;
    this.b = paramString;
    this.c = parama;
  }
  
  public int describeContents()
  {
    au localau = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    au localau = CREATOR;
    au.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/dz$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */