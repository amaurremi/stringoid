package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fp
  implements SafeParcelable
{
  public static final fq CREATOR = new fq();
  public final String name;
  public final int weight;
  final int xM;
  public final String yb;
  public final boolean yc;
  public final boolean yd;
  public final String ye;
  public final fm[] yf;
  final int[] yg;
  public final String yh;
  
  fp(int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString3, fm[] paramArrayOffm, int[] paramArrayOfInt, String paramString4)
  {
    this.xM = paramInt1;
    this.name = paramString1;
    this.yb = paramString2;
    this.yc = paramBoolean1;
    this.weight = paramInt2;
    this.yd = paramBoolean2;
    this.ye = paramString3;
    this.yf = paramArrayOffm;
    this.yg = paramArrayOfInt;
    this.yh = paramString4;
  }
  
  fp(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString3, fm[] paramArrayOffm, int[] paramArrayOfInt, String paramString4)
  {
    this(2, paramString1, paramString2, paramBoolean1, paramInt, paramBoolean2, paramString3, paramArrayOffm, paramArrayOfInt, paramString4);
  }
  
  public int describeContents()
  {
    fq localfq = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof fp))
    {
      paramObject = (fp)paramObject;
      bool1 = bool2;
      if (this.name.equals(((fp)paramObject).name))
      {
        bool1 = bool2;
        if (this.yb.equals(((fp)paramObject).yb))
        {
          bool1 = bool2;
          if (this.yc == ((fp)paramObject).yc) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fq localfq = CREATOR;
    fq.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/fp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */