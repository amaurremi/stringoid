package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class dx
  implements SafeParcelable
{
  public static final bV CREATOR = new bV();
  public final int a;
  public String b;
  public int c;
  public int d;
  public boolean e;
  
  public dx(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(1, "afma-sdk-a-v" + 4452000 + ".4452000" + ".0", 4452000, 4452000, true);
  }
  
  dx(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramString;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramBoolean;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bV.a(this, paramParcel);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/dx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */