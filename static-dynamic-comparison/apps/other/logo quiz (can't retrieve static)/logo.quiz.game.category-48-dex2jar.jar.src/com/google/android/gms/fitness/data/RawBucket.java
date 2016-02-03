package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class RawBucket
  implements SafeParcelable
{
  public static final Parcelable.Creator<RawBucket> CREATOR = new m();
  final int BR;
  final long KL;
  final long Si;
  final Session Sk;
  final int Sv;
  final List<RawDataSet> Sw;
  final int Sx;
  final boolean Sy;
  
  RawBucket(int paramInt1, long paramLong1, long paramLong2, Session paramSession, int paramInt2, List<RawDataSet> paramList, int paramInt3, boolean paramBoolean)
  {
    this.BR = paramInt1;
    this.KL = paramLong1;
    this.Si = paramLong2;
    this.Sk = paramSession;
    this.Sv = paramInt2;
    this.Sw = paramList;
    this.Sx = paramInt3;
    this.Sy = paramBoolean;
  }
  
  public RawBucket(Bucket paramBucket, List<DataSource> paramList, List<DataType> paramList1)
  {
    this.BR = 2;
    this.KL = paramBucket.getStartTimeMillis();
    this.Si = paramBucket.getEndTimeMillis();
    this.Sk = paramBucket.getSession();
    this.Sv = paramBucket.getActivity();
    this.Sx = paramBucket.getBucketType();
    this.Sy = paramBucket.iB();
    paramBucket = paramBucket.getDataSets();
    this.Sw = new ArrayList(paramBucket.size());
    paramBucket = paramBucket.iterator();
    while (paramBucket.hasNext())
    {
      DataSet localDataSet = (DataSet)paramBucket.next();
      this.Sw.add(new RawDataSet(localDataSet, paramList, paramList1));
    }
  }
  
  private boolean a(RawBucket paramRawBucket)
  {
    return (this.KL == paramRawBucket.KL) && (this.Si == paramRawBucket.Si) && (this.Sv == paramRawBucket.Sv) && (com.google.android.gms.common.internal.m.equal(this.Sw, paramRawBucket.Sw)) && (this.Sx == paramRawBucket.Sx) && (this.Sy == paramRawBucket.Sy);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof RawBucket)) && (a((RawBucket)paramObject)));
  }
  
  public int hashCode()
  {
    return com.google.android.gms.common.internal.m.hashCode(new Object[] { Long.valueOf(this.KL), Long.valueOf(this.Si), Integer.valueOf(this.Sx) });
  }
  
  public String toString()
  {
    return com.google.android.gms.common.internal.m.h(this).a("startTime", Long.valueOf(this.KL)).a("endTime", Long.valueOf(this.Si)).a("activity", Integer.valueOf(this.Sv)).a("dataSets", this.Sw).a("bucketType", Integer.valueOf(this.Sx)).a("serverHasMoreData", Boolean.valueOf(this.Sy)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    m.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/data/RawBucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */