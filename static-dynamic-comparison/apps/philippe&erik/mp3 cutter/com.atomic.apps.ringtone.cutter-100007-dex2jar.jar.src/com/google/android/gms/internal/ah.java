package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class ah
  implements SafeParcelable
{
  public static final l CREATOR = new l();
  public final int a;
  public final long b;
  public final Bundle c;
  public final int d;
  public final List e;
  public final boolean f;
  public final int g;
  public final boolean h;
  public final String i;
  public final av j;
  public final Location k;
  public final String l;
  
  public ah(int paramInt1, long paramLong, Bundle paramBundle, int paramInt2, List paramList, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, av paramav, Location paramLocation, String paramString2)
  {
    this.a = paramInt1;
    this.b = paramLong;
    this.c = paramBundle;
    this.d = paramInt2;
    this.e = paramList;
    this.f = paramBoolean1;
    this.g = paramInt3;
    this.h = paramBoolean2;
    this.i = paramString1;
    this.j = paramav;
    this.k = paramLocation;
    this.l = paramString2;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    l.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */