package com.google.android.gms.tagmanager;

class cv
  implements cf
{
  private long ahG;
  private final long wB;
  private final int wC;
  private double wD;
  private final Object wF = new Object();
  
  public cv()
  {
    this(60, 2000L);
  }
  
  public cv(int paramInt, long paramLong)
  {
    this.wC = paramInt;
    this.wD = this.wC;
    this.wB = paramLong;
  }
  
  public boolean dj()
  {
    synchronized (this.wF)
    {
      long l = System.currentTimeMillis();
      if (this.wD < this.wC)
      {
        double d = (l - this.ahG) / this.wB;
        if (d > 0.0D) {
          this.wD = Math.min(this.wC, d + this.wD);
        }
      }
      this.ahG = l;
      if (this.wD >= 1.0D)
      {
        this.wD -= 1.0D;
        return true;
      }
      bh.D("No more tokens available.");
      return false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */