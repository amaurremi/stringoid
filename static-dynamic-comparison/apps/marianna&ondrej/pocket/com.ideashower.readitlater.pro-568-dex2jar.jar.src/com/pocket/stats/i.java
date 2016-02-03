package com.pocket.stats;

import com.ideashower.readitlater.util.l;
import org.codehaus.jackson.node.ObjectNode;

@Deprecated
public class i
{
  public final String a;
  public final String b;
  public final int c;
  
  public i(String paramString)
  {
    this(null, paramString, 1);
  }
  
  public i(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, 1);
  }
  
  public i(String paramString1, String paramString2, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt;
  }
  
  public ObjectNode a()
  {
    ObjectNode localObjectNode = l.b();
    localObjectNode.put("view", "mobile");
    localObjectNode.put("section", "core");
    localObjectNode.put("type_id", this.c);
    if (this.b != null) {
      localObjectNode.put("page", this.b);
    }
    if (this.a != null) {
      localObjectNode.put("action_identifier", this.a);
    }
    localObjectNode.put("time", System.currentTimeMillis() / 1000L);
    return localObjectNode;
  }
  
  public void a(String paramString)
  {
    h.a(this, paramString);
  }
  
  public void b()
  {
    a(null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/stats/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */