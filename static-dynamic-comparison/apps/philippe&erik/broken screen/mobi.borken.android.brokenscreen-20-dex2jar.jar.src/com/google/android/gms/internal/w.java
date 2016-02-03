package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class w
  implements SafeParcelable
{
  public static final x CREATOR = new x();
  public final boolean kZ;
  public final boolean lb;
  public final int versionCode;
  
  w(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.versionCode = paramInt;
    this.kZ = paramBoolean1;
    this.lb = paramBoolean2;
  }
  
  public w(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.versionCode = 1;
    this.kZ = paramBoolean1;
    this.lb = paramBoolean2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    x.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */