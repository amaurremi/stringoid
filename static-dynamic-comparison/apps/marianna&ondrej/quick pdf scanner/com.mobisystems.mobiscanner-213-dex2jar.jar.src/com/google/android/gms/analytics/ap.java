package com.google.android.gms.analytics;

class ap
  implements m
{
  private final long pX;
  private final int pY;
  private double pZ;
  private long qa;
  private final Object qb = new Object();
  private final String qc;
  
  public ap(int paramInt, long paramLong, String paramString)
  {
    this.pY = paramInt;
    this.pZ = this.pY;
    this.pX = paramLong;
    this.qc = paramString;
  }
  
  public ap(String paramString)
  {
    this(60, 2000L, paramString);
  }
  
  public boolean kW()
  {
    synchronized (this.qb)
    {
      long l = System.currentTimeMillis();
      if (this.pZ < this.pY)
      {
        double d = (l - this.qa) / this.pX;
        if (d > 0.0D) {
          this.pZ = Math.min(this.pY, d + this.pZ);
        }
      }
      this.qa = l;
      if (this.pZ >= 1.0D)
      {
        this.pZ -= 1.0D;
        return true;
      }
      j.D("Excessive " + this.qc + " detected; call ignored.");
      return false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */