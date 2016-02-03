package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bucket
  implements SafeParcelable
{
  public static final Parcelable.Creator<Bucket> CREATOR = new d();
  public static final int TYPE_ACTIVITY_SEGMENT = 4;
  public static final int TYPE_ACTIVITY_TYPE = 3;
  public static final int TYPE_SESSION = 2;
  public static final int TYPE_TIME = 1;
  private final int BR;
  private final long KL;
  private final long Si;
  private final Session Sk;
  private final int Sv;
  private final List<DataSet> Sw;
  private final int Sx;
  private boolean Sy = false;
  
  Bucket(int paramInt1, long paramLong1, long paramLong2, Session paramSession, int paramInt2, List<DataSet> paramList, int paramInt3, boolean paramBoolean)
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
  
  public Bucket(RawBucket paramRawBucket, List<DataSource> paramList, List<DataType> paramList1)
  {
    this(2, paramRawBucket.KL, paramRawBucket.Si, paramRawBucket.Sk, paramRawBucket.Sv, a(paramRawBucket.Sw, paramList, paramList1), paramRawBucket.Sx, paramRawBucket.Sy);
  }
  
  private static List<DataSet> a(List<RawDataSet> paramList, List<DataSource> paramList1, List<DataType> paramList2)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new DataSet((RawDataSet)paramList.next(), paramList1, paramList2));
    }
    return localArrayList;
  }
  
  private boolean a(Bucket paramBucket)
  {
    return (this.KL == paramBucket.KL) && (this.Si == paramBucket.Si) && (this.Sv == paramBucket.Sv) && (m.equal(this.Sw, paramBucket.Sw)) && (this.Sx == paramBucket.Sx) && (this.Sy == paramBucket.Sy);
  }
  
  public static String cz(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "bug";
    case 1: 
      return "time";
    case 3: 
      return "type";
    case 4: 
      return "segment";
    case 2: 
      return "session";
    }
    return "unknown";
  }
  
  public boolean b(Bucket paramBucket)
  {
    return (this.KL == paramBucket.KL) && (this.Si == paramBucket.Si) && (this.Sv == paramBucket.Sv) && (this.Sx == paramBucket.Sx);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof Bucket)) && (a((Bucket)paramObject)));
  }
  
  public int getActivity()
  {
    return this.Sv;
  }
  
  public int getBucketType()
  {
    return this.Sx;
  }
  
  public DataSet getDataSet(DataType paramDataType)
  {
    Iterator localIterator = this.Sw.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (localDataSet.getDataType().equals(paramDataType)) {
        return localDataSet;
      }
    }
    return null;
  }
  
  public List<DataSet> getDataSets()
  {
    return this.Sw;
  }
  
  public long getEndTimeMillis()
  {
    return this.Si;
  }
  
  public Session getSession()
  {
    return this.Sk;
  }
  
  public long getStartTimeMillis()
  {
    return this.KL;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { Long.valueOf(this.KL), Long.valueOf(this.Si), Integer.valueOf(this.Sv), Integer.valueOf(this.Sx) });
  }
  
  public boolean iB()
  {
    if (this.Sy) {
      return true;
    }
    Iterator localIterator = this.Sw.iterator();
    while (localIterator.hasNext()) {
      if (((DataSet)localIterator.next()).iB()) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    return m.h(this).a("startTime", Long.valueOf(this.KL)).a("endTime", Long.valueOf(this.Si)).a("activity", Integer.valueOf(this.Sv)).a("dataSets", this.Sw).a("bucketType", cz(this.Sx)).a("serverHasMoreData", Boolean.valueOf(this.Sy)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/data/Bucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */