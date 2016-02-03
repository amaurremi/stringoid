package com.jirbo.adcolony;

import java.io.Serializable;

class ADCData$f
  extends ADCData.i
  implements Serializable
{
  String a;
  
  ADCData$f(String paramString)
  {
    this.a = paramString;
  }
  
  void a(af paramaf)
  {
    a(paramaf, this.a);
  }
  
  String b()
  {
    return this.a;
  }
  
  double d()
  {
    try
    {
      double d = Double.parseDouble(this.a);
      return d;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 0.0D;
  }
  
  int e()
  {
    return (int)d();
  }
  
  boolean k()
  {
    return true;
  }
  
  boolean l()
  {
    String str = this.a.toLowerCase();
    return (str.equals("true")) || (str.equals("yes"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/ADCData$f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */