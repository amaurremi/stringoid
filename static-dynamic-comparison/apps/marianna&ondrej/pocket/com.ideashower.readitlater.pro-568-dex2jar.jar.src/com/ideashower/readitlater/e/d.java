package com.ideashower.readitlater.e;

import com.ideashower.readitlater.util.l;
import org.codehaus.jackson.node.ObjectNode;

public class d
{
  private final int a;
  private final String b;
  private final String c;
  
  public d(int paramInt, String paramString1, String paramString2)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public ObjectNode d()
  {
    ObjectNode localObjectNode = l.b();
    localObjectNode.put("author_id", this.a);
    localObjectNode.put("name", this.b);
    localObjectNode.put("url", this.c);
    return localObjectNode;
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
        paramObject = (d)paramObject;
        if (this.a != ((d)paramObject).a) {
          return false;
        }
        if (this.b == null)
        {
          if (((d)paramObject).b != null) {
            return false;
          }
        }
        else if (!this.b.equals(((d)paramObject).b)) {
          return false;
        }
        if (this.c != null) {
          break;
        }
      } while (((d)paramObject).c == null);
      return false;
    } while (this.c.equals(((d)paramObject).c));
    return false;
  }
  
  public int hashCode()
  {
    int j = 0;
    int k = this.a;
    int i;
    if (this.b == null)
    {
      i = 0;
      if (this.c != null) {
        break label49;
      }
    }
    for (;;)
    {
      return (i + (k + 31) * 31) * 31 + j;
      i = this.b.hashCode();
      break;
      label49:
      j = this.c.hashCode();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */