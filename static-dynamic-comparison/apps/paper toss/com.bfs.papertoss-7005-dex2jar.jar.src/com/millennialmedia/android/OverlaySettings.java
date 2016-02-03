package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class OverlaySettings
  implements Parcelable
{
  public static final String ADURL = "OVERLAY_adurl";
  public static final String BANNER_TYPE = "OVERLAY_type";
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
  static final String PROPERTIES_ACCELEROMETER = "enableNativeAccelerometer";
  static final String PROPERTIES_CUSTOM_CLOSE = "useCustomClose";
  static final String PROPERTIES_DELAY_ENABLE_BOTTOM_BAR = "delayEnableBottombar";
  static final String PROPERTIES_DELAY_SHOW_BOTTOM_BAR = "delayShowBottombar";
  static final String PROPERTIES_ENABLE_BOTTOM = "enableBottombar";
  static final String PROPERTIES_ORIENTATION = "orientation";
  static final String PROPERTIES_SHOW_BOTTOM = "showBottombar";
  static final String PROPERTIES_SHOW_TITLE = "showTitlebar";
  static final String PROPERTIES_TITLE = "title";
  static final String PROPERTIES_TRANSITION = "transition";
  static final String PROPERTIES_TRANSITION_DURATION = "transitionDuration";
  static final String PROPERTIES_TRANSPARENT = "transparent";
  public static final String STATE = "OVERLAY_state";
  static final String STATE_DEFAULT = "default";
  static final String STATE_EXPANDED = "expanded";
  static final String STATE_HIDDEN = "hidden";
  static final String STATE_LOADING = "loading";
  String adUrl;
  boolean canAccelerate;
  long delayEnableBottombar;
  long delayShowBottombar;
  boolean isBannerAd;
  String orientation;
  String overlayTitle;
  String overlayTransition;
  boolean shouldEnableBottomBar;
  boolean shouldLaunchToOverlay;
  boolean shouldMakeOverlayTransparent;
  int shouldResizeOverlay;
  boolean shouldShowBottomBar;
  boolean shouldShowCustomClose;
  boolean shouldShowTitlebar;
  String state;
  long transitionTime;
  
  OverlaySettings()
  {
    reset();
    this.state = "loading";
  }
  
  OverlaySettings(Parcel paramParcel)
  {
    try
    {
      boolean[] arrayOfBoolean = new boolean[8];
      paramParcel.readBooleanArray(arrayOfBoolean);
      this.shouldLaunchToOverlay = arrayOfBoolean[0];
      this.shouldShowTitlebar = arrayOfBoolean[1];
      this.shouldShowBottomBar = arrayOfBoolean[2];
      this.shouldEnableBottomBar = arrayOfBoolean[3];
      this.shouldMakeOverlayTransparent = arrayOfBoolean[4];
      this.canAccelerate = arrayOfBoolean[5];
      this.shouldShowCustomClose = arrayOfBoolean[6];
      this.isBannerAd = arrayOfBoolean[7];
      this.shouldResizeOverlay = paramParcel.readInt();
      this.overlayTitle = paramParcel.readString();
      this.overlayTransition = paramParcel.readString();
      this.transitionTime = paramParcel.readLong();
      if (this.transitionTime < 0L) {}
      for (;;)
      {
        this.transitionTime = l;
        this.orientation = paramParcel.readString();
        this.state = paramParcel.readString();
        this.delayEnableBottombar = paramParcel.readLong();
        this.delayShowBottombar = paramParcel.readLong();
        return;
        l = this.transitionTime;
      }
      return;
    }
    catch (Exception paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  void log()
  {
    MMAdViewSDK.Log.v("shouldResizeOverlay: %d transitionTime: %d overlayTransition: %s overlayTitle: %s shouldEnableBottomBar: %b shouldShowBottomBar: %b shouldAccelerate: %b shouldMakeOverlayTransparent: %b shouldShowCustomClose: %b Orientation: %s DelayEnableBottomBar: %d, DelayShowBottomBar: %d", new Object[] { Integer.valueOf(this.shouldResizeOverlay), Long.valueOf(this.transitionTime), this.overlayTransition, this.overlayTitle, Boolean.valueOf(this.shouldEnableBottomBar), Boolean.valueOf(this.shouldShowBottomBar), Boolean.valueOf(this.canAccelerate), Boolean.valueOf(this.shouldMakeOverlayTransparent), Boolean.valueOf(this.shouldShowCustomClose), this.orientation, Long.valueOf(this.delayEnableBottombar), Long.valueOf(this.delayShowBottombar) });
  }
  
  void reset()
  {
    this.shouldLaunchToOverlay = true;
    this.shouldShowTitlebar = false;
    this.shouldShowBottomBar = true;
    this.shouldEnableBottomBar = true;
    this.shouldShowCustomClose = true;
    this.shouldMakeOverlayTransparent = false;
    this.shouldResizeOverlay = 0;
    this.overlayTitle = "Advertisement";
    this.overlayTransition = "bottomtotop";
    this.transitionTime = 600L;
    this.canAccelerate = false;
    this.orientation = "both";
    this.delayEnableBottombar = 0L;
    this.delayShowBottombar = 0L;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBooleanArray(new boolean[] { this.shouldLaunchToOverlay, this.shouldShowTitlebar, this.shouldShowBottomBar, this.shouldEnableBottomBar, this.shouldMakeOverlayTransparent, this.canAccelerate, this.shouldShowCustomClose, this.isBannerAd });
    paramParcel.writeInt(this.shouldResizeOverlay);
    paramParcel.writeString(this.overlayTitle);
    paramParcel.writeString(this.overlayTransition);
    paramParcel.writeLong(this.transitionTime);
    paramParcel.writeString(this.orientation);
    paramParcel.writeString(this.state);
    paramParcel.writeLong(this.delayEnableBottombar);
    paramParcel.writeLong(this.delayShowBottombar);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/OverlaySettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */