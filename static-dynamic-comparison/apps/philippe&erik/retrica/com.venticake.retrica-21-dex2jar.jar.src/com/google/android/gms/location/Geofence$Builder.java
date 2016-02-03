package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.jh;

public final class Geofence$Builder
{
  private String OB = null;
  private int Va = 0;
  private long Vb = Long.MIN_VALUE;
  private short Vc = -1;
  private double Vd;
  private double Ve;
  private float Vf;
  private int Vg = 0;
  private int Vh = -1;
  
  public Geofence build()
  {
    if (this.OB == null) {
      throw new IllegalArgumentException("Request ID not set.");
    }
    if (this.Va == 0) {
      throw new IllegalArgumentException("Transitions types not set.");
    }
    if (((this.Va & 0x4) != 0) && (this.Vh < 0)) {
      throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
    }
    if (this.Vb == Long.MIN_VALUE) {
      throw new IllegalArgumentException("Expiration not set.");
    }
    if (this.Vc == -1) {
      throw new IllegalArgumentException("Geofence region not set.");
    }
    if (this.Vg < 0) {
      throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
    }
    return new jh(this.OB, this.Va, (short)1, this.Vd, this.Ve, this.Vf, this.Vb, this.Vg, this.Vh);
  }
  
  public Builder setCircularRegion(double paramDouble1, double paramDouble2, float paramFloat)
  {
    this.Vc = 1;
    this.Vd = paramDouble1;
    this.Ve = paramDouble2;
    this.Vf = paramFloat;
    return this;
  }
  
  public Builder setExpirationDuration(long paramLong)
  {
    if (paramLong < 0L)
    {
      this.Vb = -1L;
      return this;
    }
    this.Vb = (SystemClock.elapsedRealtime() + paramLong);
    return this;
  }
  
  public Builder setLoiteringDelay(int paramInt)
  {
    this.Vh = paramInt;
    return this;
  }
  
  public Builder setNotificationResponsiveness(int paramInt)
  {
    this.Vg = paramInt;
    return this;
  }
  
  public Builder setRequestId(String paramString)
  {
    this.OB = paramString;
    return this;
  }
  
  public Builder setTransitionTypes(int paramInt)
  {
    this.Va = paramInt;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/location/Geofence$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */