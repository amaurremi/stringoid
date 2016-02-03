package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class dt$a
  implements SafeParcelable
{
  public static final ar CREATOR = new ar();
  final int a;
  final String b;
  final int c;
  
  dt$a(int paramInt1, String paramString, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramString;
    this.c = paramInt2;
  }
  
  dt$a(String paramString, int paramInt)
  {
    this.a = 1;
    this.b = paramString;
    this.c = paramInt;
  }
  
  public int describeContents()
  {
    ar localar = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ar localar = CREATOR;
    ar.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/dt$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */