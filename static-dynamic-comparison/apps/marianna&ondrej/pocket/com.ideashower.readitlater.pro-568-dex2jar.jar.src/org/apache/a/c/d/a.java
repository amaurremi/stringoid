package org.apache.a.c.d;

public class a
{
  public static final Long a = Long.valueOf(0L);
  public static final Long b = Long.valueOf(1L);
  public static final Long c = Long.valueOf(-1L);
  public static final Integer d = Integer.valueOf(0);
  public static final Integer e = Integer.valueOf(1);
  public static final Integer f = Integer.valueOf(-1);
  public static final Short g = Short.valueOf((short)0);
  public static final Short h = Short.valueOf((short)1);
  public static final Short i = Short.valueOf((short)-1);
  public static final Byte j = Byte.valueOf((byte)0);
  public static final Byte k = Byte.valueOf((byte)1);
  public static final Byte l = Byte.valueOf((byte)-1);
  public static final Double m = Double.valueOf(0.0D);
  public static final Double n = Double.valueOf(1.0D);
  public static final Double o = Double.valueOf(-1.0D);
  public static final Float p = Float.valueOf(0.0F);
  public static final Float q = Float.valueOf(1.0F);
  public static final Float r = Float.valueOf(-1.0F);
  
  public static int a(String paramString)
  {
    return a(paramString, 0);
  }
  
  public static int a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return paramInt;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      return i1;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */