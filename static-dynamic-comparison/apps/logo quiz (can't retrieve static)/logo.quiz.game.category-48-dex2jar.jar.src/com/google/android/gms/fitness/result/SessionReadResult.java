package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SessionReadResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<SessionReadResult> CREATOR = new f();
  private final int BR;
  private final Status CM;
  private final List<q> UO;
  private final List<Session> Ua;
  
  SessionReadResult(int paramInt, List<Session> paramList, List<q> paramList1, Status paramStatus)
  {
    this.BR = paramInt;
    this.Ua = paramList;
    this.UO = Collections.unmodifiableList(paramList1);
    this.CM = paramStatus;
  }
  
  public SessionReadResult(List<Session> paramList, List<q> paramList1, Status paramStatus)
  {
    this.BR = 3;
    this.Ua = paramList;
    this.UO = Collections.unmodifiableList(paramList1);
    this.CM = paramStatus;
  }
  
  public static SessionReadResult H(Status paramStatus)
  {
    return new SessionReadResult(new ArrayList(), new ArrayList(), paramStatus);
  }
  
  private boolean b(SessionReadResult paramSessionReadResult)
  {
    return (this.CM.equals(paramSessionReadResult.CM)) && (m.equal(this.Ua, paramSessionReadResult.Ua)) && (m.equal(this.UO, paramSessionReadResult.UO));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SessionReadResult)) && (b((SessionReadResult)paramObject)));
  }
  
  public List<DataSet> getDataSet(Session paramSession)
  {
    n.b(this.Ua.contains(paramSession), "Attempting to read data for session %s which was not returned", new Object[] { paramSession });
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.UO.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if (m.equal(paramSession, localq.getSession())) {
        localArrayList.add(localq.iP());
      }
    }
    return localArrayList;
  }
  
  public List<DataSet> getDataSet(Session paramSession, DataType paramDataType)
  {
    n.b(this.Ua.contains(paramSession), "Attempting to read data for session %s which was not returned", new Object[] { paramSession });
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.UO.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if ((m.equal(paramSession, localq.getSession())) && (paramDataType.equals(localq.iP().getDataType()))) {
        localArrayList.add(localq.iP());
      }
    }
    return localArrayList;
  }
  
  public List<Session> getSessions()
  {
    return this.Ua;
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
    return m.hashCode(new Object[] { this.CM, this.Ua, this.UO });
  }
  
  public List<q> jJ()
  {
    return this.UO;
  }
  
  public String toString()
  {
    return m.h(this).a("status", this.CM).a("sessions", this.Ua).a("sessionDataSets", this.UO).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/result/SessionReadResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */