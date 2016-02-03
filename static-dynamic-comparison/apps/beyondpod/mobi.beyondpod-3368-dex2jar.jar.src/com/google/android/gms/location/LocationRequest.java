package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ee;

public final class LocationRequest
  implements SafeParcelable
{
  public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
  public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
  public static final int PRIORITY_HIGH_ACCURACY = 100;
  public static final int PRIORITY_LOW_POWER = 104;
  public static final int PRIORITY_NO_POWER = 105;
  private final int kg;
  int mPriority;
  long xB;
  long xC;
  boolean xD;
  int xE;
  float xF;
  long xu;
  
  public LocationRequest()
  {
    this.kg = 1;
    this.mPriority = 102;
    this.xB = 3600000L;
    this.xC = 600000L;
    this.xD = false;
    this.xu = Long.MAX_VALUE;
    this.xE = Integer.MAX_VALUE;
    this.xF = 0.0F;
  }
  
  LocationRequest(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt3, float paramFloat)
  {
    this.kg = paramInt1;
    this.mPriority = paramInt2;
    this.xB = paramLong1;
    this.xC = paramLong2;
    this.xD = paramBoolean;
    this.xu = paramLong3;
    this.xE = paramInt3;
    this.xF = paramFloat;
  }
  
  private static void a(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException("invalid displacement: " + paramFloat);
    }
  }
  
  private static void aO(int paramInt)
  {
    switch (paramInt)
    {
    case 101: 
    case 103: 
    default: 
      throw new IllegalArgumentException("invalid quality: " + paramInt);
    }
  }
  
  public static String aP(int paramInt)
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
  
  private static void m(long paramLong)
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
    } while ((this.mPriority == ((LocationRequest)paramObject).mPriority) && (this.xB == ((LocationRequest)paramObject).xB) && (this.xC == ((LocationRequest)paramObject).xC) && (this.xD == ((LocationRequest)paramObject).xD) && (this.xu == ((LocationRequest)paramObject).xu) && (this.xE == ((LocationRequest)paramObject).xE) && (this.xF == ((LocationRequest)paramObject).xF));
    return false;
  }
  
  public long getExpirationTime()
  {
    return this.xu;
  }
  
  public long getFastestInterval()
  {
    return this.xC;
  }
  
  public long getInterval()
  {
    return this.xB;
  }
  
  public int getNumUpdates()
  {
    return this.xE;
  }
  
  public int getPriority()
  {
    return this.mPriority;
  }
  
  public float getSmallestDisplacement()
  {
    return this.xF;
  }
  
  int getVersionCode()
  {
    return this.kg;
  }
  
  public int hashCode()
  {
    return ee.hashCode(new Object[] { Integer.valueOf(this.mPriority), Long.valueOf(this.xB), Long.valueOf(this.xC), Boolean.valueOf(this.xD), Long.valueOf(this.xu), Integer.valueOf(this.xE), Float.valueOf(this.xF) });
  }
  
  public LocationRequest setExpirationDuration(long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    if (paramLong > Long.MAX_VALUE - l) {}
    for (this.xu = Long.MAX_VALUE;; this.xu = (l + paramLong))
    {
      if (this.xu < 0L) {
        this.xu = 0L;
      }
      return this;
    }
  }
  
  public LocationRequest setExpirationTime(long paramLong)
  {
    this.xu = paramLong;
    if (this.xu < 0L) {
      this.xu = 0L;
    }
    return this;
  }
  
  public LocationRequest setFastestInterval(long paramLong)
  {
    m(paramLong);
    this.xD = true;
    this.xC = paramLong;
    return this;
  }
  
  public LocationRequest setInterval(long paramLong)
  {
    m(paramLong);
    this.xB = paramLong;
    if (!this.xD) {
      this.xC = ((this.xB / 6.0D));
    }
    return this;
  }
  
  public LocationRequest setNumUpdates(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("invalid numUpdates: " + paramInt);
    }
    this.xE = paramInt;
    return this;
  }
  
  public LocationRequest setPriority(int paramInt)
  {
    aO(paramInt);
    this.mPriority = paramInt;
    return this;
  }
  
  public LocationRequest setSmallestDisplacement(float paramFloat)
  {
    a(paramFloat);
    this.xF = paramFloat;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request[").append(aP(this.mPriority));
    if (this.mPriority != 105)
    {
      localStringBuilder.append(" requested=");
      localStringBuilder.append(this.xB + "ms");
    }
    localStringBuilder.append(" fastest=");
    localStringBuilder.append(this.xC + "ms");
    if (this.xu != Long.MAX_VALUE)
    {
      long l1 = this.xu;
      long l2 = SystemClock.elapsedRealtime();
      localStringBuilder.append(" expireIn=");
      localStringBuilder.append(l1 - l2 + "ms");
    }
    if (this.xE != Integer.MAX_VALUE) {
      localStringBuilder.append(" num=").append(this.xE);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    LocationRequestCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/location/LocationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */