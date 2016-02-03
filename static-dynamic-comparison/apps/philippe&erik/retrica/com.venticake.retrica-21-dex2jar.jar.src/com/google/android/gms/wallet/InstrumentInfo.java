package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class InstrumentInfo
  implements SafeParcelable
{
  public static final Parcelable.Creator<InstrumentInfo> CREATOR = new h();
  private String ajc;
  private String ajd;
  private final int xM;
  
  InstrumentInfo(int paramInt, String paramString1, String paramString2)
  {
    this.xM = paramInt;
    this.ajc = paramString1;
    this.ajd = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getInstrumentDetails()
  {
    return this.ajd;
  }
  
  public String getInstrumentType()
  {
    return this.ajc;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/InstrumentInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */