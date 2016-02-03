package com.google.gson.internal;

import java.math.BigInteger;

public final class LazilyParsedNumber
  extends Number
{
  private final String value;
  
  public LazilyParsedNumber(String paramString)
  {
    this.value = paramString;
  }
  
  public double doubleValue()
  {
    return Double.parseDouble(this.value);
  }
  
  public float floatValue()
  {
    return Float.parseFloat(this.value);
  }
  
  public int intValue()
  {
    try
    {
      int i = Integer.parseInt(this.value);
      return i;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        long l = Long.parseLong(this.value);
        return (int)l;
      }
      catch (NumberFormatException localNumberFormatException2) {}
    }
    return new BigInteger(this.value).intValue();
  }
  
  public long longValue()
  {
    try
    {
      long l = Long.parseLong(this.value);
      return l;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return new BigInteger(this.value).longValue();
  }
  
  public String toString()
  {
    return this.value;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/internal/LazilyParsedNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */