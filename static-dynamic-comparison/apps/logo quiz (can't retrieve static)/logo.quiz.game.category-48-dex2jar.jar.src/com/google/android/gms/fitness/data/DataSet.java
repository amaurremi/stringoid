package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class DataSet
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataSet> CREATOR = new f();
  private final int BR;
  private final DataType SF;
  private final List<DataPoint> SG;
  private final List<DataSource> SH;
  private final DataSource Sh;
  private boolean Sy = false;
  
  DataSet(int paramInt, DataSource paramDataSource, DataType paramDataType, List<RawDataPoint> paramList, List<DataSource> paramList1, boolean paramBoolean)
  {
    this.BR = paramInt;
    this.Sh = paramDataSource;
    this.SF = paramDataType;
    this.Sy = paramBoolean;
    this.SG = new ArrayList(paramList.size());
    if (paramInt >= 2) {}
    for (;;)
    {
      this.SH = paramList1;
      paramDataSource = paramList.iterator();
      while (paramDataSource.hasNext())
      {
        paramDataType = (RawDataPoint)paramDataSource.next();
        this.SG.add(new DataPoint(this.SH, paramDataType));
      }
      paramList1 = Collections.singletonList(paramDataSource);
    }
  }
  
  private DataSet(DataSource paramDataSource, DataType paramDataType)
  {
    this.BR = 3;
    this.Sh = ((DataSource)n.i(paramDataSource));
    this.SF = ((DataType)n.i(paramDataType));
    this.SG = new ArrayList();
    this.SH = new ArrayList();
    this.SH.add(this.Sh);
  }
  
  public DataSet(RawDataSet paramRawDataSet, List<DataSource> paramList, List<DataType> paramList1)
  {
    this(3, (DataSource)b(paramList, paramRawDataSet.Tb), (DataType)b(paramList1, paramRawDataSet.Td), paramRawDataSet.Te, paramList, paramRawDataSet.Sy);
  }
  
  private boolean a(DataSet paramDataSet)
  {
    return (m.equal(this.SF, paramDataSet.SF)) && (m.equal(this.Sh, paramDataSet.Sh)) && (m.equal(this.SG, paramDataSet.SG)) && (this.Sy == paramDataSet.Sy);
  }
  
  private static <T> T b(List<T> paramList, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < paramList.size())) {
      return (T)paramList.get(paramInt);
    }
    return null;
  }
  
  public static DataSet create(DataSource paramDataSource)
  {
    return new DataSet(paramDataSource, paramDataSource.getDataType());
  }
  
  public void a(Iterable<DataPoint> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      b((DataPoint)paramIterable.next());
    }
  }
  
  public void add(DataPoint paramDataPoint)
  {
    DataSource localDataSource = paramDataPoint.getDataSource();
    n.b(localDataSource.getStreamIdentifier().equals(this.Sh.getStreamIdentifier()), "Conflicting data sources found %s vs %s", new Object[] { localDataSource, this.Sh });
    n.b(paramDataPoint.getDataType().getName().equals(this.SF.getName()), "Conflicting data types found %s vs %s", new Object[] { paramDataPoint.getDataType(), this.SF });
    if (paramDataPoint.getTimestampNanos() > 0L)
    {
      bool = true;
      n.b(bool, "Data point does not have the timestamp set: %s", new Object[] { paramDataPoint });
      if (paramDataPoint.getStartTimeNanos() > paramDataPoint.getEndTimeNanos()) {
        break label143;
      }
    }
    label143:
    for (boolean bool = true;; bool = false)
    {
      n.b(bool, "Data point with start time greater than end time found: %s", new Object[] { paramDataPoint });
      b(paramDataPoint);
      return;
      bool = false;
      break;
    }
  }
  
  public void addAll(Iterable<DataPoint> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      add((DataPoint)paramIterable.next());
    }
  }
  
  public void b(DataPoint paramDataPoint)
  {
    this.SG.add(paramDataPoint);
    paramDataPoint = paramDataPoint.getOriginalDataSource();
    if ((paramDataPoint != null) && (!this.SH.contains(paramDataPoint))) {
      this.SH.add(paramDataPoint);
    }
  }
  
  public DataPoint createDataPoint()
  {
    return DataPoint.create(this.Sh);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  List<RawDataPoint> e(List<DataSource> paramList)
  {
    ArrayList localArrayList = new ArrayList(this.SG.size());
    Iterator localIterator = this.SG.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new RawDataPoint((DataPoint)localIterator.next(), paramList));
    }
    return localArrayList;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof DataSet)) && (a((DataSet)paramObject)));
  }
  
  public List<DataPoint> getDataPoints()
  {
    return Collections.unmodifiableList(this.SG);
  }
  
  public DataSource getDataSource()
  {
    return this.Sh;
  }
  
  public DataType getDataType()
  {
    return this.SF;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.SF, this.Sh });
  }
  
  public boolean iB()
  {
    return this.Sy;
  }
  
  List<RawDataPoint> iF()
  {
    return e(this.SH);
  }
  
  List<DataSource> iG()
  {
    return this.SH;
  }
  
  public String toString()
  {
    Object localObject = iF();
    String str = this.Sh.toDebugString();
    if (this.SG.size() < 10) {}
    for (;;)
    {
      return String.format("DataSet{%s %s}", new Object[] { str, localObject });
      localObject = String.format("%d data points, first 5: %s", new Object[] { Integer.valueOf(this.SG.size()), ((List)localObject).subList(0, 5) });
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/data/DataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */