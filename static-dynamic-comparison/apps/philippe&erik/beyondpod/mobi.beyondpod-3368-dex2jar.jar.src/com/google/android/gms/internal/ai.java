package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ai
  implements SafeParcelable
{
  public static final aj CREATOR = new aj();
  public final int backgroundColor;
  public final int eZ;
  public final int fa;
  public final int fb;
  public final int fc;
  public final int fd;
  public final int fe;
  public final int ff;
  public final String fg;
  public final int fh;
  public final String fi;
  public final int fj;
  public final int fk;
  public final String fl;
  public final int versionCode;
  
  ai(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, int paramInt10, String paramString2, int paramInt11, int paramInt12, String paramString3)
  {
    this.versionCode = paramInt1;
    this.eZ = paramInt2;
    this.backgroundColor = paramInt3;
    this.fa = paramInt4;
    this.fb = paramInt5;
    this.fc = paramInt6;
    this.fd = paramInt7;
    this.fe = paramInt8;
    this.ff = paramInt9;
    this.fg = paramString1;
    this.fh = paramInt10;
    this.fi = paramString2;
    this.fj = paramInt11;
    this.fk = paramInt12;
    this.fl = paramString3;
  }
  
  public ai(SearchAdRequest paramSearchAdRequest)
  {
    this.versionCode = 1;
    this.eZ = paramSearchAdRequest.getAnchorTextColor();
    this.backgroundColor = paramSearchAdRequest.getBackgroundColor();
    this.fa = paramSearchAdRequest.getBackgroundGradientBottom();
    this.fb = paramSearchAdRequest.getBackgroundGradientTop();
    this.fc = paramSearchAdRequest.getBorderColor();
    this.fd = paramSearchAdRequest.getBorderThickness();
    this.fe = paramSearchAdRequest.getBorderType();
    this.ff = paramSearchAdRequest.getCallButtonColor();
    this.fg = paramSearchAdRequest.getCustomChannels();
    this.fh = paramSearchAdRequest.getDescriptionTextColor();
    this.fi = paramSearchAdRequest.getFontFace();
    this.fj = paramSearchAdRequest.getHeaderTextColor();
    this.fk = paramSearchAdRequest.getHeaderTextSize();
    this.fl = paramSearchAdRequest.getQuery();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    aj.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */