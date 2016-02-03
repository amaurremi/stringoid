package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.jz;

public final class al
  extends gj
{
  public static final al[] tT = new al[0];
  public String tU = "";
  public long tV = -1L;
  public long tW = -1L;
  private int tX = -1;
  public int versionCode = 1;
  
  public void a(jz paramjz)
  {
    paramjz.r(1, this.versionCode);
    paramjz.b(2, this.tU);
    paramjz.c(3, this.tV);
    paramjz.c(4, this.tW);
  }
  
  public int np()
  {
    if (this.tX < 0) {
      nq();
    }
    return this.tX;
  }
  
  public int nq()
  {
    int i = 0 + jz.s(1, this.versionCode) + jz.c(2, this.tU) + jz.e(3, this.tV) + jz.e(4, this.tW);
    this.tX = i;
    return i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/internal/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */