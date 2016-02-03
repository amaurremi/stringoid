package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;
import com.google.android.gms.a.d;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ce
  implements SafeParcelable
{
  public static final aB CREATOR = new aB();
  public final int a;
  public final cb b;
  public final du c;
  public final aC d;
  public final bW e;
  public final H f;
  public final String g;
  public final boolean h;
  public final String i;
  public final aH j;
  public final int k;
  public final int l;
  public final String m;
  public final dx n;
  public final S o;
  public final String p;
  
  ce(int paramInt1, cb paramcb, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4, String paramString1, boolean paramBoolean, String paramString2, IBinder paramIBinder5, int paramInt2, int paramInt3, String paramString3, dx paramdx, IBinder paramIBinder6, String paramString4)
  {
    this.a = paramInt1;
    this.b = paramcb;
    this.c = ((du)d.a(b.a(paramIBinder1)));
    this.d = ((aC)d.a(b.a(paramIBinder2)));
    this.e = ((bW)d.a(b.a(paramIBinder3)));
    this.f = ((H)d.a(b.a(paramIBinder4)));
    this.g = paramString1;
    this.h = paramBoolean;
    this.i = paramString2;
    this.j = ((aH)d.a(b.a(paramIBinder5)));
    this.k = paramInt2;
    this.l = paramInt3;
    this.m = paramString3;
    this.n = paramdx;
    this.o = ((S)d.a(b.a(paramIBinder6)));
    this.p = paramString4;
  }
  
  public ce(cb paramcb, du paramdu, aC paramaC, aH paramaH, dx paramdx)
  {
    this.a = 3;
    this.b = paramcb;
    this.c = paramdu;
    this.d = paramaC;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = false;
    this.i = null;
    this.j = paramaH;
    this.k = -1;
    this.l = 4;
    this.m = null;
    this.n = paramdx;
    this.o = null;
    this.p = null;
  }
  
  public ce(du paramdu, aC paramaC, H paramH, aH paramaH, bW parambW, boolean paramBoolean, int paramInt, String paramString, dx paramdx, S paramS)
  {
    this.a = 3;
    this.b = null;
    this.c = paramdu;
    this.d = paramaC;
    this.e = parambW;
    this.f = paramH;
    this.g = null;
    this.h = paramBoolean;
    this.i = null;
    this.j = paramaH;
    this.k = paramInt;
    this.l = 3;
    this.m = paramString;
    this.n = paramdx;
    this.o = paramS;
    this.p = null;
  }
  
  public ce(du paramdu, aC paramaC, H paramH, aH paramaH, bW parambW, boolean paramBoolean, int paramInt, String paramString1, String paramString2, dx paramdx, S paramS)
  {
    this.a = 3;
    this.b = null;
    this.c = paramdu;
    this.d = paramaC;
    this.e = parambW;
    this.f = paramH;
    this.g = paramString2;
    this.h = paramBoolean;
    this.i = paramString1;
    this.j = paramaH;
    this.k = paramInt;
    this.l = 3;
    this.m = null;
    this.n = paramdx;
    this.o = paramS;
    this.p = null;
  }
  
  public ce(du paramdu, aC paramaC, aH paramaH, bW parambW, int paramInt, dx paramdx, String paramString)
  {
    this.a = 3;
    this.b = null;
    this.c = paramdu;
    this.d = paramaC;
    this.e = parambW;
    this.f = null;
    this.g = null;
    this.h = false;
    this.i = null;
    this.j = paramaH;
    this.k = paramInt;
    this.l = 1;
    this.m = null;
    this.n = paramdx;
    this.o = null;
    this.p = paramString;
  }
  
  public ce(du paramdu, aC paramaC, aH paramaH, bW parambW, boolean paramBoolean, int paramInt, dx paramdx)
  {
    this.a = 3;
    this.b = null;
    this.c = paramdu;
    this.d = paramaC;
    this.e = parambW;
    this.f = null;
    this.g = null;
    this.h = paramBoolean;
    this.i = null;
    this.j = paramaH;
    this.k = paramInt;
    this.l = 2;
    this.m = null;
    this.n = paramdx;
    this.o = null;
    this.p = null;
  }
  
  public static ce a(Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      paramIntent.setClassLoader(ce.class.getClassLoader());
      paramIntent = (ce)paramIntent.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public static void a(Intent paramIntent, ce paramce)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", paramce);
    paramIntent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", localBundle);
  }
  
  final IBinder a()
  {
    return d.a(this.c).asBinder();
  }
  
  final IBinder b()
  {
    return d.a(this.d).asBinder();
  }
  
  final IBinder c()
  {
    return d.a(this.e).asBinder();
  }
  
  final IBinder d()
  {
    return d.a(this.f).asBinder();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  final IBinder e()
  {
    return d.a(this.o).asBinder();
  }
  
  final IBinder f()
  {
    return d.a(this.j).asBinder();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    aB.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */