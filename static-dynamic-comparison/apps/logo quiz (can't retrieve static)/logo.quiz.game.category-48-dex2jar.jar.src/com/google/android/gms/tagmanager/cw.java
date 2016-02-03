package com.google.android.gms.tagmanager;

class cw
  implements cg
{
  private final long AN;
  private final int AO;
  private double AP;
  private final Object AR = new Object();
  private long are;
  
  public cw()
  {
    this(60, 2000L);
  }
  
  public cw(int paramInt, long paramLong)
  {
    this.AO = paramInt;
    this.AP = this.AO;
    this.AN = paramLong;
  }
  
  public boolean eK()
  {
    synchronized (this.AR)
    {
      long l = System.currentTimeMillis();
      if (this.AP < this.AO)
      {
        double d = (l - this.are) / this.AN;
        if (d > 0.0D) {
          this.AP = Math.min(this.AO, d + this.AP);
        }
      }
      this.are = l;
      if (this.AP >= 1.0D)
      {
        this.AP -= 1.0D;
        return true;
      }
      bh.W("No more tokens available.");
      return false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */