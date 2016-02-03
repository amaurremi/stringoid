package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.al;

public final class LocationRequest
  implements SafeParcelable
{
  public static final c CREATOR = new c();
  int a;
  long b;
  long c;
  boolean d;
  long e;
  int f;
  float g;
  private final int h;
  
  public LocationRequest()
  {
    this.h = 1;
    this.a = 102;
    this.b = 3600000L;
    this.c = 600000L;
    this.d = false;
    this.e = Long.MAX_VALUE;
    this.f = Integer.MAX_VALUE;
    this.g = 0.0F;
  }
  
  LocationRequest(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt3, float paramFloat)
  {
    this.h = paramInt1;
    this.a = paramInt2;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramBoolean;
    this.e = paramLong3;
    this.f = paramInt3;
    this.g = paramFloat;
  }
  
  public static String a(int paramInt)
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
  
  int a()
  {
    return this.h;
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
    } while ((this.a == ((LocationRequest)paramObject).a) && (this.b == ((LocationRequest)paramObject).b) && (this.c == ((LocationRequest)paramObject).c) && (this.d == ((LocationRequest)paramObject).d) && (this.e == ((LocationRequest)paramObject).e) && (this.f == ((LocationRequest)paramObject).f) && (this.g == ((LocationRequest)paramObject).g));
    return false;
  }
  
  public int hashCode()
  {
    return al.a(new Object[] { Integer.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), Boolean.valueOf(this.d), Long.valueOf(this.e), Integer.valueOf(this.f), Float.valueOf(this.g) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request[").append(a(this.a));
    if (this.a != 105)
    {
      localStringBuilder.append(" requested=");
      localStringBuilder.append(this.b + "ms");
    }
    localStringBuilder.append(" fastest=");
    localStringBuilder.append(this.c + "ms");
    if (this.e != Long.MAX_VALUE)
    {
      long l1 = this.e;
      long l2 = SystemClock.elapsedRealtime();
      localStringBuilder.append(" expireIn=");
      localStringBuilder.append(l1 - l2 + "ms");
    }
    if (this.f != Integer.MAX_VALUE) {
      localStringBuilder.append(" num=").append(this.f);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/location/LocationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */