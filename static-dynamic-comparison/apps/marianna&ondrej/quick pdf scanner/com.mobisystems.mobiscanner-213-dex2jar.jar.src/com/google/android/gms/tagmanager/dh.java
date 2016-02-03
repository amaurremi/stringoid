package com.google.android.gms.tagmanager;

class dh
  extends Number
  implements Comparable<dh>
{
  private double XF;
  private long XG;
  private boolean XH;
  
  private dh(long paramLong)
  {
    this.XG = paramLong;
    this.XH = true;
  }
  
  public static dh w(long paramLong)
  {
    return new dh(paramLong);
  }
  
  public int a(dh paramdh)
  {
    if ((wt()) && (paramdh.wt())) {
      return new Long(this.XG).compareTo(Long.valueOf(paramdh.XG));
    }
    return Double.compare(doubleValue(), paramdh.doubleValue());
  }
  
  public byte byteValue()
  {
    return (byte)(int)longValue();
  }
  
  public double doubleValue()
  {
    if (wt()) {
      return this.XG;
    }
    return this.XF;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof dh)) && (a((dh)paramObject) == 0);
  }
  
  public float floatValue()
  {
    return (float)doubleValue();
  }
  
  public int hashCode()
  {
    return new Long(longValue()).hashCode();
  }
  
  public int intValue()
  {
    return wv();
  }
  
  public long longValue()
  {
    return wu();
  }
  
  public short shortValue()
  {
    return ww();
  }
  
  public String toString()
  {
    if (wt()) {
      return Long.toString(this.XG);
    }
    return Double.toString(this.XF);
  }
  
  public boolean ws()
  {
    return !wt();
  }
  
  public boolean wt()
  {
    return this.XH;
  }
  
  public long wu()
  {
    if (wt()) {
      return this.XG;
    }
    return this.XF;
  }
  
  public int wv()
  {
    return (int)longValue();
  }
  
  public short ww()
  {
    return (short)(int)longValue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/tagmanager/dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */