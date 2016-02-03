package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
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
  static final String EXTRA_AD_URL = "EXTRA_AD_URL";
  static final String EXTRA_CONTENT = "EXTRA_CONTENT";
  static final long serialVersionUID = 5158660334173309853L;
  String adUrl;
  String content;
  HttpMMHeaders mmHeaders;
  
  public InterstitialAd() {}
  
  InterstitialAd(Parcel paramParcel)
  {
    super(paramParcel);
    try
    {
      this.content = paramParcel.readString();
      this.adUrl = paramParcel.readString();
      this.mmHeaders = ((HttpMMHeaders)paramParcel.readParcelable(HttpMMHeaders.class.getClassLoader()));
      return;
    }
    catch (Exception paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
  
  private Intent getExpandExtrasIntent(Context paramContext, long paramLong)
  {
    paramContext = new Intent();
    OverlaySettings localOverlaySettings = new OverlaySettings();
    localOverlaySettings.creatorAdImplId = paramLong;
    localOverlaySettings.content = this.content;
    localOverlaySettings.adUrl = this.adUrl;
    localOverlaySettings.setWebMMHeaders(this.mmHeaders);
    localOverlaySettings.isFromInterstitial = true;
    paramContext.putExtra("settings", localOverlaySettings);
    paramContext.putExtra("internalId", paramLong);
    return paramContext;
  }
  
  boolean canShow(Context paramContext, MMAdImpl paramMMAdImpl, boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((this.content == null) || (this.content.length() <= 0) || (this.adUrl == null) || (this.adUrl.length() <= 0) || (!HandShake.sharedHandShake(paramContext).canDisplayCachedAd(paramMMAdImpl.adType, this.deferredViewStart))) {}
    }
    while ((this.content != null) && (this.content.length() > 0) && (this.adUrl != null) && (this.adUrl.length() > 0))
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
    this.adUrl = ((String)paramObjectInput.readObject());
    this.mmHeaders = ((HttpMMHeaders)paramObjectInput.readObject());
  }
  
  boolean saveAssets(Context paramContext)
  {
    return true;
  }
  
  void show(Context paramContext, long paramLong)
  {
    Utils.IntentUtils.startAdViewOverlayActivity(paramContext, getExpandExtrasIntent(paramContext, paramLong));
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    paramObjectOutput.writeObject(this.content);
    paramObjectOutput.writeObject(this.adUrl);
    paramObjectOutput.writeObject(this.mmHeaders);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.adUrl);
    paramParcel.writeParcelable(this.mmHeaders, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/InterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */