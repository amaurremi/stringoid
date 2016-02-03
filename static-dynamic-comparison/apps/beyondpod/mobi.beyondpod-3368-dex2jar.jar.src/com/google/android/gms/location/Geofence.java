package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.go;

public abstract interface Geofence
{
  public static final int GEOFENCE_TRANSITION_DWELL = 4;
  public static final int GEOFENCE_TRANSITION_ENTER = 1;
  public static final int GEOFENCE_TRANSITION_EXIT = 2;
  public static final long NEVER_EXPIRE = -1L;
  
  public abstract String getRequestId();
  
  public static final class Builder
  {
    private int xA = -1;
    private String xs = null;
    private int xt = 0;
    private long xu = Long.MIN_VALUE;
    private short xv = -1;
    private double xw;
    private double xx;
    private float xy;
    private int xz = 0;
    
    public Geofence build()
    {
      if (this.xs == null) {
        throw new IllegalArgumentException("Request ID not set.");
      }
      if (this.xt == 0) {
        throw new IllegalArgumentException("Transitions types not set.");
      }
      if (((this.xt & 0x4) != 0) && (this.xA < 0)) {
        throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
      }
      if (this.xu == Long.MIN_VALUE) {
        throw new IllegalArgumentException("Expiration not set.");
      }
      if (this.xv == -1) {
        throw new IllegalArgumentException("Geofence region not set.");
      }
      if (this.xz < 0) {
        throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
      }
      return new go(this.xs, this.xt, (short)1, this.xw, this.xx, this.xy, this.xu, this.xz, this.xA);
    }
    
    public Builder setCircularRegion(double paramDouble1, double paramDouble2, float paramFloat)
    {
      this.xv = 1;
      this.xw = paramDouble1;
      this.xx = paramDouble2;
      this.xy = paramFloat;
      return this;
    }
    
    public Builder setExpirationDuration(long paramLong)
    {
      if (paramLong < 0L)
      {
        this.xu = -1L;
        return this;
      }
      this.xu = (SystemClock.elapsedRealtime() + paramLong);
      return this;
    }
    
    public Builder setLoiteringDelay(int paramInt)
    {
      this.xA = paramInt;
      return this;
    }
    
    public Builder setNotificationResponsiveness(int paramInt)
    {
      this.xz = paramInt;
      return this;
    }
    
    public Builder setRequestId(String paramString)
    {
      this.xs = paramString;
      return this;
    }
    
    public Builder setTransitionTypes(int paramInt)
    {
      this.xt = paramInt;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/location/Geofence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */