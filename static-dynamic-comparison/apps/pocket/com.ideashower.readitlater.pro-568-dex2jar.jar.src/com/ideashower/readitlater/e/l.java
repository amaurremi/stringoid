package com.ideashower.readitlater.e;

import com.ideashower.readitlater.util.e;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.node.ObjectNode;

public class l
{
  private ObjectNode b;
  private ObjectNode c;
  
  private l(k paramk) {}
  
  public l a()
  {
    if (this.b == null)
    {
      e.a("groups cannot be null, have you set the groups yet?");
      return this;
    }
    k.a(this.a, this.b);
    return this;
  }
  
  public l a(JsonParser paramJsonParser)
  {
    return a(com.ideashower.readitlater.util.l.b(paramJsonParser));
  }
  
  public l a(ObjectNode paramObjectNode)
  {
    this.b = com.ideashower.readitlater.util.l.b();
    synchronized (k.a(this.a))
    {
      this.c = k.b(this.a);
      if (this.c != null) {
        this.b.putAll(this.c);
      }
      this.b.putAll(paramObjectNode);
      return this;
    }
  }
  
  public void b()
  {
    k.a(this.a, this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/e/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */