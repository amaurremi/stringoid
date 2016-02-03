package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jr;
import java.util.Collections;
import java.util.List;

public class StartBleScanRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<StartBleScanRequest> CREATOR = new ab();
  private final int BR;
  private final List<DataType> Su;
  private final k UF;
  private final int UG;
  
  StartBleScanRequest(int paramInt1, List<DataType> paramList, IBinder paramIBinder, int paramInt2)
  {
    this.BR = paramInt1;
    this.Su = paramList;
    this.UF = k.a.ay(paramIBinder);
    this.UG = paramInt2;
  }
  
  private StartBleScanRequest(Builder paramBuilder)
  {
    this.BR = 2;
    this.Su = jr.b(Builder.a(paramBuilder));
    this.UF = Builder.b(paramBuilder);
    this.UG = Builder.c(paramBuilder);
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
  
  public int jA()
  {
    return this.UG;
  }
  
  public IBinder jz()
  {
    return this.UF.asBinder();
  }
  
  public String toString()
  {
    return m.h(this).a("dataTypes", this.Su).a("timeoutSecs", Integer.valueOf(this.UG)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ab.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private k UF;
    private int UG = 10;
    private DataType[] Un = new DataType[0];
    
    public Builder a(k paramk)
    {
      this.UF = paramk;
      return this;
    }
    
    public StartBleScanRequest build()
    {
      if (this.UF != null) {}
      for (boolean bool = true;; bool = false)
      {
        n.a(bool, "Must set BleScanCallback");
        return new StartBleScanRequest(this, null);
      }
    }
    
    public Builder setBleScanCallback(BleScanCallback paramBleScanCallback)
    {
      a(a.a.iV().a(paramBleScanCallback));
      return this;
    }
    
    public Builder setDataTypes(DataType... paramVarArgs)
    {
      this.Un = paramVarArgs;
      return this;
    }
    
    public Builder setTimeoutSecs(int paramInt)
    {
      boolean bool2 = true;
      if (paramInt > 0)
      {
        bool1 = true;
        n.b(bool1, "Stop time must be greater than zero");
        if (paramInt > 60) {
          break label40;
        }
      }
      label40:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        n.b(bool1, "Stop time must be less than 1 minute");
        this.UG = paramInt;
        return this;
        bool1 = false;
        break;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/StartBleScanRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */