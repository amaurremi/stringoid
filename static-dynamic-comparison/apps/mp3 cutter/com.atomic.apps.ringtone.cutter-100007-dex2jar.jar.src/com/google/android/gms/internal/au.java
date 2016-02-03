package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.atomic.apps.ringtone.cutter.aa;

public final class au
  implements Parcelable.Creator
{
  static void a(cb paramcb, Parcel paramParcel)
  {
    int i = aa.b(paramParcel);
    aa.a(paramParcel, 1, paramcb.a);
    aa.a(paramParcel, 2, paramcb.b, false);
    aa.a(paramParcel, 3, paramcb.c, false);
    aa.a(paramParcel, 4, paramcb.d, false);
    aa.a(paramParcel, 5, paramcb.e, false);
    aa.a(paramParcel, 6, paramcb.f, false);
    aa.a(paramParcel, 7, paramcb.g, false);
    aa.a(paramParcel, 8, paramcb.h, false);
    aa.j(paramParcel, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */