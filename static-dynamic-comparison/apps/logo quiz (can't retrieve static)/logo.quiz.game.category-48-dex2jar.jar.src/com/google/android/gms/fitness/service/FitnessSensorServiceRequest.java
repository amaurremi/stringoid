package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.k;
import com.google.android.gms.fitness.data.k.a;

public class FitnessSensorServiceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<FitnessSensorServiceRequest> CREATOR = new a();
  public static final int UNSPECIFIED = -1;
  private final int BR;
  private final DataSource Sh;
  private final long UR;
  private final long US;
  private final k Up;
  
  FitnessSensorServiceRequest(int paramInt, DataSource paramDataSource, IBinder paramIBinder, long paramLong1, long paramLong2)
  {
    this.BR = paramInt;
    this.Sh = paramDataSource;
    this.Up = k.a.an(paramIBinder);
    this.UR = paramLong1;
    this.US = paramLong2;
  }
  
  private boolean a(FitnessSensorServiceRequest paramFitnessSensorServiceRequest)
  {
    return (m.equal(this.Sh, paramFitnessSensorServiceRequest.Sh)) && (this.UR == paramFitnessSensorServiceRequest.UR) && (this.US == paramFitnessSensorServiceRequest.US);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof FitnessSensorServiceRequest)) && (a((FitnessSensorServiceRequest)paramObject)));
  }
  
  public long getBatchIntervalMicros()
  {
    return this.US;
  }
  
  public DataSource getDataSource()
  {
    return this.Sh;
  }
  
  public SensorEventDispatcher getDispatcher()
  {
    return new b(this.Up);
  }
  
  public long getSamplingRateMicros()
  {
    return this.UR;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.Sh, Long.valueOf(this.UR), Long.valueOf(this.US) });
  }
  
  IBinder jq()
  {
    return this.Up.asBinder();
  }
  
  public String toString()
  {
    return String.format("FitnessSensorServiceRequest{%s}", new Object[] { this.Sh });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/service/FitnessSensorServiceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */