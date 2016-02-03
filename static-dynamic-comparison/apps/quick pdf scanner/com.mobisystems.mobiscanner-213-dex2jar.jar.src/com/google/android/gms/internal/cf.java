package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public final class cf
  implements SafeParcelable
{
  public static final bb DK = new bb();
  public final String CT;
  public final String DL;
  public final long DM;
  public final boolean DN;
  public final long DO;
  public final List<String> DP;
  public final String DQ;
  public final long DR;
  public final int errorCode;
  public final int orientation;
  public final int versionCode;
  public final List<String> yi;
  public final List<String> yj;
  public final long ym;
  
  public cf(int paramInt)
  {
    this(3, null, null, null, paramInt, null, -1L, false, -1L, null, -1L, -1, null, -1L);
  }
  
  cf(int paramInt1, String paramString1, String paramString2, List<String> paramList1, int paramInt2, List<String> paramList2, long paramLong1, boolean paramBoolean, long paramLong2, List<String> paramList3, long paramLong3, int paramInt3, String paramString3, long paramLong4)
  {
    this.versionCode = paramInt1;
    this.CT = paramString1;
    this.DL = paramString2;
    if (paramList1 != null)
    {
      paramString1 = Collections.unmodifiableList(paramList1);
      this.yi = paramString1;
      this.errorCode = paramInt2;
      if (paramList2 == null) {
        break label121;
      }
      paramString1 = Collections.unmodifiableList(paramList2);
      label52:
      this.yj = paramString1;
      this.DM = paramLong1;
      this.DN = paramBoolean;
      this.DO = paramLong2;
      if (paramList3 == null) {
        break label126;
      }
    }
    label121:
    label126:
    for (paramString1 = Collections.unmodifiableList(paramList3);; paramString1 = null)
    {
      this.DP = paramString1;
      this.ym = paramLong3;
      this.orientation = paramInt3;
      this.DQ = paramString3;
      this.DR = paramLong4;
      return;
      paramString1 = null;
      break;
      paramString1 = null;
      break label52;
    }
  }
  
  public cf(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, long paramLong1, boolean paramBoolean, long paramLong2, List<String> paramList3, long paramLong3, int paramInt, String paramString3, long paramLong4)
  {
    this(3, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean, paramLong2, paramList3, paramLong3, paramInt, paramString3, paramLong4);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bb.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */