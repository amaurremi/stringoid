package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DetectedActivity
  implements SafeParcelable
{
  public static final b CREATOR = new b();
  int a;
  int b;
  private final int c;
  
  public DetectedActivity(int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.a = paramInt2;
    this.b = paramInt3;
  }
  
  private int a(int paramInt)
  {
    int i = paramInt;
    if (paramInt > 6) {
      i = 4;
    }
    return i;
  }
  
  public int a()
  {
    return a(this.a);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "DetectedActivity [type=" + a() + ", confidence=" + this.b + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/location/DetectedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */