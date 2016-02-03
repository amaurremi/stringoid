package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hr
  implements SafeParcelable
{
  public static final hs CREATOR = new hs();
  public final String GT;
  public final int GU;
  final int xM;
  
  public hr(int paramInt1, String paramString, int paramInt2)
  {
    this.xM = paramInt1;
    this.GT = paramString;
    this.GU = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hs.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/hr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */