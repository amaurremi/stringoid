package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataPoint> CREATOR = new e();
  private final int BR;
  private long SA;
  private final Value[] SB;
  private DataSource SC;
  private long SD;
  private long SE;
  private final DataSource Sh;
  private long Sz;
  
  DataPoint(int paramInt, DataSource paramDataSource1, long paramLong1, long paramLong2, Value[] paramArrayOfValue, DataSource paramDataSource2, long paramLong3, long paramLong4)
  {
    this.BR = paramInt;
    this.Sh = paramDataSource1;
    this.SC = paramDataSource2;
    this.Sz = paramLong1;
    this.SA = paramLong2;
    this.SB = paramArrayOfValue;
    this.SD = paramLong3;
    this.SE = paramLong4;
  }
  
  private DataPoint(DataSource paramDataSource)
  {
    this.BR = 4;
    this.Sh = ((DataSource)n.b(paramDataSource, "Data source cannot be null"));
    paramDataSource = paramDataSource.getDataType().getFields();
    this.SB = new Value[paramDataSource.size()];
    paramDataSource = paramDataSource.iterator();
    int i = 0;
    while (paramDataSource.hasNext())
    {
      Field localField = (Field)paramDataSource.next();
      this.SB[i] = new Value(localField.getFormat());
      i += 1;
    }
  }
  
  DataPoint(List<DataSource> paramList, RawDataPoint paramRawDataPoint)
  {
    this(4, a(paramList, paramRawDataPoint.Tb), paramRawDataPoint.Sz, paramRawDataPoint.SA, paramRawDataPoint.SB, a(paramList, paramRawDataPoint.Tc), paramRawDataPoint.SD, paramRawDataPoint.SE);
  }
  
  private static DataSource a(List<DataSource> paramList, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < paramList.size())) {
      return (DataSource)paramList.get(paramInt);
    }
    return null;
  }
  
  private boolean a(DataPoint paramDataPoint)
  {
    return (m.equal(this.Sh, paramDataPoint.Sh)) && (this.Sz == paramDataPoint.Sz) && (this.SA == paramDataPoint.SA) && (Arrays.equals(this.SB, paramDataPoint.SB)) && (m.equal(this.SC, paramDataPoint.SC));
  }
  
  private void cB(int paramInt)
  {
    List localList = getDataType().getFields();
    int i = localList.size();
    if (paramInt == i) {}
    for (boolean bool = true;; bool = false)
    {
      n.b(bool, "Attempting to insert %s values, but needed %s: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), localList });
      return;
    }
  }
  
  public static DataPoint create(DataSource paramDataSource)
  {
    return new DataPoint(paramDataSource);
  }
  
  public static DataPoint extract(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return (DataPoint)c.a(paramIntent, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataPoint)) && (a((DataPoint)paramObject)));
  }
  
  public DataSource getDataSource()
  {
    return this.Sh;
  }
  
  public DataType getDataType()
  {
    return this.Sh.getDataType();
  }
  
  public long getEndTimeNanos()
  {
    return this.Sz;
  }
  
  public DataSource getOriginalDataSource()
  {
    return this.SC;
  }
  
  public long getStartTimeNanos()
  {
    return this.SA;
  }
  
  public long getTimestampNanos()
  {
    return this.Sz;
  }
  
  public Value getValue(Field paramField)
  {
    int i = getDataType().indexOf(paramField);
    return this.SB[i];
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.Sh, Long.valueOf(this.Sz), Long.valueOf(this.SA) });
  }
  
  public Value[] iC()
  {
    return this.SB;
  }
  
  public long iD()
  {
    return this.SD;
  }
  
  public long iE()
  {
    return this.SE;
  }
  
  public DataPoint setFloatValues(float... paramVarArgs)
  {
    cB(paramVarArgs.length);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.SB[i].setFloat(paramVarArgs[i]);
      i += 1;
    }
    return this;
  }
  
  public DataPoint setIntValues(int... paramVarArgs)
  {
    cB(paramVarArgs.length);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.SB[i].setInt(paramVarArgs[i]);
      i += 1;
    }
    return this;
  }
  
  public DataPoint setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return setTimeIntervalNanos(paramTimeUnit.toNanos(paramLong1), paramTimeUnit.toNanos(paramLong2));
  }
  
  public DataPoint setTimeIntervalNanos(long paramLong1, long paramLong2)
  {
    this.SA = paramLong1;
    this.Sz = paramLong2;
    return this;
  }
  
  public DataPoint setTimestamp(long paramLong, TimeUnit paramTimeUnit)
  {
    return setTimestampNanos(paramTimeUnit.toNanos(paramLong));
  }
  
  public DataPoint setTimestampNanos(long paramLong)
  {
    this.Sz = paramLong;
    return this;
  }
  
  public String toString()
  {
    return String.format("DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}", new Object[] { Arrays.toString(this.SB), Long.valueOf(this.SA), Long.valueOf(this.Sz), Long.valueOf(this.SD), Long.valueOf(this.SE), this.Sh, this.SC });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/data/DataPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */