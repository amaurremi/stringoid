package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class v
  implements SafeParcelable
{
  public static final w CREATOR = new w();
  public final boolean lb;
  public final boolean ld;
  public final int versionCode;
  
  v(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.versionCode = paramInt;
    this.lb = paramBoolean1;
    this.ld = paramBoolean2;
  }
  
  public v(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.versionCode = 1;
    this.lb = paramBoolean1;
    this.ld = paramBoolean2;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */