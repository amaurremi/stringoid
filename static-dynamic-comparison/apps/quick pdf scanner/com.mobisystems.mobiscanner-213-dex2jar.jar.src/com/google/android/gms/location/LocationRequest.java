package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.cz;

public final class LocationRequest
  implements SafeParcelable
{
  public static final e Ui = new e();
  long Uc;
  long Ud;
  boolean Ue;
  long Uf;
  int Ug;
  float Uh;
  int mPriority;
  private final int qh;
  
  public LocationRequest()
  {
    this.qh = 1;
    this.mPriority = 102;
    this.Uc = 3600000L;
    this.Ud = 600000L;
    this.Ue = false;
    this.Uf = Long.MAX_VALUE;
    this.Ug = Integer.MAX_VALUE;
    this.Uh = 0.0F;
  }
  
  LocationRequest(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt3, float paramFloat)
  {
    this.qh = paramInt1;
    this.mPriority = paramInt2;
    this.Uc = paramLong1;
    this.Ud = paramLong2;
    this.Ue = paramBoolean;
    this.Uf = paramLong3;
    this.Ug = paramInt3;
    this.Uh = paramFloat;
  }
  
  private static void dK(int paramInt)
  {
    switch (paramInt)
    {
    case 101: 
    case 103: 
    default: 
      throw new IllegalArgumentException("invalid quality: " + paramInt);
    }
  }
  
  public static String dL(int paramInt)
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
  
  public static LocationRequest tX()
  {
    return new LocationRequest();
  }
  
  private static void v(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("invalid interval: " + paramLong);
    }
  }
  
  public LocationRequest dJ(int paramInt)
  {
    dK(paramInt);
    this.mPriority = paramInt;
    return this;
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
    } while ((this.mPriority == ((LocationRequest)paramObject).mPriority) && (this.Uc == ((LocationRequest)paramObject).Uc) && (this.Ud == ((LocationRequest)paramObject).Ud) && (this.Ue == ((LocationRequest)paramObject).Ue) && (this.Uf == ((LocationRequest)paramObject).Uf) && (this.Ug == ((LocationRequest)paramObject).Ug) && (this.Uh == ((LocationRequest)paramObject).Uh));
    return false;
  }
  
  public int hashCode()
  {
    return cz.hashCode(new Object[] { Integer.valueOf(this.mPriority), Long.valueOf(this.Uc), Long.valueOf(this.Ud), Boolean.valueOf(this.Ue), Long.valueOf(this.Uf), Integer.valueOf(this.Ug), Float.valueOf(this.Uh) });
  }
  
  int lX()
  {
    return this.qh;
  }
  
  public LocationRequest t(long paramLong)
  {
    v(paramLong);
    this.Uc = paramLong;
    if (!this.Ue) {
      this.Ud = ((this.Uc / 6.0D));
    }
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request[").append(dL(this.mPriority));
    if (this.mPriority != 105)
    {
      localStringBuilder.append(" requested=");
      localStringBuilder.append(this.Uc + "ms");
    }
    localStringBuilder.append(" fastest=");
    localStringBuilder.append(this.Ud + "ms");
    if (this.Uf != Long.MAX_VALUE)
    {
      long l1 = this.Uf;
      long l2 = SystemClock.elapsedRealtime();
      localStringBuilder.append(" expireIn=");
      localStringBuilder.append(l1 - l2 + "ms");
    }
    if (this.Ug != Integer.MAX_VALUE) {
      localStringBuilder.append(" num=").append(this.Ug);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public LocationRequest u(long paramLong)
  {
    v(paramLong);
    this.Ue = true;
    this.Ud = paramLong;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/location/LocationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */