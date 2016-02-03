package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class di
  implements Parcelable
{
  @Deprecated
  public static final Parcelable.Creator<di> CREATOR = new Parcelable.Creator()
  {
    @Deprecated
    public di aq(Parcel paramAnonymousParcel)
    {
      return new di(paramAnonymousParcel);
    }
    
    @Deprecated
    public di[] cD(int paramAnonymousInt)
    {
      return new di[paramAnonymousInt];
    }
  };
  private String Gi;
  private String Gj;
  private String mValue;
  
  @Deprecated
  public di() {}
  
  @Deprecated
  di(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public di(String paramString1, String paramString2, String paramString3)
  {
    this.Gi = paramString1;
    this.Gj = paramString2;
    this.mValue = paramString3;
  }
  
  @Deprecated
  private void readFromParcel(Parcel paramParcel)
  {
    this.Gi = paramParcel.readString();
    this.Gj = paramParcel.readString();
    this.mValue = paramParcel.readString();
  }
  
  @Deprecated
  public int describeContents()
  {
    return 0;
  }
  
  public String getId()
  {
    return this.Gi;
  }
  
  public String getValue()
  {
    return this.mValue;
  }
  
  @Deprecated
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.Gi);
    paramParcel.writeString(this.Gj);
    paramParcel.writeString(this.mValue);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */