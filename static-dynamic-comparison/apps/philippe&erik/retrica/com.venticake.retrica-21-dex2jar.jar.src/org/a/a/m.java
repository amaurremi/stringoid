package org.a.a;

public class m
  extends IllegalArgumentException
{
  private final d a;
  private final k b;
  private final String c;
  private final Number d;
  private final String e;
  private final Number f;
  private final Number g;
  private String h;
  
  public m(d paramd, Number paramNumber1, Number paramNumber2, Number paramNumber3)
  {
    super(a(paramd.x(), paramNumber1, paramNumber2, paramNumber3, null));
    this.a = paramd;
    this.b = null;
    this.c = paramd.x();
    this.d = paramNumber1;
    this.e = null;
    this.f = paramNumber2;
    this.g = paramNumber3;
    this.h = super.getMessage();
  }
  
  public m(d paramd, Number paramNumber, String paramString)
  {
    super(a(paramd.x(), paramNumber, null, null, paramString));
    this.a = paramd;
    this.b = null;
    this.c = paramd.x();
    this.d = paramNumber;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = super.getMessage();
  }
  
  public m(d paramd, String paramString)
  {
    super(a(paramd.x(), paramString));
    this.a = paramd;
    this.b = null;
    this.c = paramd.x();
    this.e = paramString;
    this.d = null;
    this.f = null;
    this.g = null;
    this.h = super.getMessage();
  }
  
  private static String a(String paramString1, Number paramNumber1, Number paramNumber2, Number paramNumber3, String paramString2)
  {
    paramString1 = new StringBuilder().append("Value ").append(paramNumber1).append(" for ").append(paramString1).append(' ');
    if (paramNumber2 == null) {
      if (paramNumber3 == null) {
        paramString1.append("is not supported");
      }
    }
    for (;;)
    {
      if (paramString2 != null) {
        paramString1.append(": ").append(paramString2);
      }
      return paramString1.toString();
      paramString1.append("must not be larger than ").append(paramNumber3);
      continue;
      if (paramNumber3 == null) {
        paramString1.append("must not be smaller than ").append(paramNumber2);
      } else {
        paramString1.append("must be in the range [").append(paramNumber2).append(',').append(paramNumber3).append(']');
      }
    }
  }
  
  private static String a(String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer().append("Value ");
    if (paramString2 == null) {
      localStringBuffer.append("null");
    }
    for (;;)
    {
      localStringBuffer.append(" for ").append(paramString1).append(' ').append("is not supported");
      return localStringBuffer.toString();
      localStringBuffer.append('"');
      localStringBuffer.append(paramString2);
      localStringBuffer.append('"');
    }
  }
  
  public void a(String paramString)
  {
    if (this.h == null) {
      this.h = paramString;
    }
    while (paramString == null) {
      return;
    }
    this.h = (paramString + ": " + this.h);
  }
  
  public String getMessage()
  {
    return this.h;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */