package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class q
  implements SafeParcelable
{
  public static final Parcelable.Creator<q> CREATOR = new r();
  final int BR;
  private final Session Sk;
  private final DataSet Th;
  
  q(int paramInt, Session paramSession, DataSet paramDataSet)
  {
    this.BR = paramInt;
    this.Sk = paramSession;
    this.Th = paramDataSet;
  }
  
  private boolean a(q paramq)
  {
    return (m.equal(this.Sk, paramq.Sk)) && (m.equal(this.Th, paramq.Th));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof q)) && (a((q)paramObject)));
  }
  
  public Session getSession()
  {
    return this.Sk;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.Sk, this.Th });
  }
  
  public DataSet iP()
  {
    return this.Th;
  }
  
  public String toString()
  {
    return m.h(this).a("session", this.Sk).a("dataSet", this.Th).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    r.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/data/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */