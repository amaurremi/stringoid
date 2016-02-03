package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.millennialmedia.google.gson.Gson;
import com.millennialmedia.google.gson.annotations.SerializedName;

class OverlaySettings
  implements Parcelable
{
  public static final Parcelable.Creator<OverlaySettings> CREATOR = new Parcelable.Creator()
  {
    public OverlaySettings createFromParcel(Parcel paramAnonymousParcel)
    {
      return new OverlaySettings(paramAnonymousParcel);
    }
    
    public OverlaySettings[] newArray(int paramAnonymousInt)
    {
      return new OverlaySettings[paramAnonymousInt];
    }
  };
  static final String PROPERTIES_ACID = "acid";
  static final String PROPERTIES_ALLOW_ORIENTATION_CHANGE = "allowOrientationChange";
  static final String PROPERTIES_CUSTOM_CLOSE = "useCustomClose";
  static final String PROPERTIES_ENABLE_HARDWARE_ACCEL = "enableHardwareAccel";
  static final String PROPERTIES_FORCE_ORIENTATION = "forceOrientation";
  static final String PROPERTIES_HEIGHT = "height";
  static final String PROPERTIES_MODAL = "modal";
  static final String PROPERTIES_ORIENTATION = "orientation";
  static final String PROPERTIES_TRANSITION = "transition";
  static final String PROPERTIES_TRANSITION_DURATION = "transitionDuration";
  static final String PROPERTIES_TRANSPARENT = "transparent";
  static final String PROPERTIES_WIDTH = "width";
  String adUrl = "";
  boolean allowOrientationChange = true;
  String content = "";
  long creatorAdImplId;
  boolean hasLoadedExpandUrl = false;
  int height;
  boolean isFromInterstitial;
  @SerializedName("transparent")
  private boolean isTransparent;
  HttpMMHeaders mmHeaders;
  boolean modal;
  String orientation = "";
  boolean shouldLaunchToOverlay;
  int shouldResizeOverlay;
  private String transition = "";
  @SerializedName("transitionDuration")
  private long transitionTimeInMillis;
  String urlToLoad = "";
  private boolean useCustomClose;
  int width;
  
  OverlaySettings() {}
  
  OverlaySettings(Parcel paramParcel)
  {
    try
    {
      boolean[] arrayOfBoolean = new boolean[6];
      paramParcel.readBooleanArray(arrayOfBoolean);
      this.shouldLaunchToOverlay = arrayOfBoolean[0];
      this.isTransparent = arrayOfBoolean[1];
      this.useCustomClose = arrayOfBoolean[2];
      this.modal = arrayOfBoolean[3];
      this.isFromInterstitial = arrayOfBoolean[4];
      this.allowOrientationChange = arrayOfBoolean[5];
      this.shouldResizeOverlay = paramParcel.readInt();
      this.transition = paramParcel.readString();
      this.transitionTimeInMillis = paramParcel.readLong();
      if (this.transitionTimeInMillis < 0L) {}
      for (;;)
      {
        this.transitionTimeInMillis = l;
        this.orientation = paramParcel.readString();
        this.creatorAdImplId = paramParcel.readLong();
        this.urlToLoad = paramParcel.readString();
        this.height = paramParcel.readInt();
        this.width = paramParcel.readInt();
        this.content = paramParcel.readString();
        this.adUrl = paramParcel.readString();
        this.mmHeaders = ((HttpMMHeaders)paramParcel.readParcelable(HttpMMHeaders.class.getClassLoader()));
        return;
        l = this.transitionTimeInMillis;
      }
      return;
    }
    catch (Exception paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
  
  static final OverlaySettings createFromJson(String paramString)
  {
    return (OverlaySettings)new Gson().fromJson(paramString, OverlaySettings.class);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  boolean enableHardwareAccel()
  {
    return (this.mmHeaders != null) && (this.mmHeaders.enableHardwareAccel);
  }
  
  String getAcid()
  {
    if ((this.mmHeaders != null) && (!TextUtils.isEmpty(this.mmHeaders.acid))) {
      return this.mmHeaders.acid;
    }
    return "";
  }
  
  boolean getIsTransparent()
  {
    return (this.isTransparent) || ((this.mmHeaders != null) && (this.mmHeaders.isTransparent));
  }
  
  String getTransition()
  {
    if (!TextUtils.isEmpty(this.transition)) {
      return this.transition;
    }
    if ((this.mmHeaders != null) && (!TextUtils.isEmpty(this.mmHeaders.transition))) {
      return this.mmHeaders.transition;
    }
    return "none";
  }
  
  long getTransitionDurationInMillis()
  {
    long l = 0L;
    if (this.transitionTimeInMillis > 0L) {
      l = this.transitionTimeInMillis;
    }
    while (this.mmHeaders == null) {
      return l;
    }
    return this.mmHeaders.transitionTimeInMillis;
  }
  
  boolean getUseCustomClose()
  {
    return (this.useCustomClose) || ((this.mmHeaders != null) && (this.mmHeaders.useCustomClose));
  }
  
  boolean hasExpandUrl()
  {
    return (this.urlToLoad != null) && (!this.urlToLoad.equals(""));
  }
  
  boolean hasLoadedExpandUrl()
  {
    boolean bool = true;
    if (!this.hasLoadedExpandUrl)
    {
      this.hasLoadedExpandUrl = true;
      bool = false;
    }
    return bool;
  }
  
  boolean isExpanded()
  {
    return (!this.isFromInterstitial) && (this.creatorAdImplId != 0L);
  }
  
  boolean isFromInterstitial()
  {
    return (this.isFromInterstitial) && (this.creatorAdImplId != 0L);
  }
  
  void log()
  {
    MMSDK.Log.v(toString());
  }
  
  void setIsTransparent(boolean paramBoolean)
  {
    this.isTransparent = paramBoolean;
  }
  
  void setTransition(String paramString)
  {
    this.transition = paramString;
  }
  
  void setTransitionDurationInMillis(long paramLong)
  {
    this.transitionTimeInMillis = paramLong;
  }
  
  void setUseCustomClose(boolean paramBoolean)
  {
    this.useCustomClose = paramBoolean;
  }
  
  void setWebMMHeaders(HttpMMHeaders paramHttpMMHeaders)
  {
    this.mmHeaders = paramHttpMMHeaders;
  }
  
  public String toString()
  {
    return String.format("height %d width %d modal %b urlToLoad %s creatorAdImplId %s shouldResizeOverlay: %d transitionTime: %d overlayTransition: %s shouldMakeOverlayTransparent: %b shouldShowCustomClose: %b Orientation: %s", new Object[] { Integer.valueOf(this.height), Integer.valueOf(this.width), Boolean.valueOf(this.modal), this.urlToLoad, Long.valueOf(this.creatorAdImplId), Integer.valueOf(this.shouldResizeOverlay), Long.valueOf(this.transitionTimeInMillis), this.transition, Boolean.valueOf(this.isTransparent), Boolean.valueOf(this.useCustomClose), this.orientation });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBooleanArray(new boolean[] { this.shouldLaunchToOverlay, this.isTransparent, this.useCustomClose, this.modal, this.isFromInterstitial, this.allowOrientationChange });
    paramParcel.writeInt(this.shouldResizeOverlay);
    paramParcel.writeString(this.transition);
    paramParcel.writeLong(this.transitionTimeInMillis);
    paramParcel.writeString(this.orientation);
    paramParcel.writeLong(this.creatorAdImplId);
    paramParcel.writeString(this.urlToLoad);
    paramParcel.writeInt(this.height);
    paramParcel.writeInt(this.width);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.adUrl);
    paramParcel.writeParcelable(this.mmHeaders, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/OverlaySettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */