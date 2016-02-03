package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public final class cz
  implements SafeParcelable
{
  public static final bn CREATOR = new bn();
  public final int a;
  public final String b;
  public final String c;
  public final List d;
  public final int e;
  public final List f;
  public final long g;
  public final boolean h;
  public final long i;
  public final List j;
  public final long k;
  public final int l;
  public final String m;
  public final long n;
  public final String o;
  public final boolean p;
  public final String q;
  public final String r;
  
  public cz(int paramInt)
  {
    this(7, null, null, null, paramInt, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null);
  }
  
  public cz(int paramInt, long paramLong)
  {
    this(7, null, null, null, paramInt, null, -1L, false, -1L, null, paramLong, -1, null, -1L, null, false, null, null);
  }
  
  cz(int paramInt1, String paramString1, String paramString2, List paramList1, int paramInt2, List paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List paramList3, long paramLong3, int paramInt3, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    if (paramList1 != null)
    {
      paramString1 = Collections.unmodifiableList(paramList1);
      this.d = paramString1;
      this.e = paramInt2;
      if (paramList2 == null) {
        break label145;
      }
      paramString1 = Collections.unmodifiableList(paramList2);
      label52:
      this.f = paramString1;
      this.g = paramLong1;
      this.h = paramBoolean1;
      this.i = paramLong2;
      if (paramList3 == null) {
        break label150;
      }
    }
    label145:
    label150:
    for (paramString1 = Collections.unmodifiableList(paramList3);; paramString1 = null)
    {
      this.j = paramString1;
      this.k = paramLong3;
      this.l = paramInt3;
      this.m = paramString3;
      this.n = paramLong4;
      this.o = paramString4;
      this.p = paramBoolean2;
      this.q = paramString5;
      this.r = paramString6;
      return;
      paramString1 = null;
      break;
      paramString1 = null;
      break label52;
    }
  }
  
  public cz(String paramString1, String paramString2, List paramList1, List paramList2, long paramLong1, boolean paramBoolean, long paramLong2, List paramList3, long paramLong3, int paramInt, String paramString3, long paramLong4, String paramString4, String paramString5)
  {
    this(7, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean, -1L, paramList3, paramLong3, paramInt, paramString3, paramLong4, paramString4, false, null, paramString5);
  }
  
  public cz(String paramString1, String paramString2, List paramList1, List paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List paramList3, long paramLong3, int paramInt, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6)
  {
    this(7, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, false, -1L, paramList3, -1L, paramInt, paramString3, paramLong4, paramString4, paramBoolean2, paramString5, paramString6);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bn.a(this, paramParcel);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */