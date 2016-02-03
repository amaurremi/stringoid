package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class aw
  implements SafeParcelable
{
  public static final ax CREATOR = new ax();
  public final int backgroundColor;
  public final int mD;
  public final int mE;
  public final int mF;
  public final int mG;
  public final int mH;
  public final int mI;
  public final int mJ;
  public final String mK;
  public final int mL;
  public final String mM;
  public final int mN;
  public final int mO;
  public final String mP;
  public final int versionCode;
  
  aw(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, int paramInt10, String paramString2, int paramInt11, int paramInt12, String paramString3)
  {
    this.versionCode = paramInt1;
    this.mD = paramInt2;
    this.backgroundColor = paramInt3;
    this.mE = paramInt4;
    this.mF = paramInt5;
    this.mG = paramInt6;
    this.mH = paramInt7;
    this.mI = paramInt8;
    this.mJ = paramInt9;
    this.mK = paramString1;
    this.mL = paramInt10;
    this.mM = paramString2;
    this.mN = paramInt11;
    this.mO = paramInt12;
    this.mP = paramString3;
  }
  
  public aw(SearchAdRequest paramSearchAdRequest)
  {
    this.versionCode = 1;
    this.mD = paramSearchAdRequest.getAnchorTextColor();
    this.backgroundColor = paramSearchAdRequest.getBackgroundColor();
    this.mE = paramSearchAdRequest.getBackgroundGradientBottom();
    this.mF = paramSearchAdRequest.getBackgroundGradientTop();
    this.mG = paramSearchAdRequest.getBorderColor();
    this.mH = paramSearchAdRequest.getBorderThickness();
    this.mI = paramSearchAdRequest.getBorderType();
    this.mJ = paramSearchAdRequest.getCallButtonColor();
    this.mK = paramSearchAdRequest.getCustomChannels();
    this.mL = paramSearchAdRequest.getDescriptionTextColor();
    this.mM = paramSearchAdRequest.getFontFace();
    this.mN = paramSearchAdRequest.getHeaderTextColor();
    this.mO = paramSearchAdRequest.getHeaderTextSize();
    this.mP = paramSearchAdRequest.getQuery();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ax.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */