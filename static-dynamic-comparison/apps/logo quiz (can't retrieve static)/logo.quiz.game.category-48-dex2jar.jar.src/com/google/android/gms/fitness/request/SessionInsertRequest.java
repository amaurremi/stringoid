package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionInsertRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SessionInsertRequest> CREATOR = new r();
  private final int BR;
  private final Session Sk;
  private final List<DataSet> Sw;
  private final List<DataPoint> UA;
  
  SessionInsertRequest(int paramInt, Session paramSession, List<DataSet> paramList, List<DataPoint> paramList1)
  {
    this.BR = paramInt;
    this.Sk = paramSession;
    this.Sw = Collections.unmodifiableList(paramList);
    this.UA = Collections.unmodifiableList(paramList1);
  }
  
  private SessionInsertRequest(Builder paramBuilder)
  {
    this.BR = 1;
    this.Sk = Builder.a(paramBuilder);
    this.Sw = Collections.unmodifiableList(Builder.b(paramBuilder));
    this.UA = Collections.unmodifiableList(Builder.c(paramBuilder));
  }
  
  private boolean a(SessionInsertRequest paramSessionInsertRequest)
  {
    return (m.equal(this.Sk, paramSessionInsertRequest.Sk)) && (m.equal(this.Sw, paramSessionInsertRequest.Sw)) && (m.equal(this.UA, paramSessionInsertRequest.UA));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof SessionInsertRequest)) && (a((SessionInsertRequest)paramObject)));
  }
  
  public List<DataSet> getDataSets()
  {
    return this.Sw;
  }
  
  public Session getSession()
  {
    return this.Sk;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.Sk, this.Sw, this.UA });
  }
  
  public List<DataPoint> js()
  {
    return this.UA;
  }
  
  public String toString()
  {
    return m.h(this).a("session", this.Sk).a("dataSets", this.Sw).a("aggregateDataPoints", this.UA).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    r.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private Session Sk;
    private List<DataSet> Sw = new ArrayList();
    private List<DataPoint> UA = new ArrayList();
    private List<DataSource> UB = new ArrayList();
    
    private void c(DataPoint paramDataPoint)
    {
      long l1 = TimeUnit.MILLISECONDS.toNanos(this.Sk.getStartTimeMillis());
      long l2 = TimeUnit.MILLISECONDS.toNanos(this.Sk.getEndTimeMillis());
      long l3 = paramDataPoint.getTimestampNanos();
      if (l3 != 0L)
      {
        if ((l3 >= l1) && (l3 <= l2))
        {
          bool = true;
          n.a(bool, "Data point %s has time stamp outside session interval [%d, %d]", new Object[] { paramDataPoint, Long.valueOf(l1), Long.valueOf(l2) });
        }
      }
      else
      {
        l3 = paramDataPoint.getStartTimeNanos();
        long l4 = paramDataPoint.getEndTimeNanos();
        if ((l3 != 0L) && (l4 != 0L)) {
          if ((l3 < l1) || (l4 > l2)) {
            break label171;
          }
        }
      }
      label171:
      for (boolean bool = true;; bool = false)
      {
        n.a(bool, "Data point %s has start and end times outside session interval [%d, %d]", new Object[] { paramDataPoint, Long.valueOf(l1), Long.valueOf(l2) });
        return;
        bool = false;
        break;
      }
    }
    
    private void jt()
    {
      Iterator localIterator1 = this.Sw.iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((DataSet)localIterator1.next()).getDataPoints().iterator();
        while (localIterator2.hasNext()) {
          c((DataPoint)localIterator2.next());
        }
      }
      localIterator1 = this.UA.iterator();
      while (localIterator1.hasNext()) {
        c((DataPoint)localIterator1.next());
      }
    }
    
    public Builder addAggregateDataPoint(DataPoint paramDataPoint)
    {
      label38:
      DataSource localDataSource;
      if (paramDataPoint != null)
      {
        bool = true;
        n.b(bool, "Must specify a valid aggregate data point.");
        long l1 = paramDataPoint.getStartTimeNanos();
        long l2 = paramDataPoint.getEndTimeNanos();
        if ((l1 <= 0L) || (l2 <= l1)) {
          break label119;
        }
        bool = true;
        n.b(bool, "Aggregate data point should have valid start and end times: %s", new Object[] { paramDataPoint });
        localDataSource = paramDataPoint.getDataSource();
        if (this.UB.contains(localDataSource)) {
          break label124;
        }
      }
      label119:
      label124:
      for (boolean bool = true;; bool = false)
      {
        n.a(bool, "Data set/Aggregate data point for this data source %s is already added.", new Object[] { localDataSource });
        this.UB.add(localDataSource);
        this.UA.add(paramDataPoint);
        return this;
        bool = false;
        break;
        bool = false;
        break label38;
      }
    }
    
    public Builder addDataSet(DataSet paramDataSet)
    {
      boolean bool2 = true;
      DataSource localDataSource;
      if (paramDataSet != null)
      {
        bool1 = true;
        n.b(bool1, "Must specify a valid data set.");
        localDataSource = paramDataSet.getDataSource();
        if (this.UB.contains(localDataSource)) {
          break label101;
        }
        bool1 = true;
        label36:
        n.a(bool1, "Data set for this data source %s is already added.", new Object[] { localDataSource });
        if (paramDataSet.getDataPoints().isEmpty()) {
          break label106;
        }
      }
      label101:
      label106:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        n.b(bool1, "No data points specified in the input data set.");
        this.UB.add(localDataSource);
        this.Sw.add(paramDataSet);
        return this;
        bool1 = false;
        break;
        bool1 = false;
        break label36;
      }
    }
    
    public SessionInsertRequest build()
    {
      boolean bool2 = true;
      if (this.Sk != null)
      {
        bool1 = true;
        n.a(bool1, "Must specify a valid session.");
        if (this.Sk.getEndTimeMillis() == 0L) {
          break label56;
        }
      }
      label56:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        n.a(bool1, "Must specify a valid end time, cannot insert a continuing session.");
        jt();
        return new SessionInsertRequest(this, null);
        bool1 = false;
        break;
      }
    }
    
    public Builder setSession(Session paramSession)
    {
      this.Sk = paramSession;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/SessionInsertRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */