package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;

public final class RawDataPoint
  implements SafeParcelable
{
  public static final Parcelable.Creator<RawDataPoint> CREATOR = new n();
  final int BR;
  final long SA;
  final Value[] SB;
  final long SD;
  final long SE;
  final long Sz;
  final int Tb;
  final int Tc;
  
  RawDataPoint(int paramInt1, long paramLong1, long paramLong2, Value[] paramArrayOfValue, int paramInt2, int paramInt3, long paramLong3, long paramLong4)
  {
    this.BR = paramInt1;
    this.Sz = paramLong1;
    this.SA = paramLong2;
    this.Tb = paramInt2;
    this.Tc = paramInt3;
    this.SD = paramLong3;
    this.SE = paramLong4;
    this.SB = paramArrayOfValue;
  }
  
  RawDataPoint(DataPoint paramDataPoint, List<DataSource> paramList)
  {
    this.BR = 4;
    this.Sz = paramDataPoint.getTimestampNanos();
    this.SA = paramDataPoint.getStartTimeNanos();
    this.SB = paramDataPoint.iC();
    this.Tb = t.a(paramDataPoint.getDataSource(), paramList);
    this.Tc = t.a(paramDataPoint.getOriginalDataSource(), paramList);
    this.SD = paramDataPoint.iD();
    this.SE = paramDataPoint.iE();
  }
  
  private boolean a(RawDataPoint paramRawDataPoint)
  {
    return (this.Sz == paramRawDataPoint.Sz) && (this.SA == paramRawDataPoint.SA) && (Arrays.equals(this.SB, paramRawDataPoint.SB)) && (this.Tb == paramRawDataPoint.Tb) && (this.Tc == paramRawDataPoint.Tc) && (this.SD == paramRawDataPoint.SD);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof RawDataPoint)) && (a((RawDataPoint)paramObject)));
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { Long.valueOf(this.Sz), Long.valueOf(this.SA) });
  }
  
  public String toString()
  {
    return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[] { Arrays.toString(this.SB), Long.valueOf(this.SA), Long.valueOf(this.Sz), Integer.valueOf(this.Tb), Integer.valueOf(this.Tc) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    n.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/data/RawDataPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */