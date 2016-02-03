package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.k;
import com.google.android.gms.fitness.data.k.a;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class n
  implements SafeParcelable
{
  public static final Parcelable.Creator<n> CREATOR = new o();
  private final int BR;
  private final DataType SF;
  private final DataSource Sh;
  private final long Ti;
  private final int Tj;
  private k Up;
  int Uq;
  int Ur;
  private final long Us;
  private final long Ut;
  private final List<LocationRequest> Uu;
  private final long Uv;
  private final List Uw;
  private final PendingIntent mPendingIntent;
  
  n(int paramInt1, DataSource paramDataSource, DataType paramDataType, IBinder paramIBinder, int paramInt2, int paramInt3, long paramLong1, long paramLong2, PendingIntent paramPendingIntent, long paramLong3, int paramInt4, List<LocationRequest> paramList, long paramLong4)
  {
    this.BR = paramInt1;
    this.Sh = paramDataSource;
    this.SF = paramDataType;
    if (paramIBinder == null) {}
    for (paramDataSource = null;; paramDataSource = k.a.an(paramIBinder))
    {
      this.Up = paramDataSource;
      long l = paramLong1;
      if (paramLong1 == 0L) {
        l = paramInt2;
      }
      this.Ti = l;
      this.Ut = paramLong3;
      paramLong1 = paramLong2;
      if (paramLong2 == 0L) {
        paramLong1 = paramInt3;
      }
      this.Us = paramLong1;
      this.Uu = paramList;
      this.mPendingIntent = paramPendingIntent;
      this.Tj = paramInt4;
      this.Uw = Collections.emptyList();
      this.Uv = paramLong4;
      return;
    }
  }
  
  private n(DataSource paramDataSource, DataType paramDataType, k paramk, PendingIntent paramPendingIntent, long paramLong1, long paramLong2, long paramLong3, int paramInt, List paramList1, List paramList2, long paramLong4)
  {
    this.BR = 4;
    this.Sh = paramDataSource;
    this.SF = paramDataType;
    this.Up = paramk;
    this.mPendingIntent = paramPendingIntent;
    this.Ti = paramLong1;
    this.Ut = paramLong2;
    this.Us = paramLong3;
    this.Tj = paramInt;
    this.Uu = paramList1;
    this.Uw = paramList2;
    this.Uv = paramLong4;
  }
  
  public n(SensorRequest paramSensorRequest, k paramk, PendingIntent paramPendingIntent)
  {
    this(paramSensorRequest.getDataSource(), paramSensorRequest.getDataType(), paramk, paramPendingIntent, paramSensorRequest.getSamplingRateMicros(), paramSensorRequest.jm(), paramSensorRequest.jn(), paramSensorRequest.iQ(), null, Collections.emptyList(), paramSensorRequest.jr());
  }
  
  private boolean a(n paramn)
  {
    return (m.equal(this.Sh, paramn.Sh)) && (m.equal(this.SF, paramn.SF)) && (this.Ti == paramn.Ti) && (this.Ut == paramn.Ut) && (this.Us == paramn.Us) && (this.Tj == paramn.Tj) && (m.equal(this.Uu, paramn.Uu));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof n)) && (a((n)paramObject)));
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
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.Sh, this.SF, this.Up, Long.valueOf(this.Ti), Long.valueOf(this.Ut), Long.valueOf(this.Us), Integer.valueOf(this.Tj), this.Uu });
  }
  
  public int iQ()
  {
    return this.Tj;
  }
  
  public PendingIntent jl()
  {
    return this.mPendingIntent;
  }
  
  public long jm()
  {
    return this.Ut;
  }
  
  public long jn()
  {
    return this.Us;
  }
  
  public List<LocationRequest> jo()
  {
    return this.Uu;
  }
  
  public long jp()
  {
    return this.Uv;
  }
  
  IBinder jq()
  {
    if (this.Up == null) {
      return null;
    }
    return this.Up.asBinder();
  }
  
  public String toString()
  {
    return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", new Object[] { this.SF, this.Sh, Long.valueOf(this.Ti), Long.valueOf(this.Ut), Long.valueOf(this.Us) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    o.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */