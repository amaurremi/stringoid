package com.jirbo.adcolony;

import java.io.File;
import java.io.IOException;

class f
{
  static byte[] a = new byte['Ѐ'];
  String b;
  
  f(String paramString)
  {
    this.b = (a.l.f.d + paramString);
  }
  
  y a()
  {
    return new y(this.b);
  }
  
  void a(String paramString)
  {
    y localy = a();
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      localy.a(paramString.charAt(i));
      i += 1;
    }
    localy.b();
  }
  
  s b()
  {
    try
    {
      s locals = new s(new x(this.b));
      return locals;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  void c()
  {
    new File(this.b).delete();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */