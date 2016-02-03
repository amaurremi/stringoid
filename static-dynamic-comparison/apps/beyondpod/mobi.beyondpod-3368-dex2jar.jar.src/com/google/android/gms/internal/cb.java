package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public final class cb
  implements SafeParcelable
{
  public static final cc CREATOR = new cc();
  public final int errorCode;
  public final List<String> fK;
  public final List<String> fL;
  public final long fO;
  public final String gL;
  public final List<String> hA;
  public final String hB;
  public final String hw;
  public final long hx;
  public final boolean hy;
  public final long hz;
  public final int orientation;
  public final int versionCode;
  
  public cb(int paramInt)
  {
    this(2, null, null, null, paramInt, null, -1L, false, -1L, null, -1L, -1, null);
  }
  
  cb(int paramInt1, String paramString1, String paramString2, List<String> paramList1, int paramInt2, List<String> paramList2, long paramLong1, boolean paramBoolean, long paramLong2, List<String> paramList3, long paramLong3, int paramInt3, String paramString3)
  {
    this.versionCode = paramInt1;
    this.gL = paramString1;
    this.hw = paramString2;
    if (paramList1 != null)
    {
      paramString1 = Collections.unmodifiableList(paramList1);
      this.fK = paramString1;
      this.errorCode = paramInt2;
      if (paramList2 == null) {
        break label115;
      }
      paramString1 = Collections.unmodifiableList(paramList2);
      label52:
      this.fL = paramString1;
      this.hx = paramLong1;
      this.hy = paramBoolean;
      this.hz = paramLong2;
      if (paramList3 == null) {
        break label120;
      }
    }
    label115:
    label120:
    for (paramString1 = Collections.unmodifiableList(paramList3);; paramString1 = null)
    {
      this.hA = paramString1;
      this.fO = paramLong3;
      this.orientation = paramInt3;
      this.hB = paramString3;
      return;
      paramString1 = null;
      break;
      paramString1 = null;
      break label52;
    }
  }
  
  public cb(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, long paramLong1, boolean paramBoolean, long paramLong2, List<String> paramList3, long paramLong3, int paramInt, String paramString3)
  {
    this(2, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean, paramLong2, paramList3, paramLong3, paramInt, paramString3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cc.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */