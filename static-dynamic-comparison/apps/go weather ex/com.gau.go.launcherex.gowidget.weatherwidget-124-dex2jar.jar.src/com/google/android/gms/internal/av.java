package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class av
  implements SafeParcelable
{
  public static final aw CREATOR = new aw();
  public final int backgroundColor;
  public final int mA;
  public final int mB;
  public final String mC;
  public final int mq;
  public final int mr;
  public final int ms;
  public final int mt;
  public final int mu;
  public final int mv;
  public final int mw;
  public final String mx;
  public final int my;
  public final String mz;
  public final int versionCode;
  
  av(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, int paramInt10, String paramString2, int paramInt11, int paramInt12, String paramString3)
  {
    this.versionCode = paramInt1;
    this.mq = paramInt2;
    this.backgroundColor = paramInt3;
    this.mr = paramInt4;
    this.ms = paramInt5;
    this.mt = paramInt6;
    this.mu = paramInt7;
    this.mv = paramInt8;
    this.mw = paramInt9;
    this.mx = paramString1;
    this.my = paramInt10;
    this.mz = paramString2;
    this.mA = paramInt11;
    this.mB = paramInt12;
    this.mC = paramString3;
  }
  
  public av(SearchAdRequest paramSearchAdRequest)
  {
    this.versionCode = 1;
    this.mq = paramSearchAdRequest.getAnchorTextColor();
    this.backgroundColor = paramSearchAdRequest.getBackgroundColor();
    this.mr = paramSearchAdRequest.getBackgroundGradientBottom();
    this.ms = paramSearchAdRequest.getBackgroundGradientTop();
    this.mt = paramSearchAdRequest.getBorderColor();
    this.mu = paramSearchAdRequest.getBorderThickness();
    this.mv = paramSearchAdRequest.getBorderType();
    this.mw = paramSearchAdRequest.getCallButtonColor();
    this.mx = paramSearchAdRequest.getCustomChannels();
    this.my = paramSearchAdRequest.getDescriptionTextColor();
    this.mz = paramSearchAdRequest.getFontFace();
    this.mA = paramSearchAdRequest.getHeaderTextColor();
    this.mB = paramSearchAdRequest.getHeaderTextSize();
    this.mC = paramSearchAdRequest.getQuery();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    aw.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */