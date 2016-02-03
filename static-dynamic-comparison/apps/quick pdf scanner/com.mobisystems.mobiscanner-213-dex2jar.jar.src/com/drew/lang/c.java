package com.drew.lang;

public final class c
{
  private final double fE;
  private final double fF;
  
  public c(double paramDouble1, double paramDouble2)
  {
    this.fE = paramDouble1;
    this.fF = paramDouble2;
  }
  
  public static Double a(Rational paramRational1, Rational paramRational2, Rational paramRational3, boolean paramBoolean)
  {
    double d2 = Math.abs(paramRational1.doubleValue()) + paramRational2.doubleValue() / 60.0D + paramRational3.doubleValue() / 3600.0D;
    if (Double.isNaN(d2)) {
      return null;
    }
    double d1 = d2;
    if (paramBoolean) {
      d1 = d2 * -1.0D;
    }
    return Double.valueOf(d1);
  }
  
  public static String c(double paramDouble)
  {
    double[] arrayOfDouble = d(paramDouble);
    return arrayOfDouble[0] + "° " + arrayOfDouble[1] + "' " + arrayOfDouble[2] + '"';
  }
  
  public static double[] d(double paramDouble)
  {
    int i = (int)paramDouble;
    paramDouble = Math.abs(paramDouble % 1.0D * 60.0D);
    return new double[] { i, (int)paramDouble, paramDouble % 1.0D * 60.0D };
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (c)paramObject;
      if (Double.compare(((c)paramObject).fE, this.fE) != 0) {
        return false;
      }
    } while (Double.compare(((c)paramObject).fF, this.fF) == 0);
    return false;
  }
  
  public double getLatitude()
  {
    return this.fE;
  }
  
  public double getLongitude()
  {
    return this.fF;
  }
  
  public int hashCode()
  {
    long l2 = 0L;
    if (this.fE != 0.0D) {}
    for (long l1 = Double.doubleToLongBits(this.fE);; l1 = 0L)
    {
      int i = (int)(l1 ^ l1 >>> 32);
      l1 = l2;
      if (this.fF != 0.0D) {
        l1 = Double.doubleToLongBits(this.fF);
      }
      return i * 31 + (int)(l1 ^ l1 >>> 32);
    }
  }
  
  public String toString()
  {
    return this.fE + ", " + this.fF;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/lang/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */