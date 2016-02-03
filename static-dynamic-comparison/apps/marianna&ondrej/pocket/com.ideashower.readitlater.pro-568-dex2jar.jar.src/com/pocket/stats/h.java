package com.pocket.stats;

import com.ideashower.readitlater.g.g;
import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.util.l;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

@Deprecated
public class h
{
  @Deprecated
  public static void a(i parami, String paramString)
  {
    ArrayNode localArrayNode = l.c();
    parami = parami.a();
    if (paramString != null) {
      parami.put("string_params", paramString);
    }
    localArrayNode.add(parami);
    new g()
    {
      protected void a()
      {
        a locala = new a("https://getpocket.com/v3/pv", false);
        locala.a();
        locala.a("type", "mobile");
        locala.a("actions", h.this.toString());
        locala.b();
      }
    }.h();
  }
  
  @Deprecated
  public static void a(String paramString1, String paramString2)
  {
    ObjectNode localObjectNode = l.b();
    localObjectNode.put("action", "pv_ab");
    localObjectNode.put("ab_test", paramString1);
    localObjectNode.put("ab_test_option", paramString2);
    localObjectNode.put("time", System.currentTimeMillis() / 1000L);
    paramString1 = l.c();
    paramString1.add(localObjectNode);
    new g()
    {
      protected void a()
      {
        a locala = new a("https://getpocket.com/v3/abtr", false);
        locala.a();
        locala.a("actions", h.this.toString());
        locala.b();
      }
    }.h();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/stats/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */