package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Subscription
  implements SafeParcelable
{
  public static final Parcelable.Creator<Subscription> CREATOR = new s();
  private final int BR;
  private final DataType SF;
  private final DataSource Sh;
  private final long Ti;
  private final int Tj;
  
  Subscription(int paramInt1, DataSource paramDataSource, DataType paramDataType, long paramLong, int paramInt2)
  {
    this.BR = paramInt1;
    this.Sh = paramDataSource;
    this.SF = paramDataType;
    this.Ti = paramLong;
    this.Tj = paramInt2;
  }
  
  private Subscription(a parama)
  {
    this.BR = 1;
    this.SF = a.a(parama);
    this.Sh = a.b(parama);
    this.Ti = a.c(parama);
    this.Tj = a.d(parama);
  }
  
  private boolean a(Subscription paramSubscription)
  {
    return (m.equal(this.Sh, paramSubscription.Sh)) && (m.equal(this.SF, paramSubscription.SF)) && (this.Ti == paramSubscription.Ti) && (this.Tj == paramSubscription.Tj);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof Subscription)) && (a((Subscription)paramObject)));
  }
  
  public DataSource getDataSource()
  {
    return this.Sh;
  }
  
  public DataType getDataType()
  {
    return this.SF;
  }
  
  public long getSamplingRateMicros()
  {
    return this.Ti;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.Sh, this.Sh, Long.valueOf(this.Ti), Integer.valueOf(this.Tj) });
  }
  
  public int iQ()
  {
    return this.Tj;
  }
  
  public String toString()
  {
    return m.h(this).a("dataSource", this.Sh).a("dataType", this.SF).a("samplingIntervalMicros", Long.valueOf(this.Ti)).a("accuracyMode", Integer.valueOf(this.Tj)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    s.a(this, paramParcel, paramInt);
  }
  
  public static class a
  {
    private DataType SF;
    private DataSource Sh;
    private long Ti = -1L;
    private int Tj = 2;
    
    public a b(DataSource paramDataSource)
    {
      this.Sh = paramDataSource;
      return this;
    }
    
    public a b(DataType paramDataType)
    {
      this.SF = paramDataType;
      return this;
    }
    
    public Subscription iR()
    {
      boolean bool2 = false;
      if ((this.Sh != null) || (this.SF != null)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        n.a(bool1, "Must call setDataSource() or setDataType()");
        if ((this.SF != null) && (this.Sh != null))
        {
          bool1 = bool2;
          if (!this.SF.equals(this.Sh.getDataType())) {}
        }
        else
        {
          bool1 = true;
        }
        n.a(bool1, "Specified data type is incompatible with specified data source");
        return new Subscription(this, null);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/data/Subscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */