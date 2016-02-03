package com.google.android.gms.tagmanager;

class cv
  implements cf
{
  private long aab;
  private final long vm;
  private final int vn;
  private double vo;
  private final Object vq = new Object();
  
  public cv()
  {
    this(60, 2000L);
  }
  
  public cv(int paramInt, long paramLong)
  {
    this.vn = paramInt;
    this.vo = this.vn;
    this.vm = paramLong;
  }
  
  public boolean cS()
  {
    synchronized (this.vq)
    {
      long l = System.currentTimeMillis();
      if (this.vo < this.vn)
      {
        double d = (l - this.aab) / this.vm;
        if (d > 0.0D) {
          this.vo = Math.min(this.vn, d + this.vo);
        }
      }
      this.aab = l;
      if (this.vo >= 1.0D)
      {
        this.vo -= 1.0D;
        return true;
      }
      bh.z("No more tokens available.");
      return false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */