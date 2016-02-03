package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class Task
  implements Parcelable
{
  private final String adq = null;
  private final boolean adr = false;
  private final boolean ads = false;
  private final String mTag = null;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getServiceName()
  {
    return this.adq;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public boolean isPersisted()
  {
    return this.ads;
  }
  
  public boolean isUpdateCurrent()
  {
    return this.adr;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.adq);
    paramParcel.writeString(this.mTag);
    if (this.adr)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.ads) {
        break label52;
      }
    }
    label52:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/gcm/Task.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */