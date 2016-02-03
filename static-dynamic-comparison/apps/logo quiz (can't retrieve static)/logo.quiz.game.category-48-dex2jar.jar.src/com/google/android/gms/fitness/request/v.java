package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;

public class v
  implements SafeParcelable
{
  public static final Parcelable.Creator<v> CREATOR = new w();
  private final int BR;
  private final Session Sk;
  
  v(int paramInt, Session paramSession)
  {
    this.BR = paramInt;
    this.Sk = paramSession;
  }
  
  private v(a parama)
  {
    this.BR = 1;
    this.Sk = a.a(parama);
  }
  
  private boolean a(v paramv)
  {
    return m.equal(this.Sk, paramv.Sk);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof v)) && (a((v)paramObject)));
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
    return m.hashCode(new Object[] { this.Sk });
  }
  
  public String toString()
  {
    return m.h(this).a("session", this.Sk).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    w.a(this, paramParcel, paramInt);
  }
  
  public static class a
  {
    private Session Sk;
    
    public a b(Session paramSession)
    {
      if (paramSession.getEndTimeMillis() == 0L) {}
      for (boolean bool = true;; bool = false)
      {
        n.b(bool, "Cannot start a session which has already ended");
        this.Sk = paramSession;
        return this;
      }
    }
    
    public v jx()
    {
      return new v(this, null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */