package com.ideashower.readitlater.e;

import com.ideashower.readitlater.a.g;
import org.apache.a.c.k;

public class z
{
  private static final String a = g.a(2131493364);
  private final String b;
  private final String c;
  
  public z(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public String b()
  {
    if (k.c(this.c)) {
      return a;
    }
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (z)paramObject;
        if (this.c == null)
        {
          if (((z)paramObject).c != null) {
            return false;
          }
        }
        else if (!this.c.equals(((z)paramObject).c)) {
          return false;
        }
        if (this.b != null) {
          break;
        }
      } while (((z)paramObject).b == null);
      return false;
    } while (this.b.equals(((z)paramObject).b));
    return false;
  }
  
  public int hashCode()
  {
    int j = 0;
    int i;
    if (this.c == null)
    {
      i = 0;
      if (this.b != null) {
        break label39;
      }
    }
    for (;;)
    {
      return (i + 31) * 31 + j;
      i = this.c.hashCode();
      break;
      label39:
      j = this.b.hashCode();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/e/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */