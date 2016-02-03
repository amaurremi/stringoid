package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import java.util.List;

public class DataInsertRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataInsertRequest> CREATOR = new e();
  private final int BR;
  private final DataSet Th;
  
  DataInsertRequest(int paramInt, DataSet paramDataSet)
  {
    this.BR = paramInt;
    this.Th = paramDataSet;
  }
  
  private DataInsertRequest(Builder paramBuilder)
  {
    this.BR = 1;
    this.Th = Builder.a(paramBuilder);
  }
  
  private boolean a(DataInsertRequest paramDataInsertRequest)
  {
    return m.equal(this.Th, paramDataInsertRequest.Th);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof DataInsertRequest)) && (a((DataInsertRequest)paramObject)));
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.Th });
  }
  
  public DataSet iP()
  {
    return this.Th;
  }
  
  public String toString()
  {
    return m.h(this).a("dataSet", this.Th).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private DataSet Th;
    
    public DataInsertRequest build()
    {
      boolean bool2 = true;
      if (this.Th != null)
      {
        bool1 = true;
        n.a(bool1, "Must set the data set");
        if (this.Th.getDataPoints().isEmpty()) {
          break label76;
        }
        bool1 = true;
        label34:
        n.a(bool1, "Cannot use an empty data set");
        if (this.Th.getDataSource().iH() == null) {
          break label81;
        }
      }
      label76:
      label81:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        n.a(bool1, "Must set the app package name for the data source");
        return new DataInsertRequest(this, null);
        bool1 = false;
        break;
        bool1 = false;
        break label34;
      }
    }
    
    public Builder setDataSet(DataSet paramDataSet)
    {
      this.Th = paramDataSet;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/DataInsertRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */