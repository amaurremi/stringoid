package com.google.android.gms.tagmanager;

class cp
  implements bv
{
  private final long a;
  private final int b;
  private double c;
  private long d;
  private final Object e = new Object();
  
  public cp()
  {
    this(60, 2000L);
  }
  
  public cp(int paramInt, long paramLong)
  {
    this.b = paramInt;
    this.c = this.b;
    this.a = paramLong;
  }
  
  public boolean a()
  {
    synchronized (this.e)
    {
      long l = System.currentTimeMillis();
      if (this.c < this.b)
      {
        double d1 = (l - this.d) / this.a;
        if (d1 > 0.0D) {
          this.c = Math.min(this.b, d1 + this.c);
        }
      }
      this.d = l;
      if (this.c >= 1.0D)
      {
        this.c -= 1.0D;
        return true;
      }
      as.b("No more tokens available.");
      return false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */