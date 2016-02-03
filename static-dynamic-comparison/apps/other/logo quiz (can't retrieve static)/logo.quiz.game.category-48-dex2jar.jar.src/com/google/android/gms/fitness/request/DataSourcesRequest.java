package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jr;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataSourcesRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataSourcesRequest> CREATOR = new g();
  private final int BR;
  private final List<DataType> Su;
  private final List<Integer> Ul;
  private final boolean Um;
  
  DataSourcesRequest(int paramInt, List<DataType> paramList, List<Integer> paramList1, boolean paramBoolean)
  {
    this.BR = paramInt;
    this.Su = paramList;
    this.Ul = paramList1;
    this.Um = paramBoolean;
  }
  
  private DataSourcesRequest(Builder paramBuilder)
  {
    this.BR = 2;
    this.Su = jr.b(Builder.a(paramBuilder));
    this.Ul = Arrays.asList(jr.a(Builder.b(paramBuilder)));
    this.Um = Builder.c(paramBuilder);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<DataType> getDataTypes()
  {
    return Collections.unmodifiableList(this.Su);
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public boolean ji()
  {
    return this.Um;
  }
  
  List<Integer> jj()
  {
    return this.Ul;
  }
  
  public String toString()
  {
    m.a locala = m.h(this).a("dataTypes", this.Su).a("sourceTypes", this.Ul);
    if (this.Um) {
      locala.a("includeDbOnlySources", "true");
    }
    return locala.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private boolean Um = false;
    private DataType[] Un = new DataType[0];
    private int[] Uo = { 0, 1 };
    
    public DataSourcesRequest build()
    {
      boolean bool2 = true;
      if (this.Un.length > 0)
      {
        bool1 = true;
        n.a(bool1, "Must add at least one data type");
        if (this.Uo.length <= 0) {
          break label49;
        }
      }
      label49:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        n.a(bool1, "Must add at least one data source type");
        return new DataSourcesRequest(this, null);
        bool1 = false;
        break;
      }
    }
    
    public Builder setDataSourceTypes(int... paramVarArgs)
    {
      this.Uo = paramVarArgs;
      return this;
    }
    
    public Builder setDataTypes(DataType... paramVarArgs)
    {
      this.Un = paramVarArgs;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/DataSourcesRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */