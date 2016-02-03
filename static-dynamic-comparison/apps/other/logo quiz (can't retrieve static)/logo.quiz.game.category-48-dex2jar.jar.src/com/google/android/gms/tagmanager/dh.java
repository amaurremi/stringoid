package com.google.android.gms.tagmanager;

class dh
  extends Number
  implements Comparable<dh>
{
  private double arG;
  private long arH;
  private boolean arI;
  
  private dh(double paramDouble)
  {
    this.arG = paramDouble;
    this.arI = false;
  }
  
  private dh(long paramLong)
  {
    this.arH = paramLong;
    this.arI = true;
  }
  
  public static dh a(Double paramDouble)
  {
    return new dh(paramDouble.doubleValue());
  }
  
  public static dh cT(String paramString)
    throws NumberFormatException
  {
    try
    {
      dh localdh1 = new dh(Long.parseLong(paramString));
      return localdh1;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        dh localdh2 = new dh(Double.parseDouble(paramString));
        return localdh2;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        throw new NumberFormatException(paramString + " is not a valid TypedNumber");
      }
    }
  }
  
  public static dh z(long paramLong)
  {
    return new dh(paramLong);
  }
  
  public int a(dh paramdh)
  {
    if ((py()) && (paramdh.py())) {
      return new Long(this.arH).compareTo(Long.valueOf(paramdh.arH));
    }
    return Double.compare(doubleValue(), paramdh.doubleValue());
  }
  
  public byte byteValue()
  {
    return (byte)(int)longValue();
  }
  
  public double doubleValue()
  {
    if (py()) {
      return this.arH;
    }
    return this.arG;
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
    return pA();
  }
  
  public long longValue()
  {
    return pz();
  }
  
  public int pA()
  {
    return (int)longValue();
  }
  
  public short pB()
  {
    return (short)(int)longValue();
  }
  
  public boolean px()
  {
    return !py();
  }
  
  public boolean py()
  {
    return this.arI;
  }
  
  public long pz()
  {
    if (py()) {
      return this.arH;
    }
    return this.arG;
  }
  
  public short shortValue()
  {
    return pB();
  }
  
  public String toString()
  {
    if (py()) {
      return Long.toString(this.arH);
    }
    return Double.toString(this.arG);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */