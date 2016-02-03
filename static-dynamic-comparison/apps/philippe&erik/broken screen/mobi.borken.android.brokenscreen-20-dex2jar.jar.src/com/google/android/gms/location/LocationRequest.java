package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;

public final class LocationRequest
  implements SafeParcelable
{
  public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
  public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
  public static final int PRIORITY_HIGH_ACCURACY = 100;
  public static final int PRIORITY_LOW_POWER = 104;
  public static final int PRIORITY_NO_POWER = 105;
  long UY;
  long Vi;
  long Vj;
  boolean Vk;
  int Vl;
  float Vm;
  int mPriority;
  private final int xJ;
  
  public LocationRequest()
  {
    this.xJ = 1;
    this.mPriority = 102;
    this.Vi = 3600000L;
    this.Vj = 600000L;
    this.Vk = false;
    this.UY = Long.MAX_VALUE;
    this.Vl = Integer.MAX_VALUE;
    this.Vm = 0.0F;
  }
  
  LocationRequest(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt3, float paramFloat)
  {
    this.xJ = paramInt1;
    this.mPriority = paramInt2;
    this.Vi = paramLong1;
    this.Vj = paramLong2;
    this.Vk = paramBoolean;
    this.UY = paramLong3;
    this.Vl = paramInt3;
    this.Vm = paramFloat;
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
    } while ((this.mPriority == ((LocationRequest)paramObject).mPriority) && (this.Vi == ((LocationRequest)paramObject).Vi) && (this.Vj == ((LocationRequest)paramObject).Vj) && (this.Vk == ((LocationRequest)paramObject).Vk) && (this.UY == ((LocationRequest)paramObject).UY) && (this.Vl == ((LocationRequest)paramObject).Vl) && (this.Vm == ((LocationRequest)paramObject).Vm));
    return false;
  }
  
  public long getExpirationTime()
  {
    return this.UY;
  }
  
  public long getFastestInterval()
  {
    return this.Vj;
  }
  
  public long getInterval()
  {
    return this.Vi;
  }
  
  public int getNumUpdates()
  {
    return this.Vl;
  }
  
  public int getPriority()
  {
    return this.mPriority;
  }
  
  public float getSmallestDisplacement()
  {
    return this.Vm;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { Integer.valueOf(this.mPriority), Long.valueOf(this.Vi), Long.valueOf(this.Vj), Boolean.valueOf(this.Vk), Long.valueOf(this.UY), Integer.valueOf(this.Vl), Float.valueOf(this.Vm) });
  }
  
  public LocationRequest setExpirationDuration(long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    if (paramLong > Long.MAX_VALUE - l) {}
    for (this.UY = Long.MAX_VALUE;; this.UY = (l + paramLong))
    {
      if (this.UY < 0L) {
        this.UY = 0L;
      }
      return this;
    }
  }
  
  public LocationRequest setExpirationTime(long paramLong)
  {
    this.UY = paramLong;
    if (this.UY < 0L) {
      this.UY = 0L;
    }
    return this;
  }
  
  public LocationRequest setFastestInterval(long paramLong)
  {
    v(paramLong);
    this.Vk = true;
    this.Vj = paramLong;
    return this;
  }
  
  public LocationRequest setInterval(long paramLong)
  {
    v(paramLong);
    this.Vi = paramLong;
    if (!this.Vk) {
      this.Vj = ((this.Vi / 6.0D));
    }
    return this;
  }
  
  public LocationRequest setNumUpdates(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("invalid numUpdates: " + paramInt);
    }
    this.Vl = paramInt;
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
    this.Vm = paramFloat;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request[").append(cH(this.mPriority));
    if (this.mPriority != 105)
    {
      localStringBuilder.append(" requested=");
      localStringBuilder.append(this.Vi + "ms");
    }
    localStringBuilder.append(" fastest=");
    localStringBuilder.append(this.Vj + "ms");
    if (this.UY != Long.MAX_VALUE)
    {
      long l1 = this.UY;
      long l2 = SystemClock.elapsedRealtime();
      localStringBuilder.append(" expireIn=");
      localStringBuilder.append(l1 - l2 + "ms");
    }
    if (this.Vl != Integer.MAX_VALUE) {
      localStringBuilder.append(" num=").append(this.Vl);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    LocationRequestCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/location/LocationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */