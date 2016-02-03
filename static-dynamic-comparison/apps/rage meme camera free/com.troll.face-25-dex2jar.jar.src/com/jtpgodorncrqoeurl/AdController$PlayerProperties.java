package com.jtpgodorncrqoeurl;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class AdController$PlayerProperties
  extends AdController.ReflectedParcelable
{
  public static final Parcelable.Creator CREATOR = new F();
  public boolean audioMuted;
  public boolean autoPlay;
  public boolean doLoop;
  public boolean inline;
  public boolean showControl;
  public String startStyle;
  public String stopStyle;
  
  public AdController$PlayerProperties()
  {
    this.showControl = true;
    this.autoPlay = true;
    this.audioMuted = false;
    this.doLoop = false;
    this.stopStyle = "normal";
    this.startStyle = "normal";
    this.inline = false;
  }
  
  public AdController$PlayerProperties(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public boolean doLoop()
  {
    return this.doLoop;
  }
  
  public boolean doMute()
  {
    return this.audioMuted;
  }
  
  public boolean exitOnComplete()
  {
    return this.stopStyle.equalsIgnoreCase("exit");
  }
  
  public boolean isAutoPlay()
  {
    return this.autoPlay == true;
  }
  
  public boolean isFullScreen()
  {
    return this.startStyle.equalsIgnoreCase("fullscreen");
  }
  
  public void muteAudio()
  {
    this.audioMuted = true;
  }
  
  public void setProperties(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString1, String paramString2)
  {
    this.autoPlay = paramBoolean2;
    this.showControl = paramBoolean3;
    this.doLoop = paramBoolean5;
    this.audioMuted = paramBoolean1;
    this.startStyle = paramString1;
    this.stopStyle = paramString2;
    this.inline = paramBoolean4;
  }
  
  public void setStopStyle(String paramString)
  {
    this.stopStyle = paramString;
  }
  
  public boolean showControl()
  {
    return this.showControl;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdController$PlayerProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */