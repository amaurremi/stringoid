package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class cu
  implements SafeParcelable
{
  public static final cv CREATOR = new cv();
  public String iJ;
  public int iK;
  public int iL;
  public boolean iM;
  public final int versionCode;
  
  public cu(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  cu(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.versionCode = paramInt1;
    this.iJ = paramString;
    this.iK = paramInt2;
    this.iL = paramInt3;
    this.iM = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cv.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */