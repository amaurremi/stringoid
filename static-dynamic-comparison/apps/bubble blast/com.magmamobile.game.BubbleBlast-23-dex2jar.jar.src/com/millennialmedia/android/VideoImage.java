package com.millennialmedia.android;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONArray;
import org.json.JSONObject;

class VideoImage
  implements Parcelable, Externalizable
{
  public static final Parcelable.Creator<VideoImage> CREATOR = new Parcelable.Creator()
  {
    public VideoImage createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VideoImage(paramAnonymousParcel);
    }
    
    public VideoImage[] newArray(int paramAnonymousInt)
    {
      return new VideoImage[paramAnonymousInt];
    }
  };
  static final long serialVersionUID = 808334584720834205L;
  String[] activity;
  int anchor;
  int anchor2;
  long appearanceDelay;
  ImageButton button;
  long contentLength;
  long fadeDuration = 1000L;
  float fromAlpha = 1.0F;
  String imageUrl;
  long inactivityTimeout;
  RelativeLayout.LayoutParams layoutParams;
  String linkUrl;
  String overlayOrientation;
  int paddingBottom = 0;
  int paddingLeft = 0;
  int paddingRight = 0;
  int paddingTop = 0;
  int position;
  int position2;
  float toAlpha = 1.0F;
  
  public VideoImage() {}
  
  VideoImage(Parcel paramParcel)
  {
    try
    {
      this.imageUrl = paramParcel.readString();
      this.contentLength = paramParcel.readLong();
      this.activity = new String[paramParcel.readInt()];
      paramParcel.readStringArray(this.activity);
      this.linkUrl = paramParcel.readString();
      this.overlayOrientation = paramParcel.readString();
      this.paddingTop = paramParcel.readInt();
      this.paddingBottom = paramParcel.readInt();
      this.paddingLeft = paramParcel.readInt();
      this.paddingRight = paramParcel.readInt();
      this.position = paramParcel.readInt();
      this.anchor = paramParcel.readInt();
      this.position2 = paramParcel.readInt();
      this.anchor2 = paramParcel.readInt();
      this.appearanceDelay = paramParcel.readLong();
      this.inactivityTimeout = paramParcel.readLong();
      this.fromAlpha = paramParcel.readFloat();
      this.toAlpha = paramParcel.readFloat();
      this.fadeDuration = paramParcel.readLong();
      return;
    }
    catch (Exception paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
  
  VideoImage(JSONObject paramJSONObject)
  {
    deserializeFromObj(paramJSONObject);
  }
  
  private void deserializeFromObj(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      this.imageUrl = paramJSONObject.optString("image", null);
      this.contentLength = paramJSONObject.optLong("contentLength");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("activity");
      if (localJSONArray != null)
      {
        this.activity = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          this.activity[i] = localJSONArray.optString(i);
          i += 1;
        }
      }
      this.activity = new String[0];
      this.linkUrl = paramJSONObject.optString("url", null);
      this.overlayOrientation = paramJSONObject.optString("overlayOrientation", null);
      this.position = paramJSONObject.optInt("android-layout");
      this.anchor = paramJSONObject.optInt("android-layoutAnchor");
      this.position2 = paramJSONObject.optInt("android-layout2");
      this.anchor2 = paramJSONObject.optInt("android-layoutAnchor2");
      this.paddingTop = paramJSONObject.optInt("android-paddingTop");
      this.paddingLeft = paramJSONObject.optInt("android-paddingLeft");
      this.paddingRight = paramJSONObject.optInt("android-paddingRight");
      this.paddingBottom = paramJSONObject.optInt("android-paddingBottom");
      this.appearanceDelay = ((paramJSONObject.optDouble("appearanceDelay", 0.0D) * 1000.0D));
      this.inactivityTimeout = ((paramJSONObject.optDouble("inactivityTimeout", 0.0D) * 1000.0D));
      paramJSONObject = paramJSONObject.optJSONObject("opacity");
    } while (paramJSONObject == null);
    this.fromAlpha = ((float)paramJSONObject.optDouble("start", 1.0D));
    this.toAlpha = ((float)paramJSONObject.optDouble("end", 1.0D));
    this.fadeDuration = ((paramJSONObject.optDouble("fadeDuration", 1.0D) * 1000.0D));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  String getImageName()
  {
    if (this.imageUrl != null)
    {
      Uri localUri = Uri.parse(this.imageUrl);
      if ((localUri != null) && (localUri.getLastPathSegment() != null)) {
        return localUri.getLastPathSegment().replaceFirst("\\.[^\\.]*$", ".dat");
      }
    }
    return null;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.imageUrl = ((String)paramObjectInput.readObject());
    this.contentLength = paramObjectInput.readLong();
    int j = paramObjectInput.readInt();
    this.activity = new String[j];
    int i = 0;
    while (i < j)
    {
      this.activity[i] = ((String)paramObjectInput.readObject());
      i += 1;
    }
    this.linkUrl = ((String)paramObjectInput.readObject());
    this.overlayOrientation = ((String)paramObjectInput.readObject());
    this.paddingTop = paramObjectInput.readInt();
    this.paddingBottom = paramObjectInput.readInt();
    this.paddingLeft = paramObjectInput.readInt();
    this.paddingRight = paramObjectInput.readInt();
    this.position = paramObjectInput.readInt();
    this.anchor = paramObjectInput.readInt();
    this.position2 = paramObjectInput.readInt();
    this.anchor2 = paramObjectInput.readInt();
    this.appearanceDelay = paramObjectInput.readLong();
    this.inactivityTimeout = paramObjectInput.readLong();
    this.fromAlpha = paramObjectInput.readFloat();
    this.toAlpha = paramObjectInput.readFloat();
    this.fadeDuration = paramObjectInput.readLong();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.imageUrl);
    paramObjectOutput.writeLong(this.contentLength);
    paramObjectOutput.writeInt(this.activity.length);
    String[] arrayOfString = this.activity;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramObjectOutput.writeObject(arrayOfString[i]);
      i += 1;
    }
    paramObjectOutput.writeObject(this.linkUrl);
    paramObjectOutput.writeObject(this.overlayOrientation);
    paramObjectOutput.writeInt(this.paddingTop);
    paramObjectOutput.writeInt(this.paddingBottom);
    paramObjectOutput.writeInt(this.paddingLeft);
    paramObjectOutput.writeInt(this.paddingRight);
    paramObjectOutput.writeInt(this.position);
    paramObjectOutput.writeInt(this.anchor);
    paramObjectOutput.writeInt(this.position2);
    paramObjectOutput.writeInt(this.anchor2);
    paramObjectOutput.writeLong(this.appearanceDelay);
    paramObjectOutput.writeLong(this.inactivityTimeout);
    paramObjectOutput.writeFloat(this.fromAlpha);
    paramObjectOutput.writeFloat(this.toAlpha);
    paramObjectOutput.writeLong(this.fadeDuration);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.imageUrl);
    paramParcel.writeLong(this.contentLength);
    paramParcel.writeInt(this.activity.length);
    paramParcel.writeStringArray(this.activity);
    paramParcel.writeString(this.linkUrl);
    paramParcel.writeString(this.overlayOrientation);
    paramParcel.writeInt(this.paddingTop);
    paramParcel.writeInt(this.paddingBottom);
    paramParcel.writeInt(this.paddingLeft);
    paramParcel.writeInt(this.paddingRight);
    paramParcel.writeInt(this.position);
    paramParcel.writeInt(this.anchor);
    paramParcel.writeInt(this.position2);
    paramParcel.writeInt(this.anchor2);
    paramParcel.writeLong(this.appearanceDelay);
    paramParcel.writeLong(this.inactivityTimeout);
    paramParcel.writeFloat(this.fromAlpha);
    paramParcel.writeFloat(this.toAlpha);
    paramParcel.writeLong(this.fadeDuration);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/millennialmedia/android/VideoImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */