package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DetectedActivity
  implements SafeParcelable
{
  public static final c TY = new c();
  int TZ;
  int Ua;
  private final int qh;
  
  public DetectedActivity(int paramInt1, int paramInt2, int paramInt3)
  {
    this.qh = paramInt1;
    this.TZ = paramInt2;
    this.Ua = paramInt3;
  }
  
  private int dH(int paramInt)
  {
    int i = paramInt;
    if (paramInt > 6) {
      i = 4;
    }
    return i;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getType()
  {
    return dH(this.TZ);
  }
  
  public int lX()
  {
    return this.qh;
  }
  
  public String toString()
  {
    return "DetectedActivity [type=" + getType() + ", confidence=" + this.Ua + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/location/DetectedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */