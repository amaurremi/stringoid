package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Command
  implements Parcelable
{
  public static final Parcelable.Creator<Command> CREATOR = new Parcelable.Creator()
  {
    public Command[] be(int paramAnonymousInt)
    {
      return new Command[paramAnonymousInt];
    }
    
    public Command c(Parcel paramAnonymousParcel)
    {
      return new Command(paramAnonymousParcel);
    }
  };
  private String id;
  private String ny;
  private String value;
  
  public Command() {}
  
  Command(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public Command(String paramString1, String paramString2, String paramString3)
  {
    this.id = paramString1;
    this.ny = paramString2;
    this.value = paramString3;
  }
  
  private void readFromParcel(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.ny = paramParcel.readString();
    this.value = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.ny);
    paramParcel.writeString(this.value);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/internal/Command.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */