package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kv;

public class DataSource
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataSource> CREATOR = new g();
  public static final int TYPE_DERIVED = 1;
  public static final int TYPE_RAW = 0;
  private final int BR;
  private final int FD;
  private final DataType SF;
  private final Device SI;
  private final a SJ;
  private final String SK;
  private final boolean SL;
  private final String SM;
  private final String mName;
  
  DataSource(int paramInt1, DataType paramDataType, String paramString1, int paramInt2, Device paramDevice, a parama, String paramString2, boolean paramBoolean)
  {
    this.BR = paramInt1;
    this.SF = paramDataType;
    this.FD = paramInt2;
    this.mName = paramString1;
    this.SI = paramDevice;
    this.SJ = parama;
    this.SK = paramString2;
    this.SL = paramBoolean;
    this.SM = iI();
  }
  
  private DataSource(Builder paramBuilder)
  {
    this.BR = 3;
    this.SF = Builder.a(paramBuilder);
    this.FD = Builder.b(paramBuilder);
    this.mName = Builder.c(paramBuilder);
    this.SI = Builder.d(paramBuilder);
    this.SJ = Builder.e(paramBuilder);
    this.SK = Builder.f(paramBuilder);
    this.SL = Builder.g(paramBuilder);
    this.SM = iI();
  }
  
  private boolean a(DataSource paramDataSource)
  {
    return (this.SF.equals(paramDataSource.SF)) && (this.FD == paramDataSource.FD) && (m.equal(this.mName, paramDataSource.mName)) && (m.equal(this.SI, paramDataSource.SI)) && (m.equal(this.SK, paramDataSource.SK)) && (m.equal(this.SJ, paramDataSource.SJ));
  }
  
  private String getTypeString()
  {
    switch (this.FD)
    {
    default: 
      throw new IllegalArgumentException("invalid type value");
    case 0: 
      return "raw";
    }
    return "derived";
  }
  
  private String iI()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getTypeString());
    localStringBuilder.append(":").append(this.SF.getName());
    if (this.SJ != null) {
      localStringBuilder.append(":").append(this.SJ.getPackageName());
    }
    if (this.SI != null) {
      localStringBuilder.append(":").append(this.SI.getStreamIdentifier());
    }
    if (this.SK != null) {
      localStringBuilder.append(":").append(this.SK);
    }
    return localStringBuilder.toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataSource)) && (a((DataSource)paramObject)));
  }
  
  public String getAppPackageName()
  {
    if (this.SJ == null) {
      return null;
    }
    return this.SJ.getPackageName();
  }
  
  public DataType getDataType()
  {
    return this.SF;
  }
  
  public Device getDevice()
  {
    return this.SI;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getStreamIdentifier()
  {
    return this.SM;
  }
  
  public String getStreamName()
  {
    return this.SK;
  }
  
  public int getType()
  {
    return this.FD;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return this.SM.hashCode();
  }
  
  public a iH()
  {
    return this.SJ;
  }
  
  public boolean iJ()
  {
    return this.SL;
  }
  
  public DataSource iK()
  {
    Device localDevice;
    if (this.SI == null)
    {
      localDevice = null;
      if (this.SJ != null) {
        break label63;
      }
    }
    label63:
    for (a locala = null;; locala = this.SJ.iA())
    {
      return new DataSource(3, this.SF, this.mName, this.FD, localDevice, locala, kv.bq(this.SK), this.SL);
      localDevice = this.SI.iM();
      break;
    }
  }
  
  public String toDebugString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.FD == 0)
    {
      str = "r";
      localStringBuilder = localStringBuilder.append(str).append(":").append(this.SF.iL());
      if (this.SJ != null) {
        break label139;
      }
      str = "";
      label49:
      localStringBuilder = localStringBuilder.append(str);
      if (this.SI == null) {
        break label187;
      }
      str = ":" + this.SI.getModel();
      label88:
      localStringBuilder = localStringBuilder.append(str);
      if (this.SK == null) {
        break label193;
      }
    }
    label139:
    label187:
    label193:
    for (String str = ":" + this.SK;; str = "")
    {
      return str;
      str = "d";
      break;
      if (this.SJ.equals(a.Sp))
      {
        str = ":gms";
        break label49;
      }
      str = ":" + this.SJ.getPackageName();
      break label49;
      str = "";
      break label88;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DataSource{");
    localStringBuilder.append(getTypeString());
    if (this.mName != null) {
      localStringBuilder.append(":").append(this.mName);
    }
    if (this.SJ != null) {
      localStringBuilder.append(":").append(this.SJ);
    }
    if (this.SI != null) {
      localStringBuilder.append(":").append(this.SI);
    }
    if (this.SK != null) {
      localStringBuilder.append(":").append(this.SK);
    }
    localStringBuilder.append(":").append(this.SF);
    return "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(kv.c(this), paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    private int FD = -1;
    private DataType SF;
    private Device SI;
    private a SJ;
    private String SK = "";
    private boolean SL = false;
    private String mName;
    
    public DataSource build()
    {
      boolean bool2 = true;
      if (this.SF != null)
      {
        bool1 = true;
        n.a(bool1, "Must set data type");
        if (this.FD < 0) {
          break label47;
        }
      }
      label47:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        n.a(bool1, "Must set data source type");
        return new DataSource(this, null);
        bool1 = false;
        break;
      }
    }
    
    public Builder setAppPackageName(Context paramContext)
    {
      return setAppPackageName(paramContext.getPackageName());
    }
    
    public Builder setAppPackageName(String paramString)
    {
      this.SJ = new a(paramString, null, null);
      return this;
    }
    
    public Builder setDataType(DataType paramDataType)
    {
      this.SF = paramDataType;
      return this;
    }
    
    public Builder setDevice(Device paramDevice)
    {
      this.SI = paramDevice;
      return this;
    }
    
    public Builder setName(String paramString)
    {
      this.mName = paramString;
      return this;
    }
    
    public Builder setObfuscated(boolean paramBoolean)
    {
      this.SL = paramBoolean;
      return this;
    }
    
    public Builder setStreamName(String paramString)
    {
      if (paramString != null) {}
      for (boolean bool = true;; bool = false)
      {
        n.b(bool, "Must specify a valid stream name");
        this.SK = paramString;
        return this;
      }
    }
    
    public Builder setType(int paramInt)
    {
      this.FD = paramInt;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/data/DataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */