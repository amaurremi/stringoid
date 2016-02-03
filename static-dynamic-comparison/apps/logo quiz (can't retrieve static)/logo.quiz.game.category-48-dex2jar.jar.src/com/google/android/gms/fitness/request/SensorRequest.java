package com.google.android.gms.fitness.request;

import android.os.SystemClock;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.TimeUnit;

public class SensorRequest
{
  public static final int ACCURACY_MODE_DEFAULT = 2;
  public static final int ACCURACY_MODE_HIGH = 3;
  public static final int ACCURACY_MODE_LOW = 1;
  private final DataType SF;
  private final DataSource Sh;
  private final long Ti;
  private final int Tj;
  private final long Us;
  private final long Ut;
  private final LocationRequest Ux;
  private final long Uy;
  
  private SensorRequest(DataSource paramDataSource, LocationRequest paramLocationRequest)
  {
    this.Ux = paramLocationRequest;
    this.Ti = TimeUnit.MILLISECONDS.toMicros(paramLocationRequest.getInterval());
    this.Ut = TimeUnit.MILLISECONDS.toMicros(paramLocationRequest.getFastestInterval());
    this.Us = this.Ti;
    this.SF = paramDataSource.getDataType();
    this.Tj = a(paramLocationRequest);
    this.Sh = paramDataSource;
    long l = paramLocationRequest.getExpirationTime();
    if (l == Long.MAX_VALUE)
    {
      this.Uy = Long.MAX_VALUE;
      return;
    }
    this.Uy = TimeUnit.MILLISECONDS.toMicros(l - SystemClock.elapsedRealtime());
  }
  
  private SensorRequest(Builder paramBuilder)
  {
    this.Sh = Builder.a(paramBuilder);
    this.SF = Builder.b(paramBuilder);
    this.Ti = Builder.c(paramBuilder);
    this.Ut = Builder.d(paramBuilder);
    this.Us = Builder.e(paramBuilder);
    this.Tj = Builder.f(paramBuilder);
    this.Ux = null;
    this.Uy = Builder.g(paramBuilder);
  }
  
  private static int a(LocationRequest paramLocationRequest)
  {
    switch (paramLocationRequest.getPriority())
    {
    default: 
      return 2;
    case 100: 
      return 3;
    }
    return 1;
  }
  
  private boolean a(SensorRequest paramSensorRequest)
  {
    return (m.equal(this.Sh, paramSensorRequest.Sh)) && (m.equal(this.SF, paramSensorRequest.SF)) && (this.Ti == paramSensorRequest.Ti) && (this.Ut == paramSensorRequest.Ut) && (this.Us == paramSensorRequest.Us) && (this.Tj == paramSensorRequest.Tj) && (m.equal(this.Ux, paramSensorRequest.Ux)) && (this.Uy == paramSensorRequest.Uy);
  }
  
  public static int da(int paramInt)
  {
    int i = paramInt;
    switch (paramInt)
    {
    case 2: 
    default: 
      i = 2;
    }
    return i;
  }
  
  public static SensorRequest fromLocationRequest(DataSource paramDataSource, LocationRequest paramLocationRequest)
  {
    return new SensorRequest(paramDataSource, paramLocationRequest);
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SensorRequest)) && (a((SensorRequest)paramObject)));
  }
  
  public DataSource getDataSource()
  {
    return this.Sh;
  }
  
  public DataType getDataType()
  {
    return this.SF;
  }
  
  public long getSamplingRateMicros()
  {
    return this.Ti;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.Sh, this.SF, Long.valueOf(this.Ti), Long.valueOf(this.Ut), Long.valueOf(this.Us), Integer.valueOf(this.Tj), this.Ux, Long.valueOf(this.Uy) });
  }
  
  public int iQ()
  {
    return this.Tj;
  }
  
  public long jm()
  {
    return this.Ut;
  }
  
  public long jn()
  {
    return this.Us;
  }
  
  public long jr()
  {
    return this.Uy;
  }
  
  public String toString()
  {
    return m.h(this).a("dataSource", this.Sh).a("dataType", this.SF).a("samplingRateMicros", Long.valueOf(this.Ti)).a("deliveryLatencyMicros", Long.valueOf(this.Us)).a("timeOutMicros", Long.valueOf(this.Uy)).toString();
  }
  
  public static class Builder
  {
    private DataType SF;
    private DataSource Sh;
    private long Ti = -1L;
    private int Tj = 2;
    private long Us = 0L;
    private long Ut = 0L;
    private long Uy = Long.MAX_VALUE;
    private boolean Uz = false;
    
    public SensorRequest build()
    {
      boolean bool2 = false;
      if ((this.Sh != null) || (this.SF != null)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        n.a(bool1, "Must call setDataSource() or setDataType()");
        if ((this.SF != null) && (this.Sh != null))
        {
          bool1 = bool2;
          if (!this.SF.equals(this.Sh.getDataType())) {}
        }
        else
        {
          bool1 = true;
        }
        n.a(bool1, "Specified data type is incompatible with specified data source");
        return new SensorRequest(this, null);
      }
    }
    
    public Builder setAccuracyMode(int paramInt)
    {
      this.Tj = SensorRequest.da(paramInt);
      return this;
    }
    
    public Builder setDataSource(DataSource paramDataSource)
    {
      this.Sh = paramDataSource;
      return this;
    }
    
    public Builder setDataType(DataType paramDataType)
    {
      this.SF = paramDataType;
      return this;
    }
    
    public Builder setFastestRate(int paramInt, TimeUnit paramTimeUnit)
    {
      if (paramInt >= 0) {}
      for (boolean bool = true;; bool = false)
      {
        n.b(bool, "Cannot use a negative interval");
        this.Uz = true;
        this.Ut = paramTimeUnit.toMicros(paramInt);
        return this;
      }
    }
    
    public Builder setMaxDeliveryLatency(int paramInt, TimeUnit paramTimeUnit)
    {
      if (paramInt >= 0) {}
      for (boolean bool = true;; bool = false)
      {
        n.b(bool, "Cannot use a negative delivery interval");
        this.Us = paramTimeUnit.toMicros(paramInt);
        return this;
      }
    }
    
    public Builder setSamplingRate(long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramLong >= 0L) {}
      for (boolean bool = true;; bool = false)
      {
        n.b(bool, "Cannot use a negative sampling interval");
        this.Ti = paramTimeUnit.toMicros(paramLong);
        if (!this.Uz) {
          this.Ut = (this.Ti / 2L);
        }
        return this;
      }
    }
    
    public Builder setTimeout(long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool2 = true;
      if (paramLong > 0L)
      {
        bool1 = true;
        n.b(bool1, "Invalid time out value specified: %d", new Object[] { Long.valueOf(paramLong) });
        if (paramTimeUnit == null) {
          break label62;
        }
      }
      label62:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        n.b(bool1, "Invalid time unit specified");
        this.Uy = paramTimeUnit.toMicros(paramLong);
        return this;
        bool1 = false;
        break;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/SensorRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */