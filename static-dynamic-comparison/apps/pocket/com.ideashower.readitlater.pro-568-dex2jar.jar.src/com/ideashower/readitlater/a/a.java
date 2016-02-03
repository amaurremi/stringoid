package com.ideashower.readitlater.a;

import com.ideashower.readitlater.h.h;
import com.ideashower.readitlater.h.i;
import com.pocket.c.e;
import com.pocket.stats.f;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

public class a
{
  private static final d a;
  private static ObjectNode b;
  
  static
  {
    ObjectNode localObjectNode = com.ideashower.readitlater.util.l.b();
    localObjectNode.put("option", "control");
    localObjectNode.put("value", "control");
    a = new d(localObjectNode, null);
  }
  
  public static String a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return d.b(d(paramString, paramBoolean1, paramBoolean2));
  }
  
  public static ObjectNode a(boolean paramBoolean)
  {
    ObjectNode localObjectNode = null;
    if (b != null) {
      localObjectNode = b;
    }
    do
    {
      return localObjectNode;
      b = i.a(com.ideashower.readitlater.h.a.be, null);
      if (b != null) {
        return b;
      }
    } while (!paramBoolean);
    a();
    return null;
  }
  
  public static void a()
  {
    if (!as.l()) {
      return;
    }
    e.r();
  }
  
  public static void a(ObjectNode paramObjectNode)
  {
    com.ideashower.readitlater.h.l locall = i.b();
    h localh = com.ideashower.readitlater.h.a.be;
    if (paramObjectNode != null) {}
    for (String str = paramObjectNode.toString();; str = null)
    {
      locall.a(localh, str).a();
      b = paramObjectNode;
      return;
    }
  }
  
  public static void b()
  {
    if (g.r() != 0) {
      a();
    }
  }
  
  private static void b(String paramString)
  {
    if (g.y())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("unexpected value ");
      if (paramString != null) {}
      for (;;)
      {
        throw new RuntimeException(paramString);
        paramString = "null";
      }
    }
  }
  
  public static void b(ObjectNode paramObjectNode)
  {
    a((ObjectNode)paramObjectNode.get("tests"));
  }
  
  private static d d(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(true);
    if (localObject != null)
    {
      localObject = ((ObjectNode)localObject).get(paramString);
      if (localObject != null) {
        localObject = new d((JsonNode)localObject, null);
      }
    }
    for (;;)
    {
      if (paramBoolean1) {
        f.a(paramString, d.a((d)localObject), paramBoolean2);
      }
      return (d)localObject;
      if (g.y()) {
        throw new RuntimeException(paramString + " not found");
      }
      localObject = a;
      continue;
      if (g.y()) {
        throw new RuntimeException(paramString + " not found");
      }
      localObject = a;
    }
  }
  
  private static String e(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return d.a(d(paramString, paramBoolean1, paramBoolean2));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */