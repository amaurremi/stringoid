package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DetectedActivity
  implements SafeParcelable
{
  public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();
  public static final int IN_VEHICLE = 0;
  public static final int ON_BICYCLE = 1;
  public static final int ON_FOOT = 2;
  public static final int RUNNING = 8;
  public static final int STILL = 3;
  public static final int TILTING = 5;
  public static final int UNKNOWN = 4;
  public static final int WALKING = 7;
  int NS;
  int NT;
  private final int xH;
  
  public DetectedActivity(int paramInt1, int paramInt2)
  {
    this.xH = 1;
    this.NS = paramInt1;
    this.NT = paramInt2;
  }
  
  public DetectedActivity(int paramInt1, int paramInt2, int paramInt3)
  {
    this.xH = paramInt1;
    this.NS = paramInt2;
    this.NT = paramInt3;
  }
  
  private int bv(int paramInt)
  {
    int i = paramInt;
    if (paramInt > 8) {
      i = 4;
    }
    return i;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getConfidence()
  {
    return this.NT;
  }
  
  public int getType()
  {
    return bv(this.NS);
  }
  
  public int getVersionCode()
  {
    return this.xH;
  }
  
  public String toString()
  {
    return "DetectedActivity [type=" + getType() + ", confidence=" + this.NT + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    DetectedActivityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/location/DetectedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */