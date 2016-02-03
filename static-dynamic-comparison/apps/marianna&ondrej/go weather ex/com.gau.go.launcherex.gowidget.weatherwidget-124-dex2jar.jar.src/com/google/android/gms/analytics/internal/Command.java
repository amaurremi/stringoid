package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Command
  implements Parcelable
{
  public static final String APPEND_CACHE_BUSTER = "appendCacheBuster";
  public static final String APPEND_QUEUE_TIME = "appendQueueTime";
  public static final String APPEND_VERSION = "appendVersion";
  public static final Parcelable.Creator<Command> CREATOR = new Parcelable.Creator()
  {
    public Command createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Command(paramAnonymousParcel);
    }
    
    public Command[] newArray(int paramAnonymousInt)
    {
      return new Command[paramAnonymousInt];
    }
  };
  private String id;
  private String urlParam;
  private String value;
  
  public Command() {}
  
  Command(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public Command(String paramString1, String paramString2, String paramString3)
  {
    this.id = paramString1;
    this.urlParam = paramString2;
    this.value = paramString3;
  }
  
  private void readFromParcel(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.urlParam = paramParcel.readString();
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
  
  public String getUrlParam()
  {
    return this.urlParam;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.urlParam);
    paramParcel.writeString(this.value);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/analytics/internal/Command.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */