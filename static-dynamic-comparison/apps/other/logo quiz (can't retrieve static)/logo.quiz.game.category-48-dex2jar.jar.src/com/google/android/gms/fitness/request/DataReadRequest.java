package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.AggregateDataTypes;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.DataTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DataReadRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataReadRequest> CREATOR = new f();
  private final int BR;
  private final long KL;
  private final long Si;
  private final List<DataType> Su;
  private final int Sx;
  private final List<DataSource> TZ;
  private final List<DataType> Ud;
  private final List<DataSource> Ue;
  private final long Uf;
  private final DataSource Ug;
  private final int Uh;
  private final boolean Ui;
  private final boolean Uj;
  private final boolean Uk;
  
  DataReadRequest(int paramInt1, List<DataType> paramList1, List<DataSource> paramList2, long paramLong1, long paramLong2, List<DataType> paramList3, List<DataSource> paramList4, int paramInt2, long paramLong3, DataSource paramDataSource, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.BR = paramInt1;
    this.Su = Collections.unmodifiableList(paramList1);
    this.TZ = Collections.unmodifiableList(paramList2);
    this.KL = paramLong1;
    this.Si = paramLong2;
    this.Ud = Collections.unmodifiableList(paramList3);
    this.Ue = Collections.unmodifiableList(paramList4);
    this.Sx = paramInt2;
    this.Uf = paramLong3;
    this.Ug = paramDataSource;
    this.Uh = paramInt3;
    this.Ui = paramBoolean1;
    this.Uj = paramBoolean2;
    this.Uk = paramBoolean3;
  }
  
  private DataReadRequest(Builder paramBuilder)
  {
    this.BR = 2;
    this.Su = Collections.unmodifiableList(Builder.a(paramBuilder));
    this.TZ = Collections.unmodifiableList(Builder.b(paramBuilder));
    this.KL = Builder.c(paramBuilder);
    this.Si = Builder.d(paramBuilder);
    this.Ud = Collections.unmodifiableList(Builder.e(paramBuilder));
    this.Ue = Collections.unmodifiableList(Builder.f(paramBuilder));
    this.Sx = Builder.g(paramBuilder);
    this.Uf = Builder.h(paramBuilder);
    this.Ug = Builder.i(paramBuilder);
    this.Uh = Builder.j(paramBuilder);
    this.Ui = Builder.k(paramBuilder);
    this.Uj = Builder.l(paramBuilder);
    this.Uk = Builder.m(paramBuilder);
  }
  
  private boolean a(DataReadRequest paramDataReadRequest)
  {
    return (this.Su.equals(paramDataReadRequest.Su)) && (this.TZ.equals(paramDataReadRequest.TZ)) && (this.KL == paramDataReadRequest.KL) && (this.Si == paramDataReadRequest.Si) && (this.Sx == paramDataReadRequest.Sx) && (this.Ue.equals(paramDataReadRequest.Ue)) && (this.Ud.equals(paramDataReadRequest.Ud)) && (m.equal(this.Ug, paramDataReadRequest.Ug)) && (this.Uf == paramDataReadRequest.Uf) && (this.Uk == paramDataReadRequest.Uk);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataReadRequest)) && (a((DataReadRequest)paramObject)));
  }
  
  public int getBucketType()
  {
    return this.Sx;
  }
  
  public List<DataSource> getDataSources()
  {
    return this.TZ;
  }
  
  public List<DataType> getDataTypes()
  {
    return this.Su;
  }
  
  public long getEndTimeMillis()
  {
    return this.Si;
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
    return m.hashCode(new Object[] { Integer.valueOf(this.Sx), Long.valueOf(this.KL), Long.valueOf(this.Si) });
  }
  
  public List<DataType> ja()
  {
    return this.Ud;
  }
  
  public List<DataSource> jb()
  {
    return this.Ue;
  }
  
  public long jc()
  {
    return this.Uf;
  }
  
  public DataSource jd()
  {
    return this.Ug;
  }
  
  public int je()
  {
    return this.Uh;
  }
  
  public boolean jf()
  {
    return this.Ui;
  }
  
  public boolean jg()
  {
    return this.Uk;
  }
  
  public boolean jh()
  {
    return this.Uj;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadDataRequest{");
    Iterator localIterator;
    if (!this.Su.isEmpty())
    {
      localIterator = this.Su.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((DataType)localIterator.next()).iL()).append(" ");
      }
    }
    if (!this.TZ.isEmpty())
    {
      localIterator = this.TZ.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((DataSource)localIterator.next()).toDebugString()).append(" ");
      }
    }
    if (this.Sx != 0)
    {
      localStringBuilder.append("bucket by ").append(Bucket.cz(this.Sx));
      if (this.Uf > 0L) {
        localStringBuilder.append(" >").append(this.Uf).append("ms");
      }
      localStringBuilder.append(": ");
    }
    if (!this.Ud.isEmpty())
    {
      localIterator = this.Ud.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((DataType)localIterator.next()).iL()).append(" ");
      }
    }
    if (!this.Ue.isEmpty())
    {
      localIterator = this.Ue.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((DataSource)localIterator.next()).toDebugString()).append(" ");
      }
    }
    localStringBuilder.append(String.format("(%tF %tT - %tF %tT)", new Object[] { Long.valueOf(this.KL), Long.valueOf(this.KL), Long.valueOf(this.Si), Long.valueOf(this.Si) }));
    if (this.Ug != null) {
      localStringBuilder.append("activities: ").append(this.Ug.toDebugString());
    }
    if (this.Uk) {
      localStringBuilder.append(" +server");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private long KL;
    private long Si;
    private List<DataType> Su = new ArrayList();
    private int Sx = 0;
    private List<DataSource> TZ = new ArrayList();
    private List<DataType> Ud = new ArrayList();
    private List<DataSource> Ue = new ArrayList();
    private long Uf = 0L;
    private DataSource Ug;
    private int Uh = 0;
    private boolean Ui = false;
    private boolean Uj = false;
    private boolean Uk = false;
    
    public Builder aggregate(DataSource paramDataSource, DataType paramDataType)
    {
      n.b(paramDataSource, "Attempting to add a null data source");
      if (!this.TZ.contains(paramDataSource)) {}
      for (boolean bool = true;; bool = false)
      {
        n.a(bool, "Cannot add the same data source for aggregated and detailed");
        DataType localDataType = paramDataSource.getDataType();
        n.b(AggregateDataTypes.INPUT_TYPES.contains(localDataType), "Unsupported input data type specified for aggregation: %s", new Object[] { localDataType });
        n.b(AggregateDataTypes.getForInput(localDataType).contains(paramDataType), "Invalid output aggregate data type specified: %s -> %s", new Object[] { localDataType, paramDataType });
        if (!this.Ue.contains(paramDataSource)) {
          this.Ue.add(paramDataSource);
        }
        return this;
      }
    }
    
    public Builder aggregate(DataType paramDataType1, DataType paramDataType2)
    {
      n.b(paramDataType1, "Attempting to use a null data type");
      if (!this.Su.contains(paramDataType1)) {}
      for (boolean bool = true;; bool = false)
      {
        n.a(bool, "Cannot add the same data type as aggregated and detailed");
        n.b(AggregateDataTypes.INPUT_TYPES.contains(paramDataType1), "Unsupported input data type specified for aggregation: %s", new Object[] { paramDataType1 });
        n.b(AggregateDataTypes.getForInput(paramDataType1).contains(paramDataType2), "Invalid output aggregate data type specified: %s -> %s", new Object[] { paramDataType1, paramDataType2 });
        if (!this.Ud.contains(paramDataType1)) {
          this.Ud.add(paramDataType1);
        }
        return this;
      }
    }
    
    public Builder bucketByActivitySegment(int paramInt, TimeUnit paramTimeUnit)
    {
      if (this.Sx == 0)
      {
        bool = true;
        n.b(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.Sx) });
        if (paramInt <= 0) {
          break label74;
        }
      }
      label74:
      for (boolean bool = true;; bool = false)
      {
        n.b(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
        this.Sx = 4;
        this.Uf = paramTimeUnit.toMillis(paramInt);
        return this;
        bool = false;
        break;
      }
    }
    
    public Builder bucketByActivitySegment(int paramInt, TimeUnit paramTimeUnit, DataSource paramDataSource)
    {
      if (this.Sx == 0)
      {
        bool = true;
        n.b(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.Sx) });
        if (paramInt <= 0) {
          break label121;
        }
        bool = true;
        label38:
        n.b(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
        if (paramDataSource == null) {
          break label127;
        }
      }
      label121:
      label127:
      for (boolean bool = true;; bool = false)
      {
        n.b(bool, "Invalid activity data source specified");
        n.b(paramDataSource.getDataType().equals(DataTypes.ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", new Object[] { paramDataSource });
        this.Ug = paramDataSource;
        this.Sx = 4;
        this.Uf = paramTimeUnit.toMillis(paramInt);
        return this;
        bool = false;
        break;
        bool = false;
        break label38;
      }
    }
    
    public Builder bucketByActivityType(int paramInt, TimeUnit paramTimeUnit)
    {
      if (this.Sx == 0)
      {
        bool = true;
        n.b(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.Sx) });
        if (paramInt <= 0) {
          break label74;
        }
      }
      label74:
      for (boolean bool = true;; bool = false)
      {
        n.b(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
        this.Sx = 3;
        this.Uf = paramTimeUnit.toMillis(paramInt);
        return this;
        bool = false;
        break;
      }
    }
    
    public Builder bucketByActivityType(int paramInt, TimeUnit paramTimeUnit, DataSource paramDataSource)
    {
      if (this.Sx == 0)
      {
        bool = true;
        n.b(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.Sx) });
        if (paramInt <= 0) {
          break label121;
        }
        bool = true;
        label38:
        n.b(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
        if (paramDataSource == null) {
          break label127;
        }
      }
      label121:
      label127:
      for (boolean bool = true;; bool = false)
      {
        n.b(bool, "Invalid activity data source specified");
        n.b(paramDataSource.getDataType().equals(DataTypes.ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", new Object[] { paramDataSource });
        this.Ug = paramDataSource;
        this.Sx = 3;
        this.Uf = paramTimeUnit.toMillis(paramInt);
        return this;
        bool = false;
        break;
        bool = false;
        break label38;
      }
    }
    
    public Builder bucketBySession(int paramInt, TimeUnit paramTimeUnit)
    {
      if (this.Sx == 0)
      {
        bool = true;
        n.b(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.Sx) });
        if (paramInt <= 0) {
          break label74;
        }
      }
      label74:
      for (boolean bool = true;; bool = false)
      {
        n.b(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
        this.Sx = 2;
        this.Uf = paramTimeUnit.toMillis(paramInt);
        return this;
        bool = false;
        break;
      }
    }
    
    public Builder bucketByTime(int paramInt, TimeUnit paramTimeUnit)
    {
      if (this.Sx == 0)
      {
        bool = true;
        n.b(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.Sx) });
        if (paramInt <= 0) {
          break label74;
        }
      }
      label74:
      for (boolean bool = true;; bool = false)
      {
        n.b(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
        this.Sx = 1;
        this.Uf = paramTimeUnit.toMillis(paramInt);
        return this;
        bool = false;
        break;
      }
    }
    
    public DataReadRequest build()
    {
      boolean bool2 = true;
      label69:
      label112:
      int i;
      if ((!this.TZ.isEmpty()) || (!this.Su.isEmpty()) || (!this.Ue.isEmpty()) || (!this.Ud.isEmpty()))
      {
        bool1 = true;
        n.a(bool1, "Must add at least one data source (aggregated or detailed)");
        if (this.KL <= 0L) {
          break label205;
        }
        bool1 = true;
        n.a(bool1, "Invalid start time: %s", new Object[] { Long.valueOf(this.KL) });
        if ((this.Si <= 0L) || (this.Si <= this.KL)) {
          break label210;
        }
        bool1 = true;
        n.a(bool1, "Invalid end time: %s", new Object[] { Long.valueOf(this.Si) });
        if ((!this.Ue.isEmpty()) || (!this.Ud.isEmpty())) {
          break label215;
        }
        i = 1;
        label158:
        if (i != 0)
        {
          bool1 = bool2;
          if (this.Sx == 0) {}
        }
        else
        {
          if ((i != 0) || (this.Sx == 0)) {
            break label220;
          }
        }
      }
      label205:
      label210:
      label215:
      label220:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        n.a(bool1, "Must specify a valid bucketing strategy while requesting aggregation");
        return new DataReadRequest(this, null);
        bool1 = false;
        break;
        bool1 = false;
        break label69;
        bool1 = false;
        break label112;
        i = 0;
        break label158;
      }
    }
    
    public Builder enableServerQueries()
    {
      this.Uk = true;
      return this;
    }
    
    public Builder read(DataSource paramDataSource)
    {
      n.b(paramDataSource, "Attempting to add a null data source");
      if (!this.Ue.contains(paramDataSource)) {}
      for (boolean bool = true;; bool = false)
      {
        n.b(bool, "Cannot add the same data source as aggregated and detailed");
        if (!this.TZ.contains(paramDataSource)) {
          this.TZ.add(paramDataSource);
        }
        return this;
      }
    }
    
    public Builder read(DataType paramDataType)
    {
      n.b(paramDataType, "Attempting to use a null data type");
      if (!this.Ud.contains(paramDataType)) {}
      for (boolean bool = true;; bool = false)
      {
        n.a(bool, "Cannot add the same data type as aggregated and detailed");
        if (!this.Su.contains(paramDataType)) {
          this.Su.add(paramDataType);
        }
        return this;
      }
    }
    
    public Builder setTimeRange(long paramLong1, long paramLong2)
    {
      this.KL = paramLong1;
      this.Si = paramLong2;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/DataReadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */