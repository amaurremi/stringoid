package com.drew.lang;

import java.io.Serializable;

public class Rational
  extends Number
  implements Serializable
{
  private static final long serialVersionUID = 510688928138848770L;
  private final long _denominator;
  private final long _numerator;
  
  public Rational(long paramLong1, long paramLong2)
  {
    this._numerator = paramLong1;
    this._denominator = paramLong2;
  }
  
  private boolean ax()
  {
    return (Math.min(this._denominator, this._numerator) - 1L) / 5.0D + 2.0D > 1000.0D;
  }
  
  public final long at()
  {
    return this._denominator;
  }
  
  public final long au()
  {
    return this._numerator;
  }
  
  public Rational av()
  {
    return new Rational(this._denominator, this._numerator);
  }
  
  public boolean aw()
  {
    return (this._denominator == 1L) || ((this._denominator != 0L) && (this._numerator % this._denominator == 0L)) || ((this._denominator == 0L) && (this._numerator == 0L));
  }
  
  public Rational ay()
  {
    if (ax()) {
      return this;
    }
    int i = 2;
    label11:
    if (i <= Math.min(this._denominator, this._numerator)) {
      if (((i % 2 != 0) || (i <= 2)) && ((i % 5 != 0) || (i <= 5))) {
        break label57;
      }
    }
    label57:
    while ((this._denominator % i != 0L) || (this._numerator % i != 0L))
    {
      i += 1;
      break label11;
      break;
    }
    return new Rational(this._numerator / i, this._denominator / i);
  }
  
  public final byte byteValue()
  {
    return (byte)(int)doubleValue();
  }
  
  public double doubleValue()
  {
    return this._numerator / this._denominator;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Rational))) {}
    do
    {
      return false;
      paramObject = (Rational)paramObject;
    } while (doubleValue() != ((Rational)paramObject).doubleValue());
    return true;
  }
  
  public float floatValue()
  {
    return (float)this._numerator / (float)this._denominator;
  }
  
  public String g(boolean paramBoolean)
  {
    Object localObject;
    if ((this._denominator == 0L) && (this._numerator != 0L)) {
      localObject = toString();
    }
    Rational localRational;
    String str;
    do
    {
      return (String)localObject;
      if (aw()) {
        return Integer.toString(intValue());
      }
      if ((this._numerator != 1L) && (this._denominator % this._numerator == 0L)) {
        return new Rational(1L, this._denominator / this._numerator).g(paramBoolean);
      }
      localRational = ay();
      if (!paramBoolean) {
        break;
      }
      str = Double.toString(localRational.doubleValue());
      localObject = str;
    } while (str.length() < 5);
    return localRational.toString();
  }
  
  public int hashCode()
  {
    return (int)this._denominator * 23 + (int)this._numerator;
  }
  
  public final int intValue()
  {
    return (int)doubleValue();
  }
  
  public final long longValue()
  {
    return doubleValue();
  }
  
  public final short shortValue()
  {
    return (short)(int)doubleValue();
  }
  
  public String toString()
  {
    return this._numerator + "/" + this._denominator;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/lang/Rational.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */