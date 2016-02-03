package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionReadRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SessionReadRequest> CREATOR = new s();
  private final int BR;
  private final long KL;
  private final long Si;
  private final List<DataType> Su;
  private final List<DataSource> TZ;
  private final String UC;
  private boolean UD;
  private final List<String> UE;
  private final boolean Uk;
  private final String vL;
  
  SessionReadRequest(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, List<DataType> paramList, List<DataSource> paramList1, boolean paramBoolean1, boolean paramBoolean2, List<String> paramList2)
  {
    this.BR = paramInt;
    this.UC = paramString1;
    this.vL = paramString2;
    this.KL = paramLong1;
    this.Si = paramLong2;
    this.Su = Collections.unmodifiableList(paramList);
    this.TZ = Collections.unmodifiableList(paramList1);
    this.UD = paramBoolean1;
    this.Uk = paramBoolean2;
    this.UE = paramList2;
  }
  
  private SessionReadRequest(Builder paramBuilder)
  {
    this.BR = 3;
    this.UC = Builder.a(paramBuilder);
    this.vL = Builder.b(paramBuilder);
    this.KL = Builder.c(paramBuilder);
    this.Si = Builder.d(paramBuilder);
    this.Su = Collections.unmodifiableList(Builder.e(paramBuilder));
    this.TZ = Collections.unmodifiableList(Builder.f(paramBuilder));
    this.UD = Builder.g(paramBuilder);
    this.Uk = Builder.h(paramBuilder);
    this.UE = Builder.i(paramBuilder);
  }
  
  private boolean a(SessionReadRequest paramSessionReadRequest)
  {
    return (m.equal(this.UC, paramSessionReadRequest.UC)) && (this.vL.equals(paramSessionReadRequest.vL)) && (this.KL == paramSessionReadRequest.KL) && (this.Si == paramSessionReadRequest.Si) && (m.equal(this.Su, paramSessionReadRequest.Su)) && (m.equal(this.TZ, paramSessionReadRequest.TZ)) && (this.UD == paramSessionReadRequest.UD) && (this.UE.equals(paramSessionReadRequest.UE)) && (this.Uk == paramSessionReadRequest.Uk);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SessionReadRequest)) && (a((SessionReadRequest)paramObject)));
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
  
  public String getSessionId()
  {
    return this.vL;
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
    return m.hashCode(new Object[] { this.UC, this.vL, Long.valueOf(this.KL), Long.valueOf(this.Si) });
  }
  
  public boolean jg()
  {
    return this.Uk;
  }
  
  public String ju()
  {
    return this.UC;
  }
  
  public boolean jv()
  {
    return this.UD;
  }
  
  public List<String> jw()
  {
    return this.UE;
  }
  
  public String toString()
  {
    return m.h(this).a("sessionName", this.UC).a("sessionId", this.vL).a("startTimeMillis", Long.valueOf(this.KL)).a("endTimeMillis", Long.valueOf(this.Si)).a("dataTypes", this.Su).a("dataSources", this.TZ).a("sessionsFromAllApps", Boolean.valueOf(this.UD)).a("excludedPackages", this.UE).a("useServer", Boolean.valueOf(this.Uk)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    s.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private long KL = 0L;
    private long Si = 0L;
    private List<DataType> Su = new ArrayList();
    private List<DataSource> TZ = new ArrayList();
    private String UC;
    private boolean UD = false;
    private List<String> UE = new ArrayList();
    private boolean Uk = false;
    private String vL;
    
    public SessionReadRequest build()
    {
      if (this.KL > 0L)
      {
        bool = true;
        n.b(bool, "Invalid start time: %s", new Object[] { Long.valueOf(this.KL) });
        if ((this.Si <= 0L) || (this.Si <= this.KL)) {
          break label89;
        }
      }
      label89:
      for (boolean bool = true;; bool = false)
      {
        n.b(bool, "Invalid end time: %s", new Object[] { Long.valueOf(this.Si) });
        return new SessionReadRequest(this, null);
        bool = false;
        break;
      }
    }
    
    public Builder enableServerQueries()
    {
      this.Uk = true;
      return this;
    }
    
    public Builder excludePackage(String paramString)
    {
      n.b(paramString, "Attempting to use a null package name");
      if (!this.UE.contains(paramString)) {
        this.UE.add(paramString);
      }
      return this;
    }
    
    public Builder read(DataSource paramDataSource)
    {
      n.b(paramDataSource, "Attempting to add a null data source");
      if (!this.TZ.contains(paramDataSource)) {
        this.TZ.add(paramDataSource);
      }
      return this;
    }
    
    public Builder read(DataType paramDataType)
    {
      n.b(paramDataType, "Attempting to use a null data type");
      if (!this.Su.contains(paramDataType)) {
        this.Su.add(paramDataType);
      }
      return this;
    }
    
    public Builder readSessionsFromAllApps()
    {
      this.UD = true;
      return this;
    }
    
    public Builder setSessionId(String paramString)
    {
      this.vL = paramString;
      return this;
    }
    
    public Builder setSessionName(String paramString)
    {
      this.UC = paramString;
      return this;
    }
    
    public Builder setTimeInterval(long paramLong1, long paramLong2)
    {
      this.KL = paramLong1;
      this.Si = paramLong2;
      return this;
    }
    
    public Builder setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      return setTimeInterval(paramTimeUnit.toMillis(paramLong1), paramTimeUnit.toMillis(paramLong2));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/SessionReadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */