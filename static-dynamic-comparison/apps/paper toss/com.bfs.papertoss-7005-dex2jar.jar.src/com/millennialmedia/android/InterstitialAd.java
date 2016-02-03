package com.millennialmedia.android;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

class InterstitialAd
  extends CachedAd
  implements Parcelable, Externalizable
{
  public static final Parcelable.Creator<InterstitialAd> CREATOR = new Parcelable.Creator()
  {
    public InterstitialAd createFromParcel(Parcel paramAnonymousParcel)
    {
      return new InterstitialAd(paramAnonymousParcel);
    }
    
    public InterstitialAd[] newArray(int paramAnonymousInt)
    {
      return new InterstitialAd[paramAnonymousInt];
    }
  };
  static final long serialVersionUID = 5158660334173309853L;
  String baseUrl;
  String content;
  
  public InterstitialAd() {}
  
  InterstitialAd(Parcel paramParcel)
  {
    super(paramParcel);
    try
    {
      this.content = paramParcel.readString();
      this.baseUrl = paramParcel.readString();
      return;
    }
    catch (Exception paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
  
  boolean canShow(Context paramContext, MMAdView paramMMAdView, boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((this.content == null) || (this.content.length() <= 0) || (this.baseUrl == null) || (this.baseUrl.length() <= 0) || (!HandShake.sharedHandShake(paramContext).canDisplayCachedAd(paramMMAdView.adType, this.deferredViewStart))) {}
    }
    while ((this.content != null) && (this.content.length() > 0) && (this.baseUrl != null) && (this.baseUrl.length() > 0))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  boolean download(Context paramContext)
  {
    return true;
  }
  
  int getType()
  {
    return 2;
  }
  
  String getTypeString()
  {
    return "Interstitial";
  }
  
  boolean isOnDisk(Context paramContext)
  {
    return true;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    super.readExternal(paramObjectInput);
    this.content = ((String)paramObjectInput.readObject());
    this.baseUrl = ((String)paramObjectInput.readObject());
  }
  
  boolean saveAssets(Context paramContext)
  {
    return true;
  }
  
  void show(Context paramContext, MMAdView paramMMAdView)
  {
    paramMMAdView.controller.setWebViewContent(this.content, this.baseUrl, paramMMAdView, null, false);
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    paramObjectOutput.writeObject(this.content);
    paramObjectOutput.writeObject(this.baseUrl);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.baseUrl);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/InterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */