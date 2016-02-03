package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataDeleteRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataDeleteRequest> CREATOR = new d();
  private final int BR;
  private final long KL;
  private final long Si;
  private final List<DataType> Su;
  private final List<DataSource> TZ;
  private final List<Session> Ua;
  private final boolean Ub;
  private final boolean Uc;
  
  DataDeleteRequest(int paramInt, long paramLong1, long paramLong2, List<DataSource> paramList, List<DataType> paramList1, List<Session> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.BR = paramInt;
    this.KL = paramLong1;
    this.Si = paramLong2;
    this.TZ = Collections.unmodifiableList(paramList);
    this.Su = Collections.unmodifiableList(paramList1);
    this.Ua = paramList2;
    this.Ub = paramBoolean1;
    this.Uc = paramBoolean2;
  }
  
  private DataDeleteRequest(Builder paramBuilder)
  {
    this.BR = 1;
    this.KL = Builder.a(paramBuilder);
    this.Si = Builder.b(paramBuilder);
    this.TZ = Collections.unmodifiableList(Builder.c(paramBuilder));
    this.Su = Collections.unmodifiableList(Builder.d(paramBuilder));
    this.Ua = Collections.unmodifiableList(Builder.e(paramBuilder));
    this.Ub = Builder.f(paramBuilder);
    this.Uc = Builder.g(paramBuilder);
  }
  
  private boolean a(DataDeleteRequest paramDataDeleteRequest)
  {
    return (this.KL == paramDataDeleteRequest.KL) && (this.Si == paramDataDeleteRequest.Si) && (m.equal(this.TZ, paramDataDeleteRequest.TZ)) && (m.equal(this.Su, paramDataDeleteRequest.Su)) && (m.equal(this.Ua, paramDataDeleteRequest.Ua)) && (this.Ub == paramDataDeleteRequest.Ub) && (this.Uc == paramDataDeleteRequest.Uc);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof DataDeleteRequest)) && (a((DataDeleteRequest)paramObject)));
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
  
  public List<Session> getSessions()
  {
    return this.Ua;
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
    return m.hashCode(new Object[] { Long.valueOf(this.KL), Long.valueOf(this.Si) });
  }
  
  public boolean iX()
  {
    return this.Ub;
  }
  
  public boolean iY()
  {
    return this.Uc;
  }
  
  public String toString()
  {
    return m.h(this).a("startTimeMillis", Long.valueOf(this.KL)).a("endTimeMillis", Long.valueOf(this.Si)).a("dataSources", this.TZ).a("dateTypes", this.Su).a("sessions", this.Ua).a("deleteAllData", Boolean.valueOf(this.Ub)).a("deleteAllSessions", Boolean.valueOf(this.Uc)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private long KL;
    private long Si;
    private List<DataType> Su = new ArrayList();
    private List<DataSource> TZ = new ArrayList();
    private List<Session> Ua = new ArrayList();
    private boolean Ub = false;
    private boolean Uc = false;
    
    private void iZ()
    {
      if (this.Ua.isEmpty()) {
        return;
      }
      Iterator localIterator = this.Ua.iterator();
      label23:
      Session localSession;
      if (localIterator.hasNext())
      {
        localSession = (Session)localIterator.next();
        if ((localSession.getStartTimeMillis() < this.KL) || (localSession.getEndTimeMillis() > this.Si)) {
          break label105;
        }
      }
      label105:
      for (boolean bool = true;; bool = false)
      {
        n.a(bool, "Session %s is outside the time interval [%d, %d]", new Object[] { localSession, Long.valueOf(this.KL), Long.valueOf(this.Si) });
        break label23;
        break;
      }
    }
    
    public Builder addDataSource(DataSource paramDataSource)
    {
      boolean bool2 = true;
      if (!this.Ub)
      {
        bool1 = true;
        n.b(bool1, "All data is already marked for deletion");
        if (paramDataSource == null) {
          break label60;
        }
      }
      label60:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        n.b(bool1, "Must specify a valid data source");
        if (!this.TZ.contains(paramDataSource)) {
          this.TZ.add(paramDataSource);
        }
        return this;
        bool1 = false;
        break;
      }
    }
    
    public Builder addDataType(DataType paramDataType)
    {
      boolean bool2 = true;
      if (!this.Ub)
      {
        bool1 = true;
        n.b(bool1, "All data is already marked for deletion");
        if (paramDataType == null) {
          break label60;
        }
      }
      label60:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        n.b(bool1, "Must specify a valid data type");
        if (!this.Su.contains(paramDataType)) {
          this.Su.add(paramDataType);
        }
        return this;
        bool1 = false;
        break;
      }
    }
    
    public Builder addSession(Session paramSession)
    {
      boolean bool2 = true;
      if (!this.Uc)
      {
        bool1 = true;
        n.b(bool1, "All sessions already marked for deletion");
        if (paramSession == null) {
          break label64;
        }
        bool1 = true;
        label23:
        n.b(bool1, "Must specify a valid session");
        if (paramSession.getEndTimeMillis() <= 0L) {
          break label69;
        }
      }
      label64:
      label69:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        n.b(bool1, "Must specify a session that has already ended");
        this.Ua.add(paramSession);
        return this;
        bool1 = false;
        break;
        bool1 = false;
        break label23;
      }
    }
    
    public DataDeleteRequest build()
    {
      boolean bool2 = false;
      boolean bool1;
      int i;
      if ((this.KL > 0L) && (this.Si > this.KL))
      {
        bool1 = true;
        n.a(bool1, "Must specify a valid time interval");
        if ((!this.Ub) && (this.TZ.isEmpty()) && (this.Su.isEmpty())) {
          break label124;
        }
        i = 1;
        label65:
        if ((!this.Uc) && (this.Ua.isEmpty())) {
          break label129;
        }
      }
      label124:
      label129:
      for (int j = 1;; j = 0)
      {
        if (i == 0)
        {
          bool1 = bool2;
          if (j == 0) {}
        }
        else
        {
          bool1 = true;
        }
        n.a(bool1, "No data or session marked for deletion");
        iZ();
        return new DataDeleteRequest(this, null);
        bool1 = false;
        break;
        i = 0;
        break label65;
      }
    }
    
    public Builder deleteAllData()
    {
      if ((this.Su.isEmpty()) && (this.TZ.isEmpty())) {}
      for (boolean bool = true;; bool = false)
      {
        n.b(bool, "Specific data source/type already specified for deletion. DataSources: %s DataTypes: %s", new Object[] { this.TZ, this.Su });
        this.Ub = true;
        return this;
      }
    }
    
    public Builder deleteAllSessions()
    {
      n.b(this.Ua.isEmpty(), "Specific sessions already added for deletion: %s", new Object[] { this.Ua });
      this.Uc = true;
      return this;
    }
    
    public Builder setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      if (paramLong1 > 0L)
      {
        bool = true;
        n.b(bool, "Invalid start time :%d", new Object[] { Long.valueOf(paramLong1) });
        if (paramLong2 <= paramLong1) {
          break label82;
        }
      }
      label82:
      for (boolean bool = true;; bool = false)
      {
        n.b(bool, "Invalid end time :%d", new Object[] { Long.valueOf(paramLong2) });
        this.KL = paramTimeUnit.toMillis(paramLong1);
        this.Si = paramTimeUnit.toMillis(paramLong2);
        return this;
        bool = false;
        break;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/DataDeleteRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */