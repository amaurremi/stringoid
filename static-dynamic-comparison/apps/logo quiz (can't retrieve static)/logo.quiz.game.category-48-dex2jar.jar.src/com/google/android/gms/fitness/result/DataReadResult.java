package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DataReadResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<DataReadResult> CREATOR = new b();
  private final int BR;
  private final Status CM;
  private final List<DataSource> SH;
  private final List<DataSet> Sw;
  private final List<Bucket> UK;
  private int UL;
  private final List<DataType> UM;
  
  DataReadResult(int paramInt1, List<RawDataSet> paramList, Status paramStatus, List<RawBucket> paramList1, int paramInt2, List<DataSource> paramList2, List<DataType> paramList3)
  {
    this.BR = paramInt1;
    this.CM = paramStatus;
    this.UL = paramInt2;
    this.SH = paramList2;
    this.UM = paramList3;
    this.Sw = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramStatus = (RawDataSet)paramList.next();
      this.Sw.add(new DataSet(paramStatus, paramList2, paramList3));
    }
    this.UK = new ArrayList(paramList1.size());
    paramList = paramList1.iterator();
    while (paramList.hasNext())
    {
      paramStatus = (RawBucket)paramList.next();
      this.UK.add(new Bucket(paramStatus, paramList2, paramList3));
    }
  }
  
  public DataReadResult(List<DataSet> paramList, List<Bucket> paramList1, Status paramStatus)
  {
    this.BR = 5;
    this.Sw = paramList;
    this.CM = paramStatus;
    this.UK = paramList1;
    this.UL = 1;
    this.SH = new ArrayList();
    this.UM = new ArrayList();
  }
  
  public static DataReadResult a(Status paramStatus, DataReadRequest paramDataReadRequest)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramDataReadRequest.getDataSources().iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(DataSet.create((DataSource)((Iterator)localObject).next()));
    }
    paramDataReadRequest = paramDataReadRequest.getDataTypes().iterator();
    while (paramDataReadRequest.hasNext())
    {
      localObject = (DataType)paramDataReadRequest.next();
      localArrayList.add(DataSet.create(new DataSource.Builder().setDataType((DataType)localObject).setType(1).setName("Default").build()));
    }
    return new DataReadResult(localArrayList, Collections.emptyList(), paramStatus);
  }
  
  private void a(Bucket paramBucket, List<Bucket> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (Bucket)localIterator.next();
      if (paramList.b(paramBucket))
      {
        paramBucket = paramBucket.getDataSets().iterator();
        while (paramBucket.hasNext()) {
          a((DataSet)paramBucket.next(), paramList.getDataSets());
        }
      }
    }
    this.UK.add(paramBucket);
  }
  
  private void a(DataSet paramDataSet, List<DataSet> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (localDataSet.getDataSource().equals(paramDataSet.getDataSource()))
      {
        localDataSet.a(paramDataSet.getDataPoints());
        return;
      }
    }
    paramList.add(paramDataSet);
  }
  
  private boolean c(DataReadResult paramDataReadResult)
  {
    return (this.CM.equals(paramDataReadResult.CM)) && (m.equal(this.Sw, paramDataReadResult.Sw)) && (m.equal(this.UK, paramDataReadResult.UK));
  }
  
  public void b(DataReadResult paramDataReadResult)
  {
    Iterator localIterator = paramDataReadResult.getDataSets().iterator();
    while (localIterator.hasNext()) {
      a((DataSet)localIterator.next(), this.Sw);
    }
    paramDataReadResult = paramDataReadResult.getBuckets().iterator();
    while (paramDataReadResult.hasNext()) {
      a((Bucket)paramDataReadResult.next(), this.UK);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataReadResult)) && (c((DataReadResult)paramObject)));
  }
  
  public List<Bucket> getBuckets()
  {
    return this.UK;
  }
  
  public DataSet getDataSet(DataSource paramDataSource)
  {
    Iterator localIterator = this.Sw.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (paramDataSource.equals(localDataSet.getDataSource())) {
        return localDataSet;
      }
    }
    throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", new Object[] { paramDataSource.getStreamIdentifier() }));
  }
  
  public DataSet getDataSet(DataType paramDataType)
  {
    Iterator localIterator = this.Sw.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (paramDataType.equals(localDataSet.getDataType())) {
        return localDataSet;
      }
    }
    throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", new Object[] { paramDataType.getName() }));
  }
  
  public List<DataSet> getDataSets()
  {
    return this.Sw;
  }
  
  public Status getStatus()
  {
    return this.CM;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.CM, this.Sw, this.UK });
  }
  
  List<DataSource> iG()
  {
    return this.SH;
  }
  
  public int jF()
  {
    return this.UL;
  }
  
  List<RawBucket> jG()
  {
    ArrayList localArrayList = new ArrayList(this.UK.size());
    Iterator localIterator = this.UK.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new RawBucket((Bucket)localIterator.next(), this.SH, this.UM));
    }
    return localArrayList;
  }
  
  List<RawDataSet> jH()
  {
    ArrayList localArrayList = new ArrayList(this.Sw.size());
    Iterator localIterator = this.Sw.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new RawDataSet((DataSet)localIterator.next(), this.SH, this.UM));
    }
    return localArrayList;
  }
  
  List<DataType> jI()
  {
    return this.UM;
  }
  
  public String toString()
  {
    m.a locala = m.h(this).a("status", this.CM);
    if (this.Sw.size() > 5)
    {
      localObject = this.Sw.size() + " data sets";
      locala = locala.a("dataSets", localObject);
      if (this.UK.size() <= 5) {
        break label127;
      }
    }
    label127:
    for (Object localObject = this.UK.size() + " buckets";; localObject = this.UK)
    {
      return locala.a("buckets", localObject).toString();
      localObject = this.Sw;
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/result/DataReadResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */