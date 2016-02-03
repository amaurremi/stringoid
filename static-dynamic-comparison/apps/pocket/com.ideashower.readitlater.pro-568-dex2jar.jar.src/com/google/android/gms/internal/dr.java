package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class dr
  implements SafeParcelable
{
  public static final ap CREATOR = new ap();
  private final int a;
  private final dt b;
  
  dr(int paramInt, dt paramdt)
  {
    this.a = paramInt;
    this.b = paramdt;
  }
  
  private dr(dt paramdt)
  {
    this.a = 1;
    this.b = paramdt;
  }
  
  public static dr a(as paramas)
  {
    if ((paramas instanceof dt)) {
      return new dr((dt)paramas);
    }
    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
  }
  
  int a()
  {
    return this.a;
  }
  
  dt b()
  {
    return this.b;
  }
  
  public as c()
  {
    if (this.b != null) {
      return this.b;
    }
    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
  }
  
  public int describeContents()
  {
    ap localap = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ap localap = CREATOR;
    ap.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/dr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */