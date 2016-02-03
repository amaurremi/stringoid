package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.mb;

public abstract interface Geofence
{
  public static final int GEOFENCE_TRANSITION_DWELL = 4;
  public static final int GEOFENCE_TRANSITION_ENTER = 1;
  public static final int GEOFENCE_TRANSITION_EXIT = 2;
  public static final long NEVER_EXPIRE = -1L;
  
  public abstract String getRequestId();
  
  public static final class Builder
  {
    private String Xr = null;
    private int adW = 0;
    private long adX = Long.MIN_VALUE;
    private short adY = -1;
    private double adZ;
    private double aea;
    private float aeb;
    private int aec = 0;
    private int aed = -1;
    
    public Geofence build()
    {
      if (this.Xr == null) {
        throw new IllegalArgumentException("Request ID not set.");
      }
      if (this.adW == 0) {
        throw new IllegalArgumentException("Transitions types not set.");
      }
      if (((this.adW & 0x4) != 0) && (this.aed < 0)) {
        throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
      }
      if (this.adX == Long.MIN_VALUE) {
        throw new IllegalArgumentException("Expiration not set.");
      }
      if (this.adY == -1) {
        throw new IllegalArgumentException("Geofence region not set.");
      }
      if (this.aec < 0) {
        throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
      }
      return new mb(this.Xr, this.adW, (short)1, this.adZ, this.aea, this.aeb, this.adX, this.aec, this.aed);
    }
    
    public Builder setCircularRegion(double paramDouble1, double paramDouble2, float paramFloat)
    {
      this.adY = 1;
      this.adZ = paramDouble1;
      this.aea = paramDouble2;
      this.aeb = paramFloat;
      return this;
    }
    
    public Builder setExpirationDuration(long paramLong)
    {
      if (paramLong < 0L)
      {
        this.adX = -1L;
        return this;
      }
      this.adX = (SystemClock.elapsedRealtime() + paramLong);
      return this;
    }
    
    public Builder setLoiteringDelay(int paramInt)
    {
      this.aed = paramInt;
      return this;
    }
    
    public Builder setNotificationResponsiveness(int paramInt)
    {
      this.aec = paramInt;
      return this;
    }
    
    public Builder setRequestId(String paramString)
    {
      this.Xr = paramString;
      return this;
    }
    
    public Builder setTransitionTypes(int paramInt)
    {
      this.adW = paramInt;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/location/Geofence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */