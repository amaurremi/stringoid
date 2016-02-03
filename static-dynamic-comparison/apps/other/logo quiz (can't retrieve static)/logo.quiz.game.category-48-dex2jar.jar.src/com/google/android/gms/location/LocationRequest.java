package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LocationRequest
  implements SafeParcelable
{
  public static final b CREATOR = new b();
  public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
  public static final int PRIORITY_HIGH_ACCURACY = 100;
  public static final int PRIORITY_LOW_POWER = 104;
  public static final int PRIORITY_NO_POWER = 105;
  private final int BR;
  boolean Uz;
  long adX;
  long aeh;
  long aei;
  int aej;
  float aek;
  long ael;
  int mPriority;
  
  public LocationRequest()
  {
    this.BR = 1;
    this.mPriority = 102;
    this.aeh = 3600000L;
    this.aei = 600000L;
    this.Uz = false;
    this.adX = Long.MAX_VALUE;
    this.aej = Integer.MAX_VALUE;
    this.aek = 0.0F;
    this.ael = 0L;
  }
  
  LocationRequest(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt3, float paramFloat, long paramLong4)
  {
    this.BR = paramInt1;
    this.mPriority = paramInt2;
    this.aeh = paramLong1;
    this.aei = paramLong2;
    this.Uz = paramBoolean;
    this.adX = paramLong3;
    this.aej = paramInt3;
    this.aek = paramFloat;
    this.ael = paramLong4;
  }
  
  private static void a(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException("invalid displacement: " + paramFloat);
    }
  }
  
  public static LocationRequest create()
  {
    return new LocationRequest();
  }
  
  private static void ea(int paramInt)
  {
    switch (paramInt)
    {
    case 101: 
    case 103: 
    default: 
      throw new IllegalArgumentException("invalid quality: " + paramInt);
    }
  }
  
  public static String eb(int paramInt)
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
    } while ((this.mPriority == ((LocationRequest)paramObject).mPriority) && (this.aeh == ((LocationRequest)paramObject).aeh) && (this.aei == ((LocationRequest)paramObject).aei) && (this.Uz == ((LocationRequest)paramObject).Uz) && (this.adX == ((LocationRequest)paramObject).adX) && (this.aej == ((LocationRequest)paramObject).aej) && (this.aek == ((LocationRequest)paramObject).aek));
    return false;
  }
  
  public long getExpirationTime()
  {
    return this.adX;
  }
  
  public long getFastestInterval()
  {
    return this.aei;
  }
  
  public long getInterval()
  {
    return this.aeh;
  }
  
  public int getNumUpdates()
  {
    return this.aej;
  }
  
  public int getPriority()
  {
    return this.mPriority;
  }
  
  public float getSmallestDisplacement()
  {
    return this.aek;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { Integer.valueOf(this.mPriority), Long.valueOf(this.aeh), Long.valueOf(this.aei), Boolean.valueOf(this.Uz), Long.valueOf(this.adX), Integer.valueOf(this.aej), Float.valueOf(this.aek) });
  }
  
  public LocationRequest setExpirationDuration(long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    if (paramLong > Long.MAX_VALUE - l) {}
    for (this.adX = Long.MAX_VALUE;; this.adX = (l + paramLong))
    {
      if (this.adX < 0L) {
        this.adX = 0L;
      }
      return this;
    }
  }
  
  public LocationRequest setExpirationTime(long paramLong)
  {
    this.adX = paramLong;
    if (this.adX < 0L) {
      this.adX = 0L;
    }
    return this;
  }
  
  public LocationRequest setFastestInterval(long paramLong)
  {
    v(paramLong);
    this.Uz = true;
    this.aei = paramLong;
    return this;
  }
  
  public LocationRequest setInterval(long paramLong)
  {
    v(paramLong);
    this.aeh = paramLong;
    if (!this.Uz) {
      this.aei = ((this.aeh / 6.0D));
    }
    return this;
  }
  
  public LocationRequest setNumUpdates(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("invalid numUpdates: " + paramInt);
    }
    this.aej = paramInt;
    return this;
  }
  
  public LocationRequest setPriority(int paramInt)
  {
    ea(paramInt);
    this.mPriority = paramInt;
    return this;
  }
  
  public LocationRequest setSmallestDisplacement(float paramFloat)
  {
    a(paramFloat);
    this.aek = paramFloat;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request[").append(eb(this.mPriority));
    if (this.mPriority != 105)
    {
      localStringBuilder.append(" requested=");
      localStringBuilder.append(this.aeh + "ms");
    }
    localStringBuilder.append(" fastest=");
    localStringBuilder.append(this.aei + "ms");
    if (this.adX != Long.MAX_VALUE)
    {
      long l1 = this.adX;
      long l2 = SystemClock.elapsedRealtime();
      localStringBuilder.append(" expireIn=");
      localStringBuilder.append(l1 - l2 + "ms");
    }
    if (this.aej != Integer.MAX_VALUE) {
      localStringBuilder.append(" num=").append(this.aej);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/location/LocationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */