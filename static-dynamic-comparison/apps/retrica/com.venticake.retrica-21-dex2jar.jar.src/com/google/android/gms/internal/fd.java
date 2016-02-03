package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class fd
  implements Parcelable
{
  @Deprecated
  public static final Parcelable.Creator<fd> CREATOR = new Parcelable.Creator()
  {
    @Deprecated
    public fd a(Parcel paramAnonymousParcel)
    {
      return new fd(paramAnonymousParcel);
    }
    
    @Deprecated
    public fd[] a(int paramAnonymousInt)
    {
      return new fd[paramAnonymousInt];
    }
  };
  private String mValue;
  private String xG;
  private String xH;
  
  @Deprecated
  public fd() {}
  
  @Deprecated
  fd(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public fd(String paramString1, String paramString2, String paramString3)
  {
    this.xG = paramString1;
    this.xH = paramString2;
    this.mValue = paramString3;
  }
  
  @Deprecated
  private void readFromParcel(Parcel paramParcel)
  {
    this.xG = paramParcel.readString();
    this.xH = paramParcel.readString();
    this.mValue = paramParcel.readString();
  }
  
  @Deprecated
  public int describeContents()
  {
    return 0;
  }
  
  public String getId()
  {
    return this.xG;
  }
  
  public String getValue()
  {
    return this.mValue;
  }
  
  @Deprecated
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.xG);
    paramParcel.writeString(this.xH);
    paramParcel.writeString(this.mValue);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/fd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */