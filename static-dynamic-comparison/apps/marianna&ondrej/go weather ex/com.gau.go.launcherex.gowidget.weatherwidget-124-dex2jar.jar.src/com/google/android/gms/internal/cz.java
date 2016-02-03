package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public final class cz
  implements SafeParcelable
{
  public static final da CREATOR = new da();
  public final int errorCode;
  public final List<String> ne;
  public final List<String> nf;
  public final long ni;
  public final String ol;
  public final int orientation;
  public final String pm;
  public final long pn;
  public final boolean po;
  public final long pp;
  public final List<String> pq;
  public final String pr;
  public final long ps;
  public final String pt;
  public final boolean pu;
  public final String pv;
  public final String pw;
  public final int versionCode;
  
  public cz(int paramInt)
  {
    this(7, null, null, null, paramInt, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null);
  }
  
  public cz(int paramInt, long paramLong)
  {
    this(7, null, null, null, paramInt, null, -1L, false, -1L, null, paramLong, -1, null, -1L, null, false, null, null);
  }
  
  cz(int paramInt1, String paramString1, String paramString2, List<String> paramList1, int paramInt2, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt3, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6)
  {
    this.versionCode = paramInt1;
    this.ol = paramString1;
    this.pm = paramString2;
    if (paramList1 != null)
    {
      paramString1 = Collections.unmodifiableList(paramList1);
      this.ne = paramString1;
      this.errorCode = paramInt2;
      if (paramList2 == null) {
        break label145;
      }
      paramString1 = Collections.unmodifiableList(paramList2);
      label52:
      this.nf = paramString1;
      this.pn = paramLong1;
      this.po = paramBoolean1;
      this.pp = paramLong2;
      if (paramList3 == null) {
        break label150;
      }
    }
    label145:
    label150:
    for (paramString1 = Collections.unmodifiableList(paramList3);; paramString1 = null)
    {
      this.pq = paramString1;
      this.ni = paramLong3;
      this.orientation = paramInt3;
      this.pr = paramString3;
      this.ps = paramLong4;
      this.pt = paramString4;
      this.pu = paramBoolean2;
      this.pv = paramString5;
      this.pw = paramString6;
      return;
      paramString1 = null;
      break;
      paramString1 = null;
      break label52;
    }
  }
  
  public cz(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, long paramLong1, boolean paramBoolean, long paramLong2, List<String> paramList3, long paramLong3, int paramInt, String paramString3, long paramLong4, String paramString4, String paramString5)
  {
    this(7, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean, paramLong2, paramList3, paramLong3, paramInt, paramString3, paramLong4, paramString4, false, null, paramString5);
  }
  
  public cz(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6)
  {
    this(7, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean1, paramLong2, paramList3, paramLong3, paramInt, paramString3, paramLong4, paramString4, paramBoolean2, paramString5, paramString6);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    da.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */