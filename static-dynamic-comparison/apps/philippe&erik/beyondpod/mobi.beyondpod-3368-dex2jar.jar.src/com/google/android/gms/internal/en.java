package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class en
  implements SafeParcelable
{
  public static final eo CREATOR = new eo();
  private final int kg;
  private final ep qc;
  
  en(int paramInt, ep paramep)
  {
    this.kg = paramInt;
    this.qc = paramep;
  }
  
  private en(ep paramep)
  {
    this.kg = 1;
    this.qc = paramep;
  }
  
  public static en a(es.b<?, ?> paramb)
  {
    if ((paramb instanceof ep)) {
      return new en((ep)paramb);
    }
    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
  }
  
  ep ce()
  {
    return this.qc;
  }
  
  public es.b<?, ?> cf()
  {
    if (this.qc != null) {
      return this.qc;
    }
    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
  }
  
  public int describeContents()
  {
    eo localeo = CREATOR;
    return 0;
  }
  
  int getVersionCode()
  {
    return this.kg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    eo localeo = CREATOR;
    eo.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/en.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */