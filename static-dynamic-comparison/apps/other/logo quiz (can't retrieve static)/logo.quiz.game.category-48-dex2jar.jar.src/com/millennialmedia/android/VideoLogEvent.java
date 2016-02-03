package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONArray;
import org.json.JSONObject;

class VideoLogEvent
  implements Parcelable, Externalizable
{
  public static final Parcelable.Creator<VideoLogEvent> CREATOR = new Parcelable.Creator()
  {
    public VideoLogEvent createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VideoLogEvent(paramAnonymousParcel);
    }
    
    public VideoLogEvent[] newArray(int paramAnonymousInt)
    {
      return new VideoLogEvent[paramAnonymousInt];
    }
  };
  static final long serialVersionUID = 795553873017368584L;
  String[] activities;
  long position;
  
  public VideoLogEvent() {}
  
  VideoLogEvent(Parcel paramParcel)
  {
    try
    {
      this.position = paramParcel.readLong();
      this.activities = new String[paramParcel.readInt()];
      paramParcel.readStringArray(this.activities);
      return;
    }
    catch (Exception paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
  
  VideoLogEvent(JSONObject paramJSONObject)
  {
    deserializeFromObj(paramJSONObject);
  }
  
  private void deserializeFromObj(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      this.position = (paramJSONObject.optInt("time") * 1000);
      paramJSONObject = paramJSONObject.optJSONArray("urls");
      if (paramJSONObject == null) {
        break;
      }
      this.activities = new String[paramJSONObject.length()];
      int i = 0;
      while (i < paramJSONObject.length())
      {
        this.activities[i] = paramJSONObject.optString(i);
        i += 1;
      }
    }
    this.activities = new String[0];
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.position = paramObjectInput.readLong();
    int j = paramObjectInput.readInt();
    this.activities = new String[j];
    int i = 0;
    while (i < j)
    {
      this.activities[i] = ((String)paramObjectInput.readObject());
      i += 1;
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeLong(this.position);
    paramObjectOutput.writeInt(this.activities.length);
    String[] arrayOfString = this.activities;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramObjectOutput.writeObject(arrayOfString[i]);
      i += 1;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.position);
    paramParcel.writeInt(this.activities.length);
    paramParcel.writeStringArray(this.activities);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/VideoLogEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */