package com.google.android.gms.tagmanager;

class dd
  extends Number
  implements Comparable<dd>
{
  private double a;
  private long b;
  private boolean c;
  
  private dd(double paramDouble)
  {
    this.a = paramDouble;
    this.c = false;
  }
  
  private dd(long paramLong)
  {
    this.b = paramLong;
    this.c = true;
  }
  
  public static dd a(long paramLong)
  {
    return new dd(paramLong);
  }
  
  public static dd a(Double paramDouble)
  {
    return new dd(paramDouble.doubleValue());
  }
  
  public static dd a(String paramString)
  {
    try
    {
      dd localdd1 = new dd(Long.parseLong(paramString));
      return localdd1;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        dd localdd2 = new dd(Double.parseDouble(paramString));
        return localdd2;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        throw new NumberFormatException(paramString + " is not a valid TypedNumber");
      }
    }
  }
  
  public int a(dd paramdd)
  {
    if ((b()) && (paramdd.b())) {
      return new Long(this.b).compareTo(Long.valueOf(paramdd.b));
    }
    return Double.compare(doubleValue(), paramdd.doubleValue());
  }
  
  public boolean a()
  {
    return !b();
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public byte byteValue()
  {
    return (byte)(int)longValue();
  }
  
  public long c()
  {
    if (b()) {
      return this.b;
    }
    return this.a;
  }
  
  public int d()
  {
    return (int)longValue();
  }
  
  public double doubleValue()
  {
    if (b()) {
      return this.b;
    }
    return this.a;
  }
  
  public short e()
  {
    return (short)(int)longValue();
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof dd)) && (a((dd)paramObject) == 0);
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
    return d();
  }
  
  public long longValue()
  {
    return c();
  }
  
  public short shortValue()
  {
    return e();
  }
  
  public String toString()
  {
    if (b()) {
      return Long.toString(this.b);
    }
    return Double.toString(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */