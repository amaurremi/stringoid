package com.ideashower.readitlater.a;

import com.ideashower.readitlater.util.l;
import org.codehaus.jackson.JsonNode;

class d
{
  private final JsonNode a;
  
  private d(JsonNode paramJsonNode)
  {
    this.a = paramJsonNode;
  }
  
  private String a()
  {
    return l.a(this.a, "option", "control");
  }
  
  private String b()
  {
    return l.a(this.a, "value", "control");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */