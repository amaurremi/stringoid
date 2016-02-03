package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;

public final class LocationRequest
  implements SafeParcelable
{
  public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
  public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
  public static final int PRIORITY_HIGH_ACCURACY = 100;
  public static final int PRIORITY_LOW_POWER = 104;
  public static final int PRIORITY_NO_POWER = 105;
  long Vb;
  long Vl;
  long Vm;
  boolean Vn;
  int Vo;
  float Vp;
  int mPriority;
  private final int xM;
  
  public LocationRequest()
  {
    this.xM = 1;
    this.mPriority = 102;
    this.Vl = 3600000L;
    this.Vm = 600000L;
    this.Vn = false;
    this.Vb = Long.MAX_VALUE;
    this.Vo = Integer.MAX_VALUE;
    this.Vp = 0.0F;
  }
  
  LocationRequest(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt3, float paramFloat)
  {
    this.xM = paramInt1;
    this.mPriority = paramInt2;
    this.Vl = paramLong1;
    this.Vm = paramLong2;
    this.Vn = paramBoolean;
    this.Vb = paramLong3;
    this.Vo = paramInt3;
    this.Vp = paramFloat;
  }
  
  private static void a(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException("invalid displacement: " + paramFloat);
    }
  }
  
  private static void cG(int paramInt)
  {
    switch (paramInt)
    {
    case 101: 
    case 103: 
    default: 
      throw new IllegalArgumentException("invalid quality: " + paramInt);
    }
  }
  
  public static String cH(int paramInt)
  {
    switch (paramInt)
    {
    case 101: 
    case 103: 
    default: 
      return "???";
    case 100: 
      return "PRIORITY_HIGH_ACCURACY";
    case 102: 
      return "PRIORITY_BALANCED_POWER_ACCURACY";
    case 104: 
      return "PRIORITY_LOW_POWER";
    }
    return "PRIORITY_NO_POWER";
  }
  
  public static LocationRequest create()
  {
    return new LocationRequest();
  }
  
  private static void v(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("invalid interval: " + paramLong);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof LocationRequest)) {
        return false;
      }
      paramObject = (LocationRequest)paramObject;
    } while ((this.mPriority == ((LocationRequest)paramObject).mPriority) && (this.Vl == ((LocationRequest)paramObject).Vl) && (this.Vm == ((LocationRequest)paramObject).Vm) && (this.Vn == ((LocationRequest)paramObject).Vn) && (this.Vb == ((LocationRequest)paramObject).Vb) && (this.Vo == ((LocationRequest)paramObject).Vo) && (this.Vp == ((LocationRequest)paramObject).Vp));
    return false;
  }
  
  public long getExpirationTime()
  {
    return this.Vb;
  }
  
  public long getFastestInterval()
  {
    return this.Vm;
  }
  
  public long getInterval()
  {
    return this.Vl;
  }
  
  public int getNumUpdates()
  {
    return this.Vo;
  }
  
  public int getPriority()
  {
    return this.mPriority;
  }
  
  public float getSmallestDisplacement()
  {
    return this.Vp;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { Integer.valueOf(this.mPriority), Long.valueOf(this.Vl), Long.valueOf(this.Vm), Boolean.valueOf(this.Vn), Long.valueOf(this.Vb), Integer.valueOf(this.Vo), Float.valueOf(this.Vp) });
  }
  
  public LocationRequest setExpirationDuration(long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    if (paramLong > Long.MAX_VALUE - l) {}
    for (this.Vb = Long.MAX_VALUE;; this.Vb = (l + paramLong))
    {
      if (this.Vb < 0L) {
        this.Vb = 0L;
      }
      return this;
    }
  }
  
  public LocationRequest setExpirationTime(long paramLong)
  {
    this.Vb = paramLong;
    if (this.Vb < 0L) {
      this.Vb = 0L;
    }
    return this;
  }
  
  public LocationRequest setFastestInterval(long paramLong)
  {
    v(paramLong);
    this.Vn = true;
    this.Vm = paramLong;
    return this;
  }
  
  public LocationRequest setInterval(long paramLong)
  {
    v(paramLong);
    this.Vl = paramLong;
    if (!this.Vn) {
      this.Vm = ((this.Vl / 6.0D));
    }
    return this;
  }
  
  public LocationRequest setNumUpdates(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("invalid numUpdates: " + paramInt);
    }
    this.Vo = paramInt;
    return this;
  }
  
  public LocationRequest setPriority(int paramInt)
  {
    cG(paramInt);
    this.mPriority = paramInt;
    return this;
  }
  
  public LocationRequest setSmallestDisplacement(float paramFloat)
  {
    a(paramFloat);
    this.Vp = paramFloat;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request[").append(cH(this.mPriority));
    if (this.mPriority != 105)
    {
      localStringBuilder.append(" requested=");
      localStringBuilder.append(this.Vl + "ms");
    }
    localStringBuilder.append(" fastest=");
    localStringBuilder.append(this.Vm + "ms");
    if (this.Vb != Long.MAX_VALUE)
    {
      long l1 = this.Vb;
      long l2 = SystemClock.elapsedRealtime();
      localStringBuilder.append(" expireIn=");
      localStringBuilder.append(l1 - l2 + "ms");
    }
    if (this.Vo != Integer.MAX_VALUE) {
      localStringBuilder.append(" num=").append(this.Vo);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    LocationRequestCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/location/LocationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */