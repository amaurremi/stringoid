package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.ik;

class bf
  implements cf
{
  private final ik aec;
  private final long agc;
  private final long wB;
  private final int wC;
  private double wD;
  private long wE;
  private final Object wF = new Object();
  private final String wG;
  
  public bf(int paramInt, long paramLong1, long paramLong2, String paramString, ik paramik)
  {
    this.wC = paramInt;
    this.wD = this.wC;
    this.wB = paramLong1;
    this.agc = paramLong2;
    this.wG = paramString;
    this.aec = paramik;
  }
  
  public boolean dj()
  {
    synchronized (this.wF)
    {
      long l = this.aec.currentTimeMillis();
      if (l - this.wE < this.agc)
      {
        bh.D("Excessive " + this.wG + " detected; call ignored.");
        return false;
      }
      if (this.wD < this.wC)
      {
        double d = (l - this.wE) / this.wB;
        if (d > 0.0D) {
          this.wD = Math.min(this.wC, d + this.wD);
        }
      }
      this.wE = l;
      if (this.wD >= 1.0D)
      {
        this.wD -= 1.0D;
        return true;
      }
    }
    bh.D("Excessive " + this.wG + " detected; call ignored.");
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */