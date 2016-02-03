package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class fe
  implements Parcelable
{
  @Deprecated
  public static final Parcelable.Creator<fe> CREATOR = new Parcelable.Creator()
  {
    @Deprecated
    public fe[] C(int paramAnonymousInt)
    {
      return new fe[paramAnonymousInt];
    }
    
    @Deprecated
    public fe k(Parcel paramAnonymousParcel)
    {
      return new fe(paramAnonymousParcel);
    }
  };
  private String mValue;
  private String xD;
  private String xE;
  
  @Deprecated
  public fe() {}
  
  @Deprecated
  fe(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public fe(String paramString1, String paramString2, String paramString3)
  {
    this.xD = paramString1;
    this.xE = paramString2;
    this.mValue = paramString3;
  }
  
  @Deprecated
  private void readFromParcel(Parcel paramParcel)
  {
    this.xD = paramParcel.readString();
    this.xE = paramParcel.readString();
    this.mValue = paramParcel.readString();
  }
  
  @Deprecated
  public int describeContents()
  {
    return 0;
  }
  
  public String getId()
  {
    return this.xD;
  }
  
  public String getValue()
  {
    return this.mValue;
  }
  
  @Deprecated
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.xD);
    paramParcel.writeString(this.xE);
    paramParcel.writeString(this.mValue);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/fe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */