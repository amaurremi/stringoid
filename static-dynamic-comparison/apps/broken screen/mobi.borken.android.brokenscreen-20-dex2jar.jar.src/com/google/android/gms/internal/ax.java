package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ax
  implements SafeParcelable
{
  public static final ay CREATOR = new ay();
  public final int backgroundColor;
  public final int mB;
  public final int mC;
  public final int mD;
  public final int mE;
  public final int mF;
  public final int mG;
  public final int mH;
  public final String mI;
  public final int mJ;
  public final String mK;
  public final int mL;
  public final int mM;
  public final String mN;
  public final int versionCode;
  
  ax(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, int paramInt10, String paramString2, int paramInt11, int paramInt12, String paramString3)
  {
    this.versionCode = paramInt1;
    this.mB = paramInt2;
    this.backgroundColor = paramInt3;
    this.mC = paramInt4;
    this.mD = paramInt5;
    this.mE = paramInt6;
    this.mF = paramInt7;
    this.mG = paramInt8;
    this.mH = paramInt9;
    this.mI = paramString1;
    this.mJ = paramInt10;
    this.mK = paramString2;
    this.mL = paramInt11;
    this.mM = paramInt12;
    this.mN = paramString3;
  }
  
  public ax(SearchAdRequest paramSearchAdRequest)
  {
    this.versionCode = 1;
    this.mB = paramSearchAdRequest.getAnchorTextColor();
    this.backgroundColor = paramSearchAdRequest.getBackgroundColor();
    this.mC = paramSearchAdRequest.getBackgroundGradientBottom();
    this.mD = paramSearchAdRequest.getBackgroundGradientTop();
    this.mE = paramSearchAdRequest.getBorderColor();
    this.mF = paramSearchAdRequest.getBorderThickness();
    this.mG = paramSearchAdRequest.getBorderType();
    this.mH = paramSearchAdRequest.getCallButtonColor();
    this.mI = paramSearchAdRequest.getCustomChannels();
    this.mJ = paramSearchAdRequest.getDescriptionTextColor();
    this.mK = paramSearchAdRequest.getFontFace();
    this.mL = paramSearchAdRequest.getHeaderTextColor();
    this.mM = paramSearchAdRequest.getHeaderTextSize();
    this.mN = paramSearchAdRequest.getQuery();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ay.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */