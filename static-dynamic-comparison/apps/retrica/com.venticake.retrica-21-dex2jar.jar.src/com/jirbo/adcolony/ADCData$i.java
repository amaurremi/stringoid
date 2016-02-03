package com.jirbo.adcolony;

class ADCData$i
{
  void a(af paramaf) {}
  
  void a(af paramaf, String paramString)
  {
    paramaf.b('"');
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    int m = str.length();
    int i = 0;
    if (i < m)
    {
      char c1 = str.charAt(i);
      switch (c1)
      {
      default: 
        if ((c1 >= ' ') && (c1 <= '~')) {
          paramaf.b(c1);
        }
        break;
      case '"': 
      case '\\': 
      case '/': 
      case '\b': 
      case '\f': 
      case '\n': 
      case '\r': 
      case '\t': 
        for (;;)
        {
          i += 1;
          break;
          paramaf.a("\\\"");
          continue;
          paramaf.a("\\\\");
          continue;
          paramaf.a("\\/");
          continue;
          paramaf.a("\\b");
          continue;
          paramaf.a("\\f");
          continue;
          paramaf.a("\\n");
          continue;
          paramaf.a("\\r");
          continue;
          paramaf.a("\\t");
        }
      }
      paramaf.a("\\u");
      char c2 = c1;
      int j = 0;
      label226:
      int n;
      if (j < 4)
      {
        n = c2 >> '\f' & 0xF;
        int k;
        c2 <<= '\004';
        if (n > 9) {
          break label271;
        }
        paramaf.a(n);
      }
      for (;;)
      {
        j += 1;
        break label226;
        break;
        label271:
        paramaf.b((char)(n - 10 + 97));
      }
    }
    paramaf.b('"');
  }
  
  boolean a()
  {
    return false;
  }
  
  String b()
  {
    return q();
  }
  
  boolean b_()
  {
    return false;
  }
  
  boolean c()
  {
    return false;
  }
  
  boolean c_()
  {
    return false;
  }
  
  double d()
  {
    return 0.0D;
  }
  
  int e()
  {
    return 0;
  }
  
  boolean f()
  {
    return false;
  }
  
  boolean g()
  {
    return true;
  }
  
  ADCData.c h()
  {
    return null;
  }
  
  boolean k()
  {
    return false;
  }
  
  boolean l()
  {
    return false;
  }
  
  boolean m()
  {
    return false;
  }
  
  ADCData.g n()
  {
    return null;
  }
  
  boolean p()
  {
    return (b_()) || (c());
  }
  
  String q()
  {
    z localz = new z();
    a(localz);
    return localz.toString();
  }
  
  public String toString()
  {
    return q();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/ADCData$i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */