package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.a;
import java.math.BigInteger;

public final class k
  extends h
{
  private static final Class<?>[] aeP = { Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class };
  private Object aeQ;
  
  public k(Boolean paramBoolean)
  {
    setValue(paramBoolean);
  }
  
  public k(Number paramNumber)
  {
    setValue(paramNumber);
  }
  
  public k(String paramString)
  {
    setValue(paramString);
  }
  
  private static boolean a(k paramk)
  {
    if ((paramk.aeQ instanceof Number))
    {
      paramk = (Number)paramk.aeQ;
      return ((paramk instanceof BigInteger)) || ((paramk instanceof Long)) || ((paramk instanceof Integer)) || ((paramk instanceof Short)) || ((paramk instanceof Byte));
    }
    return false;
  }
  
  private static boolean am(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return true;
    }
    paramObject = paramObject.getClass();
    Class[] arrayOfClass = aeP;
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label45;
      }
      if (arrayOfClass[i].isAssignableFrom((Class)paramObject)) {
        break;
      }
      i += 1;
    }
    label45:
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (k)paramObject;
        if (this.aeQ != null) {
          break;
        }
      } while (((k)paramObject).aeQ == null);
      return false;
      if ((!a(this)) || (!a((k)paramObject))) {
        break;
      }
    } while (zo().longValue() == ((k)paramObject).zo().longValue());
    return false;
    if (((this.aeQ instanceof Number)) && ((((k)paramObject).aeQ instanceof Number)))
    {
      double d1 = zo().doubleValue();
      double d2 = ((k)paramObject).zo().doubleValue();
      boolean bool1;
      if (d1 != d2)
      {
        bool1 = bool2;
        if (Double.isNaN(d1))
        {
          bool1 = bool2;
          if (!Double.isNaN(d2)) {}
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    return this.aeQ.equals(((k)paramObject).aeQ);
  }
  
  public int hashCode()
  {
    if (this.aeQ == null) {
      return 31;
    }
    long l;
    if (a(this))
    {
      l = zo().longValue();
      return (int)(l ^ l >>> 32);
    }
    if ((this.aeQ instanceof Number))
    {
      l = Double.doubleToLongBits(zo().doubleValue());
      return (int)(l ^ l >>> 32);
    }
    return this.aeQ.hashCode();
  }
  
  void setValue(Object paramObject)
  {
    if ((paramObject instanceof Character))
    {
      this.aeQ = String.valueOf(((Character)paramObject).charValue());
      return;
    }
    if (((paramObject instanceof Number)) || (am(paramObject))) {}
    for (boolean bool = true;; bool = false)
    {
      a.av(bool);
      this.aeQ = paramObject;
      return;
    }
  }
  
  Boolean zB()
  {
    return (Boolean)this.aeQ;
  }
  
  public boolean zC()
  {
    return this.aeQ instanceof Boolean;
  }
  
  public boolean zD()
  {
    return this.aeQ instanceof Number;
  }
  
  public boolean zE()
  {
    return this.aeQ instanceof String;
  }
  
  public Number zo()
  {
    if ((this.aeQ instanceof String)) {
      return new LazilyParsedNumber((String)this.aeQ);
    }
    return (Number)this.aeQ;
  }
  
  public String zp()
  {
    if (zD()) {
      return zo().toString();
    }
    if (zC()) {
      return zB().toString();
    }
    return (String)this.aeQ;
  }
  
  public double zq()
  {
    if (zD()) {
      return zo().doubleValue();
    }
    return Double.parseDouble(zp());
  }
  
  public long zr()
  {
    if (zD()) {
      return zo().longValue();
    }
    return Long.parseLong(zp());
  }
  
  public int zs()
  {
    if (zD()) {
      return zo().intValue();
    }
    return Integer.parseInt(zp());
  }
  
  public boolean zt()
  {
    if (zC()) {
      return zB().booleanValue();
    }
    return Boolean.parseBoolean(zp());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */