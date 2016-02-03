package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CountrySpecification
  implements SafeParcelable
{
  public static final Parcelable.Creator<CountrySpecification> CREATOR = new c();
  String id;
  private final int kg;
  
  CountrySpecification(int paramInt, String paramString)
  {
    this.kg = paramInt;
    this.id = paramString;
  }
  
  public CountrySpecification(String paramString)
  {
    this.kg = 1;
    this.id = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCountryCode()
  {
    return this.id;
  }
  
  public int getVersionCode()
  {
    return this.kg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/wallet/CountrySpecification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */