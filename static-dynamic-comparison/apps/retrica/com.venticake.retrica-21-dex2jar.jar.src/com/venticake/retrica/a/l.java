package com.venticake.retrica.a;

import com.venticake.retrica.setting.a;
import java.util.HashSet;
import java.util.Set;

public enum l
{
  private static Set<String> c;
  private String b;
  
  static
  {
    c = new HashSet();
    c.add(a.a());
  }
  
  private l(String paramString1)
  {
    this.b = paramString1;
  }
  
  public static Set<String> b()
  {
    return c;
  }
  
  public String a()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */