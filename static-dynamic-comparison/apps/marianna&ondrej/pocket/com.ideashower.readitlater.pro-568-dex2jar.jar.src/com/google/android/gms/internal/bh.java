package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class bh
  implements SafeParcelable
{
  public static final c CREATOR = new c();
  public final int a;
  public final be b;
  public final cq c;
  public final d d;
  public final j e;
  public final a f;
  public final String g;
  public final boolean h;
  public final String i;
  public final e j;
  public final int k;
  public final int l;
  public final String m;
  public final co n;
  
  bh(int paramInt1, be parambe, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4, String paramString1, boolean paramBoolean, String paramString2, IBinder paramIBinder5, int paramInt2, int paramInt3, String paramString3, co paramco)
  {
    this.a = paramInt1;
    this.b = parambe;
    this.c = ((cq)com.google.android.gms.a.d.a(b.a(paramIBinder1)));
    this.d = ((d)com.google.android.gms.a.d.a(b.a(paramIBinder2)));
    this.e = ((j)com.google.android.gms.a.d.a(b.a(paramIBinder3)));
    this.f = ((a)com.google.android.gms.a.d.a(b.a(paramIBinder4)));
    this.g = paramString1;
    this.h = paramBoolean;
    this.i = paramString2;
    this.j = ((e)com.google.android.gms.a.d.a(b.a(paramIBinder5)));
    this.k = paramInt2;
    this.l = paramInt3;
    this.m = paramString3;
    this.n = paramco;
  }
  
  IBinder a()
  {
    return com.google.android.gms.a.d.a(this.c).asBinder();
  }
  
  IBinder b()
  {
    return com.google.android.gms.a.d.a(this.d).asBinder();
  }
  
  IBinder c()
  {
    return com.google.android.gms.a.d.a(this.e).asBinder();
  }
  
  IBinder d()
  {
    return com.google.android.gms.a.d.a(this.f).asBinder();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  IBinder e()
  {
    return com.google.android.gms.a.d.a(this.j).asBinder();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */