package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

public class ah
  implements SafeParcelable
{
  public static final Parcelable.Creator<ah> CREATOR = new ai();
  private final int BR;
  private final DataType SF;
  private final DataSource Sh;
  
  ah(int paramInt, DataType paramDataType, DataSource paramDataSource)
  {
    this.BR = paramInt;
    this.SF = paramDataType;
    this.Sh = paramDataSource;
  }
  
  private ah(a parama)
  {
    this.BR = 1;
    this.SF = a.a(parama);
    this.Sh = a.b(parama);
  }
  
  private boolean a(ah paramah)
  {
    return (m.equal(this.Sh, paramah.Sh)) && (m.equal(this.SF, paramah.SF));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof ah)) && (a((ah)paramObject)));
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
    return m.hashCode(new Object[] { this.Sh, this.SF });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ai.a(this, paramParcel, paramInt);
  }
  
  public static class a
  {
    private DataType SF;
    private DataSource Sh;
    
    public a d(DataSource paramDataSource)
    {
      this.Sh = paramDataSource;
      return this;
    }
    
    public a d(DataType paramDataType)
    {
      this.SF = paramDataType;
      return this;
    }
    
    public ah jE()
    {
      if ((this.SF != null) && (this.Sh != null)) {
        throw new IllegalArgumentException("Cannot specify both dataType and dataSource");
      }
      return new ah(this, null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */