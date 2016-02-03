package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ev
  implements SafeParcelable
{
  public static final ew CREATOR = new ew();
  public String sw;
  public int sx;
  public int sy;
  public boolean sz;
  public final int versionCode;
  
  public ev(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  ev(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.versionCode = paramInt1;
    this.sw = paramString;
    this.sx = paramInt2;
    this.sy = paramInt3;
    this.sz = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ew.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */