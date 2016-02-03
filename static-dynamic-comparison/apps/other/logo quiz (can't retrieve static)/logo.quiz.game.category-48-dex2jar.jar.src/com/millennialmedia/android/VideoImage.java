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
  int anchor;
  int anchor2;
  long appearanceDelay;
  ImageButton button;
  long contentLength;
  String[] eventLoggingUrls;
  long fadeDuration = 1000L;
  float fromAlpha = 1.0F;
  String imageUrl;
  long inactivityTimeout;
  boolean isLeaveBehind;
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
      this.eventLoggingUrls = new String[paramParcel.readInt()];
      paramParcel.readStringArray(this.eventLoggingUrls);
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
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.isLeaveBehind = bool;
        return;
        bool = false;
      }
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
    if (paramJSONObject == null) {
      return;
    }
    this.imageUrl = paramJSONObject.optString("image", null);
    this.contentLength = paramJSONObject.optLong("contentLength");
    Object localObject = paramJSONObject.optJSONArray("activity");
    if (localObject != null)
    {
      this.eventLoggingUrls = new String[((JSONArray)localObject).length()];
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        this.eventLoggingUrls[i] = ((JSONArray)localObject).optString(i);
        i += 1;
      }
    }
    this.eventLoggingUrls = new String[0];
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
    localObject = paramJSONObject.optJSONObject("opacity");
    if (localObject != null)
    {
      this.fromAlpha = ((float)((JSONObject)localObject).optDouble("start", 1.0D));
      this.toAlpha = ((float)((JSONObject)localObject).optDouble("end", 1.0D));
      this.fadeDuration = ((((JSONObject)localObject).optDouble("fadeDuration", 1.0D) * 1000.0D));
    }
    this.isLeaveBehind = paramJSONObject.optBoolean("is_leavebehind");
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
    this.eventLoggingUrls = new String[j];
    int i = 0;
    while (i < j)
    {
      this.eventLoggingUrls[i] = ((String)paramObjectInput.readObject());
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
    this.isLeaveBehind = paramObjectInput.readBoolean();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.imageUrl);
    paramObjectOutput.writeLong(this.contentLength);
    paramObjectOutput.writeInt(this.eventLoggingUrls.length);
    String[] arrayOfString = this.eventLoggingUrls;
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
    paramObjectOutput.writeBoolean(this.isLeaveBehind);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.imageUrl);
    paramParcel.writeLong(this.contentLength);
    paramParcel.writeInt(this.eventLoggingUrls.length);
    paramParcel.writeStringArray(this.eventLoggingUrls);
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
    if (this.isLeaveBehind) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/VideoImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */