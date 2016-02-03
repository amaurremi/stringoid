package com.google.tagmanager;

class TypedNumber
  extends Number
  implements Comparable<TypedNumber>
{
  private double mDouble;
  private long mInt64;
  private boolean mIsInt64;
  
  private TypedNumber(long paramLong)
  {
    this.mInt64 = paramLong;
    this.mIsInt64 = true;
  }
  
  public static TypedNumber D(long paramLong)
  {
    return new TypedNumber(paramLong);
  }
  
  public long AA()
  {
    if (Az()) {
      return this.mInt64;
    }
    return this.mDouble;
  }
  
  public int AB()
  {
    return (int)longValue();
  }
  
  public short AC()
  {
    return (short)(int)longValue();
  }
  
  public boolean Ay()
  {
    return !Az();
  }
  
  public boolean Az()
  {
    return this.mIsInt64;
  }
  
  public int a(TypedNumber paramTypedNumber)
  {
    if ((Az()) && (paramTypedNumber.Az())) {
      return new Long(this.mInt64).compareTo(Long.valueOf(paramTypedNumber.mInt64));
    }
    return Double.compare(doubleValue(), paramTypedNumber.doubleValue());
  }
  
  public byte byteValue()
  {
    return (byte)(int)longValue();
  }
  
  public double doubleValue()
  {
    if (Az()) {
      return this.mInt64;
    }
    return this.mDouble;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof TypedNumber)) && (a((TypedNumber)paramObject) == 0);
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
    return AB();
  }
  
  public long longValue()
  {
    return AA();
  }
  
  public short shortValue()
  {
    return AC();
  }
  
  public String toString()
  {
    if (Az()) {
      return Long.toString(this.mInt64);
    }
    return Double.toString(this.mDouble);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/TypedNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */