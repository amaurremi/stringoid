package com.vungle.publisher;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class bf
  extends bb
  implements Parcelable
{
  public static final Parcelable.Creator<bf> CREATOR = new Parcelable.Creator() {};
  static final Orientation b = Orientation.matchVideo;
  
  public bf(bb... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      bb localbb = paramVarArgs[i];
      if (localbb != null) {
        this.a.putAll(localbb.a);
      }
      i += 1;
    }
  }
  
  protected final bf a(Parcel paramParcel)
  {
    ClassLoader localClassLoader = bf.class.getClassLoader();
    this.a = paramParcel.readBundle();
    this.a.setClassLoader(localClassLoader);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getIncentivizedCancelDialogBodyText()
  {
    String str2 = this.a.getString("incentivizedCancelDialogBodyText");
    String str1 = str2;
    if (str2 == null) {
      str1 = "Closing this video early will prevent you from earning your reward. Are you sure?";
    }
    return str1;
  }
  
  public String getIncentivizedCancelDialogCloseButtonText()
  {
    String str2 = this.a.getString("incentivizedCancelDialogNegativeButtonText");
    String str1 = str2;
    if (str2 == null) {
      str1 = "Close video";
    }
    return str1;
  }
  
  public String getIncentivizedCancelDialogKeepWatchingButtonText()
  {
    String str2 = this.a.getString("incentivizedCancelDialogPositiveButtonText");
    String str1 = str2;
    if (str2 == null) {
      str1 = "Keep watching";
    }
    return str1;
  }
  
  public String getIncentivizedCancelDialogTitle()
  {
    String str2 = this.a.getString("incentivizedCancelDialogTitle");
    String str1 = str2;
    if (str2 == null) {
      str1 = "Close video?";
    }
    return str1;
  }
  
  public Orientation getOrientation()
  {
    Orientation localOrientation2 = (Orientation)this.a.getParcelable("orientation");
    Orientation localOrientation1 = localOrientation2;
    if (localOrientation2 == null) {
      localOrientation1 = b;
    }
    return localOrientation1;
  }
  
  public boolean isBackButtonImmediatelyEnabled()
  {
    return this.a.getBoolean("isBackButtonEnabled", false);
  }
  
  public boolean isIncentivized()
  {
    return this.a.getBoolean("isIncentivized", false);
  }
  
  public boolean isSoundEnabled()
  {
    return this.a.getBoolean("isSoundEnabled", true);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */