package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public final class bw
  implements SafeParcelable
{
  public static final g CREATOR = new g();
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
  
  bw(int paramInt1, String paramString1, String paramString2, List paramList1, int paramInt2, List paramList2, long paramLong1, boolean paramBoolean, long paramLong2, List paramList3, long paramLong3, int paramInt3)
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
        break label109;
      }
      paramString1 = Collections.unmodifiableList(paramList2);
      label52:
      this.f = paramString1;
      this.g = paramLong1;
      this.h = paramBoolean;
      this.i = paramLong2;
      if (paramList3 == null) {
        break label114;
      }
    }
    label109:
    label114:
    for (paramString1 = Collections.unmodifiableList(paramList3);; paramString1 = null)
    {
      this.j = paramString1;
      this.k = paramLong3;
      this.l = paramInt3;
      return;
      paramString1 = null;
      break;
      paramString1 = null;
      break label52;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */