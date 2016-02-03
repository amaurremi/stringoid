package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class v
  implements SafeParcelable
{
  public static final Parcelable.Creator<v> CREATOR = new w();
  public final m alL;
  public final int statusCode;
  public final int versionCode;
  
  v(int paramInt1, int paramInt2, m paramm)
  {
    this.versionCode = paramInt1;
    this.statusCode = paramInt2;
    this.alL = paramm;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    w.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wearable/internal/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */